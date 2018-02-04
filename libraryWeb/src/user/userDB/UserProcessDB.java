package user.userDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import user.userBean.UserProcessBean;
import user.userDao.UserProcessDao;

import common.Cnst;
import commonJson.JsonUtil;

public class UserProcessDB {
  private int flag;
  private ResultSet rs;
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
        flag = upDao.userRegisteDao(userId, mngUserId, userName, userAddress,
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
      rs = upDao.getUserListDao();//ユーザ情報取得メソッド

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
      rs = upDao.getLendingUserListDao();//図書情報取得メソッド

      //検索結果を1レコードずつ処理
      while (rs.next()) {
        //図書一覧を格納するbeanクラスインスタンス化
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

}
