package servlet;

import main.domain.Student;
import service.StudentImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String ActiId=req.getParameter("id");
        Student student=(Student) req.getSession().getAttribute("User");
        String userId=student.getId();
        String check="未考勤";
        int num= Integer.parseInt(req.getParameter("num"));
        service.Student service=new StudentImp();
        service.Application(ActiId,userId,check,num);

        resp.sendRedirect(req.getContextPath()+"/StufindActiByPageServlet");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
