<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><jsp:useBean id="mng_user_info" scope="session" class="manage.manageLogBean.LoginUserBean" /><!DOCTYPE html><html><head><title>管理メニュー</title><meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="/libraryWeb/css/bootstrap.min.css"><link href="/libraryWeb/css/library.css" rel="stylesheet" type="text/css" /></head><body class="drawer drawer--left"> <div class="container">  <jsp:include page="/common/header.jsp" />  <%    if (null != request.getAttribute("btn")) {  %>  <h4>ゲストメニュー</h4>  <a href="ManagementMenu?submit=図書一覧"><button class="btn btn-primary">図書一覧</button></a>  <%    } else {  %>  <h4>管理メニュー</h4>  <a href="./ManagementMenu?submit=ユーザ一覧"><button class="btn btn-primary">ユーザ一覧</button></a>  <a href="./ManagementMenu?submit=図書一覧"><button class="btn btn-primary">図書一覧</button></a>  <%    }  %> </div></body></html>