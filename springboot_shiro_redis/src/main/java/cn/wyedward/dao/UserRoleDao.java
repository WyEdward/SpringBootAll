package cn.wyedward.dao;

import cn.wyedward.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleDao {
    List<Role> findByUserName(String username);
}
