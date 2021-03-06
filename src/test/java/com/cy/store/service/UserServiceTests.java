package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Resource
    private IUserService userService;

    /**单元测试条件：可以独立运行， 不需要整个项目启动
     * 必须有@test, 必须void, 必须0参数， 必须public
     */
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("yang");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("Success");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void login(){
        User user = userService.login("Tom", "123");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        userService.changePassword(8, "vil", "123", "321");
    }

    @Test
    public void getByUid(){
        System.out.println(userService.getByUid(8));
    }

    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("13681923463");
        user.setEmail("Test@usc");
        user.setGender(0);
        userService.changeInfo(8,"admin", user);
    }

    @Test
    public void changeAvatar(){
        userService.changeAvatar(8, "D:/", "Tom");
    }

}
