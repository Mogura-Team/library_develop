<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
  <div class="menu">
   <a href="ManagementMenu?submit=図書一覧"><button  id="active1" class="btn btn-primary">図書一覧</button></a>
   <a href="ManagementMenu?submit=図書貸出"><button  id="active2" class="btn btn-primary lendChange">図書貸出</button></a>
   <a href="ManagementMenu?submit=貸出中一覧"><button id="active3" class="btn btn-primary">貸出中一覧</button></a>
   <a href="ManagementMenu?submit=ブックランキング"><button id="active4" class="btn btn-primary">ブックランキング</button></a>
   <a href="ManagementMenu?submit=図書登録"><button id="active5" class="btn btn-primary">図書登録</button></a>
   <a href="ManagementMenu?submit=図書削除"><button id="active6" class="btn btn-primary deleteChange">図書削除</button></a>
  </div>
  <p></p>
  <p style="border-bottom: medium solid #337ab7;"></p>
</html>