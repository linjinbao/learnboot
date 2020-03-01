package learnjdbctemplate.dao;

import learnjdbctemplate.entity.Account;

import java.util.List;

/**
 * @api Account接口
 * @apiGroup Users
 * @apiVersion 0.0.1
 * @apiDescription 用于账户管理
 * @apiSuccess (200) {String} msg 信息
 */
public interface IAccountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
