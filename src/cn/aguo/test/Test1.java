package cn.aguo.test;

import cn.aguo.util.JDBCUtils;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author 石成果
 * @Date 2020/8/4 12:30
 * @Email 1260839205@qq.com
 */
public class Test1 {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void test(){
        String sql = "update user set password = ? where id = 2";

        int num = template.update(sql, "scg2021");

        System.out.println(num);
    }
}
