package cn.aguo.web;

import cn.aguo.dao.UserDao;
import cn.aguo.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author 石成果
 * @Date 2020/8/5 15:32
 * @Email 1260839205@qq.com
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //指定浏览器页面的字符
        response.setContentType("text/html;charset=utf-8");

        //获取服务器内部传输的数据
        HttpSession session = request.getSession();

        //获取页面用户输入的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");

        //获取验证码
        Object check = session.getAttribute("check");

        //删除session中存储的数据
        session.removeAttribute("check");


        //将用户输入的用户名以及密码进行包装
        User loginUser= new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        //用来判断数据库内是否存在用户所输入的用户名以及密码
        UserDao dao = new UserDao();
        User login = dao.Login(loginUser);

        if (check != null && check.toString().equalsIgnoreCase(checkcode)){
            if (login == null){
                //登陆失败
                request.setAttribute("login_error","用户名或密码错误");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }else {
                //登陆成功
                request.getSession().setAttribute("user",username);
                response.sendRedirect(request.getContextPath()+"/Success.jsp");
            }
        }else {
            request.setAttribute("cc_error","验证码错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
