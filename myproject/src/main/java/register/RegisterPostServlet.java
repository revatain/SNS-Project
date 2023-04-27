package register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register/Login")
public class RegisterPostServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PBlogMgr pMgr = new PBlogMgr();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String url = "login.jsp";
		if(pMgr.loginPMember(id, pwd)) {
			request.getSession().setAttribute("idKey", id);
			url = "register.jsp";
		}else {
			request.getSession().setAttribute("msg", "아이디와 비밀번호가 일치하지 않습니다.");
		}
		response.sendRedirect(url);
	}
}