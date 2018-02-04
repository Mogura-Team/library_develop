package book.bookProcessS;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.manageLogBean.LoginUserBean;
import user.userBean.UserProcessBean;
import user.userDB.UserProcessDB;
import book.bookBean.BookProcessBean;
import book.bookDB.BookProcessDB;

import common.Cnst;
import common.CommonMethod;
import common.FormCheck;

/**
 * @作成日 2018/02/04
 * @ファイル名 BookProcessServlet.java
 * @description 図書関連の遷移処理を行うクラス.
 */
@WebServlet("/BookProcess")
public class BookProcessServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public BookProcessServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher rd; // 画面の情報

    // セッションタイムアウトの場合
    if (request.getSession(false) == null) {
      // セッションタイムアウトへ遷移
      response.sendRedirect(Cnst.TIMEOUT_JSP.strType());
    }

    // 共通クラス
    CommonMethod commonMethod;
    // 文字コード設定
    request.setCharacterEncoding(Cnst.UTF8_CODE.strType());
    // 押下ボタンの値を取得
    String buttonLabel = request.getParameter(Cnst.PARAM_SUBMIT.strType());
    // 管理ユーザ名格納用
    String mngUserId = null;
    // 管理ユーザ名取得
    LoginUserBean mngUserBean = (LoginUserBean) request.getSession(true)
        .getAttribute(Cnst.ATTR_MNG_USER_INFO.strType());
    // 管理ユーザ名格納
    mngUserId = mngUserBean.getMngUserId();

    // 貸出確認ボタン押した場合
    if (Cnst.BTN_LENDING_CONFIRMATION.strType().equals(buttonLabel)) {

      UserProcessDB upDB = new UserProcessDB();
      // ユーザ情報を取得
      ArrayList<UserProcessBean> userBeanList = upDB.getUserList();
      request.setAttribute(Cnst.ATTR_USER_BEAN.strType(), userBeanList);
      // 貸出確認画面のフラグセット
      request.setAttribute(Cnst.ATTR_DISPLAY_INFO.strType(), Cnst.PARAM_LEND_DISPLAY.strType());
      // 次画面のセット
      rd = request.getRequestDispatcher(Cnst.BOOK_LEND_CONFIRM_JSP.strType());
      // 遷移処理
      rd.forward(request, response);
    }

    // 貸出確認画面モーダルの決定ボタン押した場合
    if (Cnst.BTN_LEND_DECISION.strType().equals(buttonLabel)) {

      // 図書ID格納用
      ArrayList<String> arrayBookId = new ArrayList<String>();
      commonMethod = new CommonMethod();

      // 図書ID格納
      String userId = request.getParameter(Cnst.PARAM_USER_ID.strType());
      // 図書ID一時格納
      String[] tmpBookId = request.getParameterValues(Cnst.PARAM_BOOK_ID.strType());

      // ArrayList型に変換し、格納する
      arrayBookId = commonMethod.ConvertingFromArrayToArraylist(tmpBookId);
      BookProcessDB bpDB = new BookProcessDB();

      // 貸出処理
      int flag = bpDB.lendRegiste(arrayBookId, userId, mngUserId);

      // 貸出失敗の場合
      if(flag == Cnst.INT_ZERO.intType()){
        // 処理結果画面のパラメータセット
        request.setAttribute(Cnst.ATTR_RESULT.strType(), Cnst.PARAM_LEND_ERROR.strType());
        // 次画面のセット
        rd = request.getRequestDispatcher(Cnst.RESULT_ERROR_JSP.strType());
        // 遷移処理
        rd.forward(request, response);
      } else {
        // 貸出成功の場合
        // 処理結果画面のパラメータセット
        request.setAttribute(Cnst.ATTR_RESULT.strType(), Cnst.PARAM_LEND_COMPLETED.strType());
        // 次画面のセット
        rd = request.getRequestDispatcher(Cnst.RESULT_JSP.strType());
        // 遷移処理
        rd.forward(request, response);
      }
    }

    // 貸出中一覧画面モーダルの決定ボタン押した場合
    if (Cnst.BTN_RETURN_DECISION.strType().equals(buttonLabel)) {

      // 図書ID格納用
      ArrayList<String> arrayBookId = new ArrayList<String>();
      commonMethod = new CommonMethod();

      // ユーザID格納
      String userId = request.getParameter(Cnst.PARAM_USER_ID.strType());
      // 図書ID一時格納
      String[] tmpBookId = request.getParameterValues(Cnst.PARAM_BOOK_ID.strType());

      // リストに変換し、格納する
      arrayBookId = commonMethod.ConvertingFromArrayToArraylist(tmpBookId);
      BookProcessDB bpDB = new BookProcessDB();

      // 返却処理
      int flag = bpDB.returnRegiste(arrayBookId, userId);

      // 返却失敗の場合
      if(flag == Cnst.INT_ZERO.intType()){
        // 処理結果画面のパラメータセット
        request.setAttribute(Cnst.ATTR_RESULT.strType(), Cnst.PARAM_RETURN_ERROR.strType());
        // 次画面のセット
        rd = request.getRequestDispatcher(Cnst.RESULT_ERROR_JSP.strType());
        // 遷移処理
        rd.forward(request, response);
      } else {
        // 返却成功の場合
        // 処理結果画面のパラメータセット
        request.setAttribute(Cnst.ATTR_RESULT.strType(), Cnst.PARAM_RETURN_COMPLETED.strType());
        // 次画面のセット
        rd = request.getRequestDispatcher(Cnst.RESULT_JSP.strType());
        // 遷移処理
        rd.forward(request, response);
      }
    }

    // 削除するボタン押した場合
    if (Cnst.BTN_DELETING.strType().equals(buttonLabel)) {

      // 図書ID格納用
      ArrayList<String> arrayBookId = new ArrayList<String>();
      // 共通クラス
      commonMethod = new CommonMethod();
      // 図書ID一時格納
      String[] tmpBookId = request.getParameterValues(Cnst.PARAM_BOOK_ID.strType());
      // ArrayList型に変換し、格納する
      arrayBookId = commonMethod.ConvertingFromArrayToArraylist(tmpBookId);

      BookProcessDB bpDB = new BookProcessDB();

      // 図書情報,図書状態管理の削除処理
      int totalCount = bpDB.deleteBook(arrayBookId);

      // 合計削除件数が割り切れる、かつ0じゃない場合
      if ((totalCount % 2) == 0 && (totalCount) != 0) {
        // 処理結果画面のパラメータセット
        request.setAttribute(Cnst.ATTR_RESULT.strType(), Cnst.PARAM_DELETE_COMPLETED.strType());
        // 次画面のセット
        rd = request.getRequestDispatcher(Cnst.RESULT_JSP.strType());
        // 遷移処理
        rd.forward(request, response);

      } else {
        // 処理結果画面のパラメータセット
        request.setAttribute(Cnst.ATTR_RESULT.strType(), Cnst.PARAM_DELETE_ERROR.strType());
        // 次画面のセット
        rd = request.getRequestDispatcher(Cnst.RESULT_ERROR_JSP.strType());
        // 遷移処理
        rd.forward(request, response);
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    // セッションタイムアウトの場合
    if (request.getSession(false) == null) {
      // セッションタイムアウトへ遷移
      response.sendRedirect(Cnst.TIMEOUT_JSP.strType());
    }

    // 管理ユーザ名格納用
    String mngUserId = null;
    // 管理ユーザ名取得
    LoginUserBean mngUserBean = (LoginUserBean) request.getSession(true)
        .getAttribute(Cnst.ATTR_MNG_USER_INFO.strType());
    // 管理ユーザ名格納
    mngUserId = mngUserBean.getMngUserId();

    // 文字コード設定
    request.setCharacterEncoding(Cnst.UTF8_CODE.strType());
    // 押下ボタンの値を取得
    String buttonLabel = request.getParameter(Cnst.PARAM_SUBMIT.strType());

    // 画面移動の準備
    RequestDispatcher rd;

    BookProcessBean bookBean = new BookProcessBean();

    if (Cnst.BTN_REGIST.strType().equals(buttonLabel)) {

      // formの入力をチェックするクラスのインスタンス化
      FormCheck fc = new FormCheck();
      // エラーメッセージ変数
      String errorMessage = "";

      bookBean.setTitle(request.getParameter(Cnst.PARAM_TITLE.strType()));
      bookBean.setBookRegisteDate(request.getParameter(Cnst.PARAM_BOOK_REGISTE_DATE.strType()));

      // 文字列の長さのチェック
      errorMessage += fc.getLengthError(bookBean.getTitle(), 1, 60, "タイトル");
      errorMessage += fc.getLengthError(bookBean.getBookRegisteDate(), 10, 20, "登録日");

      // エラーメッセージが設定されていたら
      if (!errorMessage.equals("")) {
        // 処理結果画面にエラーメッセージを設定
        request.setAttribute(Cnst.ATTR_ERROR_MESSAGE.strType(), errorMessage);
        // 次画面のセット
        rd = request.getRequestDispatcher(Cnst.FORM_ERROR_JSP.strType());
        // 遷移処理
        rd.forward(request, response);

      } else {
        BookProcessDB bpDB = new BookProcessDB();
        int flag = bpDB.bookRegiste(bookBean.getTitle(), bookBean.getBookRegisteDate());

        // flagが1なら完了画面へ
        if (flag == 1) {
          // 処理結果画面のパラメータセット
          request.setAttribute(Cnst.ATTR_RESULT.strType(), Cnst.PARAM_REGISTE_COMPLETED.strType());
          // 次画面のセット
          rd = request.getRequestDispatcher(Cnst.RESULT_JSP.strType());
          // 遷移処理
          rd.forward(request, response);

        }
        // 処理結果画面のパラメータセット
        request.setAttribute(Cnst.ATTR_RESULT.strType(), Cnst.PARAM_REGISTE_ERROR.strType());
        // 次画面のセット
        rd = request.getRequestDispatcher(Cnst.RESULT_ERROR_JSP.strType());
        // 遷移処理
        rd.forward(request, response);
      }
    }
  }
}