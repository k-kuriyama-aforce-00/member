package jp.co.aforce.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberInfo;
import jp.co.aforce.dao.IO1DAO;
import jp.co.aforce.dao.SO1DAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/jp.co.aforce/registration")
public class Registration extends HttpServlet {
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
		
		// memberInfoの各プロパティに値を設定する
		//会員情報の検索
		SO1DAO dao1 = new SO1DAO();
		int count = 0;
		
		
		try {
			count = dao1.countMatchingRows(memberInfo);
		} catch (Exception e) {
			out.println(e);
		}
		if(count >= 1) {
			out.println("会員情報は既に登録されています。");
		}else {
			//会員情報の登録
			if(count == 0) {
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
				String formattedDate = sdf.format(now);
				String newMemberNum = ("A" +formattedDate );
				memberInfo.setMemberNumber(newMemberNum);
	       
				IO1DAO dao2 = new IO1DAO();
				int count2 = 0;
	        
				try {
					count2 = dao2.countInsertRows(memberInfo);
				} catch (Exception e) {
				
					out.println(e);
				}
	        
				if(count2 == 1) {
					out.println("会員情報を登録しました。");
				}else {
					out.println("会員情報の登録に失敗しました。");
					out.println(count2);
				}
			}
	       Page.footer(out);
		}
	}

}
