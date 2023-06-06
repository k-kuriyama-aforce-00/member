package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.MemberInfo;

public class D01DAO extends DAO{
	public int countDeleteRows(MemberInfo memberInfo)throws Exception{
		int delete = 0;
	
	 Connection con = getConnection();

     PreparedStatement st = con.prepareStatement("DELETE FROM member_info WHERE member_id = ?");
     
     st.setString(1, memberInfo.getLastName());
     
     ResultSet rs = st.executeQuery();
     
     if(rs.next()) {
    	 delete = rs.getInt(1);
     }
		
		return delete;
		
	}
	

}
