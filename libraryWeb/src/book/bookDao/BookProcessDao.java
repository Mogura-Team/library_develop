package book.bookDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.ConnectionBean;

public class BookProcessDao {

  /** UPDATE_TABLE_USER_STATUS **/
  final String UPDATE_T_USER_STATUS = "updateTUserStatus";

  /** UPDATE_T_BOOK_STATUS **/
  final String UPDATE_T_BOOK_STATUS = "updateTBookStatus";

  /** DELETE_T_BOOK_STATUS **/
  final String DELETE_T_BOOK_STATUS = "deleteTBookStatus";

  /** DELETE_TABLE_BOOK_INFO **/
  final String DELETE_T_BOOK_INFO = "deleteTBookInfo";

  /** DELETE_TABLE_USER_INFO **/
  final String DELETE_T_USER_INFO = "deleteTUserInfo";

  /** INSERT_T_LENDING_BOOK_TMP **/
  final String INSERT_T_LENDING_BOOK_TMP = "insertTLendingBookTmp";

  private Connection con = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;
  public ConnectionBean cb = new ConnectionBean();
  private int flag;//メソッドの結果判定フラグ

  /**
   * @method: UserProcessDB
   * @discription: 図書情報,図書状態管理登録
   * @projectPass: libraryWeb.user.userDB.UserProcessDB.java
   * @param mngUserId
   * @param userName
   * @param userAddress
   * @param userSexKbn
   * @param userPass
   * @param userRegisteDate
   * @param userAge
   * @return int
   * @throws SQLException
   */
  public int bookRegisteDao(String bookId, String title, String bookRegisteDate) throws SQLException {

    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());
      con.setAutoCommit(false);

      // SQL文を生成
      ps = con.prepareStatement("insert into T_BOOK_INFO(title,book_registe_date)value( ? , ? )");

      // SQL文の「？」に変数をセット
      ps.setString(1, title);
      ps.setString(2, bookRegisteDate);

      // SQLを実行
      flag = ps.executeUpdate();

      // SQL文を生成
      ps = con.prepareStatement("insert into T_USER_STATUS(mng_user_id,user_id)value( ? , ? )");

      // SQL文の「？」に変数をセット
      ps.setString(1, bookId);
      ps.setString(2, title);

      // SQLを実行
      flag = ps.executeUpdate();

      // コミットする
      con.commit();

    } catch (ClassNotFoundException ce) {
      // ドライバが見つからなかったとき
      ce.printStackTrace();
    } catch (SQLException ce) {
      // sqlが一つでも失敗したらロールバック
      con.rollback();
      System.out.println("登録失敗：ロールバック実行");
      ce.printStackTrace();
    }
    return flag;
  }

  /**
   * @method: BookProcessDao
   * @discription: 図書情報一覧を取得
   * @projectPass: libraryWeb.book.bookDao.BookProcessDao.java
   * @return ResultSet
   * @throws SQLException
   */
  public ResultSet getBookListDao() throws SQLException {
    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

      ps = con
          .prepareStatement("select TBI.book_id,TBI.title,TBI.winding_next,TBI.series,TBI.version_display,TBI.author,TBI.publisher,TBI.year_publication,TBI.isbn,TBI.number_pages_h_w,TBI.scope_disclosuer,TBI.mng_user_id,TBS.book_num_lending,TBS.book_lend_status,TBI.book_registe_date"
              + " from T_BOOK_INFO TBI inner join T_BOOK_STATUS TBS on TBI.book_id = TBS.book_id;");

      // SQLを実行
      rs = ps.executeQuery();

    } catch (ClassNotFoundException ce) {
      // ドライバが見つからなかったとき
      ce.printStackTrace();
    } catch (SQLException ce) {
      ce.printStackTrace();
    }
    return rs;
  }

  /**
   * @method: BookProcessDao
   * @discription: 図書状態管理,ユーザ状態管理更新<br>
   *               貸出中の情報登録
   * @projectPass: libraryWeb.book.bookDao.BookProcessDao.java
   * @param userId
   * @param bookId
   * @param lendingDate
   * @param returnDate
   * @param mngUserId
   * @return int
   * @throws SQLException
   */
  public int lendRegisteDao(String userId, ArrayList<String> bookId,
      String lendingDate, String returnDate, String mngUserId)
      throws SQLException {
    // makeSqlメソッドの判定用
    String param = "";

    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

      // 自動コミット無しにする
      con.setAutoCommit(false);

      //図書貸し出し履歴を更新する
      // makeSqlメソッドの判定用
      param = UPDATE_T_BOOK_STATUS;
      // SQL文を生成
      ps = con.prepareStatement(makeLendRegisteSql(userId, bookId,
          lendingDate, returnDate, mngUserId,param));
      // SQLを実行
      flag = ps.executeUpdate();

      //ユーザが借りた図書履歴を更新する
      // makeSqlメソッドの判定用
      param = UPDATE_T_USER_STATUS;
      // SQL文を生成
      ps = con.prepareStatement(makeLendRegisteSql(null, bookId, null, null, null, param));
      // SQL文の「？」に変数をセット
      ps.setString(1, userId);
      // SQLを実行
      flag = ps.executeUpdate();

      //貸出中の情報を登録する
      // makeSqlメソッドの判定用
      param = INSERT_T_LENDING_BOOK_TMP;
      // SQL文を生成
      ps = con.prepareStatement(makeLendRegisteSql(userId, bookId, lendingDate,
          returnDate, mngUserId, param));
      // SQLを実行
      flag = ps.executeUpdate();

      // コミットする
      con.commit();

    } catch (ClassNotFoundException ce) {
      // ドライバが見つからなかったとき
      ce.printStackTrace();
    } catch (SQLException ce) {
      // sqlが一つでも失敗したらロールバック
      con.rollback();
      System.out.println("登録失敗：ロールバック実行");
      return flag = 0;
    }
    return flag;
  }
  /**
   * @method: BookProcessDao
   * @discription: 貸出中の情報を削除,図書状態管理,ユーザ状態管理更新<br>
   * @projectPass: libraryWeb.book.bookDao.BookProcessDao.java
   * @param userId
   * @param bookId
   * @param lendingDate
   * @param returnDate
   * @param mngUserId
   * @return int
   * @throws SQLException
   */
  public int returnRegisteDao(String userId, ArrayList<String> bookId)
      throws SQLException {
    // makeSqlメソッドの判定用
    String param = "";

    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

      // 自動コミット無しにする
      con.setAutoCommit(false);

      //図書状態管理を更新する
      // makeSqlメソッドの判定用
      param = UPDATE_T_BOOK_STATUS;
      // SQL文を生成
      ps = con.prepareStatement(makeReturnRegisteSql(userId, bookId, null ,null, null, param));
      // SQLを実行
      flag = ps.executeUpdate();

      //遅延返却ならユーザ状態管理を更新する
      // makeSqlメソッドの判定用
      param = UPDATE_T_USER_STATUS;
      // SQL文を生成
      ps = con.prepareStatement(makeReturnRegisteSql(userId, bookId, null ,null, null, param));
      // SQL文の「？」に変数をセット
      ps.setString(1, userId);
      // SQLを実行
      flag = ps.executeUpdate();

      //貸出中の情報を削除する
      // makeSqlメソッドの判定用
      param = INSERT_T_LENDING_BOOK_TMP;
      // SQL文を生成
      ps = con.prepareStatement(makeReturnRegisteSql(userId, bookId, null ,null, null, param));
      // SQLを実行
      flag = ps.executeUpdate();

      // コミットする
      con.commit();

    } catch (ClassNotFoundException ce) {
      // ドライバが見つからなかったとき
      ce.printStackTrace();
    } catch (SQLException ce) {
      // sqlが一つでも失敗したらロールバック
      con.rollback();
      System.out.println("登録失敗：ロールバック実行");
      return flag = 0;
    }
    return flag;
  }

  /**
   * @method: BookProcessDao
   * @discription: 図書情報,図書状態管理削除
   * @projectPass: libraryWeb.book.bookDao.BookProcessDao.java
   * @param bookId
   * @return int
   * @throws SQLException
   */
  public int deleteBookDao(ArrayList<String> bookId) throws SQLException {

    // makeSqlメソッドの判定用
    String param = "";
    // 件数カウント用
    int rowCount = 0;
    // 合計件数カウント用
    int totalCount = 0;

    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());
      con.setAutoCommit(false);

      // makeSqlメソッドの判定用
      param = DELETE_T_BOOK_INFO;
      // SQL文を生成
      ps = con.prepareStatement(makeDeleteBookSql(bookId, param));
      // SQL文の「？」に変数をセット
      for (int count = 0; count < bookId.size(); count++) {
        ps.setString(count + 1, bookId.get(count).toString());
      }

      // SQLを実行
      rowCount = ps.executeUpdate();
      // 削除件数集計
      totalCount += rowCount;
      // makeSqlメソッドの判定用
      param = DELETE_T_BOOK_STATUS;
      // SQL文を生成
      ps = con.prepareStatement(makeDeleteBookSql(bookId, param));
      // SQL文の「？」に変数をセット
      for (int count = 0; count < bookId.size(); count++) {
        ps.setString(count + 1, bookId.get(count).toString());
      }

      // SQLを実行
      rowCount = ps.executeUpdate();
      // 削除件数集計
      totalCount += rowCount;

      // コミットする
      con.commit();

    } catch (ClassNotFoundException ce) {
      // ドライバが見つからなかったとき
      ce.printStackTrace();
    } catch (SQLException ce) {
      // sqlが一つでも失敗したらロールバック
      con.rollback();
      System.out.println("登録失敗：ロールバック実行");
    }
    return totalCount;
  }

  /**
   * @method: BookProcessDao
   * @discription: 貸出中の情報取得
   * @projectPass: libraryWeb.book.bookDao.BookProcessDao.java
   * @return ResultSet
   * @throws SQLException
   */
  public ResultSet getLendingBookListDao() throws SQLException {

    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

      // SQL文を生成
      /*
       * テーブルを結合し、図書貸し出し状態も取得する
       * テーブル別名：T_BOOK_INFO ->TBI
       * T_LENDING_BOOK_TMP ->TLBT
       * T_USER_INFO ->TUI
       */
      ps = con
          .prepareStatement("select TBI.book_id , TBI.title , TUI.user_id, TUI.user_name, TLBT.lending_date ,TLBT.return_date"
              + " from T_BOOK_INFO TBI "
              + "inner join T_LENDING_BOOK_TMP TLBT "
              + "on TBI.book_id = TLBT.book_id inner join T_USER_INFO TUI "
              + "on TLBT.user_id = TUI.user_id");

      // SQLを実行
      rs = ps.executeQuery();

    } catch (ClassNotFoundException ce) {
      // ドライバが見つからなかったとき
      ce.printStackTrace();
    } catch (SQLException ce) {
      ce.printStackTrace();
    }
    return rs;
  }

  /**
   * @method: UserProcessDao
   * @discription: 最新の図書IDを取得
   * @projectPass: libraryWeb.user.userDao.UserProcessDao.java
   * @return ResultSet
   * @throws SQLException
   */
  public ResultSet createBookIdDao() throws SQLException {
    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());
      con.setAutoCommit(true);

      // シーケンス番号をインクリメント
      ps = con.prepareStatement("UPDATE SEQUENCE_BOOK_ID SET ID = LAST_INSERT_ID(ID + 1)");
      // SQLを実行
      flag = ps.executeUpdate();

      // 最新のユーザIDを取得
      ps = con.prepareStatement("SELECT LAST_INSERT_ID()");
      // SQLを実行
      rs = ps.executeQuery();

    } catch (ClassNotFoundException ce) {
      // ドライバが見つからなかったとき
      ce.printStackTrace();
    }
    return rs;
  }

  /**
   * コネクションをクローズします.
   */
  public void close() {

    try {
      // データベースとの接続を解除する
      if (con != null) {
        con.close();
      }
      if (ps != null) {
        ps.close();
      }
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException se) {
      // データベースとの接続解除に失敗した場合
      se.printStackTrace();
    }
  }

  /**
   * @method: BookProcessDao
   * @discription: 図書削除用SQL文を生成する.
   * @projectPass: libraryWeb.book.bookDao.BookProcessDao.java
   * @param idList
   * @param param
   * @return String
   */
  public String makeDeleteBookSql(ArrayList<String> idList, String param) {

    String setSql = null;

    if (DELETE_T_BOOK_INFO.equals(param)) {
      setSql = "delete from T_BOOK_INFO where book_id in(";
    }
    if (DELETE_T_BOOK_STATUS.equals(param)) {
      setSql = "delete from T_BOOK_STATUS where book_id in(";
    }

    StringBuffer questions = new StringBuffer();

    for (int count = 0; count < idList.size(); count++) {
      questions.append(",?");
    }
    String sql = setSql + questions.toString().replaceFirst(",", "") + ")";
    System.out.println(sql);
    return sql;
  }

  /**
   * @method: BookProcessDao
   * @discription: 貸出処理用SQLを生成する.
   * @projectPass: libraryWeb.book.bookDao.BookProcessDao.java
   * @param userId
   * @param bookId
   * @param param
   * @return String
   */
  public String makeLendRegisteSql(String userId, ArrayList<String> bookId,
      String lendingDate, String returnDate, String mngUserId,String param) {
    // SQLセット用
    String setSql = null;
    // sql文格納
    String sql = null;
    StringBuffer questions = new StringBuffer();
    //
    if (UPDATE_T_BOOK_STATUS.equals(param)) {
      setSql = "update T_BOOK_STATUS set BOOK_LEND_HISTORY = case BOOK_ID";

      for (int count = 0; count < bookId.size(); count++) {
        setSql += " WHEN " + bookId.get(count) + " THEN CONCAT(BOOK_LEND_HISTORY, '" + userId + ",')";
      }
      setSql += "END" +
          ", BOOK_NUM_LENDING = BOOK_NUM_LENDING + 1" +
          ", BOOK_LEND_STATUS = 0" +
          " WHERE BOOK_ID IN (";


      for (int count = 0; count < bookId.size(); count++) {
        questions.append(",'" + bookId.get(count) + "'");
      }
      sql = setSql + questions.toString().replaceFirst(",", "") + ")";

      System.out.println(sql);
    }

    if (UPDATE_T_USER_STATUS.equals(param)) {

      // 借りる本数用
      int numBook = 0;
      // 図書ID連列用
      StringBuffer bookIdJoin = new StringBuffer();
      // bookIdのサイズ分ループ処理
      for (int count = 0; count < bookId.size(); count++) {
        bookIdJoin.append("," + bookId.get(count));
      }
      // 最初のカンマを削除する
      String setBookId = bookIdJoin.toString().replaceFirst(",", "") + "";
      // 本数取得
      numBook = bookId.size();

      sql = "update T_USER_STATUS set USER_HISTORY = '" + setBookId + "',"
          + "user_num_lending = user_num_lending + " + numBook + " where user_id = ?";

      // SQL確認用
      System.out.println(sql);
    }
    if (INSERT_T_LENDING_BOOK_TMP.equals(param)) {
      // SQLセット用
      StringBuffer SBsetSql = new StringBuffer();
      // 借りる本数分生成
      for (int count = 0; count < bookId.size(); count++) {
        SBsetSql.append("('" + bookId.get(count) + "','" + userId + "','" + lendingDate + "','" + returnDate + "','"
            + mngUserId + "'),");
      }
      // 最後のカンマを削除する
      int index = setSql.lastIndexOf(",");
      SBsetSql.deleteCharAt(index);
      sql = "insert into T_LENDING_BOOK_TMP values";
      sql += setSql;

      // SQL確認用
      System.out.println(sql);
    }
    return sql;
  }
  /**
   * @method: BookProcessDao
   * @discription: 返却処理用SQLを生成する.
   * @projectPass: libraryWeb.book.bookDao.BookProcessDao.java
   * @param userId
   * @param bookId
   * @param param
   * @return String
   */
  public String makeReturnRegisteSql(String userId, ArrayList<String> bookId,
      String lendingDate, String returnDate, String mngUserId,String param) {
    // SQLセット用
    String setSql = null;
    // sql文格納
    String sql = null;
    // SQLセット用
    StringBuffer SBsetSql = new StringBuffer();
    //
    if (UPDATE_T_BOOK_STATUS.equals(param)) {
      setSql = "update T_BOOK_STATUS set BOOK_LEND_HISTORY = case BOOK_ID";

      for (int count = 0; count < bookId.size(); count++) {
        setSql += " WHEN " + bookId.get(count) + " THEN CONCAT(BOOK_LEND_HISTORY, '" + userId + ",')";
      }
      setSql += "END" +
          ", BOOK_NUM_LENDING = BOOK_NUM_LENDING + 1" +
          ", BOOK_LEND_STATUS = 0" +
          " WHERE BOOK_ID IN (";


      for (int count = 0; count < bookId.size(); count++) {
        SBsetSql.append(",'" + bookId.get(count) + "'");
      }
      sql = setSql + SBsetSql.toString().replaceFirst(",", "") + ")";

      System.out.println(sql);
    }

    if (UPDATE_T_USER_STATUS.equals(param)) {

      // 借りる本数用
      int numBook = 0;
      // 図書ID連列用
      StringBuffer bookIdJoin = new StringBuffer();
      // bookIdのサイズ分ループ処理
      for (int count = 0; count < bookId.size(); count++) {
        bookIdJoin.append("," + bookId.get(count));
      }
      // 最初のカンマを削除する
      String setBookId = bookIdJoin.toString().replaceFirst(",", "") + "";
      // 本数取得
      numBook = bookId.size();

      sql = "update T_USER_STATUS set USER_HISTORY = '" + setBookId + "',"
          + "user_num_lending = user_num_lending + " + numBook + " where user_id = ?";

      // SQL確認用
      System.out.println(sql);
    }
    if (INSERT_T_LENDING_BOOK_TMP.equals(param)) {
      // 借りる本数分生成
      for (int count = 0; count < bookId.size(); count++) {
        SBsetSql.append("('" + bookId.get(count) + "','" + userId + "','" + lendingDate + "','" + returnDate + "','"
            + mngUserId + "'),");
      }
      // 最後のカンマを削除する
      int index = setSql.lastIndexOf(",");
      SBsetSql.deleteCharAt(index);
      sql = "insert into T_LENDING_BOOK_TMP values";
      sql += setSql;

      // SQL確認用
      System.out.println(sql);
    }
    return sql;
  }

}
