package manage.manageLogDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import manage.manageLogBean.LoginUserBean;
import manage.manageLogDao.ManageUserDao;

import common.Cnst;
import common.ManageLogin;

/**
 * @作成日 2018/02/04
 * @ファイル名 ManageLoginDB.java
 * @description 管理ユーザー関連の処理を行うクラス.
 */
public class ManageUserDB extends ManageLogin {

  /**
   * @method: getMngUserData
   * @discription: 管理ユーザの検索処理を行う.
   * @projectPass: libraryWeb.book.bookDB.BookProcessDB.java
   * @param mngUserId
   * @param mngUserPass
   * @return void
   * @throws SQLException
   */
  public LoginUserBean getMngUserData(String mngUserId, String mngUserPass) {

    LoginUserBean mngBean = null;
    ManageUserDao mdao = null;
    ResultSet rs = null;

    try {
      //ManageLoginDaoクラスをインスタンス化
      mdao = new ManageUserDao();
      //管理ユーザ取得処理SQL
      rs = mdao.getMngUserDao(mngUserId, mngUserPass);

      while (rs.next()) {
        //検索結果が存在する場合はbeanに値をセット（結果が1件しか返らないことを想定）
        mngBean = new LoginUserBean();
        mngBean.setMngUserId(mngUserId);
        mngBean.setMngUserName(rs.getString(Cnst.PARAM_MNG_USER_NAME.strType()));
      }
    } catch (SQLException e) {
      // エラー・メッセージを出力
      System.out.print(e.toString());
      System.out.println("エラー・コード: " +
      ((SQLException)e).getErrorCode());
    } finally {
      //処理終了時に各接続を解除
      mdao.close();
    }
    return mngBean;
  }
}
