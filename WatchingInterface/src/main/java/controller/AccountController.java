package controller;

import dao.IAdminDao;
import dao.IUserDao;
import domain.Admin;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.APIResult;

@Controller
@RequestMapping(path = "/account")
public class AccountController {

    /**
     * 账号登录接口
     * 传入帐号名、密码以及账号类型
     *
     * @param account
     * @return 账号信息或错误信息
     */
    @RequestMapping(path = "/login", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult Login(String account,String pwd,Integer type) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        if (type == 1) {//管理员用户
            IAdminDao adminDao = session.getMapper(IAdminDao.class);
            Admin admin = adminDao.findByAdminAndPwd(account,pwd);
            session.close();
            if (admin != null) {
                return APIResult.createOk("登录成功", admin);
            } else {
                return APIResult.createNg("用户名或密码错误");
            }
        }else if (type == 2) {//普通用户
            IUserDao userDao = session.getMapper(IUserDao.class);
            User user = userDao.findByNameAndPwd(account,pwd);
            session.close();
            if (user != null) {
                return APIResult.createOk("登录成功", user);
            } else {
                return APIResult.createNg("用户名或密码错误");
            }
        } else {
            session.close();
            return APIResult.createNg("请求参数不合法");
        }

    }

    /**
     * 添加用户或管理员
     *
     * @param account
     * @return 账号信息或错误信息
     */
    @RequestMapping(path = "/add", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept"})
    @ResponseBody
    public APIResult Login(String account,String pwd,String nickname,String email,Boolean isvip,Integer type) {
        //查询数据库
        SqlSession session = util.MyBatis.getSession();
        if (type == 1) {//管理员
            IAdminDao adminDao = session.getMapper(IAdminDao.class);
            try {
                adminDao.addAdmin(account,pwd);
                session.commit();
                return APIResult.createOKMessage("添加管理员成功");
            }catch (Exception e){
                e.printStackTrace();

                return APIResult.createNg("添加管理员失败");
            }finally {
                session.close();
            }
        }else if (type == 2) {//普通
            IUserDao userDao = session.getMapper(IUserDao.class);
            try {
                userDao.addUser(account,nickname,pwd,email,isvip);
                session.commit();
                return APIResult.createOKMessage("添加用户成功");
            }catch (Exception e){
                e.printStackTrace();
                return APIResult.createNg("添加用户失败");
            }finally {
                session.close();
            }
        } else {
            session.close();
            return APIResult.createNg("请求参数不合法");
        }

    }
}
