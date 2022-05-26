package edu.gdou.gym_java.mapper;

import edu.gdou.gym_java.entity.model.Role;
import edu.gdou.gym_java.entity.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author liuyuanfeng
 * @since 2022-05-25
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from User")
    @Results({
            @Result(property = "id",column = "id")
    })
    List<User> getUserList ();

    @Select("select * from User where name=#{name}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roleId",column = "role_id"),
            @Result(property = "role",javaType = Role.class,column="role_id",
                    one = @One(select="edu.gdou.gym_java.mapper.RoleMapper.getById")),
    })
    User getUserByName(@Param("name")String name);

    @Select("select * from User where id=#{id}")
    @Results({
            @Result(property = "id",column = "id")
    })
    User getById(@Param("id")Long id);

    //根据用户名[可选]查询管理员用户
    List<User> queryManagerByName(String username);
}