package servlet;

import main.domain.Student;
import service.Manager;
import service.ManagerImp;
import service.StudentImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/stuUpdateServlet")
public class stuUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
       String gender=req.getParameter("gender");
         String email=req.getParameter("email");
         String phone=req.getParameter("phone");
        StudentImp service=new StudentImp();
        service.upDate(gender,phone,email);
        Manager service1=new ManagerImp();
        Student student=service1.findStuById(req.getParameter("id"));
        HttpSession session=req.getSession();
        session.setAttribute("User",student);
        resp.sendRedirect(req.getContextPath()+"/showStuMsgServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
