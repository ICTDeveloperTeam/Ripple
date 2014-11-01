package backingBean;

import ejb.ContactFacade;
import entities.UserMaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author YusukeKato
 */
@Named(value = "mainBean")
@SessionScoped
public class MainBean implements Serializable {
    @EJB
    private ContactFacade cfejb;
    
    private UserMaster um;
    private List<UserMaster>contactTable;
    /**
     * Creates a new instance of MainBean
     */
    public MainBean() {
         contactTable = cfejb.getContactInfo("mayuyuyu0106");
    }
    
    /**
     * @return the contactTable
     */
    public List<UserMaster> getContactTable() {
        return contactTable;
    }

    /**
     * @param contactTable the contactTable to set
     */
    public void setContactTable(List<UserMaster> contactTable) {
        this.contactTable = contactTable;
    }
    
}
