package cn.wyedward.controller;

import cn.wyedward.Service.StudentService;
import cn.wyedward.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "/querystudent",method = RequestMethod.GET)
    public Student queryStudentBySno(String sno){
        return this.studentService.queryStudentBySno(sno);
    }
}
