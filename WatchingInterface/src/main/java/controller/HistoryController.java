package controller;

import dao.IHistoryDao;
import dao.ILinkDao;
import domain.History;
import domain.Link;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

import java.util.List;

@Controller
@RequestMapping(path = "/history")
public class HistoryController {


    //添加观看记录
    @RequestMapping(path = "/add", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult add(String account,Integer movieid,String time) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        IHistoryDao historyDao = session.getMapper(IHistoryDao.class);
        try {
            historyDao.addHistory(account,movieid,time);
            session.commit();
            return APIResult.createOKMessage("添加记录成功");
        }catch (Exception e){
            e.printStackTrace();
            return APIResult.createNg("添加记录失败");
        }finally {
            session.close();
        }
    }

    //查找某用户观看记录
    @RequestMapping(path = "/search", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult search(String account) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        IHistoryDao historyDao = session.getMapper(IHistoryDao.class);
        List<History> history = historyDao.findHistory(account);
        session.close();
        if (!history.isEmpty()) {
            return APIResult.createOk("查询成功", history);
        } else {
            return APIResult.createNg("查询失败");
        }
    }

}
