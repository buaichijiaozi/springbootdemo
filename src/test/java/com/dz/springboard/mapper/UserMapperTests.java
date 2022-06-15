package com.dz.springboard.mapper;


import com.dz.springboard.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

//@SpringBootTest 表示标注当前的类是一个测试类，不会随同项目一块打包
@SpringBootTest
//表示启动这个单元测试类（单元测试类是不能够运行的），需要传速一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
@Slf4j
public class UserMapperTests {

    @Resource
    private UserMapper userMapper;

    /** 单元测试方法：就可以单独独立运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
     * 1.必须被0Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不指定任何类型
     * 4.方法的访问修饰符必须是public
     * */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer roes = userMapper.insert(user);
        System.out.println(roes);
    }

    @Test
    public void findByUsername(){
        User tim = userMapper.findByUsername("tim");
        System.out.println(tim);
    }

    @Test
    public void del(){
        Integer integer = userMapper.del(1);
        log.info(String.valueOf(integer));
    }

    @Test
    public void loginn(){
        String a = "123";
        String b = "A6D4012D-EEDD-4F9C-982A-76959336FFCC";
        String c = "";

        for (int i = 0; i < 3; i++) {
            c = DigestUtils.md5DigestAsHex((b + a + b).getBytes());
        }
        System.out.println(c);
    }
}
