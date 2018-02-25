package user.userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.ConnectionBean;

/**
 * @作成日 2018/02/04
 * @ファイル名 UserProcessDao.java
 * @description ユーザ関連のデータベースアクセスを行うクラス.
 */
public class UserProcessDao {

  /** UPDATE_TABLE_USER_STATUS **/
  final String UPDATE_T_USER_STATUS = "updateTUserStatus";

  /** DELETE_T_USER_STATUS **/
  final String DELETE_T_USER_STATUS = "deleteTUserStatus";

  /** DELETE_TABLE_USER_INFO **/
  final String DELETE_T_USER_INFO = "deleteTUserInfo";

  /** INSERT_T_LENDING_USER_TMP **/
  final String INSERT_T_LENDING_USER_TMP = "insertTLendingUserTmp";

  private Connection con = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;
  public ConnectionBean cb = new ConnectionBean();

  private int flag;// メソッドの結果判定フラグ

  /**
   * @method: UserProcessDao
   * @discription: ユーザ情報,ユーザ状態管理登録
   * @projectPass: libraryWeb.user.userDao.UserProcessDao.java
   * @param userId
   * @param mngUserId
   * @param userName
   * @param userAddress
   * @param userSexKbn
   * @param userPass
   * @param userAge
   * @param userRegisteDate
   * @return int
   * @throws SQLException
   */
  public int insertUserRegisteDao(String userId, String mngUserId, String userName, String userAddress, String userSexKbn,
      String userPass, String userAge, String userRegisteDate) throws SQLException {

    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());
      con.setAutoCommit(false);

      // SQL文を生成
      ps = con
          .prepareStatement("insert into T_USER_INFO"
              + "(mng_user_id,usrd_name,user_address,user_sex_kbn,user_pass,user_age,user_registe_date)value( ? , ? , ? , ? , ? , ? , ?)");

      // SQL文の「？」に変数をセット
      ps.setString(1, mngUserId);
      ps.setString(2, userName);
      ps.setString(3, userAddress);
      ps.setString(4, userSexKbn);
      ps.setString(5, userPass);
      ps.setString(6, userAge);
      ps.setString(7, userRegisteDate);

      // SQLを実行
      flag = ps.executeUpdate();

      // SQL文を生成
      ps = con.prepareStatement("insert into T_USER_STATUS(mng_user_id,user_id)value( ? , ? )");

      // SQL文の「？」に変数をセット
      ps.setString(1, userId);
      ps.setString(2, mngUserId);

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
   * @method: UserProcessDao
   * @discription: ユーザ情報一覧を取得
   * @projectPass: libraryWeb.user.userDao.UserProcessDao.java
   * @return ResultSet
   * @throws SQLException
   */
  public ResultSet selectUserListDao() throws SQLException {
    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(),
          cb.getPass());

      ps = con.prepareStatement("select * from T_USER_INFO TUI"
          + " join T_USER_STATUS TUS on TUI.user_id = TUS.user_id");

      // SQLを実行
      rs = ps.executeQuery();

    } catch (ClassNotFoundException ce) {

      // JDBCドライバが見つからなかった場合
      ce.printStackTrace();
    }
    return rs;
  }

  /**
   * @method: UserProcessDao
   * @discription: ユーザ情報,ユーザ状態管理削除
   * @projectPass: libraryWeb.user.userDao.UserProcessDao.java
   * @param userId
   * @return int
   * @throws SQLException
   */
  public int deleteUserDao(ArrayList<String> userId) throws SQLException {

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
      param = DELETE_T_USER_INFO;
      // SQL文を生成
      ps = con.prepareStatement(makeDeleteSql(userId, param));

      // SQL文の「？」に変数をセット
      for (int count = 0; count < userId.size(); count++) {
        ps.setString(count + 1, userId.get(count).toString());
      }

      // SQLを実行
      rowCount = ps.executeUpdate();
      // 削除件数集計
      totalCount += rowCount;
      // makeSqlメソッドの判定用
      param = DELETE_T_USER_STATUS;

      // SQL文を生成
      ps = con.prepareStatement(makeDeleteSql(userId, param));

      // SQL文の「？」に変数をセット
      for (int count = 0; count < userId.size(); count++) {
        ps.setString(count + 1, userId.get(count).toString());
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
   * @method: UserProcessDao
   * @discription: 貸出中のユーザ一覧取得SQL
   * @projectPass: libraryWeb.user.userDao.UserProcessDao.java
   * @return ResultSet
   * @throws SQLException
   */
  public ResultSet selectLendingUserListDao() throws SQLException {
    try {
      // コネクション格納クラスインスタンス
      // JDBCドライバのロード
      // 「com.mysql.jdbc.Driver」クラス名
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(),
          cb.getPass());

      ps = con.prepareStatement("select TUI.user_id , TUI.user_name , TUI.user_address "
          + ", TUI.user_sex_kbn , TUI.user_age from "
          + "T_BOOK_INFO TBI inner join T_LENDING_BOOK_TMP TLBT ON TBI.book_id = TLBT.book_id "
          + "inner join T_USER_INFO TUI on TUI.user_id = TLBT.user_id");

      // SQLを実行
      rs = ps.executeQuery();

    } catch (ClassNotFoundException ce) {

      // JDBCドライバが見つからなかった場合
      ce.printStackTrace();
    }
    return rs;
  }

  public ResultSet selectLendingExcessPersonListDao() throws SQLException {
    try {

      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(),
          cb.getPass());

      ps = con.prepareStatement("select"
                                +" count(tlbt.BOOK_ID) as count,"
                                +" tui.USER_ID,"
                                +" tui.USER_NAME,"
                                +" USER_ADDRESS,"
                                +" USER_SEX_KBN,"
                                +" USER_AGE"
                              +" from"
                                +" t_lending_book_tmp tlbt left join t_user_status tus on tlbt.USER_ID = tus.USER_ID"
                                +" left join t_user_info tui on tui.USER_ID = tlbt.USER_ID"
                                +" where"
                                +" tlbt.RETURN_DATE < date(now())"
                              +" group by"
                                +" tlbt.USER_ID"
                              +" having"
                                +" count(book_id) > 0"
                              +" order by"
                                +" tlbt.USER_ID");
      // SQLを実行
      rs = ps.executeQuery();

    } catch (ClassNotFoundException ce) {

      // JDBCドライバが見つからなかった場合
      ce.printStackTrace();
    }
    return rs;
  }
  public ResultSet selectLendingExcessBookListDao() throws SQLException {
    try {

      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(),
          cb.getPass());

      ps = con.prepareStatement("select"
                                +" tlbt.USER_ID,"
                                +" tlbt.BOOK_ID,"
                                +" tbi.TITLE,"
                                +" tlbt.LENDING_DATE,"
                                +" tlbt.RETURN_DATE"
                              +" from"
                                +" t_lending_book_tmp tlbt"
                                +" left join t_book_info tbi on tlbt.BOOK_ID = tbi.BOOK_ID"
                              +" where"
                                +" tlbt.RETURN_DATE < date(now())"
                              +" order by"
                                +" tlbt.BOOK_ID");
      // SQLを実行
      rs = ps.executeQuery();

    } catch (ClassNotFoundException ce) {

      // JDBCドライバが見つからなかった場合
      ce.printStackTrace();
    }
    return rs;
  }

  public ResultSet selectReturnUser(String bookId) throws SQLException {
    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(),
          cb.getPass());

      ps = con.prepareStatement("SELECT user_id FROM t_lending_book_tmp WHERE book_id = ?");
      ps.setString(1, bookId);

      // SQLを実行
      rs = ps.executeQuery();
    } catch (ClassNotFoundException ce) {
      // JDBCドライバが見つからなかった場合
      ce.printStackTrace();
    } catch (SQLException ce) {
      ce.printStackTrace();
    }
    return rs;
  }

  /**
   * @method: UserProcessDao
   * @discription: 最新のユーザIDを取得
   * @projectPass: libraryWeb.user.userDao.UserProcessDao.java
   * @return ResultSet
   * @throws SQLException
   */
  public ResultSet createUserIdDao() throws SQLException {
    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());
      con.setAutoCommit(true);

      // シーケンス番号をインクリメント
      ps = con.prepareStatement("UPDATE SEQUENCE_USER_ID SET ID = LAST_INSERT_ID(ID + 1)");
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
   * @discription: ユーザ情報,ユーザ状態管理削除用SQL文を生成する.
   * @projectPass: libraryWeb.book.bookDao.BookProcessDao.java
   * @param idList
   * @param param
   * @return String
   */
  public String makeDeleteSql(ArrayList<String> idList, String param) {

    String setSql = null;

    if (DELETE_T_USER_INFO.equals(param)) {
      setSql = "delete from T_USER_INFO where user_id in(";
    }
    if (DELETE_T_USER_STATUS.equals(param)) {
      setSql = "delete from T_USER_STATUS where user_id in(";
    }
    StringBuffer questions = new StringBuffer();

    for (int count = 0; count < idList.size(); count++) {
      questions.append(",?");
    }
    String sql = setSql + questions.toString().replaceFirst(",", "") + ")";
    return sql;
  }

}