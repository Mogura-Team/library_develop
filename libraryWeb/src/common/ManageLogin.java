package common;

import manage.manageBean.ManageProcessBean;


/**
 * @作成日 2018/02/04
 * @ファイル名 ManageLogin.java
 * @description 親クラス。ログイン処理を行うクラス
 */
public class ManageLogin {

  /**
   * @method: ManageLogin
   * @discription: 指定されたIDとパスワードに紐づくユーザ情報を返却します.
   * @projectPass: libraryWeb.common.ManageLogin.java
   * @param id
   * @param pass
   * @return LoginUserBean
   */
  public ManageProcessBean getMngUserData(String id, String pass) {

    ManageProcessBean bean = new ManageProcessBean();

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