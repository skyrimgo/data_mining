package association.algorithm;

import association.sql.Sqlproperty;

/**
 * apriori关联规则挖掘算法调用类
 */
public class Client {
    public static void main(String[] args) {
        String filePath = "F:\\VsCodeProjects\\Apriori\\data\\testInput.txt";

        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        // 使用没有带服务器身份验证的SSL连接,默认不允许
        final String URL = "jdbc:mysql://localhost:3306/apriori_set?serverTimezone=GMT%2B8&useSSL=false";
        // 数据库的用户名与密码，需要根据自己的设置
        final String USER = "root";
        final String PASS = "";
        Sqlproperty sqlproperty = new Sqlproperty(DRIVER, URL, USER, PASS);

        /*
         * 最小支持度计数:2（项集最少出现2次为频繁集） 支持度阈值=支持度计数/事务个数
         */
        AprioriTool tool = new AprioriTool(sqlproperty, 2);
        /*
         * 置信度阈值:0.7（{a}->{b}a并b的项集在a中出现的概率,大于则为“强规则”）
         */
        tool.printAttachRule(0.7);
    }
}