package manage.manageLogDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import manage.manageLogBean.LoginUserBean;
import manage.manageLogDao.ManageLoginDao;

import common.Cnst;
import common.ManageLogin;

public class ManageLoginDB extends ManageLogin {

  /* (非 Javadoc)
   * @see common.ManageLogin#getUserData(java.lang.String, java.lang.String)
   */
  public LoginUserBean getUserData(String mngUserId, String mngUserPass) {

    LoginUserBean mngBean = null;
    ManageLoginDao mdao = null;
    ResultSet rs = null;

    try {
      //ManageLoginDaoクラスをインスタンス化
      mdao = new ManageLoginDao();
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
