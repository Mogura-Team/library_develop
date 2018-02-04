package common;

import manage.manageLogBean.LoginUserBean;

/**
 * ログイン処理クラス.<br/>
 * 今回は親クラスとして使用.
 */
public class ManageLogin {

  /**
   * @method: ManageLogin
   * @discription: 指定されたIDとパスワードに紐づくユーザ情報を返却します.
   * @projectPass: libraryWeb.common.ManageLogin.java
   * @param id
   * @param pass
   * @return
   * LoginUserBean
   */
  public LoginUserBean getUserData(String id, String pass) {

    LoginUserBean bean = new LoginUserBean();

    // 引数のIDとパスワードを判定
    if ("web01".equals(id) && "password".equals(pass)) {

      // IDがweb01の場合
      // BeanにIDを設定
      bean.setMngUserId(id);
      // Beanに名前を設定
      bean.setMngUserName("ログインユーザ名１");
      // Beanに年齢を設定
      bean.setMngUserAge("17");

    } else if ("web02".equals(id) && "password".equals(pass)) {

      // IDがweb02の場合
      // BeanにIDを設定
      bean.setMngUserId(id);
      // Beanに名前を設定
      bean.setMngUserName("ログインユーザ名２");
      // Beanに年齢を設定
      bean.setMngUserAge("10");

    } else {

      // IDが合致しない場合はnullを代入
      bean = null;
    }

    return bean;
  }
}