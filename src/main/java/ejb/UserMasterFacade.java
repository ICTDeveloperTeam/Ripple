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
        return (UserMaster)query.getSingleResult();    //クエリをとばした結果をとっているのがこっち
    }
    
     public Integer getUserID(String twitterID){
        return queryByTwitterID(twitterID).getUserID();
    }
    
     public void setUserID(String twitterID,Integer userID){
        um = queryByTwitterID(twitterID);
        um.setUserID(userID);
        em.merge(um);
    }
    
     public String getTwitterAccessToken(String twitterID){
        return queryByTwitterID(twitterID).getTwitterAccessToken();
    }
    
     public void setTwitterAccessToken(String twitterID,String twitterAccessToken){
        um = queryByTwitterID(twitterID);
        um.setTwitterAccessToken(twitterAccessToken);
        em.merge(um);
    }
    
     public String getMacAdr(String twitterID){
        return queryByTwitterID(twitterID).getMacAdr();
    }
    
     public void setMacAdr(String twitterID,String macAdr){
        um = queryByTwitterID(twitterID);
        um.setMacAdr(macAdr);
        em.merge(um);
    }
    
     public String getDevToken(String twitterID){
        return queryByTwitterID(twitterID).getDevToken();
    }
    
     public void setDevToken(String twitterID,String devToken){
        um = queryByTwitterID(twitterID);
        um.setDevToken(devToken);
        em.merge(um);
    }
    
    public String getRegID(String twitterID){
        return queryByTwitterID(twitterID).getRegID();
    }
    
    public void setRegID(String twitterID, String regID){
        um = queryByTwitterID(twitterID);
        um.setRegID(regID);
        em.merge(um);
    }
    
     public Date getRegisterDate(String twitterID){
        return queryByTwitterID(twitterID).getRegisterDate();
    }
    
    public void setRegisterDate(String twitterID, Date registerdate){
        um = queryByTwitterID(twitterID);
        um.setRegisterDate(registerdate);
        em.merge(um);
    }
    
    public String getNickName(String twitterID){
        return queryByTwitterID(twitterID).getNickName();
    }
    
    public void setNickName(String twitterID,String nickName){
        um = queryByTwitterID(twitterID);
        um.setNickName(nickName);
        em.merge(um);
    }
    
    public String getImagePath(String twitterID){
        return queryByTwitterID(twitterID).getImagePath();
    }
    
    public void setImagePath(String twitterID, String imagePath){
        um = queryByTwitterID(twitterID);
        um.setImagePath(imagePath);
        em.merge(um);
    }
    
     public String getPrefecture(String twitterID){
        return queryByTwitterID(twitterID).getImagePath();
    }
    
    public void setPrefecture(String twitterID, String prefecture){
        um = queryByTwitterID(twitterID);
        um.setPrefecture(prefecture);
        em.merge(um);
    }
    
     public String getIntroduction(String twitterID){
        return queryByTwitterID(twitterID).getIntroduction();//UserMasterからTwitterIDに紐づけてとってきた情報の中の、Introductionを取得しているだけ
    }
    
    public void setIntroduction(String twitterID, String introduction){
        um = queryByTwitterID(twitterID);
        um.setIntroduction(introduction);
        em.merge(um);//マージして更新
    }
    
    public String getRoute(String twitterID){
        return queryByTwitterID(twitterID).getRoute();
    }
    
    public void setRoute(String twitterID, String route){
        um = queryByTwitterID(twitterID);
        um.setRoute(route);
        em.merge(um);
    }
    
    
    
    
    
}
