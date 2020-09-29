package dao;

import domain.History;
import domain.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IHistoryDao {
    @Results(id = "HistoryMap",value = {
        @Result(column = "yh_zh",property = "account",id = true),
        @Result(column = "yp_bh",property = "movieid"),
        @Result(column = "gk_sj",property = "time")
    })
    //查找所有观看记录
    @Select("select * from gk")
    List<History> findAll();

    //添加观看记录
    @Insert("insert into gk(yh_zh,yp_bh,gk_sj) values(#{account},#{movieid},#{time})")
    void addHistory(@Param("account") String account, @Param("movieid") Integer movieid, @Param("time") String time);

    //查找某用户的观看记录
    @Select("select * from gk where yh_zh=#{account}")
    @ResultMap(value = {"HistoryMap"})
    List<History> findHistory(@Param("account") String account);



}
