package manage.manageDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import manage.manageBean.ManageProcessBean;
import manage.manageDao.ManageProcessDao;

import common.Cnst;
import common.ManageLogin;

/**
 * @作成日 2018/02/04
 * @ファイル名 ManageProcessDB.java
 * @description 管理ユーザー関連の処理を行うクラス.
 */
public class ManageProcessDB extends ManageLogin {

  /**
   * @method: getMngUserData
   * @discription: 管理ユーザの検索処理を行う.
   * @projectPass: libraryWeb.book.bookDB.BookProcessDB.java
   * @param mngUserId
   * @param mngUserPass
   * @return void
   * @throws SQLException
   */
  public ManageProcessBean getMngUserData(String mngUserId, String mngUserPass) {

    ManageProcessBean mngBean = null;
    ManageProcessDao mdao = null;
    ResultSet rs = null;

    try {
      //ManageLoginDaoクラスをインスタンス化
      mdao = new ManageProcessDao();
      //管理ユーザ取得処理SQL
      rs = mdao.getMngUserDao(mngUserId, mngUserPass);

      while (rs.next()) {
        //検索結果が存在する場合はbeanに値をセット（結果が1件しか返らないことを想定）
        mngBean = new ManageProcessBean();
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
