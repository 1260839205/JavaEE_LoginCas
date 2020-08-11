package cn.aguo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author 石成果
 * @Date 2020/7/28 21:06
 * @Email 1260839205@qq.com
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        Connection connection = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","scg10178");

            //获取数据库
            String sql = "update user set password = 'scg2014' where id = 2";
            statement = connection.createStatement();
            int execute = statement.executeUpdate(sql);
            System.out.println(execute);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }
}
