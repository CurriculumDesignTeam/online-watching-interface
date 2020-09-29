package dao;

import domain.Movie;
import domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IMovieDao {
    @Results(id = "MovieMap",value = {
        @Result(column = "yp_bh",property = "movieid",id = true),
        @Result(column = "gly_zh",property = "adminaccount"),
        @Result(column = "yp_pm",property = "moviename"),
        @Result(column = "yp_lx",property = "type"),
        @Result(column = "yp_yy",property = "language"),
        @Result(column = "yp_sj",property = "time"),
        @Result(column = "yp_jj",property = "introduce"),
        @Result(column = "yp_fm",property = "avatar")
    })
    //查找所有影片
    @Select("select * from yp")
    List<Movie> findAll();

    //添加影片
    @Insert("insert into yp(gly_zh,yp_pm,yp_lx,yp_yy,yp_sj,yp_jj,yp_fm) values(#{account},#{moviename},#{type},#{language},#{time},#{introduce},#{avatar})")
    void addMovie(@Param("account") String account, @Param("moviename") String moviename, @Param("type") String type, @Param("language") String language, @Param("time") String time, @Param("introduce") String introduce, @Param("avatar") String avatar);

    //条件查找影片
    @Select("select * from yp where yp_pm like ${searchword} or yp_lx like ${searchword} or yp_yy like ${searchword}" +
            " or yp_sj like ${searchword} or yp_jj like ${searchword}")
    @ResultMap(value = {"MovieMap"})
    List<Movie> findMovie(@Param("searchword") String searchword);



}
