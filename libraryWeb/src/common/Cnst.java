package common;

public enum Cnst {

///////////////////////////////////
//フラグ定数
///////////////////////////////////

  /**
   * @フラグ定数 INT_ZERO<br>
   *
   * @値 数値の０
   */
  INT_ZERO(0),

  /**
   * @フラグ定数 INT_ONE<br>
   *
   * @値 数値の１
   */
  INT_ONE(1),

  /**
   * @フラグ定数 STRINT_ZERO<br>
   *
   * @値 文字の０
   */
  STRINT_ZERO("0"),

  /**
   * @フラグ定数 STRING_ONE<br>
   *
   * @値 文字の１
   */
  STRING_ONE("1"),

  /**
   * @フラグ定数 BOOLEAN_FLAG_ZERO<br>
   *
   * @値 フラグの０
   */
  BOOLEAN_FLAG_ZERO(0),

  /**
   * @フラグ定数 BOOLEAN_FLAG_ONE<br>
   *
   * @値 フラグの１
   */
  BOOLEAN_FLAG_ONE(1),

///////////////////////////////////
//文字コード定数
///////////////////////////////////

  /**
   * @文字コード定数 UTF8_CODE<br>
   *
   * @値 UTF-8
   */
  UTF8_CODE("UTF-8"),

///////////////////////////////////
//日付フォーマット定数
///////////////////////////////////

  /**
   * @日付フォーマット定数 DATE_FORMAT<br>
   *
   * @値 yyyy/MM/dd/
   */
  DATE_FORMAT("yyyy/MM/dd/"),

///////////////////////////////////
//パラメータ定数
///////////////////////////////////

  /**
   * @パラメータ定数 PARAM_AUTHOR<br>
   *
   * @値 author
   */
  PARAM_AUTHOR("author"),

  /**
   * @パラメータ定数 PARAM_BOOK_ID<br>
   *
   * @値 book_id
   */
  PARAM_BOOK_ID("book_id"),

  /**
   * @パラメータ定数 PARAM_LEND_STATUS<br>
   *
   * @値 book_lend_status
   */
  PARAM_BOOK_LEND_STATUS("book_lend_status"),

  /**
   * @パラメータ定数 PARAM_BOOK_NUM_LENDING<br>
   *
   * @値 book_num_lending
   */
  PARAM_BOOK_NUM_LENDING("book_num_lending"),

  /**
   * @パラメータ定数 PARAM_BOOK_REGISTE_DATE<br>
   *
   * @値 book_registe_date
   */
  PARAM_BOOK_REGISTE_DATE("book_registe_date"),

  /**
   * @パラメータ定数 PARAM_CREATE_ID<br>
   *
   * @値 id
   */
  PARAM_CREATE_ID("id"),

  /**
   * @パラメータ定数 PARAM_DELETE_COMPLETED<br>
   *
   * @値 delete_completed
   */
  PARAM_DELETE_COMPLETED("delete_completed"),

  /**
   * @パラメータ定数 PARAM_DELETE_DISPLAY<br>
   *
   * @値 delete_display
   */
  PARAM_DELETE_DISPLAY("delete_display"),

  /**
   * @パラメータ定数 PARAM_DELETE_ERROR<br>
   *
   * @値 delete_error
   */
  PARAM_DELETE_ERROR("delete_error"),

  /**
   * @パラメータ定数 PARAM_ID<br>
   *
   * @値 id
   */
  PARAM_ID("id"),

  /**
   * @パラメータ定数 PARAM_ISBN<br>
   *
   * @値 isbn
   */
  PARAM_ISBN("isbn"),

  /**
   * @パラメータ定数 PARAM_LENDING_DATE<br>
   *
   * @値 lending_date
   */
  PARAM_LENDING_DATE("lending_date"),

  /**
   * @パラメータ定数 PARAM_LENDING_EXCESS_PERSON_LIST_DISPLAY<br>
   *
   * @値 lending_excess_person_list_display
   */
  PARAM_LENDING_EXCESS_PERSON_LIST_DISPLAY("lending_excess_person_list_display"),

  /**
   * @パラメータ定数 PARAM_LENDING_WITHIN_DISPLAY<br>
   *
   * @値 lending_within_display
   */
  PARAM_LENDING_WITHIN_DISPLAY("lending_within_display"),

  /**
   * @パラメータ定数 PARAM_LEND_COMPLETED<br>
   *
   * @値 lend_completed
   */
  PARAM_LEND_COMPLETED("lend_completed"),

  /**
   * @パラメータ定数 PARAM_LEND_CONFIRM<br>
   *
   * @値 lend_confirm
   */
  PARAM_LEND_CONFIRM("lend_confirm"),

  /**
   * @パラメータ定数 PARAM_LEND_DISPLAY<br>
   *
   * @値 lend_display
   */
  PARAM_LEND_DISPLAY("lend_display"),

  /**
   * @パラメータ定数 PARAM_LEND_ERROR<br>
   *
   * @値 lend_error
   */
  PARAM_LEND_ERROR("lend_error"),

  /**
   * @パラメータ定数 PARAM_LIST_ONLY_DISPLAY<br>
   *
   * @値 list_only_display
   */
  PARAM_LIST_ONLY_DISPLAY("list_only_display"),

  /**
   * @パラメータ定数 PARAM_LOGIN<br>
   *
   * @値 login
   */
  PARAM_LOGIN("login"),

  /**
   * @パラメータ定数 PARAM_MNG_USER_ID<br>
   *
   * @値 mng_user_id
   */
  PARAM_MNG_USER_ID("mng_user_id"),

  /**
   * @パラメータ定数 PARAM_MNG_USER_NAME<br>
   *
   * @値 mng_user_name
   */
  PARAM_MNG_USER_NAME("mng_user_name"),

  /**
   * @パラメータ定数 PARAM_MNG_USER_PASS<br>
   *
   * @値 mng_user_pass
   */
  PARAM_MNG_USER_PASS("mng_user_pass"),

  /**
   * @パラメータ定数 PARAM_NUMBER_PAGES_H_W<br>
   *
   * @値 number_pages_h_w
   */
  PARAM_NUMBER_PAGES_H_W("number_pages_h_w"),

  /**
   * @パラメータ定数 PARAM_PUBLISHER<br>
   *
   * @値 publisher
   */
  PARAM_PUBLISHER("publisher"),

  /**
   * @パラメータ定数 PARAM_REGISTE_COMPLETED<br>
   *
   * @値 registe_completed
   */
  PARAM_REGISTE_COMPLETED("registe_completed"),

  /**
   * @パラメータ定数 PARAM_REGISTE_COMPLETED<br>
   *
   * @値 registe_display
   */
  PARAM_REGISTE_DISPLAY("registe_display"),

  /**
   * @パラメータ定数 PARAM_REGISTE_ERROR<br>
   *
   * @値 registe_error
   */
  PARAM_REGISTE_ERROR("registe_error"),
  /**
   * @パラメータ定数 PARAM_RETURN_COMPLETED<br>
   *
   * @値 return_completed
   */
  PARAM_RETURN_COMPLETED("return_completed"),

  /**
   * @パラメータ定数 PARAM_RETURN_ERROR<br>
   *
   * @値 returnError
   */
  PARAM_RETURN_ERROR("returnError"),

  /**
   * @パラメータ定数 PARAM_RETURN_DATE<br>
   *
   * @値 return_date
   */
  PARAM_RETURN_DATE("return_date"),

  /**
   * @パラメータ定数 PARAM_SCOPE_DISCLOSUER<br>
   *
   * @値 scope_disclosuer
   */
  PARAM_SCOPE_DISCLOSUER("scope_disclosuer"),

  /**
   * @パラメータ定数 PARAM_SERIES<br>
   *
   * @値 series
   */
  PARAM_SERIES("series"),

  /**
   * @パラメータ定数 PARAM_SIGNUP<br>
   *
   * @値 signUp
   */
  PARAM_SIGNUP("signUp"),

  /**
   * @パラメータ定数 PARAM_SUBMIT<br>
   *
   * @値 submit
   */
  PARAM_SUBMIT("submit"),

  /**
   * @パラメータ定数 PARAM_TITLE<br>
   *
   * @値 title
   */
  PARAM_TITLE("title"),

  /**
   * @パラメータ定数 PARAM_USER_ADDRESS<br>
   *
   * @値 user_address
   */
  PARAM_USER_ADDRESS("user_address"),

  /**
   * @パラメータ定数 PARAM_USER_AGE<br>
   *
   * @値 user_age
   */
  PARAM_USER_AGE("user_age"),

  /**
   * @パラメータ定数 PARAM_USER_ID<br>
   *
   * @値 user_id
   */
  PARAM_USER_ID("user_id"),

  /**
   * @パラメータ定数 PARAM_USER_NAME<br>
   *
   * @値 user_name
   */
  PARAM_USER_NAME("user_name"),

  /**
   * @パラメータ定数 PARAM_USER_NUM_LENDING<br>
   *
   * @値 user_num_lending
   */
  PARAM_USER_NUM_LENDING("user_num_lending"),

  /**
   * @パラメータ定数 PARAM_USER_PASS<br>
   *
   * @値 user_pass
   */
  PARAM_USER_PASS("user_pass"),

  /**
   * @パラメータ定数 PARAM_USER_REGISTE_DATE<br>
   *
   * @値 user_registe_date
   */
  PARAM_USER_REGISTE_DATE("user_registe_date"),

  /**
   * @パラメータ定数 PARAM_USER_SEX_KBN<br>
   *
   * @値 user_sex_kbn
   */
  PARAM_USER_SEX_KBN("user_sex_kbn"),

  /**
   * @パラメータ定数 PARAM_VERSION_DISPLAY<br>
   *
   * @値 version_display
   */
  PARAM_VERSION_DISPLAY("version_display"),

  /**
   * @パラメータ定数 PARAM_WINDING_NEXT<br>
   *
   * @値 winding_next
   */
  PARAM_WINDING_NEXT("winding_next"),

  /**
   * @パラメータ定数 PARAM_YEAR_PUBLICATION<br>
   *
   * @値 year_publication
   */
  PARAM_YEAR_PUBLICATION("year_publication"),

///////////////////////////////////
//属性名定数
///////////////////////////////////

  /**
   * @属性名定数 ATTR_BTN<br>
   *
   * @値 btn
   */
  ATTR_BTN("btn"),

  /**
   * @属性名定数 ATTR_DISPLAY_INFO<br>
   *
   * @値 display_info
   */
  ATTR_DISPLAY_INFO("display_info"),

  /**
   * @属性名定数 ATTR_BOOK<br>
   *
   * @値 book
   */
  ATTR_BOOK("book"),

  /**
   * @属性名定数 ATTR_MNG_USER_INFO<br>
   *
   * @値 mng_user_info
   */
  ATTR_MNG_USER_INFO("mng_user_info"),

  /**
   * @属性名定数 ATTR_SESSION_USER<br>
   *        @ ログインしたユーザを識別する
   * @値 session_user
   */
  ATTR_SESSION_USER("session_user"),

  /**
   * @パラメータ定数 ATTR_SESSION_MNG_USER<br>
   *
   * @値 session_mng_user
   */
  ATTR_SESSION_MNG_USER("session_mng_user"),

  /**
   * @パラメータ定数 ATTR_SESSION_GUEST_USER<br>
   *
   * @値 session_guest_user
   */
  ATTR_SESSION_GUEST_USER("session_guest_user"),

  /**
   * @属性名定数 ATTR_RESULT<br>
   *
   * @値 result
   */
  ATTR_RESULT("result"),

  /**
   * @属性名定数 ATTR_ERROR_MESSAGE<br>
   *
   * @値 error_message
   */
  ATTR_ERROR_MESSAGE("error_message"),

  /**
   * @属性名定数 ATTR_BEAN<br>
   *
   * @値 bean
   */
  ATTR_BEAN("bean"),

  /**
   * @属性名定数 ATTR_USER_BEAN<br>
   *
   * @値 userBean
   */
  ATTR_USER_BEAN("userBean"),

  /**
   * @属性名定数 ATTR_BOOK_BEAN<br>
   *
   * @値 bookBean
   */
  ATTR_BOOK_BEAN("bookBean"),

  /**
   * @属性名定数 ATTR_COMMON_BEAN<br>
   *
   * @値 commonBean
   */
  ATTR_COMMON_BEAN("commonBean"),

  /**
   * @属性名定数 ATTR_USER_ID<br>
   *
   * @値 userId
   */
  ATTR_USER_ID("userId"),

  /**
   * @属性名定数 ATTR_COMMON_ID<br>
   *
   * @値 common_id
   */
  ATTR_COMMON_ID("common_id"),

  /**
   * @属性名定数 ATTR_USER_ID<br>
   *
   * @値 bookId
   */
  ATTR_BOOK_ID("bookId"),

///////////////////////////////////
//ボタンラベル定数
///////////////////////////////////

  /**
   * @ボタンラベル定数 BTN_LOGIN<br>
   *
   * @値 ログイン
   */
  BTN_LOGIN("ログイン"),

  /**
   * @ボタンラベル定数 BTN_LOGOUT<br>
   *
   * @値 ログアウト
   */
  BTN_LOGOUT("ログアウト"),

  /**
   * @ボタンラベル定数 BTN_END<br>
   *
   * @値 終了
   */
  BTN_END("終了"),

  /**
   * @ボタンラベル定数 BTN_GUEST<br>
   *
   * @値 ゲスト
   */
  BTN_GUEST("ゲスト"),

  /**
   * @ボタンラベル定数 BTN_SIGNUP<br>
   *
   * @値 サインアップ
   */
  BTN_SIGNUP("サインアップ"),

  /**
   * @ボタンラベル定数 BTN_REGIST<br>
   *
   * @値 登録
   */
  BTN_REGIST("登録"),

  /**
   * @ボタンラベル定数 BTN_DELETING_CONFIRMATION<br>
   *
   * @値 削除確認
   */
  BTN_DELETING_CONFIRMATION("削除確認"),

  /**
   * @ボタンラベル定数 BTN_DELETING<br>
   *
   * @値 削除する
   */
  BTN_DELETING("削除する"),

  /**
   * @ボタンラベル定数 BTN_USER_REGISTRATION<br>
   *
   * @値 ユーザ登録
   */
  BTN_USER_REGISTRATION("ユーザ登録"),

  /**
   * @ボタンラベル定数 BTN_USER_DELETING<br>
   *
   * @値 ユーザ削除
   */
  BTN_USER_DELETING("ユーザ削除"),

  /**
   * @ボタンラベル定数 BTN_USER_LIST<br>
   *
   * @値 ユーザ一覧
   */
  BTN_USER_LIST("ユーザ一覧"),

  /**
   * @ボタンラベル定数 BTN_LENDING_EXCESS_PERSON_LIST<br>
   *
   * @値 貸出超過者一覧
   */
  BTN_LENDING_EXCESS_PERSON_LIST("貸出超過者一覧"),

  /**
   * @ボタンラベル定数 BTN_USER_RANKING<br>
   *
   * @値 ユーザランキング
   */
  BTN_USER_RANKING("ユーザランキング"),

  /**
   * @ボタンラベル定数 BTN_BOOK_REGISTRATION<br>
   *
   * @値 図書登録
   */
  BTN_BOOK_REGISTRATION("図書登録"),

  /**
   * @ボタンラベル定数 BTN_BOOK_LENDING<br>
   *
   * @値 図書貸出
   */
  BTN_BOOK_LENDING("図書貸出"),
  /**
   * @ボタンラベル定数 BTN_LENDING_CONFIRMATION<br>
   *
   * @値 貸出確認
   */
  BTN_LENDING_CONFIRMATION("貸出確認"),

  /**
   * @ボタンラベル定数 BTN_LEND_DECISION<br>
   *
   * @値 貸出決定
   */
  BTN_LEND_DECISION("貸出決定"),

  /**
   * @ボタンラベル定数 BTN_RETURN_DECISION<br>
   *
   * @値 返却決定
   */
  BTN_RETURN_DECISION("返却決定"),

  /**
   * @ボタンラベル定数 BTN_BOOK_DELETING<br>
   *
   * @値 図書削除
   */
  BTN_BOOK_DELETING("図書削除"),

  /**
   * @ボタンラベル定数 BTN_BOOK_LIST<br>
   *
   * @値 図書一覧
   */
  BTN_BOOK_LIST("図書一覧"),

  /**
   * @ボタンラベル定数 BTN_LENDING_WITHIN_LIST<br>
   *
   * @値 貸出中一覧
   */
  BTN_LENDING_WITHIN_LIST("貸出中一覧"),

  /**
   * @ボタンラベル定数 BTN_BOOK_RANKING<br>
   *
   * @値 ブックランキング
   */
  BTN_BOOK_RANKING("ブックランキング"),

  /**
   * @ボタンラベル定数 BTN_BOOK_LEND<br>
   *
   * @値 貸し出す
   */
  BTN_BOOK_LEND("貸し出す"),

  /**
   * @ボタンラベル定数 BTN_RETURNING_RETURN<br>
   *
   * @値 返却
   */
  BTN_RETURNING_RETURN("返却"),

  /**
   * @ボタンラベル定数 BTN_BOOK_RETURN<br>
   *
   * @値 返却
   */
  BTN_BOOK_RETURN("返却する"),

  /**
   * @ボタンラベル定数 BTN_BACK_TO_LIST<br>
   *
   * @値 一覧に戻る
   */
  BTN_BACK_TO_LIST("一覧に戻る"),

  /**
   * @ボタンラベル定数 BTN_BACK_TO_MENU<br>
   *
   * @値 メニューに戻る
   */
  BTN_BACK_TO_MENU("メニューに戻る"),

///////////////////////////////////
//画面(ビュー)定数
///////////////////////////////////

  /**
   * @画面(ビュー)定数 MANAGEMENTMENU_JSP<br>
   *
   * @値 /common/managementMenu.jsp
   */
  MANAGEMENT_MENU_JSP("/common/managementMenu.jsp"),

  /**
   * @画面(ビュー)定数 LOGIN_NG_JSP<br>
   *
   * @値 /common/loginNG.jsp
   */
  LOGIN_NG_JSP("/common/loginNG.jsp"),

  /**
   * @画面(ビュー)定数 LOGIN_JSP<br>
   *
   * @値 /login.jsp
   */
  LOGIN_JSP("/login.jsp"),

  /**
   * @画面(ビュー)定数 M_USER_REGISTE_JSP<br>
   *
   * @値 ./mUserRegiste.jsp
   */
  M_USER_REGISTE_JSP("./mUserRegiste.jsp"),
  /**
   * @画面(ビュー)定数 USER_DELETE_CONFIRM_JSP<br>
   *
   * @値 /user/userDeleteConfirm.jsp
   */
  USER_DELETE_CONFIRM_JSP("/user/userDeleteConfirm.jsp"),

  /**
   * @画面(ビュー)定数 RESULT_JSP<br>
   *
   * @値 ./common/result.jsp
   */
  RESULT_JSP("./common/result.jsp"),

  /**
   * @画面(ビュー)定数 RESULT_ERROR_JSP<br>
   *
   * @値 ./common/resultError.jsp
   */
  RESULT_ERROR_JSP("./common/resultError.jsp"),

  /**
   * @画面 TIMEOUT_JSP<br>
   *
   * @値 ./common/timeout.jsp
   */
  TIMEOUT_JSP("./common/timeout.jsp"),

  /**
   * @画面 FORM_ERROR_JSP<br>
   *
   * @値 ./common/formError.jsp
   */
  FORM_ERROR_JSP("./common/formError.jsp"),

  /**
   * @画面 USER_REGISTE_JSP<br>
   *
   * @値 /user/userRegiste.jsp
   */
  USER_REGISTE_JSP("./user/userRegiste.jsp"),

  /**
   * @画面 USER_LIST<br>
   *
   * @値 /user/userList.jsp
   */
  USER_LIST("/user/userList.jsp"),

  /**
   * @画面 EXCEEDING_PERSON_LIST_JSP<br>
   *
   * @値 ./exceedingPersonList.jsp
   */
  EXCEEDING_PERSON_LIST_JSP("/user/exceedingPersonList.jsp"),

  /**
   * @画面 USER_RANKING_JSP<br>
   *
   * @値 /user/userRanking.jsp
   */
  USER_RANKING_JSP("/user/userRanking.jsp"),

  /**
   * @画面 BOOK_REGISTER_JSP<br>
   *
   * @値 /book/bookRegister.jsp
   */
  BOOK_REGISTER_JSP("/book/bookRegister.jsp"),

  /**
   * @画面 BOOK_LIST_JSP<br>
   *
   * @値 /book/bookList.jsp
   */
  BOOK_LIST_JSP("/book/bookList.jsp"),

  /**
   * @画面 BOOK_LENDING_LIST_JSP<br>
   *
   * @値 /book/bookLendingList.jsp
   */
  BOOK_LENDING_LIST_JSP("/book/bookLendingList.jsp"),

  /**
   * @画面 BOOK_RANKING_JSP<br>
   *
   * @値 /book/bookRanking.jsp
   */
  BOOK_RANKING_JSP("/book/bookRanking.jsp"),

  /**
   * @画面 BOOK_LEND_CONFIRM_JSP<br>
   *
   * @値 /book/bookLendConfirm.jsp
   */
  BOOK_LEND_CONFIRM_JSP("/book/bookLendConfirm.jsp"),
  /**
   * @画面 BOOK_RETURN_CONFIRM_JSP<br>
   *
   * @値 /book/bookReturnConfirm.jsp
   */
  BOOK_RETURN_CONFIRM_JSP("/book/bookReturnConfirm.jsp"),

  /**
   * @画面 BOOK_DELETE_CONFIRM_JSP<br>
   *
   * @値 /book/bookDeleteConfirm.jsp
   */
  BOOK_DELETE_CONFIRM_JSP("/book/bookDeleteConfirm.jsp"),

  ;

  private Integer intType;
  private String strType;
  private boolean boolType;

  private Cnst(Integer intType) {
    this.intType = intType;
  }

  private Cnst(String strType) {
    this.strType = strType;
  }

  private Cnst(boolean boolType) {
    this.boolType = boolType;
  }

  /*
   * <p>
   * [概 要] 番号を取得する。
   * </p>
   * <p>
   * [詳 細]
   * </p>
   * <p>
   * [備 考]
   * </p>
   *
   * @return 番号
   */
  public Integer intType() {
    return this.intType;
  }

  public String strType() {
    return this.strType;
  }

  public boolean boolType() {
    return this.boolType;
  }

}
