package com.faber.dao;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.dto.AccountDTO;
import java.util.List;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 */
public interface AccountDAO {

    public boolean addAccount(AccountDTO accountDTO);

    public List<AccountDTO> getAccountList();

    public boolean deleteAccount(int id);

    public boolean editAccount(AccountDTO accountDTO);
}
