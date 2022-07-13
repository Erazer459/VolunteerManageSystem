package servlet;

import main.domain.Student;
import service.Manager;
import service.ManagerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/BanStuServlet")
public class BanStuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id=req.getParameter("id");
        Manager service=new ManagerImp();
        Student student= service.findStuById(id);
        req.setAttribute("student",student);
        req.getRequestDispatcher("/teacher/jsp/ban.jsp").forward(req,resp);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
