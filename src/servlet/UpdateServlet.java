package servlet;

import main.domain.Student;
import service.Manager;
import service.ManagerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updateStuServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
        Student student = new Student();
        student.setId(req.getParameter("id"));
        student.setGender(req.getParameter("gender"));
        student.setPassword(req.getParameter("password"));
        student.setClassname(req.getParameter("classname"));
        student.setUsername(req.getParameter("username"));
        student.setEmail(req.getParameter("email"));
        student.setPhone(req.getParameter("phone"));
        Manager service=new ManagerImp();
        service.updateStu(student);
        req.setAttribute("student",student);
        resp.sendRedirect(req.getContextPath()+"/FindStuByPageServlet");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
