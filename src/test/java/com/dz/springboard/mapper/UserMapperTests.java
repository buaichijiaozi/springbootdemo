package com.dz.springboard.mapper;


import com.dz.springboard.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

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
        user.setUsername("tim001");
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
    public void findByUid(){
        User user = userMapper.findByUid(32);
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid(){
        Integer integer = userMapper.updatePasswordByUid(26, "123456", "tim17", new Date());
        System.out.println(integer);
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(32);
        user.setPhone("15615208037");
        user.setEmail("163@126.com");
        user.setGender(0);
        userMapper.updateInfoByUid(user);
    }
    @Test
    public void updateAvatarByUid(){
        String str = "C:\\Users\\zhang\\Desktop\\2014ddc975294a7c.png";
        Integer integer = userMapper.updateAvatarByUid(32, str, "032", new Date());
        System.out.println(integer);
    }
}
