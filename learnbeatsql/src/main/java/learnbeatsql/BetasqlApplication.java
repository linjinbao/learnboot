package learnbeatsql;

import learnbeatsql.entity.User;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.core.query.Query;
import org.beetl.sql.ext.DebugInterceptor;

import java.util.List;

public class BetasqlApplication {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String userName= "root";
        String password = "369369";
        ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
        DBStyle mysql = new MySqlStyle();
        // sql语句放在classpagth的/sql 目录下
        SQLLoader loader = new ClasspathLoader("/sql");
        // 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的，
        UnderlinedNameConversion nc = new  UnderlinedNameConversion();
        // 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
        //使用内置的生成的sql 新增用户，如果需要获取主键，可以传入KeyHolder
        User user = new User();
        user.setAge(19);
        user.setName("xiandafu");
        sqlManager.insert(user);
        //使用内置sql查询用户
        int id = 1;
        user = sqlManager.unique(User.class,id);
        //模板更新,仅仅根据id更新值不为null的列
        User newUser = new User();
        newUser.setId(1);
        newUser.setAge(20);
        sqlManager.updateTemplateById(newUser);
        //模板查询
        User query = new User();
        query.setName("xiandafu");
        List<User> list = sqlManager.template(query);
        //Query查询
        Query userQuery = sqlManager.query(User.class);
        List<User> users = userQuery.select();
    }
}
