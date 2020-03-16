package association.sql;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sqlproperty {
    private String DRIVER;
    // 使用没有带服务器身份验证的SSL连接,默认不允许
    private String URL;
    // 数据库的用户名与密码，需要根据自己的设置
    private String USER;
    private String PASS;

}
