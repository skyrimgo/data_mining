package association.sql;

import lombok.AllArgsConstructor;

import java.sql.*;
import java.util.ArrayList;

@AllArgsConstructor
public class Conn {
    //    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    // 使用没有带服务器身份验证的SSL连接,默认不允许
//    public static final String URL = "jdbc:mysql://localhost:3306/apriori_set?serverTimezone=GMT%2B8&useSSL=false";
//    // 数据库的用户名与密码，需要根据自己的设置
//    static final String USER = "root";
//    static final String PASS = "";
    private Sqlproperty sqlproperty;


    public ArrayList<String[]> getData() {
        // TODO Auto-generated method stub
        Connection conn = null;
        Statement stmt = null;
        ArrayList<String[]> lists = new ArrayList<>();
        // 注册 JDBC 驱动
        try {
            Class.forName(sqlproperty.getDRIVER());
            // 打开链接
            System.out.println("数据库连接中。。。");
            conn = DriverManager.getConnection(sqlproperty.getURL(), sqlproperty.getUSER(), sqlproperty.getPASS());
            System.out.println("数据库连接成功！");
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            // String sql, sql1;
            // sql1 = "INSERT INTO `tb_1` VALUES(111,111)";
            // stmt.executeQuery(sql1);
            String sql = "SELECT * FROM `apriori_set_test`";
            // String sql = "INSERT INTO `tb_1` VALUES(111,111)";
            ResultSet rs = stmt.executeQuery(sql);
            // stmt.execute(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int len = rs.getMetaData().getColumnCount();
                StringBuilder sb = new StringBuilder(rs.getString(1));
                for (int index = 2; index <= len; index++) {
                    int value = rs.getInt(index);
                    if (value > 0) {
                        sb.append(" ");
                        sb.append(value);
                    }
                }
                String[] res = sb.toString().split(" ");
                lists.add(res);
            }
            // // 完成后关闭
            // rs.close();
            // stmt.close();
            // conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lists;
    }

}
