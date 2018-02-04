package user.userBean;

import java.io.Serializable;

/**
 * @作成日 2018/02/04
 * @ファイル名 UserProcessBean.java
 * @description ユーザ情報のパラメータを定義するクラス.
 *
 */
public class UserProcessBean implements Serializable {

  /** ID **/
  private String userId;
  /** パスワード **/
  private String userPass;
  /** 登録管理ユーザ **/
  private String mngUserId;
  /** 名前 **/
  private String userName;
  /** 住所 **/
  private String userAddress;
  /** 性別区分 **/
  private String userSexKbn;
  /** 年齢 **/
  private String userAge;
  /** 登録日 **/
  private String userRegisteDate;
  /** 貸出履歴 **/
  private String userHistory;
  /** 貸出回数 **/
  private String userNumLending;
  /** 遅延回数 **/
  private String delayNum;

  public UserProcessBean() {

    this.userId = "";
    this.userPass = "";
    this.mngUserId = "";
    this.userName = "";
    this.userAddress = "";
    this.userSexKbn = "";
    this.userAge = "";
    this.userRegisteDate = "";
    this.userHistory = "";
    this.userNumLending ="";
    this.delayNum = "";
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserPass() {
    return userPass;
  }

  public void setUserPass(String userPass) {
    this.userPass = userPass;
  }

  public String getMngUserId() {
    return mngUserId;
  }

  public void setMngUserId(String mngUserId) {
    this.mngUserId = mngUserId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public String getUserSexKbn() {
    return userSexKbn;
  }

  public void setUserSexKbn(String userSexKbn) {
    this.userSexKbn = userSexKbn;
  }

  public String getUserAge() {
    return userAge;
  }

  public void setUserAge(String userAge) {
    this.userAge = userAge;
  }

  public String getUserRegisteDate() {
    return userRegisteDate;
  }

  public void setUserRegisteDate(String userRegisteDate) {
    this.userRegisteDate = userRegisteDate;
  }

  public String getUserHistory() {
    return userHistory;
  }

  public void setUserHistory(String userHistory) {
    this.userHistory = userHistory;
  }

  public String getUserNumLending() {
    return userNumLending;
  }

  public void setUserNumLending(String userNumLending) {
    this.userNumLending = userNumLending;
  }

  public String getDelayNum() {
    return delayNum;
  }

  public void setDelayNum(String delayNum) {
    this.delayNum = delayNum;
  }

}
