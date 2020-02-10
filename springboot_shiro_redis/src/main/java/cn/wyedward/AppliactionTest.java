package cn.wyedward;

import cn.wyedward.dao.UserPermissionDao;
import cn.wyedward.dao.UserRoleDao;
import cn.wyedward.domain.Permission;
import cn.wyedward.domain.Role;
import cn.wyedward.domain.User;
import cn.wyedward.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootShiroRedisApplication.class)
public class AppliactionTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserPermissionDao userPermissionDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Test
    public void findUserByName(){
        String username = "scott";
        User user = userService.findUserByName(username);
        System.out.println(user);
        List<Permission> permissions = userPermissionDao.findByUserName(username);
        System.out.println("权限："+permissions);
        List<Role> Roles = userRoleDao.findByUserName(username);
        System.out.println("角色："+Roles);
    }
}
