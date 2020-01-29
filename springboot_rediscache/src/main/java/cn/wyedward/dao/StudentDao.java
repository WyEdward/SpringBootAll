package cn.wyedward.dao;
import cn.wyedward.domain.Student;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * 查询用注解方式
 */
@Mapper
@Component
public interface StudentDao {
    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @Update("update student set sname = #{sname}, ssex = #{ssex} where sno = #{sno}")
    int update(Student student);

    /**
     * 根据sno删除学生
     * @param sno
     */
    @Delete("delete from student where sno=#{sno}")
    void deleteStudentBySno(String sno);

    /**
     * 根据sno查找学生
     * @param sno
     * @return
     */
    @Select("select * from student where sno = #{sno}")
    Student queryStudentBySno(String sno);

}
