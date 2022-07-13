package servlet;

import service.Student;
import service.StudentImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/dealUncheckStuServlet")
public class dealUncheckStuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Student service=new StudentImp();
        String type=req.getParameter("type");
        String userid=req.getParameter("userid");
        String actiId=req.getParameter("actiId");
        service.dealUnchekStu(userid,type,actiId);
        String id=req.getParameter("id");
        String condition=req.getParameter("condition");
        req.setAttribute("condition",condition);
        req.setAttribute("id",id);
        req.getRequestDispatcher("/workCheckConditionServlet").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
