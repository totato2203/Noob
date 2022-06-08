<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "javaexp.a13_database.A04_PreDAO"
    import = "javaexp.z03_vo.Dept"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		h2{color : pink;}
	</style>
	<script type="text/javascript">
		function call(obj){
			alert("안녕하세요");
			// DoM으로 해당 배경색상이 변경
			obj.style.backgroundColor = "navy";
		}
	</script>
</head>
<body>

<!-- html 주석
	1. html 코드
	
	태그 이벤트 = "함수(매개변수)"
	
	-->
	
	<h2 onclick = "call(this)"> jsp 입니다. </h2>
	
	<%
	// 자바코드 넣을 수 있음
	A04_PreDAO dao = new A04_PreDAO();
	for(Dept d : dao.getDeptList("", "")){
	%>
	<h3><%= d.getDeptno() %>, <%=d.getDname()%>, <%=d.getLoc() %></h3>
	<%
	}
	%>
</body>
</html>

