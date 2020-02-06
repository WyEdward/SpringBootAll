package cn.wyedward;

import cn.wyedward.domain.User;
import cn.wyedward.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootShiroAuthenticationApplication.class)
public class AppliactionTest {
    @Autowired
    private UserService userService;

    @Test
    public void findUserByName(){
        String username = "wyedward";
        User user = userService.findUserByName(username);
        System.out.println(user);
    }
}
