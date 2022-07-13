package servlet;

import main.domain.Student;
import service.StudentImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/upDatePasswordServlet")
public class upDatePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String password=req.getParameter("password1");
        Student student= (Student) req.getSession().getAttribute("User");
        String id=student.getId();
        StudentImp service=new StudentImp();
        service.upDatePassword(id,password);
        resp.sendRedirect(req.getContextPath()+"/showStuMsgServlet");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
