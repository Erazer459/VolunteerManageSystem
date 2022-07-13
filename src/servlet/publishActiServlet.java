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
@WebServlet("/publishActiServlet")
public class publishActiServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Activiti activiti=new Activiti();
        activiti.setTitle(req.getParameter("title"));
        activiti.setContent(req.getParameter("content"));
        activiti.setPlace(req.getParameter("place"));
        activiti.setPeopleLimit(req.getParameter("peopleLimit"));
        Student student= (Student) req.getSession().getAttribute("User");
        String host=student.getUsername();
        String hostid=student.getId();
        activiti.setHostid(hostid);
        activiti.setHost(host);
        activiti.setState("未开始");
        activiti.setPoint(req.getParameter("point"));
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            Date date=formatter.parse(req.getParameter("time"));
            activiti.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String type=req.getParameter("type");
        if(type.equals("person")){
            activiti.setType("person");
        }else{
            activiti.setType("class");
        }
        if(type.equals("person")){
            activiti.setClassname("none");
        }else if(type.equals("class")){
            activiti.setClassname(student.getClassname());
        }
        activiti.setWorkCheck("unCheck");
        activiti.setNumofPeople(0);
        activiti.setPass("unknown");
        StudentImp service=new StudentImp();
        service.insertActi(activiti);
        resp.sendRedirect(req.getContextPath()+"/student/jsp/publishActi.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
