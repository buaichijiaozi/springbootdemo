package com.dz.springboard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringboardApplicationTests {

    @Resource
    DataSource dataSource;

    @Test
    void contextLoads() {

    }

    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

}
