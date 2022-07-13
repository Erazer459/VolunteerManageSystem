package servlet;

import service.Manager;
import service.ManagerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/confirmActiServlet")
public class confirmActiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Manager service=new ManagerImp();
        String id=req.getParameter("id");
        String pass=req.getParameter("pass");
        if(pass.equals("passed")){
            service.confirmActi("passed",id);
        }else if(pass.equals("unpassed")){
            service.confirmActi("unpassed",id);
        }
        resp.sendRedirect(req.getContextPath()+"/FindAllUnkownActiServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
