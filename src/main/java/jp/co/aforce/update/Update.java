package jp.co.aforce.update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberInfo;
import jp.co.aforce.dao.U01DAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Update
 */
@WebServlet("/jp.co.aforce/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setLastName(request.getParameter("lastName"));
		memberInfo.setFirstName(request.getParameter("firstName"));
		memberInfo.setSex(request.getParameter("sex"));
		memberInfo.setBirthYear(Integer.parseInt(request.getParameter("birthYear")));
		memberInfo.setBirthMonth(Integer.parseInt(request.getParameter("birthMonth")));
		memberInfo.setBirthDay(Integer.parseInt(request.getParameter("birthDay")));
		memberInfo.setJob(request.getParameter("job"));
		memberInfo.setPhoneNumber(request.getParameter("phoneNumber"));
		memberInfo.setMailAddress(request.getParameter("mailAddress"));
		
		U01DAO dao3 = new U01DAO();
		int update = 0;
		
		try {
			update = dao3.countUpdateRows(memberInfo);
			if(update == 1) {
			out.println("情報の更新に成功しました。");
			}else{
			out.println("情報の更新に失敗しました。");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(update == 1) {
			out.println("情報の更新に成功しました。");
			}else{
			out.println("情報の更新に失敗しました。");
			}
		
		Page.footer(out);
	}

}
