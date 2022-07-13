package servlet;

import main.domain.Activiti;
import service.Manager;
import service.ManagerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/FindActiByIdServlet")
public class FindActiByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id=req.getParameter("id");
        Manager service=new ManagerImp();
        Activiti activiti=service.finActiById(id);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm");
        String time=formatter.format(activiti.getTime());
        req.setAttribute("time",time);
        req.setAttribute("activiti",activiti);
        String url=req.getParameter("uri");
        req.getRequestDispatcher("/teacher/jsp/"+url).forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
