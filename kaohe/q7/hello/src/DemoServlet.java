import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key=req.getParameter("search_id");
        String name =req.getParameter("search_name");
        String academy= req.getParameter("search_academy");
        String clazz= req.getParameter("search_class");
        resp.setContentType("text/html;charset=gbk");
        if (key!=null)
        resp.getWriter().write(Data.getInstance().findById(key));
        else if (name!=null)
            resp.getWriter().write(Data.getInstance().findByName(name));
        else if (academy!=null)
            resp.getWriter().write(Data.getInstance().findByAcademy(academy));
        else if (clazz!=null)
            resp.getWriter().write(Data.getInstance().findByClass(clazz));
        else
            resp.getWriter().write("Parameter Error");
    }
}
