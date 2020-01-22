package cn.wyedward.dao;

import cn.wyedward.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    List<Map<String,Object>> queryStudentsListMap();
    Student queryStudentBySno(String sno);
}