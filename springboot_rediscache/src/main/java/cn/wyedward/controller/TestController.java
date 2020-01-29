package cn.wyedward.controller;

import cn.wyedward.domain.Student;
import cn.wyedward.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/queryStudentBySno")
    public Student queryStudentBySno(String sno){
        return studentService.queryStudentBySno(sno);
    }

    @RequestMapping("/deleteStudentBySno")
    public void deleteStudentBySno(String sno){
        studentService.deleteStudentBySno(sno);
    }
}
