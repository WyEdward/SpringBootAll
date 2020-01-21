package cn.wyedward.Service.impl;

import cn.wyedward.Service.StudentService;
import cn.wyedward.dao.StudentDao_anno;
import cn.wyedward.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao_anno studentDao_anno;

    @Override
    public int add(Student student) {
        return this.studentDao_anno.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentDao_anno.update(student);
    }

    @Override
    public int deleteBySno(String sno) {
        return this.studentDao_anno.deleteBysno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentDao_anno.queryStudentBySno(sno);
    }
}
