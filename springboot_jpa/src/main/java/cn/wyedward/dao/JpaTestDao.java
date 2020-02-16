package cn.wyedward.dao;

        import cn.wyedward.domain.JpaTest;
        import org.apache.ibatis.annotations.Mapper;
        import org.apache.ibatis.annotations.Result;
        import org.apache.ibatis.annotations.Results;
        import org.apache.ibatis.annotations.Select;

        import java.util.List;

@Mapper
public interface JpaTestDao {
    @Select("select * from jpatest")
    @Results(id = "jpatest",value= {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "address", column = "address", javaType = String.class),
            @Result(property = "jpaName", column = "jpa_name", javaType = String.class),
            @Result(property = "lastName", column = "last_name", javaType = String.class)
    })
    List<JpaTest> findall();
}
