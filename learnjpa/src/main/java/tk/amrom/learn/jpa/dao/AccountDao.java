package tk.amrom.learn.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.amrom.learn.jpa.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {

}
