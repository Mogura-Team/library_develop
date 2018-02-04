package manage.manageLogDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.ConnectionBean;

public class ManageLoginDao {
  private Connection con = null;
  private ResultSet rs = null;
  private PreparedStatement ps = null;
  public ConnectionBean cb = new ConnectionBean();

  /**
   * @method: ManageLoginDao
   * @discription: 管理ユーザ情報を取得
   * @projectPass: libraryWeb.manage.manageLogDao.ManageLoginDao.java
   * @param mngUserId
   * @param mngUserPass
   * @return ResultSet
   * @throws SQLException
   */
  public ResultSet getMngUserDao(String mngUserId, String mngUserPass) throws SQLException {

    try {
      // JDBCドライバのロード
      Class.forName(cb.getDriver());

      // データベースと接続
      con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());
      // SQL文を生成
      ps = con.prepareStatement("select MNG_USER_NAME from t_mng_user_info where MNG_USER_ID = ? and MNG_USER_PASS = ?");

      // SQL文の「？」にIDとパスワードをセット
      ps.setString(1, mngUserId);
      ps.setString(2, mngUserPass);

      // SQLを実行
      rs = ps.executeQuery();

    } catch (ClassNotFoundException ce) {
      // JDBCドライバが見つからなかった場合
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
}
