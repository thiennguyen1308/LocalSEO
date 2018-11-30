package com.faber.dao;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
public interface LoginDAO {

    public boolean checkLogin(String username, String password);

    public boolean logout(HttpSession session);
}
