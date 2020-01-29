package cn.wyedward.service.impl;

import cn.wyedward.dao.StudentDao;
import cn.wyedward.domain.Student;
import cn.wyedward.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("studentService")
@CacheConfig(cacheNames = "student")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    @CachePut(key = "#p0.sno")
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    @CacheEvict(key = "#p0", allEntries = true)
    public void deleteStudentBySno(String sno) {
        studentDao.deleteStudentBySno(sno);
    }

    @Override
    @Cacheable(key = "#p0")
    public Student queryStudentBySno(String sno) {
        return studentDao.queryStudentBySno(sno);
    }
}
