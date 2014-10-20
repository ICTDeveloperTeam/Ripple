package backingBean;

import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author YusukeKato
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {
    
    public String toMain() {
        return "/views/main";
    }
    
    public String toSignUp() {
        return "/views/setting";
    }
}
