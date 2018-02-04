package manage.manageProcessS;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.manageBean.ManageProcessBean;
import user.userBean.UserProcessBean;
import user.userDB.UserProcessDB;
import book.bookBean.BookProcessBean;
import book.bookDB.BookProcessDB;

import common.Cnst;
import common.CommonBean;


/**
 * @作成日 2018/02/04
 * @ファイル名 ManageMenuProcessServlet.java
 * @description 基本的なメニューボタンの遷移処理を行うクラス.
 */
@WebServlet("/ManagementMenu")
public class ManageMenuProcessServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ManageMenuProcessServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    //セッションタイムアウト処理でタイムアウト画面遷移
    if (request.getSession(false) == null) {
      response.sendRedirect(Cnst.TIMEOUT_JSP.strType());
    } else {
      String mUserId = null;
      ManageProcessBean mngUserBean = (ManageProcessBean) request.getSession(true)
          .getAttribute(Cnst.ATTR_MNG_USER_INFO.strType());
      mUserId = mngUserBean.getMngUserId();
      RequestDispatcher rd; // 画面の情報
      // 文字コード設定
      request.setCharacterEncoding(Cnst.UTF8_CODE.strType());
      // ボタン名称取得
      String buttonLabel = request.getParameter(Cnst.PARAM_SUBMIT.strType());

      // ユーザ登録ボタンを押した場合
      if (Cnst.BTN_USER_REGISTRATION.strType().equals(buttonLabel)) {

        // ユーザ一覧フラグセット
        request.setAttribute(Cnst.ATTR_DISPLAY_INFO.strType(), Cnst.PARAM_REGISTE_DISPLAY.strType());

        rd = request.getRequestDispatcher(Cnst.USER_REGISTE_JSP.strType());
        rd.forward(request, response);
      }

      // ユーザ削除ボタンを押した場合
      if (Cnst.BTN_USER_DELETING.strType().equals(buttonLabel)) {

        UserProcessDB upDB = new UserProcessDB();
        ArrayList<UserProcessBean> userBeanList = upDB.getUserList();
        request.setAttribute(Cnst.ATTR_USER_BEAN.strType(), userBeanList);

        // ユーザ削除フラグセット
        request.setAttribute(Cnst.ATTR_DISPLAY_INFO.strType(), Cnst.PARAM_DELETE_DISPLAY.strType());

        rd = request.getRequestDispatcher(Cnst.USER_LIST.strType());
        rd.forward(request, response);
      }

      // ユーザ一覧ボタンを押した場合
      if (Cnst.BTN_USER_LIST.strType().equals(buttonLabel)) {

        UserProcessDB upDB = new UserProcessDB();
        ArrayList<UserProcessBean> userBeanList = upDB.getUserList();

        request.setAttribute(Cnst.ATTR_USER_BEAN.strType(), userBeanList);
        // ユーザ一覧フラグセット
        request.setAttribute(Cnst.ATTR_DISPLAY_INFO.strType(), Cnst.PARAM_LIST_ONLY_DISPLAY.strType());

        rd = request.getRequestDispatcher(Cnst.USER_LIST.strType());
        rd.forward(request, response);
      }

      // 貸出超過者一覧ボタンを押した場合
      if (Cnst.BTN_LENDING_EXCESS_PERSON_LIST.strType().equals(buttonLabel)) {

        BookProcessDB bpDB = new BookProcessDB();
        ArrayList<CommonBean> commonBean = bpDB.LendingList();

        request.setAttribute(Cnst.ATTR_BOOK_BEAN.strType(), commonBean);

        UserProcessDB upDB = new UserProcessDB();
        ArrayList<UserProcessBean> userBeanList = upDB.getLendingUserList();

        request.setAttribute(Cnst.ATTR_USER_BEAN.strType(), userBeanList);

        // 貸出超過者一覧フラグセット
        request.setAttribute(Cnst.ATTR_DISPLAY_INFO.strType(), Cnst.PARAM_LENDING_EXCESS_PERSON_LIST_DISPLAY.strType());

        //現在の日付を取得
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(Cnst.DATE_FORMAT.strType());
        String nowDate = sdf.format(c.getTime());

        request.setAttribute("nowDate", nowDate);

        rd = request.getRequestDispatcher(Cnst.EXCEEDING_PERSON_LIST_JSP.strType());
        rd.forward(request, response);
      }

      // 図書登録ボタンを押した場合
      if (Cnst.BTN_BOOK_REGISTRATION.strType().equals(buttonLabel)) {

        request.setAttribute(Cnst.ATTR_DISPLAY_INFO.strType(), Cnst.PARAM_REGISTE_DISPLAY.strType());
        rd = request.getRequestDispatcher(Cnst.BOOK_REGISTER_JSP.strType());
        rd.forward(request, response);
      }

      // 図書貸出ボタンを押した場合
      if (Cnst.BTN_BOOK_LENDING.strType().equals(buttonLabel)) {

        BookProcessDB bpDB = new BookProcessDB();
        ArrayList<BookProcessBean> bookBeanList = bpDB.getBookList();

        request.setAttribute(Cnst.ATTR_BOOK_BEAN.strType(), bookBeanList);
        request.setAttribute(Cnst.ATTR_DISPLAY_INFO.strType(), Cnst.PARAM_LEND_DISPLAY.strType());

        rd = request.getRequestDispatcher(Cnst.BOOK_LIST_JSP.strType());
        rd.forward(request, response);
      }

      // 図書削除ボタンを押した場合
      if (Cnst.BTN_BOOK_DELETING.strType().equals(buttonLabel)) {

        BookProcessDB bpDB = new BookProcessDB();
        ArrayList<BookProcessBean> bookBean = bpDB.getBookList();

        request.setAttribute(Cnst.ATTR_BOOK_BEAN.strType(), bookBean);
        request.setAttribute(Cnst.ATTR_DISPLAY_INFO.strType(), Cnst.PARAM_DELETE_DISPLAY.strType());

        rd = request.getRequestDispatcher(Cnst.BOOK_LIST_JSP.strType());
        rd.forward(request, response);
      }

      // 図書一覧ボタンを押した場合
      if (Cnst.BTN_BOOK_LIST.strType().equals(buttonLabel)) {

        BookProcessDB bpDB = new BookProcessDB();
        ArrayList<BookProcessBean> bookBean = bpDB.getBookList();

        request.setAttribute(Cnst.ATTR_BOOK_BEAN.strType(), bookBean);
        request.setAttribute(Cnst.ATTR_DISPLAY_INFO.strType(), Cnst.PARAM_LIST_ONLY_DISPLAY.strType());

        rd = request.getRequestDispatcher(Cnst.BOOK_LIST_JSP.strType());
        rd.forward(request, response);
      }

      // 貸出中一覧ボタンを押した場合
      if (Cnst.BTN_LENDING_WITHIN_LIST.strType().equals(buttonLabel)) {

        BookProcessDB bpDB = new BookProcessDB();
        ArrayList<CommonBean> commonBean = bpDB.LendingList();

        request.setAttribute(Cnst.ATTR_COMMON_BEAN.strType(), commonBean);
        request.setAttribute(Cnst.ATTR_DISPLAY_INFO.strType(), Cnst.PARAM_LENDING_WITHIN_DISPLAY.strType());

        UserProcessDB upDB = new UserProcessDB();
        ArrayList<UserProcessBean> userBean = upDB.getLendingUserList();

        request.setAttribute(Cnst.ATTR_USER_BEAN.strType(), userBean);

        rd = request.getRequestDispatcher(Cnst.BOOK_LENDING_LIST_JSP.strType());
        rd.forward(request, response);
      }

      // 一覧に戻るボタンを押した場合
      if (Cnst.BTN_BACK_TO_LIST.strType().equals(buttonLabel)) {

        //userDeleteConfirm.jsp画面の一覧に戻るボタンを押したときの処理
        UserProcessDB upDB = new UserProcessDB();
        ArrayList<UserProcessBean> bean = upDB.getUserList();

        request.setAttribute(Cnst.ATTR_BOOK_BEAN.strType(), bean);

        rd = request.getRequestDispatcher(Cnst.USER_LIST.strType());
        rd.forward(request, response);
      }

      // メニューに戻るボタンを押した場合
      if (Cnst.BTN_BACK_TO_MENU.strType().equals(buttonLabel)) {

        rd = request.getRequestDispatcher(Cnst.MANAGEMENT_MENU_JSP.strType());
        rd.forward(request, response);
      }

      // ゲストボタンを押した場合
      if (Cnst.BTN_GUEST.strType().equals(buttonLabel)) {

        BookProcessDB upDB = new BookProcessDB();
        ArrayList<BookProcessBean> bean = upDB.getBookList();

        request.setAttribute(Cnst.ATTR_BOOK_BEAN.strType(), bean);

        rd = request.getRequestDispatcher(Cnst.BOOK_LIST_JSP.strType());
        rd.forward(request, response);
      }

      // サインアップボタンを押した場合
      if (Cnst.BTN_SIGNUP.strType().equals(buttonLabel)) {

        BookProcessDB upDB = new BookProcessDB();
        ArrayList<BookProcessBean> bean = upDB.getBookList();

        request.setAttribute(Cnst.ATTR_BOOK_BEAN.strType(), bean);

        rd = request.getRequestDispatcher(Cnst.BOOK_LIST_JSP.strType());
        rd.forward(request, response);
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 今回はdoPostで処理
    doPost(request, response);
  }

}
