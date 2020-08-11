package cn.aguo.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author 石成果
 * @Date 2020/8/4 11:48
 * @Email 1260839205@qq.com
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            //1 读取配置文件
            //1.1 创建存放配置文件的集合Properties
            Properties pt = new Properties();

            //1.2 获取配置文件路径
            InputStream rs = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");

            //1.3 存入集合中
            pt.load(rs);

            //1.4 获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pt);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     * @param rs
     */
    public static void close(Statement stmt, Connection conn , ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection conn , Statement stmt){
        JDBCUtils.close(stmt,conn,null);
    }

    public static void close(Connection conn){
        JDBCUtils.close(conn,null);
    }


    /**
     * 获取连接池
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
