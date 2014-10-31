/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.controller;

import entities.controller.exceptions.NonexistentEntityException;
import entities.controller.exceptions.PreexistingEntityException;
import entities.controller.exceptions.RollbackFailureException;
import entities.json.pojo.ProfileConfig;
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
public class ProfileConfigJpaController implements Serializable {

    public ProfileConfigJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProfileConfig profileConfig) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(profileConfig);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findProfileConfig(profileConfig.getTwitterID()) != null) {
                throw new PreexistingEntityException("ProfileConfig " + profileConfig + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProfileConfig profileConfig) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            profileConfig = em.merge(profileConfig);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = profileConfig.getTwitterID();
                if (findProfileConfig(id) == null) {
                    throw new NonexistentEntityException("The profileConfig with id " + id + " no longer exists.");
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
            ProfileConfig profileConfig;
            try {
                profileConfig = em.getReference(ProfileConfig.class, id);
                profileConfig.getTwitterID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The profileConfig with id " + id + " no longer exists.", enfe);
            }
            em.remove(profileConfig);
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

    public List<ProfileConfig> findProfileConfigEntities() {
        return findProfileConfigEntities(true, -1, -1);
    }

    public List<ProfileConfig> findProfileConfigEntities(int maxResults, int firstResult) {
        return findProfileConfigEntities(false, maxResults, firstResult);
    }

    private List<ProfileConfig> findProfileConfigEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProfileConfig.class));
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

    public ProfileConfig findProfileConfig(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProfileConfig.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfileConfigCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProfileConfig> rt = cq.from(ProfileConfig.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
