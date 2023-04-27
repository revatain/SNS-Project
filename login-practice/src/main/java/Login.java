

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 아이디 비번 확인해서 맞으면 맞다고, 틀리면 틀렸다고 리턴
		String body = Utils.getBody(request);
		System.out.println(body);
		Map map = Utils.getQueryMap(body);
		System.out.println(map);
		
		// 데이터베이스에 아이디 hong / 비번 1234 있다고 가정
		if("hong".equals(map.get("id")) &&
			"1234".equals(map.get("pw"))
		) {
			ResDTO resDTO = new ResDTO(0, "로그인에 성공했습니다.", null);
			
			String json = new Gson().toJson(resDTO);
			
			// response.setStatus(HttpServletResponse.SC_OK);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			response.getWriter().print(json);
		} else {
			
			ResDTO resDTO = new ResDTO(1, "아이디 또는 비밀번호를 확인해주세요.", null);
			
			String json = new Gson().toJson(resDTO);
			
			// response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			response.getWriter().print(json);
		}
		
	}

}














