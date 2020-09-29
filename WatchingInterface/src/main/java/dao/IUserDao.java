package dao;

import domain.Admin;
import domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    @Results(id = "userMap",value = {
        @Result(column = "yh_zh",property = "account",id = true),
        @Result(column = "yh_nc",property = "nickname"),
        @Result(column = "yh_mm",property = "password"),
        @Result(column = "yh_yx",property = "email"),
        @Result(column = "yh_vip",property = "isvip")
    })
    @Select("select * from yh")
    List<User> findAll();


    //用户登录
    @Select("select * from yh where yh_zh=#{username} and yh_mm=#{password}")
    @ResultMap(value = {"userMap"})
    User findByNameAndPwd(@Param("username") String username, @Param("password") String password);

    //添加用户
    @Insert("insert into yh(yh_zh,yh_nc,yh_mm,yh_yx,yh_vip) values(#{username},#{nickname},#{password},#{email},#{isvip})")
    void addUser(@Param("username") String username, @Param("nickname") String nickname,@Param("password") String password, @Param("email") String email,@Param("isvip") Boolean isvip);


}
