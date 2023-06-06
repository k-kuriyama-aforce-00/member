package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.MemberInfo;

public class U01DAO extends DAO{
	
	public int countUpdateRows(MemberInfo memberinfo)throws Exception {
		
		int update = 0;
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(""
				+ "UPDATE member_info"
				+ "SET last_name = ? ,"
				+ "first_name = ? ,"
				+ "sex = ? ,"
				+ "birth_year = ? ,"
				+ "birth_month = ? ,"
				+ "birth_day = ? ,"
				+ "phone_number = ? ,"
				+ "mail_address = ? ,"
				+ "job = ? ,"
				+ "WHERE member_info.member_id = ?");
		
		st.setString(1, memberinfo.getLastName());
		st.setString(2, memberinfo.getFirstName());
		st.setString(3, memberinfo.getSex());
		st.setInt(4, memberinfo.getBirthYear());
		st.setInt(5, memberinfo.getBirthMonth());
		st.setInt(6, memberinfo.getBirthDay());
		st.setString(7, memberinfo.getPhoneNumber());
		st.setString(8, memberinfo.getMailAddress());
		st.setString(9, memberinfo.getJob());
		st.setString(10, memberinfo.getMemberNumber());
		
		ResultSet rs3 = st.executeQuery();
		if (rs3.next()) {
          update  = rs3.getInt(1);	
          
        }
		 st.close();
         con.close();
		return update;
		
	}

}
