<%--
  Created by IntelliJ IDEA.
  User: fyz
  Date: 2020/9/29
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="account/login?account=admin&pwd=admin&type=1">管理员登录</a>
<a href="account/login?account=1&pwd=123456&type=2">用户登录</a>
<br>
<a href="account/add?account=add&pwd=admin&type=1">添加管理员</a>
<a href="account/add?account=123&nickname=ws&pwd=123456&email=147@qq.com&isvip=0&type=2">添加用户</a>
<br>
<a href="movie/add?account=admin&moviename=test&type=fun&language=english&time=12:57&introduce=no&avatar=www.baidu.com">添加影片</a>
<a href="movie/search?searchword=动漫">搜索影片</a>
<br>
<a href="link/add?movieid=2&link=www.baidu.com&name=测试名">添加影片</a>
<a href="link/search?movieid=2">搜索某视频的所有链接</a>
<br>
<a href="history/add?account=1&movieid=2&time=15645645645">添加观看记录</a>
<a href="history/search?account=1">搜索某用户的所有观看记录</a>
</body>
</html>
