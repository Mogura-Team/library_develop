package manage.manageBean;

import java.io.Serializable;

// ログインユーザ情報取得とセット
/**
 * @作成日 2018/02/04
 * @ファイル名 ManageProcessBean.java
 * @description 管理ユーザ関連のパラメータを定義するクラス.
 */
public class ManageProcessBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private String mngUserId;

  private String mngUserName;

  private String mngUserAge;

  private String mngRegistDate;

  public ManageProcessBean() {
    this.mngUserId = ""; //ID
    this.mngUserName = ""; //名前
    this.mngUserAge = ""; //年齢
    this.mngRegistDate = ""; //登録日
  }

  public String getMngUserAge() {
    return mngUserAge;
  }

  public void setMngUserAge(String mngUserAge) {
    this.mngUserAge = mngUserAge;
  }

  public void setMngUserId(String mngUserId) {
    this.mngUserId = mngUserId;
  }

  public String getMngUserId() {
    return mngUserId;
  }

  public String getMngUserName() {
    return mngUserName;
  }

  public void setMngUserName(String mngUserName) {
    this.mngUserName = mngUserName;
  }

  public String getMngRegistDate() {
    return mngRegistDate;
  }

  public void setMngRegistDate(String mngRegistDate) {
    this.mngRegistDate = mngRegistDate;
  }

}
