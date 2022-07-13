package servlet;

import main.domain.Student;
import org.apache.commons.beanutils.BeanUtils;
import service.Manager;
import service.ManagerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Manager manager = new ManagerImp();
        req.setCharacterEncoding("utf-8");
        Student student = new Student();
        Student stu = null;
        try {
            stu = manager.findStuById(req.getParameter("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(stu!=null){
            req.setAttribute("msg","学生id已存在");
            req.getRequestDispatcher("/teacher/jsp/RegStu.jsp").forward(req,resp);
        }
        student.setId(req.getParameter("id"));
        student.setPassword(req.getParameter("password"));
        student.setGender(req.getParameter("gender"));
        student.setClassname(req.getParameter("classname"));
        student.setUsername(req.getParameter("username"));
        student.setEmail(req.getParameter("email"));
        student.setPhone(req.getParameter("phone"));
        student.setAbsenttimes(0);
        student.setLatetimes(0);
        student.setBan("notban");
        student.setBantime(null);
        student.setBantype(null);
        manager.insertStuMsg(student);
        resp.sendRedirect(req.getContextPath()+"/teacher/jsp/RegStu.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
