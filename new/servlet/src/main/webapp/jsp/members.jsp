<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jaemjeon
  Date: 2024/02/25
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody> <%
    for (Member member : members) {
        out.write("    <tr>");
        out.write("    <tr>" + member.getId() + "</td>");
        out.write("    <tr>" + member.getUsername() + "</td>");
        out.write("    <tr>" + member.getAge() + "</td>");
        out.write("    <tr>");
    }
    %>
    </tbody>
</table>
</body>
</html>