/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.controller;

import entities.controller.exceptions.NonexistentEntityException;
import entities.controller.exceptions.PreexistingEntityException;
import entities.controller.exceptions.RollbackFailureException;
import entities.json.pojo.PeopleAround;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author YusukeKato
 */
public class PeopleAroundJpaController implements Serializable {

    public PeopleAroundJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeopleAround peopleAround) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(peopleAround);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findPeopleAround(peopleAround.getOtherMacAdr()) != null) {
                throw new PreexistingEntityException("PeopleAround " + peopleAround + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeopleAround peopleAround) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            peopleAround = em.merge(peopleAround);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = peopleAround.getOtherMacAdr();
                if (findPeopleAround(id) == null) {
                    throw new NonexistentEntityException("The peopleAround with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            PeopleAround peopleAround;
            try {
                peopleAround = em.getReference(PeopleAround.class, id);
                peopleAround.getOtherMacAdr();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The peopleAround with id " + id + " no longer exists.", enfe);
            }
            em.remove(peopleAround);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeopleAround> findPeopleAroundEntities() {
        return findPeopleAroundEntities(true, -1, -1);
    }

    public List<PeopleAround> findPeopleAroundEntities(int maxResults, int firstResult) {
        return findPeopleAroundEntities(false, maxResults, firstResult);
    }

    private List<PeopleAround> findPeopleAroundEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeopleAround.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PeopleAround findPeopleAround(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeopleAround.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeopleAroundCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeopleAround> rt = cq.from(PeopleAround.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
