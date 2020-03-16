package association.scala

import java.sql.{Connection, DriverManager}

object ScalaTest {
  def main(args: Array[String]): Unit = {
    //1.数据库配置
    // 访问本地MySQL服务器，通过3306端口访问mysql数据库
    val url = "jdbc:mysql://localhost:3306/apriori_set?serverTimezone=GMT%2B8&useSSL=false"
    //驱动名称
    val driver = "com.mysql.cj.jdbc.Driver"
    //用户名
    val username = "root"
    //密码
    val password = ""

    //2.初始化数据连接
    var connection: Connection = null
    try {
      //注册Driver
      Class.forName(driver)
      //得到连接
      connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement

      //3.数据库操作
      //（1）执行查询语句，并返回结果
      val sql = "SELECT * FROM apriori_set_test"
      val rs = statement.executeQuery(sql)
      //打印返回结果
      while (rs.next) {
        val user_no = rs.getString("user_no")
        val service1 = rs.getLong("service1")

        println("user_no =" + user_no + ",service1 =" + service1)
      }
      println("查询数据完成！")

      /**
        * 查询结果：
        */

      //（2）插入操作【成功！】
      //      val sql2 = "INSERT INTO `day_video_access_topn_stat` (`day`, `cms_id`,`times`) VALUES ('20170511', '1543','4500')"
      //      val rs2 = statement.executeUpdate(sql2)
      //      println("插入数据完成")

      //（3）更新操作【成功！】
      //      val sql3 = "UPDATE day_video_access_topn_stat set times=4501 WHERE `cms_id`=1543"
      //      val rs3 = statement.executeUpdate(sql3)
      //      println("更新数据完成！")

      //（4）删除操作【成功！】
      //      val sql4 = "delete from day_video_access_topn_stat WHERE `cms_id`=1543"
      //      val rs4 = statement.executeUpdate(sql4)
      //      println("删除数据完成！")

    } catch {
      case e: Exception => e.printStackTrace()
    }
    connection.close()
  }
}
