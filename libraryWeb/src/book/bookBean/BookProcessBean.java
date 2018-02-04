package book.bookBean;

import java.io.Serializable;

/**
 * @作成日 2018/02/04
 * @ファイル名 BookProcessBean.java
 * @description 図書情報のパラメータを定義するクラス.
 *
 */
public class BookProcessBean implements Serializable {
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

  public BookProcessBean() {
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

}
