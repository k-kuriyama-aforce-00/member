package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.MemberInfo;


public class IO1DAO extends DAO{
	
	@SuppressWarnings("static-access")
	public int countInsertRows(MemberInfo memberinfo) throws Exception {
		int count2 = 0;
		
		Connection con = getConnection();
		
		
		
		
		PreparedStatement st = con.prepareStatement(
				"INSERT INTO member_info("
				+ "member_id,"
				+ "last_name,"
				+ "first_name,"
				+ "sex,"
				+ "birth_year,"
				+ "birth_month,"
				+ "birth_day,"
				+ "job,"
				+ "phone_number,"
				+ "mail_address)"
				+ "VALUES("
				+ "?,?,?,?,?,?,?,?,?,?)");
				
		
		st.setString(1, memberinfo.getMemberNumber());
		st.setString(3, memberinfo.getLastName());
		st.setString(2, memberinfo.getFirstName());
		st.setString(4, memberinfo.getSex());
		st.setInt(5, memberinfo.getBirthYear());
		st.setInt(6, memberinfo.getBirthMonth());
		st.setInt(7, memberinfo.getBirthDay());
		st.setString(8, memberinfo.getJob());
		st.setString(9, memberinfo.getPhoneNumber());
		st.setString(10, memberinfo.getMailAddress());

        
		int rs2 = st.executeUpdate();
		count2 = rs2;

       
            st.close();
            con.close();
    		
    		return count2;
      
	}
}
