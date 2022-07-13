package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.LogRecord;
@WebFilter("/*")
public class StudentLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) req;
        String uri=request.getRequestURI();
        if(uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("/login.css")){
            chain.doFilter(req,resp);
        }
        else{
            Object user=request.getSession().getAttribute("User");
            if(user!=null){
                chain.doFilter(req,resp);
            }else{
                request.setAttribute("msg","您未登录，请登录");
                request.getRequestDispatcher("/login/login.jsp").forward(req,resp);
            }
        }
    }
    public void destroy(){

    }
}
