package user.userDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import user.userBean.UserProcessBean;
import user.userDao.UserProcessDao;

import common.Cnst;
import common.CommonBean;
import commonJson.JsonUtil;

/**
 * @作成日 2018/02/04
 * @ファイル名 UserProcessDB.java
 * @description ユーザ関連処理を行うクラス.
 */
public class UserProcessDB {
  private int flag;
  private ResultSet rs;
  private ResultSet rs_1;
  private UserProcessDao upDao;

  /**
   * @method: UserProcessDB
   * @discription: ユーザ登録処理を行う
   * @projectPass: libraryWeb.user.userDB.UserProcessDB.java
   * @param mngUserId
   * @param userName
   * @param userAddress
   * @param userSexKbn
   * @param userPass
   * @param userRegisteDate
   * @param userAge
   * @return int
   * @throws SQLException
   */
  public int userRegiste(String mngUserId, String userName, String userAddress,
      String userSexKbn, String userPass, String userRegisteDate, String userAge) {

      //Daoクラスインスタンス化
      upDao = new UserProcessDao();

      ResultSet rs;
      try {
        // ユーザIDを採番
        rs = upDao.createUserIdDao();

        // Stringにキャストし、格納
        String userId = String.valueOf(rs.getInt(Cnst.PARAM_CREATE_ID.strType()));

        //ユーザ登録処理SQL
        flag = upDao.insertUserRegisteDao(userId, mngUserId, userName, userAddress,
            userSexKbn, userPass, userRegisteDate, userAge);
      } catch (SQLException e1) {
        e1.printStackTrace();
      } finally {
        // 処理終了時に各接続を解除
        upDao.close();
      }
    return flag;
  }

  /**
   * @method: UserProcessDB
   * @discription: ユーザ情報取得処理を行う
   * @projectPass: libraryWeb.user.userDB.UserProcessDB.java
   * @return ArrayList<UserProcessBean>
   */
  public ArrayList<UserProcessBean> getUserList() {

    ArrayList<UserProcessBean> userBeanList = new ArrayList<UserProcessBean>();
    try {
      upDao = new UserProcessDao();//Daoクラスインスタンス化
      rs = upDao.selectUserListDao();//ユーザ情報取得メソッド

      //検索結果を1レコードずつ処理

      while (rs.next()) {
        //ユーザ一覧を格納するbeanクラスインスタンス化
        UserProcessBean userBean = new UserProcessBean();

        userBean.setUserId(rs.getString(Cnst.PARAM_USER_ID.strType()));
        userBean.setMngUserId(rs.getString(Cnst.PARAM_MNG_USER_ID.strType()));
        userBean.setUserNumLending(rs.getString(Cnst.PARAM_USER_NUM_LENDING.strType()));
        userBean.setUserName(rs.getString(Cnst.PARAM_USER_NAME.strType()));
        userBean.setUserAddress(rs.getString(Cnst.PARAM_USER_ADDRESS.strType()));
        userBean.setUserSexKbn(rs.getString(Cnst.PARAM_USER_SEX_KBN.strType()));
        userBean.setUserPass(rs.getString(Cnst.PARAM_USER_PASS.strType()));
        userBean.setUserAge(rs.getString(Cnst.PARAM_USER_AGE.strType()));
        userBean.setUserRegisteDate(rs.getString(Cnst.PARAM_USER_REGISTE_DATE.strType()));
        userBeanList.add(userBean);
      }
      JsonUtil ju = new JsonUtil();
      System.out.println(ju.convert(userBeanList));

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 処理終了時に各接続を解除
      upDao.close();
    }
    return userBeanList;
  }

  /**
   * @method: UserProcessDB
   * @discription: ユーザ情報,ユーザの状態管理の削除処理を行う
   * @projectPass: libraryWeb.user.userDB.UserProcessDB.java
   * @param userId
   * @return int
   */
  public int deleteUser(ArrayList<String> userId) {
    upDao = new UserProcessDao();
    // 合計件数カウント用
    int totalCount = 0;
    try {
      totalCount = upDao.deleteUserDao(userId);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 処理終了時に各接続を解除
      upDao.close();
    }
    return totalCount;
  }

  /**
   * @method: UserProcessDB
   * @discription: 貸出中のユーザ一覧取得処理を行う
   * @projectPass: libraryWeb.user.userDB.UserProcessDB.java
   * @return
   * ArrayList<UserProcessBean>
   */
  public ArrayList<UserProcessBean> getLendingUserList() {
    ArrayList<UserProcessBean> userBeanList = new ArrayList<UserProcessBean>();

    try {
      upDao = new UserProcessDao();//Daoクラスインスタンス化
      rs = upDao.selectLendingUserListDao();//図書情報取得メソッド

      //検索結果を1レコードずつ処理
      while (rs.next()) {
        //ユーザ一覧を格納するbeanクラスインスタンス化
        UserProcessBean userBean = new UserProcessBean();
        userBean.setUserId(rs.getString(Cnst.PARAM_USER_ID.strType()));
        userBean.setUserName(rs.getString(Cnst.PARAM_USER_NAME.strType()));
        userBean.setUserAddress(rs.getString(Cnst.PARAM_USER_ADDRESS.strType()));
        userBean.setUserSexKbn(rs.getString(Cnst.PARAM_USER_SEX_KBN.strType()));
        userBean.setUserAge(rs.getString(Cnst.PARAM_USER_AGE.strType()));
        userBeanList.add(userBean);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 処理終了時に各接続を解除
      upDao.close();
    }
    return userBeanList;
  }

  /**
   * @method: UserProcessDB
   * @discription: 超過者情報格取得処理を行う
   * @projectPass: libraryWeb.user.userDB.UserProcessDB.java
   * @return ArrayList<UserProcessBean>
   */
  public ArrayList<CommonBean> LendingExcessPersonList() {

    // 超過者リスト格納用
    ArrayList<CommonBean> commonBeanList = new ArrayList<CommonBean>();

    try {
      upDao = new UserProcessDao();//Daoクラスインスタンス化

      rs = upDao.selectLendingExcessPersonListDao();

      int count = 0;
      //検索結果を1レコードずつ処理
      while (rs.next()) {
        //超過者一覧を格納するbean
        CommonBean commonBean = new CommonBean();

        commonBean.setCount(rs.getString(Cnst.PARAM_COUNT.strType()));
        commonBean.setUserId(rs.getString(Cnst.PARAM_USER_ID.strType()));
        commonBean.setUserName(rs.getString(Cnst.PARAM_USER_NAME.strType()));
        commonBean.setUserAddress(rs.getString(Cnst.PARAM_USER_ADDRESS.strType()));
        commonBean.setUserSexKbn(rs.getString(Cnst.PARAM_USER_SEX_KBN.strType()));
        commonBean.setUserAge(rs.getString(Cnst.PARAM_USER_AGE.strType()));
        commonBeanList.add(commonBean);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 処理終了時に各接続を解除
      upDao.close();
    }
    return commonBeanList;
  }

  /**
   * @method: UserProcessDB
   * @discription: 超過図書情報格取得処理を行う
   * @projectPass: libraryWeb.user.userDB.UserProcessDB.java
   * @return ArrayList<UserProcessBean>
   */
  public ArrayList<Map<String, Object>> LendingExcessBookList() {

    // 超過図書情報格納用
    ArrayList<Map<String, Object>> bookMap = new ArrayList<Map<String, Object>>();
    try {
      upDao = new UserProcessDao();//Daoクラスインスタンス化

      rs = upDao.selectLendingExcessBookListDao();

        //検索結果を1レコードずつ処理
        while (rs.next()) {
          Map<String,Object> map = new HashMap<String,Object>();
          //モーダル用の超過した図書一覧を格納する
          map.put(Cnst.PARAM_USER_ID.strType(),rs.getString(Cnst.PARAM_USER_ID.strType()));
          map.put(Cnst.PARAM_BOOK_ID.strType(),rs.getString(Cnst.PARAM_BOOK_ID.strType()));
          map.put(Cnst.PARAM_TITLE.strType(),rs.getString(Cnst.PARAM_TITLE.strType()));
          map.put(Cnst.PARAM_LENDING_DATE.strType(),rs.getString(Cnst.PARAM_LENDING_DATE.strType()));
          map.put(Cnst.PARAM_RETURN_DATE.strType(),rs.getString(Cnst.PARAM_RETURN_DATE.strType()));
          bookMap.add(map);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 処理終了時に各接続を解除
      upDao.close();
    }
    return bookMap;
  }

}
