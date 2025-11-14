<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.UserBean" %>
<%
	UserBean loginUser = (UserBean) session.getAttribute("loginUser");
	if(loginUser == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		return;
	}
	request.setAttribute("user", loginUser);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DCU STUDY - 프로필</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css"></head>
<body>
    <%@ include file="header.jsp" %>

    <main class="profile">
        <div class="welcome-container">
            <img src="${pageContext.request.contextPath}/img/user.png"
                 alt="프로필이미지" class="profile-img">
            <h2>${user.username}님 환영합니다!</h2>
            <p>서비스에 오신것을 진심으로 환영합니다.</p>
            <p>오늘도 즐거운 하루 보내세요!</p>
        </div>
    </main>

    <%@ include file="footer.jsp" %>
</body>
</html>