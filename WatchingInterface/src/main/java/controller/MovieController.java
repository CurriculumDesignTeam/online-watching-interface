package controller;

import dao.IAdminDao;
import dao.IMovieDao;
import dao.IUserDao;
import domain.Admin;
import domain.Movie;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.util.List;

@Controller
@RequestMapping(path = "/movie")
public class MovieController {


    //添加影片
    @RequestMapping(path = "/add", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult Login(String account,String moviename,String type,String language,String time,String introduce,String avatar) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        IMovieDao movieDao = session.getMapper(IMovieDao.class);
        try {
            movieDao.addMovie(account,moviename,type,language,time,introduce,avatar);
            session.commit();
            return APIResult.createOKMessage("添加影片成功");
        }catch (Exception e){
            e.printStackTrace();
            return APIResult.createNg("添加影片失败");
        }finally {
            session.close();
        }
    }

    //查找影片
    @RequestMapping(path = "/search", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult Login(String searchword) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        IMovieDao movieDao = session.getMapper(IMovieDao.class);
        try {

            List<Movie> movies = movieDao.findMovie("'%"+searchword+"%'");
            if (!movies.isEmpty()) {
                return APIResult.createOk("查询成功", movies);
            } else {
                return APIResult.createNg("查询失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        session.close();
        return APIResult.createOKMessage("d");
    }

}
