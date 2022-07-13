package servlet;

import main.domain.Student;
import service.StudentImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/stuWorkCheckServlet")
public class stuWorkCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String actiId=req.getParameter("actiId");
        Student student=(Student) req.getSession().getAttribute("User");
        String userId=student.getId();
        service.Student service=new StudentImp();
        service.stuWorkCheck(actiId,userId);
        resp.sendRedirect(req.getContextPath()+"/findActiHavedJoinServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
