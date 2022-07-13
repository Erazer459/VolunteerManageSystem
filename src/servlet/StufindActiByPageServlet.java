package servlet;

import main.domain.Activiti;
import main.domain.PageBean;
import main.domain.Student;
import service.Manager;
import service.ManagerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
@WebServlet("/StufindActiByPageServlet")
public class StufindActiByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String currentPage=req.getParameter("currentPage");//当前页码
        String rows=req.getParameter("rows");//每页显示条数
        if(currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }if(rows==null||"".equals(rows)){
            rows="5";
        }
        //获取条件查询参数
        Map<String,String[]> condition=req.getParameterMap();
        Manager service=new ManagerImp();
        Student student=(Student)req.getSession().getAttribute("User");
        String id=student.getId();
        PageBean<Activiti> pb=service.StufindActiByPage(currentPage,rows,condition,id);
        req.setAttribute("pb",pb);
        req.setAttribute("condition",condition);//将查询条件存入，回显信息
        req.getRequestDispatcher("/student/jsp/checkActiCanRecieve.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
