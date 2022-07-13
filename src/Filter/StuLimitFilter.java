package Filter;
import main.domain.manager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter("/teacher/*")
public class StuLimitFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    /**
     * 防止学生访问管理员资源
     * @param req
     * @param resp
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) req;
        Object user=request.getSession().getAttribute("User");
        if(user instanceof manager){
            filterChain.doFilter(req,resp);
        }else{
            req.setAttribute("msg","您没有权限访问");
            request.getRequestDispatcher("/student/jsp/studentMenu.jsp").forward(req,resp);//此处应为学生界面主菜单
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
