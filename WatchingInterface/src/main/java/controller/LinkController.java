package controller;

import dao.ILinkDao;
import dao.IMovieDao;
import domain.Link;
import domain.Movie;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.util.List;

@Controller
@RequestMapping(path = "/link")
public class LinkController {


    //添加影片
    @RequestMapping(path = "/add", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult add(Integer movieid,String link,String name) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        ILinkDao iLinkDao = session.getMapper(ILinkDao.class);
        try {
            iLinkDao.addLink(movieid,link,name);
            session.commit();
            return APIResult.createOKMessage("添加链接成功");
        }catch (Exception e){
            e.printStackTrace();
            return APIResult.createNg("添加链接失败");
        }finally {
            session.close();
        }
    }

    //查找影片
    @RequestMapping(path = "/search", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult search(Integer movieid) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        ILinkDao linkDao = session.getMapper(ILinkDao.class);
        List<Link> links = linkDao.findLink(movieid);
        session.close();
        if (!links.isEmpty()) {
            return APIResult.createOk("查询成功", links);
        } else {
            return APIResult.createNg("查询失败");
        }
    }

}
