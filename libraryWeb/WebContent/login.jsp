<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><jsp:useBean id="mng_user_info" scope="session" class="manage.manageLogBean.LoginUserBean" /><!DOCTYPE html><html><head><title>ログイン</title><meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="/libraryWeb/css/bootstrap.min.css"><link href="/libraryWeb/css/library.css" rel="stylesheet" type="text/css" /></head><body> <div class="container-fluid">  <h4>図書管理システム</h4>  <form action="./Management" method="post">   <div class="form-group">    <label for="InputEmail">ログインID</label> <input class="form-control" name="mng_user_id" id="InputEmail"     placeholder="IDを入力して下さい。" required>   </div>   <div class="form-group">    <label for="InputPassword">パスワード</label> <input type="password" class="form-control" name="mng_user_pass" id="InputPassword"     placeholder="パスワードを入力して下さい。" required>   </div>   <input class="btn btn-primary" type="submit" name="submit" value="ログイン" />  </form>  <div class="floatl-btn">   <div class="guestLogin">    <a href="/libraryWeb/Management?submit=ゲスト">     <button class="btn btn-success">ゲストでログイン</button>    </a>   </div>   <div class="signUp">    <a href="/libraryWeb/Management?submit=サインアップ">     <button class="btn btn-success">サインアップ</button>    </a>   </div>  </div> </div></body></html>