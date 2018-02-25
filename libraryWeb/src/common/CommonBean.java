package common;

import java.io.Serializable;

/**
 * @作成日 2018/02/04
 * @ファイル名 CommonBean.java
 * @description 図書,ユーザ,その他のパラメータを定義するクラス.
 *
 */
public class CommonBean implements Serializable {
  /** ID **/
  private String bookId;
  /** タイトル **/
  private String title;
  /** 巻次 **/
  private String windingNext;
  /** シリーズ **/
  private String series;
  /** 版表示 **/
  private String versionDisplay;
  /** 著者 **/
  private String author;
  /** 出版者 **/
  private String publisher;
  /** 出版年 **/
  private String yearPublication;
  /** 図書コード **/
  private String isbn;
  /** 冊数（ページ数・大きさ） **/
  private String numberPagesHW;
  /** 公開範囲 **/
  private String scopeDisclosuer;
  /** 登録管理ユーザ **/
  private String mngUserId;
  /** 登録日 **/
  private String bookRegisteDate;
  /** 貸出状態区分 **/
  private String bookLendStatus;
  /** 貸出ユーザ履歴 **/
  private String lendHistory;
  /** 貸出回数 **/
  private String BookNumLending;
  /** 貸出日 **/
  private String lendingDate;
  /** 返却日 **/
  private String returnDate;
  /** ID **/
  private String userId;
  /** パスワード **/
  private String userPass;
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
  /** 合計遅延回数 **/
  private String delayNum;
  /** 遅延冊数 **/
  private String count;

  public CommonBean() {
    this.bookId = "";
    this.title = "";
    this.windingNext = "";
    this.series = "";
    this.versionDisplay = "";
    this.author = "";
    this.publisher = "";
    this.yearPublication = "";
    this.isbn = "";
    this.numberPagesHW = "";
    this.scopeDisclosuer = "";
    this.mngUserId = "";
    this.bookRegisteDate = "";
    this.bookLendStatus = "";
    this.lendHistory = "";
    this.BookNumLending = "";
    this.lendingDate = "";
    this.returnDate = "";
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

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  public String getWindingNext() {
    return windingNext;
  }

  public void setWindingNext(String windingNext) {
    this.windingNext = windingNext;
  }

  public String getSeries() {
    return series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  public String getVersionDisplay() {
    return versionDisplay;
  }

  public void setVersionDisplay(String versionDisplay) {
    this.versionDisplay = versionDisplay;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getYearPublication() {
    return yearPublication;
  }

  public void setYearPublication(String yearPublication) {
    this.yearPublication = yearPublication;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getNumberPagesHW() {
    return numberPagesHW;
  }

  public void setNumberPagesHW(String numberPagesHW) {
    this.numberPagesHW = numberPagesHW;
  }

  public String getScopeDisclosuer() {
    return scopeDisclosuer;
  }

  public void setScopeDisclosuer(String scopeDisclosuer) {
    this.scopeDisclosuer = scopeDisclosuer;
  }

  public String getMngUserId() {
    return mngUserId;
  }

  public void setMngUserId(String mngUserId) {
    this.mngUserId = mngUserId;
  }

  public String getBookRegisteDate() {
    return bookRegisteDate;
  }

  public void setBookRegisteDate(String bookRegisteDate) {
    this.bookRegisteDate = bookRegisteDate;
  }

  public String getBookLendStatus() {
    return bookLendStatus;
  }

  public void setBookLendStatus(String bookLendStatus) {
    this.bookLendStatus = bookLendStatus;
  }

  public String getLendHistory() {
    return lendHistory;
  }

  public void setLendHistory(String lendHistory) {
    this.lendHistory = lendHistory;
  }

  public String getBookNumLending() {
    return BookNumLending;
  }

  public void setBookNumLending(String BookNumLending) {
    this.BookNumLending = BookNumLending;
  }

  public String getLendingDate() {
    return lendingDate;
  }

  public void setLendingDate(String lendingDate) {
    this.lendingDate = lendingDate;
  }

  public String getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
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

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.bookId = count;
  }

}
