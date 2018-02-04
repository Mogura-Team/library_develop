<%@ page language="java" contentType="text/html; charset=UTF-8"%><%-- Java入門 ログインエラー画面 --%>
<!DOCTYPE html>
<html>
<head>
<title>Java入門</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/libraryWeb/css/bootstrap.min.css">
</head>
<body>
 <div class="container">
  <h4>ログインエラー</h4>
  <p>入力されたユーザは存在しません...</p>
  <form>
   <input class="btn btn-primary" type="button" onclick="location.href='./login.jsp'" value="戻る" />
  </form>
 </div>
</body>
</html>