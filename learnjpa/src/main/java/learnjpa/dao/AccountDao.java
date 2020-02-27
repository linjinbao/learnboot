package learnjpa.dao;

import learnjpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Integer> {

}
