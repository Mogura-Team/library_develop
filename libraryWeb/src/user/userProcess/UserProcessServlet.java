package user.userProcess;

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

import common.Cnst;
import common.CommonMethod;
import common.FormCheck;

@WebServlet("/UserProcess")
public class UserProcessServlet extends HttpServlet {

  public UserProcessServlet() {
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

    // 削除するボタン押した場合
    if (Cnst.BTN_DELETING.strType().equals(buttonLabel)) {

      // ユーザのID格納用
      ArrayList<String> arrayUserId = new ArrayList<String>();
      // 共通クラス
      commonMethod = new CommonMethod();
      // ユーザのID一時格納
      String[] temp = request.getParameterValues(Cnst.PARAM_USER_ID.strType());
      // ArrayList型に変換し、格納する
      arrayUserId = commonMethod.ConvertingFromArrayToArraylist(temp);

      UserProcessDB upDB = new UserProcessDB();

      // ユーザ情報,ユーザの状態管理の削除処理
      int totalCount = upDB.deleteUser(arrayUserId);

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

    UserProcessBean userBean = new UserProcessBean();// ユーザプロパティのオブジェクト

    if (Cnst.BTN_REGIST.strType().equals(buttonLabel)) {

      // formの入力をチェックするクラスのインスタンス化
      FormCheck fc = new FormCheck();
      // エラーメッセージ変数
      String errorMessage = "";

      if ("mUserRegiste".equals(request.getParameter("mUserRegiste"))) {
      } else {
        userBean.setUserName(request.getParameter(Cnst.PARAM_USER_NAME.strType()));
        userBean.setUserAddress(request.getParameter(Cnst.PARAM_USER_ADDRESS.strType()));
        userBean.setUserSexKbn(request.getParameter(Cnst.PARAM_USER_SEX_KBN.strType()));
        userBean.setUserPass(request.getParameter(Cnst.PARAM_USER_PASS.strType()));
        userBean.setUserRegisteDate(request.getParameter(Cnst.PARAM_USER_REGISTE_DATE.strType()));
        userBean.setUserAge(request.getParameter(Cnst.PARAM_USER_AGE.strType()));

        // 文字列の長さのチェック
        errorMessage += fc.getLengthError(userBean.getUserName(), 1, 30, "名前");
        errorMessage += fc.getLengthError(userBean.getUserAddress(), 8, 70, "住所");
        errorMessage += fc.getLengthError(userBean.getUserPass(), 4, 18, "パスワード");
        errorMessage += fc.getLengthError(userBean.getUserRegisteDate(), 10, 20, "登録日");

        // 性別のラジオボタンチェック
        errorMessage += fc.sexCheck(userBean.getUserSexKbn());

        // 文字列のタイプのチェック
        errorMessage += fc.getDigitAlphabetError(userBean.getUserPass(),
            "パスワード");
      }

      // エラーメッセージが設定されていたら
      if (!errorMessage.equals("")) {
        // request オブジェクトにエラーメッセージを設定
        request.setAttribute(Cnst.ATTR_ERROR_MESSAGE.strType(), errorMessage);

        // エラーページへ転送
        rd = request.getRequestDispatcher(Cnst.FORM_ERROR_JSP.strType());
        rd.forward(request, response);

      } else {

        UserProcessDB upDB = new UserProcessDB();

        // ユーザ登録
        int flag = upDB.userRegiste(mngUserId, userBean.getUserName(),
            userBean.getUserAddress(), userBean.getUserSexKbn(), userBean.getUserPass(),
            userBean.getUserRegisteDate(), userBean.getUserAge());

        // 登録成功の場合
        if (flag == 1) {
          // 処理結果画面のパラメータセット
          request.setAttribute(Cnst.ATTR_RESULT.strType(), Cnst.PARAM_REGISTE_COMPLETED.strType());
          // 次画面のセット
          rd = request.getRequestDispatcher(Cnst.RESULT_JSP.strType());
          // 遷移処理
          rd.forward(request, response);
        } else {
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
}