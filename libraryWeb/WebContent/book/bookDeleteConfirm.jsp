<%@ page import="java.util.ArrayList"%>
<%@ page import="book.bookBean.BookProcessBean"%>
<%@ page import="common.Cnst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="mng_user_info" scope="session" class="manage.manageLogBean.LoginUserBean" />

<!DOCTYPE html>
<html>
<head>
<title>図書削除確認</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//cdn.datatables.net/plug-ins/1.10.16/integration/font-awesome/dataTables.fontAwesome.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link rel="stylesheet" href="/libraryWeb/css/bootstrap.min.css">
<link rel="stylesheet" href="/libraryWeb/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/libraryWeb/css/library.css">
<link rel="stylesheet" href="/libraryWeb/css/drawer.min.css">
<script src="/libraryWeb/js/jquery-3.1.0.min.js"></script>
<script src="/libraryWeb/js/drawer.min.js"></script>
<script src="/libraryWeb/js/iscroll.js"></script>
<script type="text/javascript" src="/libraryWeb/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/libraryWeb/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="/libraryWeb/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/libraryWeb/js/library.js"></script>
</head>
<body class="drawer drawer--left">
 <div class="container-fluid">
  <jsp:include page="/common/header.jsp" />
  <h4 class="head-margin">図書削除確認</h4>
  <form id="frm-example" action="../BookProcess" method="get">
   <table id="book" class="display table table-condensed" cellspacing="0" width="100%">
    <thead>
     <tr>
      <th>ID</th>
      <th>タイトル</th>
      <th>巻次</th>
      <th>著者</th>
      <th>出版者</th>
      <th>出版年</th>
      <th>登録日</th>
     </tr>
    </thead>
    <tfoot>
     <tr>
      <th>ID</th>
      <th>タイトル</th>
      <th>巻次</th>
      <th>著者</th>
      <th>出版者</th>
      <th>出版年</th>
      <th>登録日</th>
     </tr>
    </tfoot>
   </table>
   <button class="btn btn-primary" name="submit"onClick="return confirm('削除しますか？');"value="削除する">削除する</button>
   <input type="hidden" name="book_id"/>
  </form>
  <a href="javascript:history.back(-1)"><button class="btn btn-primary">戻る</button></a>
 </div>
 <script>

 // セッションストレージから図書情報を取得
 var bookInfoJson = window.sessionStorage.getItem('bookInfoJson');
 //Jsonオブジェクト変換
 bookInfoJson = $.parseJSON(bookInfoJson);
 console.log(bookInfoJson);

 // tableのDOM要素
 var table = null;

 $(document).ready(function (){

   // テーブル日本語化
   dataTablesLanguage();
   // フォームのhidden要素にbookidを詰める
   bookGetId(bookInfoJson);
   // テーブルにユーザ情報を表示する
   table = bookListdataTablesShow(bookInfoJson);
 });

  </script>
</body>
</html>