package member.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import member.model.MemberService;

@WebServlet("/register/checkAccount")
public class CheckAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckAccount() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		request.setCharacterEncoding("UTF-8");
		MemberService service = new MemberService();
		boolean result = service.accountCheck(request.getParameter("username").toLowerCase());		
		out.println(result);
	}

}
