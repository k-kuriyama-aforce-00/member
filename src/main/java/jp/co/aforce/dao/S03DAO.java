package jp.co.aforce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.MemberInfo;

public class S03DAO extends DAO{
	public List<MemberInfo> searchMembers(String memberInfo) throws Exception {
	    List<MemberInfo> member_info = new ArrayList<>();
		
		
			    try {
			      Connection con = getConnection();
			      PreparedStatement st = con.prepareStatement("SELECT * FROM member_info WHERE member_id = ?");
			      st.setString(1, memberInfo);
			      ResultSet rs = st.executeQuery();
 
			      // 検索結果をオブジェクトにマッピングしてリストに追加
			      while (rs.next()) {
			        MemberInfo member = new MemberInfo();
			        member.setMemberNumber(rs.getString("member_id"));
			        member.setFirstName(rs.getString("first_name"));
			        member.setLastName(rs.getString("last_name"));
			        member.setSex(rs.getString("sex"));
			        member.setBirthYear(Integer.parseInt(rs.getString("birth_year")));
			        member.setBirthMonth(Integer.parseInt(rs.getString("birth_month")));
			        member.setBirthDay(Integer.parseInt(rs.getString("birth_day")));
			        member.setJob(rs.getString("job"));
			        member.setPhoneNumber(rs.getString("phone_number"));
			        member.setMailAddress(rs.getString("mail_address"));

			        member_info.add(member);
			      }

			      // リソースの解放
			     rs.close();
			     st.close();
			     con.close();
			     System.out.println(member_info);
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }

			    return member_info;
			  }

}
