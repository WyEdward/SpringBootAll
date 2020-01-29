package cn.wyedward.service;

import cn.wyedward.domain.Student;

public interface StudentService {
    /**
     * 更新学生信息
     * @param student
     * @return
     */
    int update(Student student);

    /**
     * 根据sno删除学生
     * @param sno
     */
    void deleteStudentBySno(String sno);

    /**
     * 根据sno查找学生
     * @param sno
     * @return
     */
    Student queryStudentBySno(String sno);
}
