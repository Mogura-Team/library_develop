package test;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcTest {

  public static void main(String[] args) {
    // TODO 自動生成されたメソッド・スタブ
    try {

      Class.forName("com.mysql.jdbc.Driver"); // ドライバクラスをロード

      // データベースへ接続
      java.sql.Connection con =
          DriverManager.getConnection("jdbc:mysql://localhost:3306/lib_db",// データベース名
              "root",// 接続ユーザ名
              "pass");// パスワードはなし

      // ステートメントオブジェクトを生成
      java.sql.Statement stmt = con.createStatement();
      String sql = "select * from T_MNG_USER_INFO where (MNG_USER_ID ='﻿101') and (MNG_USER_PASS ='pass101')";// SQL文を指定
      // クエリーを実行して結果セットを取得
      ResultSet rs = stmt.executeQuery(sql);
      // 検索された行数分ループ
      while (rs.next()) {

        String MNG_USER_ID = rs.getString("MNG_USER_ID");// classを取得

        String MNG_USER_NAME = rs.getString("MNG_USER_NAME");// nameを取得

        String MNG_USER_PASS = rs.getString("MNG_USER_PASS"); // clubを取得

        String MNG_REGIST_DATE = rs.getString("MNG_REGIST_DATE"); // pointを取得

        // 結果をコンソールに表示
        System.out.println(MNG_USER_ID + " "
        + MNG_USER_NAME + " " + MNG_USER_PASS + " " + MNG_REGIST_DATE);
      }
      // データベースから切断
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
