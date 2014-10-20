package backingBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author YusukeKato
 */
@Named(value = "mainBean")
@SessionScoped
public class MainBean implements Serializable {
    
    /**
     * Creates a new instance of MainBean
     */
    public MainBean() {
    }
    
    private List<SelectItem> tableData = new ArrayList<SelectItem>();
    
    public List<SelectItem> getTableData() {
        return tableData;
    }
    
    public void setTableData(List<SelectItem> tableData) {
        this.tableData = tableData;
    }
    
}
