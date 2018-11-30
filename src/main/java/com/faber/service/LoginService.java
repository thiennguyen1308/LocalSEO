package com.faber.service;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 */
@Service
public interface LoginService {

    public boolean checkLogin(String username, String password);

    public boolean logout(HttpSession session);
}
