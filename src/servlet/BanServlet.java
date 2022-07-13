package servlet;

import service.Manager;
import service.ManagerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/BanServlet")
public class BanServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String id=req.getParameter("id");
        String type=req.getParameter("type");
        String _bantime=req.getParameter("ban");
        Date bantime = null;
        if (type.equals("temp") && _bantime.equals("")){
            req.setAttribute("id",id);
            req.setAttribute("msg","请输入封禁截止日期！");
            req.getRequestDispatcher("/teacher/jsp/ban.jsp").forward(req,resp);
        }
        try {
             bantime=sdf.parse(_bantime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Manager service=new ManagerImp();
        service.BanStudent(bantime,type,id);
        resp.sendRedirect(req.getContextPath()+"/FindStuByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
