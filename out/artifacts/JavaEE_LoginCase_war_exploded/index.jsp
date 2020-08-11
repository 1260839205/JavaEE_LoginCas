<%--
  Created by IntelliJ IDEA.
  User: 石成果
  Date: 2020/8/4
  Time: 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登陆</title>
    <!-- Bootstrap -->
    <link href="/aguo/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/aguo/js/jquery-3.5.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/aguo/js/bootstrap.min.js"></script>

    <style>
      .form-size{
        width: 300px;
      }
      body{
        background-color: #2aabd2;
      }
      .form-size2{
        width: 100%;
        margin-top: 250px;
      }
      .form-size3{
        width: 100px;
        float: left;
      }
      #checkcode{
        float: left;
      }
      .divcolor{
        vertical-align:middle;
        color: red;
        margin-top: 7px;
      }
    </style>
    <script>
      window.onload = function(){
        //获取图片id
        var imgid = document.getElementById("checkcode");

        // document.write(imgid);

        //添加时间戳，使每次请求不同
        // var datetime = new Date();

        //绑定图片单击事件
        imgid.onclick = function() {
          imgid.src = "/aguo/checkCodeServlet?" + new Date().getTime();
        }
      }
    </script>
  </head>
  <body>
  <div class=" form-size2">
      <form class="form-horizontal" action="/aguo/LoginServlet" method="post">
        <div class="form-group">
          <label for="username" class="col-sm-5 control-label">用户名</label>
          <div class="col-sm-7">
            <input type="text" name="username" class="form-control form-size" id="username" placeholder="请输入用户名">
          </div>
        </div>
        <div class="form-group">
          <label for="password" class="col-sm-5 control-label">密码</label>
          <div class="col-sm-7">
            <input type="password" name="password" class="form-control form-size" id="password" placeholder="请输入密码">
          </div>
        </div>
        <div class="form-group">
          <label for="check" class="col-sm-5 control-label">验证码</label>
          <div class="col-sm-3">
            <input type="text" name="checkcode" id="check" class="form-control form-size3" placeholder="输入验证码">
            <img class="col-sm-4" id="checkcode" src="/aguo/checkCodeServlet">
            <div class="col-sm-4 divcolor" id="check_error"><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-5 col-sm-7">
            <button type="submit" class="col-sm-2 btn btn-default" id="lg_error">登陆</button>
            <div class="col-sm-5 divcolor" id="lg_error2"><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%></div>
          </div>
        </div>
      </form>
  </div>
  </body>
</html>
