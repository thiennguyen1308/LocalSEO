package com.faber.controller;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.dto.AccountDTO;
import com.faber.service.AccountService;
import com.faber.service.LoginService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
@Controller
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        return "other/login";
    }

    @RequestMapping(value = "/get-account", method = RequestMethod.GET)
    @ResponseBody
    public List<AccountDTO> getAccount(HttpSession session) {
        return accountService.getAccountList();
    }

    @RequestMapping(value = "/edit-account", method = RequestMethod.POST)
    @ResponseBody
    public Boolean editAccount(HttpSession session, @RequestParam Map<String, String> req) {
        AccountDTO accountDTO = new AccountDTO(req.get("username"), req.get("password"),
                                               req.get("firstName"), req.get("lastName"),
                                               req.get("email"));
        return accountService.editAccount(accountDTO);
    }

    @RequestMapping(value = "/delete-account", method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteAccount(HttpSession session, @RequestParam int id) {
        return accountService.deleteAccount(id);
    }

    @RequestMapping(value = "/add-account", method = RequestMethod.POST)
    @ResponseBody
    public Boolean addAccount(HttpSession session, @RequestParam Map<String, String> req) {
        AccountDTO accountDTO = new AccountDTO(req.get("username"), req.get("password"),
                                               req.get("firstName"), req.get("lastName"),
                                               req.get("email"));
        return accountService.addAccount(accountDTO);
    }
}
