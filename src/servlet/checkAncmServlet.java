package servlet;

import main.domain.ancm;
import service.Student;
import service.StudentImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/checkAncmServlet")
public class checkAncmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Student service=new StudentImp();
        List<ancm> ancm=service.findAllAncm();
        req.setAttribute("ancm",ancm);
        req.getRequestDispatcher("/student/jsp/stuAncm.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
