package manage.manageLogS;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manage.manageLogBean.LoginUserBean;
import manage.manageLogDB.ManageLoginDB;

import common.Cnst;

@WebServlet("/Management")
public class ManagementServlet extends HttpServlet {
  HttpSession session;
  RequestDispatcher rd;

  /*
   * コンストラクタ
   */
  public ManagementServlet() {
    super();
  }

  /*
   * POSTメソッドでリクエストした場合の処理
   */
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 文字コード設定
    request.setCharacterEncoding(Cnst.UTF8_CODE.strType());
    // クリックされたボタンの判定
    String buttonLabel = request.getParameter(Cnst.PARAM_SUBMIT.strType());

    //画面移動の準備
    session = request.getSession();

    // ログインボタンを押した場合
    if (Cnst.BTN_LOGIN.strType().equals(buttonLabel)) {
      session.removeAttribute(Cnst.ATTR_BTN.strType());
      // セッションにログインユーザ識別をセット
      session.setAttribute(Cnst.ATTR_BTN.strType(), Cnst.ATTR_SESSION_MNG_USER.strType());

      String mngUserId = request.getParameter(Cnst.PARAM_MNG_USER_ID.strType());
      String mngUserPass = request.getParameter(Cnst.PARAM_MNG_USER_PASS.strType());

      //ログイン処理クラスをインスタンス化
      ManageLoginDB login = new ManageLoginDB();

      // ユーザ情報をモデルに格納
      LoginUserBean MngBean = login.getUserData(mngUserId, mngUserPass);

      //管理ユーザの情報を判定
      if (MngBean != null) {

        // セッションにログインした管理ユーザをセット
        session.setAttribute(Cnst.ATTR_MNG_USER_INFO.strType(), MngBean);
        // セッションにログインユーザ識別をセット
        session.setAttribute(Cnst.ATTR_SESSION_USER.strType(), Cnst.ATTR_SESSION_MNG_USER.strType());
        //セッションタイムアウトを30分に設定
        session.setMaxInactiveInterval(1800);

        //次に表示させる画面（ビュー）を指定
        rd = request.getRequestDispatcher(Cnst.MANAGEMENT_MENU_JSP.strType());

      } else {
        //管理ユーザの情報がない場合
        //次に表示させる画面(ビュー)指定
        rd = request.getRequestDispatcher(Cnst.LOGIN_NG_JSP.strType());
      }
      rd.forward(request, response);
    }

    // 終了ボタンを押した場合
    if (Cnst.BTN_END.strType().equals(buttonLabel)) {
      session.invalidate();
      //クリックされたボタンが「logout」の場合はログアウト処理（セッションの破棄）をする
      rd = request.getRequestDispatcher(Cnst.LOGIN_JSP.strType());
      rd.forward(request, response);
    }

    // ログアウトボタンを押した場合
    if (Cnst.BTN_LOGOUT.strType().equals(buttonLabel)) {
      session.invalidate();
      //クリックされたボタンが「logout」の場合はログアウト処理（セッションの破棄）をする
      rd = request.getRequestDispatcher(Cnst.LOGIN_JSP.strType());
      rd.forward(request, response);
    }

    // ゲストボタンを押した場合
    if (Cnst.BTN_GUEST.strType().equals(buttonLabel)) {
      session.invalidate();

      // ゲスト情報セット
      session = request.getSession();
      // 管理ユーザのセッションが残っていれば削除する
      session.removeAttribute(Cnst.ATTR_MNG_USER_INFO.strType());
      session.removeAttribute(Cnst.ATTR_SESSION_USER.strType());

      session.setAttribute(Cnst.ATTR_SESSION_USER.strType(), Cnst.ATTR_SESSION_GUEST_USER.strType());
      //ログイン状態
      rd = request.getRequestDispatcher(Cnst.MANAGEMENT_MENU_JSP.strType());
      rd.forward(request, response);
    }

    // 新規登録ボタンを押した場合
    if (Cnst.BTN_SIGNUP.strType().equals(buttonLabel)) {
      session.invalidate();

      // モデル（ユーザ情報）セット
      session = request.getSession();

      session.removeAttribute(Cnst.ATTR_MNG_USER_INFO.strType());
      session.removeAttribute(Cnst.ATTR_SESSION_USER.strType());
      // セッションにログインした管理ユーザをセット
      session.setAttribute(Cnst.ATTR_BTN.strType(), Cnst.PARAM_SIGNUP.strType());
      //ログイン状態
      rd = request.getRequestDispatcher(Cnst.M_USER_REGISTE_JSP.strType());
      rd.forward(request, response);
    }
    if (Cnst.BTN_REGIST.strType().equals(buttonLabel)) {
      System.out.println("登録ボタン");
    }

  }

  /*
   * GETメソッドでリクエストされた場合の処理.
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 今回はdoPostで処理
    doPost(request, response);

  }
}
