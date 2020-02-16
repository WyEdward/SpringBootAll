package cn.wyedward;


import cn.wyedward.dao.JpaTestDao;
import cn.wyedward.domain.JpaTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class AppliactionTest {
    @Autowired
    private JpaTestDao jpaTestDao;
    @Test
    public void findUserByName(){
        List<JpaTest> findall = jpaTestDao.findall();
        System.out.println(findall);
    }
}
