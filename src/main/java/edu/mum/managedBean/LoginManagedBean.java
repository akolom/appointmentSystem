/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.managedBean;

import edu.mum.bean.CredentialBean;
import edu.mum.domain.User;
import edu.mum.service.UserService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author matt
 */
//@Named(value = "loginManagedBean")
//@SessionScoped
@Component
@Scope("session")
public class LoginManagedBean implements Serializable {

    private User userLogin;
    @Inject
    private CredentialBean credentialBean;

    public User getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(User userLogin) {
        this.userLogin = userLogin;
    }

    public CredentialBean getCredentialBean() {
        return credentialBean;
    }

    public void setCredentialBean(CredentialBean credentialBean) {
        this.credentialBean = credentialBean;
    }

    public String getFullName() {
        return userLogin.getFirstName() + " " + userLogin.getLastName();
    }
    @Autowired
    private UserService userService;

    /**
     * Creates a new instance of LoginManagedBeann
     */
    public LoginManagedBean() {
    }

    public String login() {
        userLogin = checkCredentials();
        if (userLogin == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage("Login Failed!"));
            return "login";
        } else {
            return "event/welcome?faces-redirect=true";
        }
    }

    public void logout() {
        FacesContext ctx = FacesContext.getCurrentInstance();

        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        session.invalidate();

        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
        handler.performNavigation("/views/login");
//        return "login?faces-redirect=true";
        //return "welcome?faces-redirect=true";
    }

    public User checkCredentials() {
        List<User> users = userService.findAll();
//
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        for (User user : users) {
            boolean passwordMatch = encoder.matches(credentialBean.getPassword(), user.getCredentials().getPassword());
            if (user.getCredentials().getUserName().equalsIgnoreCase(credentialBean.getUsername())
                    && passwordMatch) {
                return user;
            }
        }
        return null;
    }
    public String signup()
    {
        return "userRegistration?faces-redirect=true";
    }
}
