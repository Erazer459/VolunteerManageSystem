package servlet;

import main.domain.Activiti;
import main.domain.Student;
import service.StudentImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/ManagerAddActiServlet")
public class ManagerAddActiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Activiti activiti=new Activiti();
        activiti.setTitle(req.getParameter("title"));
        activiti.setContent(req.getParameter("content"));
        activiti.setPlace(req.getParameter("place"));
        activiti.setPeopleLimit(req.getParameter("peopleLimit"));
        activiti.setHost("管理员");
        activiti.setPoint(req.getParameter("point"));
        activiti.setHostid("none");
        activiti.setState("未开始");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            Date date=formatter.parse(req.getParameter("time"));
            activiti.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        activiti.setType("person");
        activiti.setClassname("none");
        activiti.setWorkCheck("unCheck");
        activiti.setNumofPeople(0);
        activiti.setPass("passed");
        StudentImp service=new StudentImp();
        service.insertActi(activiti);
        resp.sendRedirect(req.getContextPath()+"/findActiByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
