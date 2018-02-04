<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="mng_user_info" scope="session" class="manage.manageLogBean.LoginUserBean" />
<%-- Java入門 ヘッダー画面 --%>
<div align="right" id="loginNow">
 <%-- ログイン済みの場合はIDを表示 --%>

 <%
   String s = (String) session.getAttribute("btn");
   if ("guest".equals(s)) {
 %>
 ようこそ「ゲスト」さん！ <a href="/libraryWeb/Management?submit=終了">
  <button class="btn btn-success">終了</button>
 </a>
 <%
   } else {
 %>
 管理者：「<jsp:getProperty property="mngUserName" name="mng_user_info" />」でログイン中です <a
  href="/libraryWeb/Management?submit=ログアウト">
  <button class="btn btn-success logout">ログアウト</button>
 </a>
 <%
   }
 %>
</div>