package servlet;

import main.domain.ancm;
import service.StudentImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
@WebServlet("/teacherFindAncmByIdServlet")
public class teacherFindAncmByIdServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            String id=req.getParameter("id");
            StudentImp service=new StudentImp();
            ancm ancm=service.finAcnmById(id);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm");
            String time=formatter.format(ancm.getPublish_time());
            req.setAttribute("time",time);
            req.setAttribute("ancm",ancm);
            req.getRequestDispatcher("teacher/jsp/UpDateAncm.jsp").forward(req,resp);
        }
}