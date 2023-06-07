<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%@ page import="jp.co.aforce.beans.MemberInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession"%>

<c:if test="${member_id != null }">
</c:if>
<div class="input">
	
	

	
		<form action="../jp.co.aforce/memberserch" method="post">
			<p>■会員番号<br>
				<input type="text" name="memberId" value="${member_id}">
				<input type="submit" value="検索">
		</form>
	
	<%List<MemberInfo>member_info = (List<MemberInfo>)request.getAttribute("member_info"); %>	<%
		if(member_info != null){
		for( MemberInfo m : member_info){
			%>
	<form action="../jp.co.aforce/update" method="post">
		<input type="hidden" name="memberId" value="${member_id}">
		<P>■名前<br>
			姓<input type="text" name="firstName" value="<%= m.getFirstName() %>"  required>名<input type="text" name="lastName" value=<%= m.getLastName() %> required>
		</P>
		<p>■性別<br>
			<input type="radio" name="sex" <% if(m.getSex().equals("男")){%>checked<%} %> value="男">男
			<input type="radio" name="sex" <% if(m.getSex().equals("女")){%>checked<%} %> value="女">女
		</p>
		<P>■生年月日<br>
			<select name="birthYear"  value="<%= m.getBirthYear() %>" required>
                <option value=""></option>
                    <%for (int i = 1920; i <= 2020; i++) {%>
                    <option value="<%=i%>" <%if (i == m.getBirthYear()) {%> selected
                        <%}%>><%=i%></option>
                    <%}%>
              </select>年
              
             
			<select name="birthMonth" value<%= m.getBirthMonth() %>" required>
                <option value=""></option>
                <%for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>" <%if (i == m.getBirthMonth()) {%> selected
                                <%}%>><%=i%></option>
                            <%}%>
           	 </select>月
			<select name="birthDay" value="<%= m.getBirthDay() %>" required>
                <option value=""></option>
                <%for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>" <%if (i == m.getBirthDay()) {%> selected
                    <%}%>><%=i%></option>
                <%}%>
            </select>日
		</P>
		<P>■電話番号<br>
			<input type="number" name="phoneNumber" value="<%= m.getPhoneNumber() %>" required>
		</P>
		<P>■メールアドレス<br>
			<input type="text" name="mailAddress" value="<%= m.getMailAddress() %>" required>
		</P>
		<P>■職業<br>
			<select name="job" value="" required >
				<option value=""></option>
				<option value="会社員" <% if(m.getJob().equals("会社員")){%>selected<%} %>>会社員</option>
				<option value="自営業" <% if(m.getJob().equals("自営業")){%>selected<%} %>>自営業</option>
				<option value="学生" <% if(m.getJob().equals("学生")){%>selected<%} %>>学生</opt ion>
				<option value="その他" <% if(m.getJob().equals("その他")){%>selected<%} %>>その他</option>
			</select>
		<p>
		<input type="submit" value="更新"> 
	</form>
	<%}
	}%>
	<button type="button">戻る</button>
</div>


</body>
</html>