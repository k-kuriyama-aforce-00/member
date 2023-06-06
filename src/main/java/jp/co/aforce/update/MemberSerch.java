package jp.co.aforce.update;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.MemberInfo;
import jp.co.aforce.dao.S03DAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class MemberSerch
 */
@WebServlet("/jp.co.aforce/memberserch")
public class MemberSerch extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		MemberInfo memberInfo = new MemberInfo();
		String memberId = request.getParameter("memberId");
		
		memberInfo.setMemberNumber(memberId); 
		
		//response.sendRedirect("/views/update.jsp?"+memberId);
		//memberInfoのID部分を取得しセット
		//会員情報の照会
		
		HttpSession session = request.getSession();
		session.setAttribute("member_id",memberId.toString());
		
		
		S03DAO s03 = new S03DAO();
		 try {
			List<MemberInfo> member_info = s03.searchMembers(memberId);
			request.setAttribute("member_info", member_info);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../views/update.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			out.println("登録情報が見つかりません");
			e.printStackTrace();
		}

		
		
		

		 
	}

}
