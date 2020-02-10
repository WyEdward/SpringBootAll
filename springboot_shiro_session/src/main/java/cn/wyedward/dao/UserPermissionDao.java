package cn.wyedward.dao;

import cn.wyedward.domain.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPermissionDao {
    List<Permission> findByUserName(String username);
}
