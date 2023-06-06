package jp.co.aforce.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.MemberInfo;

public class SO1DAO extends DAO{
	
	public int countMatchingRows(MemberInfo memberInfo) throws Exception {
		int count = 0;
		

        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
        	    "SELECT COUNT(*) AS COUNT FROM member_info "
        	    + "WHERE member_info.last_name = ? "
        	    + "AND first_name = ? "
        	    + "AND sex = ? "
        	    + "AND birth_year = ? "
        	    + "AND birth_month = ? "
        	    + "AND birth_day = ? "
        	    + "AND phone_number = ? "
        	    + "AND mail_address = ?" 
        	    + "AND job = ? ");

		
		st.setString(1, memberInfo.getLastName());
        st.setString(2, memberInfo.getFirstName());
        st.setString(3, memberInfo.getSex());
        st.setInt(4, memberInfo.getBirthYear());
        st.setInt(5, memberInfo.getBirthMonth());
        st.setInt(6, memberInfo.getBirthDay());
        st.setString(7, memberInfo.getPhoneNumber());
        st.setString(8, memberInfo.getMailAddress());
		st.setString(9, memberInfo.getJob());
        
		ResultSet rs = st.executeQuery();
        
        if (rs.next()) {
            count = rs.getInt(1);	
        }
        
        rs.close();
        st.close();
        con.close();
		
		return count;
		
	}

}
