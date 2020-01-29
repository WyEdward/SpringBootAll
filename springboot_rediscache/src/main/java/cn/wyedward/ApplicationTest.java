package cn.wyedward;

import cn.wyedward.domain.Student;
import cn.wyedward.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringbootRediscacheApplication.class)
public class ApplicationTest {
    @Autowired
    private StudentService studentService;
    @Test
    public void test(){
        Student student1 = this.studentService.queryStudentBySno("003");
        System.out.println("学号" + student1.getSno() + "的学生姓名为：" + student1.getSname());

        Student student2 = this.studentService.queryStudentBySno("003");
        System.out.println("学号" + student2.getSno() + "的学生姓名为：" + student2.getSname());
    }
}