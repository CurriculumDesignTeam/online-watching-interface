package dao;

import domain.Link;
import domain.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ILinkDao {
    @Results(id = "LinkMap",value = {
        @Result(column = "lj_bh",property = "linkid",id = true),
        @Result(column = "yp_bh",property = "movieid"),
        @Result(column = "lj_lj",property = "link"),
        @Result(column = "lj_jsm",property = "episodename")
    })
    //查找所有链接
    @Select("select * from lj")
    List<Link> findAll();

    //添加链接
    @Insert("insert into lj(yp_bh,lj_lj,lj_jsm) values(#{movieid},#{link},#{episodename})")
    void addLink(@Param("movieid") Integer movieid, @Param("link") String link, @Param("episodename") String episodename);


    //按影片号查找链接
    @Select("select * from lj where yp_bh=#{movieid}")
    @ResultMap(value = {"LinkMap"})
    List<Link> findLink(@Param("movieid") Integer movieid);



}
