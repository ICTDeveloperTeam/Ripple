/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ejb;

import entities.UserMaster;
import entities.service.AbstractFacade;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author まゆ
 */
@Stateless
public class UserMasterFacade extends AbstractFacade<UserMaster> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    UserMaster um;
    Query query;
    
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public UserMasterFacade() {
        super(UserMaster.class);
    }
    
    public UserMaster queryByTwitterID(String twitterID){
        query = em.createNamedQuery("UserMaster.findByTwitterID").setParameter("twitterID", twitterID);//UserMasterからUser情報をすべてとってくるクエリを飛ばしている
        if(!query.getResultList().isEmpty()){
            return (UserMaster)query.getSingleResult();
        }
        return null;//クエリをとばした結果をとっているのがこっち
    }
    
    public Integer getUserID(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getUserID();
        }
        return null;
    }
    
    public void setUserID(String twitterID,Integer userID){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setUserID(userID);
            em.merge(um);
        }
    }
    
    public String getTwitterAccessToken(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getTwitterAccessToken();
        }
        return null;
    }
    
    public void setTwitterAccessToken(String twitterID,String twitterAccessToken){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setTwitterAccessToken(twitterAccessToken);
            em.merge(um);
        }
    }
    
    public String getMacAdr(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getMacAdr();
        }
        return null;
    }
    
    public void setMacAdr(String twitterID,String macAdr){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setMacAdr(macAdr);
            em.merge(um);
        }
    }
    
    public String getDevToken(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getDevToken();
        }
        return null;
    }
    
    public void setDevToken(String twitterID,String devToken){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setDevToken(devToken);
            em.merge(um);
        }
    }
    
    public String getRegID(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getRegID();
        }
        return null;
    }
    
    public void setRegID(String twitterID, String regID){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setRegID(regID);
            em.merge(um);
        }
    }
    
    public Date getRegisterDate(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getRegisterDate();
        }
        return null;
    }
    
    public void setRegisterDate(String twitterID, Date registerdate){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setRegisterDate(registerdate);
            em.merge(um);
        }
    }
    
    public String getNickName(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getNickName();
        }return null;
    }
    
    public void setNickName(String twitterID,String nickName){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setNickName(nickName);
            em.merge(um);
        }
    }
    
    public String getImagePath(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getImagePath();
        }return null;
    }
    
    public void setImagePath(String twitterID, String imagePath){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setImagePath(imagePath);
            em.merge(um);
        }
    }
    
    public String getPrefecture(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getImagePath();
        }
        return null;
    }
    
    public void setPrefecture(String twitterID, String prefecture){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setPrefecture(prefecture);
            em.merge(um);
        }
    }
    
    public String getIntroduction(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getIntroduction();//UserMasterからTwitterIDに紐づけてとってきた情報の中の、Introductionを取得しているだけ
        }
        return null;
    }
    public void setIntroduction(String twitterID, String introduction){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setIntroduction(introduction);
            em.merge(um);//マージして更新
        }
    }
    
    public String getRoute(String twitterID){
        if(queryByTwitterID(twitterID)!=null){
            return queryByTwitterID(twitterID).getRoute();
        }
        return null;
    }
    
    public void setRoute(String twitterID, String route){
        if(queryByTwitterID(twitterID)!=null){
            um = queryByTwitterID(twitterID);
            um.setRoute(route);
            em.merge(um);
        }
    }
    
}
