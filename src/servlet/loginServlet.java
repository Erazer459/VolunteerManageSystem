package servlet;

import main.domain.Student;
import main.domain.manager;
import service.ManagerLogin;
import service.ManagerLoginImp;
import service.StudentLogin;
import service.StudentLoginImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
        HttpSession session=req.getSession();
        String type=req.getParameter("usertype");
        String id= req.getParameter("id");
        String password=req.getParameter("password");
      if((password==null||id==null)||(password.equals("") || id.equals(""))){
          req.setAttribute("msg","用户名或密码未填写");
          req.getRequestDispatcher("/login/login.jsp").forward(req,resp);
      }
if(type.equals("student")){
    Student student=new Student();
    student.setPassword(password);
    student.setId(id);
    StudentLogin service=new StudentLoginImp();
    Student stu=service.login(student);
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
    Date currenttime=new Date(System.currentTimeMillis());
    if(stu !=null){//判断是否被ban
        if(stu.getBantype()==null||stu.getBan().equals("notban")){
            session.setAttribute("User",stu);
            resp.sendRedirect(req.getContextPath()+"/student/jsp/studentMenu.jsp");
    }else if (stu.getBantype().equals("temp")){
            if(stu.getBantime().compareTo(currenttime)==-1){
                req.setAttribute("msg","用户已被封禁，封禁截止时间:"+stu.getBantime());
                req.getRequestDispatcher("/login/login.jsp").forward(req,resp);
            }else{
                session.setAttribute("User",stu);
                resp.sendRedirect(req.getContextPath()+"/student/jsp/studentMenu.jsp");
            }
        }
        else{
            req.setAttribute("msg","用户已被封禁，封禁截止时间:"+stu.getBantime());
            req.getRequestDispatcher("/login/login.jsp").forward(req,resp);
        }
    }
    else{
        req.setAttribute("msg","用户名或密码错误");
        req.getRequestDispatcher("/login/login.jsp").forward(req,resp);
    }
}
else if(type.equals("manager")){
    manager manager=new manager();
    manager.setId(id);
    manager.setPassword(password);
    ManagerLogin service=new ManagerLoginImp();
    manager manager1=service.login(manager);
    if(manager1 !=null){
        //存在用户信息
        //将该用户信息存入session
        session.setAttribute("User",manager1);
        //跳转登录成功页面,管理者界面
        resp.sendRedirect(req.getContextPath()+"/teacher/jsp/managerMenu.jsp");
    }else{
        req.setAttribute("msg","用户名或密码错误");
        req.getRequestDispatcher("/login/login.jsp").forward(req,resp);
    }
}
}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
