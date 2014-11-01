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
    private List<UserMaster>tableData;
    /**
     * Creates a new instance of MainBean
     */
    public MainBean() {
        //tableData = cfejb.getContactInfo("mayuyuyu0106");
    }

    /**
     * @return the cfejb
     */
    public ContactFacade getCfejb() {
        return cfejb;
    }

    /**
     * @param cfejb the cfejb to set
     */
    public void setCfejb(ContactFacade cfejb) {
        this.cfejb = cfejb;
    }

    /**
     * @return the um
     */
    public UserMaster getUm() {
        return um;
    }

    /**
     * @param um the um to set
     */
    public void setUm(UserMaster um) {
        this.um = um;
    }

    /**
     * @return the tableData
     */
    public List<UserMaster> getTableData() {
        tableData=cfejb.getContactInfo("mayuyuyu0106");
        return tableData;
    }

    /**
     * @param tableData the tableData to set
     */
    public void setTableData(List<UserMaster> tableData) {
        this.tableData = tableData;
    }
    
}
