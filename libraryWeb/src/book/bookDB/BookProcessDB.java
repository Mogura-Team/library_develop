package book.bookDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import book.bookBean.BookProcessBean;
import book.bookDao.BookProcessDao;

import common.Cnst;
import common.CommonBean;

/**
 * @作成日 2018/02/04
 * @ファイル名 BookProcessDB.java
 * @description 図書関連処理を行うクラス.
 */
public class BookProcessDB {
  private ResultSet rs;
  private BookProcessDao bpDao;

  private int flag;//判定フラグ

  /**
   * @method: bookRegiste
   * @discription: 図書情報,貸出日、返却日管理の登録処理を行う
   * @projectPass: libraryWeb.book.bookDB.BookProcessDB.java
   * @param title
   * @param bookRegisteDate
   * @return int
   * @throws SQLException
   */
  public int bookRegiste(String title, String bookRegisteDate) {

    //Daoクラスインスタンス化
    bpDao = new BookProcessDao();

    ResultSet rs;
    try {
      // 図書IDを採番
      rs = bpDao.createBookIdDao();

      // Stringにキャストし、格納
      String bookId = String.valueOf(rs.getInt(Cnst.PARAM_CREATE_ID.strType()));

      //図書登録処理SQL
      flag = bpDao.bookRegisteDao(bookId, title, bookRegisteDate);
    } catch (SQLException e1) {
      e1.printStackTrace();
    } finally {
      // 処理終了時に各接続を解除
      bpDao.close();
    }
  return flag;
}

  /**
   * @method: BookProcessDB
   * @discription: 図書情報取得処理を行う
   * @projectPass: libraryWeb.book.bookDB.BookProcessDB.java
   * @return ArrayList<BookProcessBean>
   */
  public ArrayList<BookProcessBean> getBookList() {

    ArrayList<BookProcessBean> bookBeanList = new ArrayList<BookProcessBean>();
    try {
      //Daoクラスインスタンス化
      bpDao = new BookProcessDao();
      //図書情報取得SQL
      rs = bpDao.getBookListDao();

      //検索結果を1レコードずつ処理
      while (rs.next()) {
        //図書一覧を格納するbeanクラスインスタンス化
        BookProcessBean bookBean = new BookProcessBean();
        bookBean.setBookId(rs.getString(Cnst.PARAM_BOOK_ID.strType()));
        bookBean.setTitle(rs.getString(Cnst.PARAM_TITLE.strType()));
        bookBean.setWindingNext(rs.getString(Cnst.PARAM_WINDING_NEXT.strType()));
        bookBean.setSeries(rs.getString(Cnst.PARAM_SERIES.strType()));
        bookBean.setVersionDisplay(rs.getString(Cnst.PARAM_VERSION_DISPLAY.strType()));
        bookBean.setAuthor(rs.getString(Cnst.PARAM_AUTHOR.strType()));
        bookBean.setPublisher(rs.getString(Cnst.PARAM_PUBLISHER.strType()));
        bookBean.setYearPublication(rs.getString(Cnst.PARAM_YEAR_PUBLICATION.strType()));
        bookBean.setIsbn(rs.getString(Cnst.PARAM_ISBN.strType()));
        bookBean.setNumberPagesHW(rs.getString(Cnst.PARAM_NUMBER_PAGES_H_W.strType()));
        bookBean.setScopeDisclosuer(rs.getString(Cnst.PARAM_SCOPE_DISCLOSUER.strType()));
        bookBean.setMngUserId(rs.getString(Cnst.PARAM_MNG_USER_ID.strType()));
        bookBean.setBookNumLending(rs.getString(Cnst.PARAM_BOOK_NUM_LENDING.strType()));
        bookBean.setBookRegisteDate(rs.getString(Cnst.PARAM_BOOK_REGISTE_DATE.strType()));
        bookBean.setBookLendStatus(rs.getString(Cnst.PARAM_BOOK_LEND_STATUS.strType()));
        bookBeanList.add(bookBean);

      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 処理終了時に各接続を解除
      bpDao.close();
    }
    return bookBeanList;
  }

  /**
   * @method: BookProcessDB
   * @discription: 貸出処理を行う
   * @projectPass: libraryWeb.book.bookDB.BookProcessDB.java
   * @param userId
   * @param bookId
   * @param mngUserId
   * @return int
   */
  public int lendRegiste(ArrayList<String> bookId, String userId, String mngUserId) {
    boolean flg = true;
    BookProcessDao bpDao = new BookProcessDao();

    // 貸出日,返却日を取得(基本返却日は１週間後)
    // 貸出日を取得
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(Cnst.DATE_FORMAT.strType());
    String lendingDate = sdf.format(c.getTime());
    // 返却日を格納
    c.add(Calendar.DATE, 7);
    String returnDate = sdf.format(c.getTime());
    try {
    //貸出処理SQL
    flag = bpDao.lendRegisteDao(userId, bookId, lendingDate, returnDate, mngUserId);
    } catch (SQLException ce) {
      ce.printStackTrace();
    }finally{
      bpDao.close();
    }

    return flag;
  }
  /**
   * @method: BookProcessDB
   * @discription: 返却処理を行う
   * @projectPass: libraryWeb.book.bookDB.BookProcessDB.java
   * @param bookId
   * @param userId
   * @return int
   */
  public int returnRegiste(ArrayList<String> bookId, String userId) {
    boolean flg = true;
    BookProcessDao bpDao = new BookProcessDao();

    // 貸出日,返却日を取得(基本返却日は１週間後)
    // 貸出日を取得

    try {
    //返却処理SQL
    flag = bpDao.returnRegisteDao(userId, bookId);
    } catch (SQLException ce) {
      ce.printStackTrace();
    }finally{
      bpDao.close();
    }

    return flag;
  }

  /**
   * @method: BookProcessDB
   * @discription: 図書情報,図書状態管理の削除処理を行う
   * @projectPass: libraryWeb.book.bookDB.BookProcessDB.java
   * @param bookId
   * @return int
   */
  public int deleteBook(ArrayList<String> bookId) {
    bpDao = new BookProcessDao();
    // 合計件数カウント用
    int totalCount = 0;
    try {
      //削除処理SQL
      totalCount = bpDao.deleteBookDao(bookId);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 処理終了時に各接続を解除
      bpDao.close();
    }
    return totalCount;
  }

  /**
   * @method: BookProcessDB
   * @discription: 貸出中の図書,ユーザ情報取得処理を行う
   * @projectPass: libraryWeb.book.bookDB.BookProcessDB.java
   * @return ArrayList<CommonBean>
   */
  public ArrayList<CommonBean> LendingList() {
    ArrayList<CommonBean> commonBeanList = new ArrayList<CommonBean>();

    try {
      //Daoクラスインスタンス化
      bpDao = new BookProcessDao();
      //図書情報取得処理SQL
      rs = bpDao.getLendingBookListDao();

      //検索結果を1レコードずつ処理
      while (rs.next()) {
        //貸出中一覧を格納するbeanクラスインスタンス化
        CommonBean commonBean = new CommonBean();
        commonBean.setBookId(rs.getString(Cnst.PARAM_BOOK_ID.strType()));
        commonBean.setTitle(rs.getString(Cnst.PARAM_TITLE.strType()));
        commonBean.setUserId(rs.getString(Cnst.PARAM_USER_ID.strType()));
        commonBean.setUserName(rs.getString(Cnst.PARAM_USER_NAME.strType()));
        commonBean.setLendingDate(rs.getString(Cnst.PARAM_LENDING_DATE.strType()));
        commonBean.setReturnDate(rs.getString(Cnst.PARAM_RETURN_DATE.strType()));
        commonBeanList.add(commonBean);

      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 処理終了時に各接続を解除
      bpDao.close();
    }
    return commonBeanList;
  }

}
