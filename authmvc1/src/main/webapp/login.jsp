<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "model.UserDAO, model.UserBean" %>
<% 
	request.setCharacterEncoding("EUC-KR");
	
	String method = request.getMethod();
	String error = null;
	
	if ("POST".equalsIgnoreCase(method)) {
		String username = request.getParameter("user-id");
		String password = request.getParameter("user-pw");
		
		if (username== null || username.trim().isEmpty()
			|| password == null || password.trim().isEmpty()){
			error = "아이디와 비밀번호를 모두 입력해주세요";
		}else {
			UserDAO dao = new UserDAO();
			UserBean user = dao.login(username,password);
			
			if(user != null) {
				session.setAttribute("loginUser", user);
				response.sendRedirect(request.getContextPath()+"/profile.jsp");
				return;
			} else {
				error = "아이디 또는 비밀번호가 올바르지 않습니다.";
			}
		}			
	}
	if (error != null) {
		request.setAttribute("error", error);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="header.jsp" %>

    <main class="login">
        <h2 class="main-title">로그인</h2>
        <p class="main-desc">아이디와 비밀번호를 입력하고 로그인하세요</p>

        <p style="color:red;">${error}</p>

        <!-- Model1: 자기 자신에게 POST -->
        <form id="main-form" method="post" action="${pageContext.request.contextPath}/login.jsp">
            <div class="flex-input">
                <label class="user-id">아이디</label>
                <input class="user-id" name="user-id" type="text" required />
            </div>
            <div class="flex-input">
                <label class="user-pw">비밀번호</label>
                <input class="user-pw" name="user-pw" type="password" required />
            </div>
            <button class="login-btn" type="submit">로그인</button>
        </form>
    </main>

    <%@ include file="footer.jsp" %>
</body>
</html>