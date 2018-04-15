package user;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.entity.TUserInfo;
import com.example.entity.TUserInfoExample;
import com.example.entity.TUserInfoMapper;

/**
 * Hello world!
 *
 */
public class MyBatisTest
{
  public static void main(String[] args) {

    // resources直下のmybatis-config.xmlを読み込みます(1)
    try (Reader r = Resources.getResourceAsReader("mybatis-config.xml");) {

      // 読み込んだ設定ファイルからSqlSessionFactoryを生成します(2)
      SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

      // SQLセッションを取得します(3)
      try (SqlSession session = factory.openSession()) {

        // ActorテーブルのMapperを取得します(4)
        TUserInfoMapper map = session.getMapper(TUserInfoMapper.class);

        TUserInfoExample ex = new TUserInfoExample();

        // WHERE
        //    (first_name LIKE 'T%' AND actor_id < 100)
        //    OR (last_name LIKE 'S%' AND actor_id > 100)
        // 検索条件に↑と同等の条件を設定しています
        // 　  Criteriaを作成し、AND条件を追加する (1)
        ex.createCriteria().andUserAddressLike("沖縄県%").andUserSexKbnEqualTo("男");

        // 上記の条件でテーブルを検索しま+す
        List<TUserInfo> tUserInfoList = map.selectByExample(ex);

        // 取得結果を表示します
        System.out.println("actor_id, first_name, last_name, last_update");
        for (TUserInfo tUserInfo : tUserInfoList) {

          System.out.printf("%s, %s, %s, %s, %s \n", tUserInfo.getMngUserId(), tUserInfo.getUserAddress(),
              tUserInfo.getUserName(),
              tUserInfo.getUserAddress(), tUserInfo.getUserSexKbn());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
