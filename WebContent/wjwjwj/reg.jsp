<%@page import="com.newlecture.jspprj.dao.MemberDao"%>
<%@page import="com.newlecture.jspprj.dao.jdbc.JdbcMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <% 
    MemberDao memberDao = new JdbcMemberDao();
 
    %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
</head>
<body>

    <main id="body" class="body">

        <h1>개인정보 등록</h1>
        <ol>
            <li>약관동의</li>
            <li>개인정보 등록</li>
            <li>회원가입 완료</li>
        </ol>
        <form action="regProc.jsp" method="post">
            <fieldset>
                <legend class="hidden">개인정보 등록</legend>
                <dl>
                    <dt id="uid">아이디</dt>
                    <dd><input type="text" name="uid" id="uid" /></dd>

                    <dt id="pwd">비밀번호</dt>
                    <dd><input type="password" name="pwd" id="pwd" /></dd>

                    <dt id="pwd2">비밀번호 확인</dt>
                    <dd><input type="password" id="pwd2" /></dd>

                    <dt id="name">이름</dt>
                    <dd><input type="text" name="name" id="name" /></dd>

                    <dt id="nic">필명</dt>
                    <dd><input type="text" name="nicname" id="nicname" /></dd>

                    <dt id="nic">사진</dt>
                    <dd>
                        <input type="radio" name="photo" value="" id="photo1" checked />기본1
                        <input type="radio" name="photo" value="" id="photo2" />기본2
                        <input type="radio" name="photo" value="" id="photo3" />기본3
                    </dd>

                    <dt id="gender">성별</dt>
                    <dd>
                        <select name="gender" id="gender">
                            <option selected value="남성">남성</option>
                            <option value="여성">여성</option>
                        </select>
                    </dd>

                    <dt id="birth">생년월일</dt>
                    <dd>
                        <input type="text" name="year" id="year" />년
                        <input type="text" name="month" id="month" />월
                        <input type="text" name="day" id="day" />일
                        <input type="radio" name="islunar" value="false" id="issolar" checked />양력
                        <input type="radio" name="islunar" value="true" id="islunar" />음력
                    </dd>

                    <dt id="phone">핸드폰 번호</dt>
                    <dd><input type="text" name="phone" id="phone" /></dd>

                    <dt id="email">이메일</dt>
                    <dd><input type="text" name="email" id="email" /></dd>

                </dl>
            </fieldset>
            <p id="button-container" class="space-top text-center">
                <input type="submit" value="등록" />
                <a href="notice.jsp">취소</a>
            </p>
        </form>
    </main>

</body>

</html>
