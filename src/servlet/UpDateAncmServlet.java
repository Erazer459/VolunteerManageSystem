package servlet;

import service.Manager;
import service.ManagerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/UpDateAncmServlet")
public class UpDateAncmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        Date date = new Date(System.currentTimeMillis());
        String id=req.getParameter("id");
        Manager service=new ManagerImp();
        service.UpDateAncmById(id,title,content,date);
        resp.sendRedirect(req.getContextPath()+"/ShowAncmServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
