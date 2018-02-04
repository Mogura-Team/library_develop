package setUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.ConnectionBean;

public class SetUpDao {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public ConnectionBean cb = new ConnectionBean();

	public int flag;//メソッドの結果判定フラグ

	public int createManagementUserTable() throws SQLException {
		flag = 0;

		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());
			// SQL文を生成

			ps = con.prepareStatement("create table IF NOT EXISTS m_user_tb(m_id int(20) not null,m_name varchar(20),m_pass varchar(20))");

			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {

			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;

	}

	public int createUserTable() throws SQLException {
		flag = 0;
		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

			// SQL文を生成
			ps = con.prepareStatement("create table IF NOT EXISTS user_tb(u_id int(50) AUTO_INCREMENT primary key, u_name varchar(50),u_address varchar(50),u_sex char(5) , u_pass varchar(50),u_age int(5) , u_date varchar(30))");

			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {

			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;

	}

	public int createBookTable() throws SQLException {
		flag = 0;
		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

			// SQL文を生成
			ps = con.prepareStatement("create table IF NOT EXISTS book_tb(b_id int(50) AUTO_INCREMENT primary key,b_title varchar(60),b_date varchar(50))");

			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {

			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;
	}

	public int createBookStatusTable() throws SQLException {
		flag = 0;
		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

			// SQL文を生成
			ps = con.prepareStatement("create table IF NOT EXISTS book_status_tb(b_id int(50)"
					+ "AUTO_INCREMENT not null primary key,lend_history varchar(255), lend_status char(5) DEFAULT 1 ,b_ranking int(5) DEFAULT 0 )");

			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {

			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;

	}

	public int createUserStatusTable() throws SQLException {
		flag = 0;
		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());
			// SQL文を生成
			ps = con.prepareStatement("create table IF NOT EXISTS user_status_tb(u_id int(50) AUTO_INCREMENT not null primary key,u_history varchar(255),u_ranking int(5) DEFAULT 0 )");

			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {

			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;

	}

	public int createLendingBookTable() throws SQLException {
		flag = 0;
		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

			// SQL文を生成
			ps = con.prepareStatement("create table IF NOT EXISTS lending_book_tb(b_id int(50),u_id int(50),lend_date varchar(30),return_date varchar(30))");

			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {

			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;

	}

	public int setUserData() throws SQLException {
		flag = 0;
		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

			// SQL文を生成
			ps = con.prepareStatement("INSERT INTO user_tb(u_name , u_address , u_sex , u_pass , u_age , u_date)values('田中一郎','沖縄県那覇市*****1-13-12','男','ichirou','30','2015年03月09日'),('田中次郎','沖縄県浦添市*****3-1-5','男','jirou','30','2015年03月09日')");
			//
			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;
	}

	public int setManagementUserData() throws SQLException {
		flag = 0;
		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

			// SQL文を生成
			ps = con.prepareStatement("INSERT INTO m_user_tb(m_id,m_name,m_pass)values(1,'user','pass')");
			//
			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;
	}

	public int setBookData() throws SQLException {
		flag = 0;
		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

			// SQL文を生成
			ps = con.prepareStatement("INSERT INTO book_tb(b_title,b_date)values('基本情報技術者教(FE)','2016年09月14日'),('応用情報技術者(AP)','2016年09月14日'),('ITストラテジスト(ST)','2016年09月14日'),('システムアーキテクト(SA)','2016年09月14日'),('プロジェクトマネージャ(PM)','2016年09月14日'),('ネットワークスペシャリスト(NW)','2016年09月14日'),('データベーススペシャリスト(DB)','2016年09月14日'),('エンベデットシステムスペシャリスト(ES)','2016年09月14日'),('情報セキュリティスペシャリスト(SC)','2016年09月14日'),('ITサービスマネージャ(SM)','2016年09月14日'),('システム監査技術者(AU)','2016年09月14日')");
			//
			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;
	}

	public int setUserStatusData() throws SQLException {
		flag = 0;
		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

			// SQL文を生成
			ps = con.prepareStatement("INSERT INTO user_status_tb(u_id)VALUES(1),(2)");
			//
			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;
	}

	public int setBookStatusData() throws SQLException {
		flag = 0;
		try {
			//コネクション格納クラスインスタンス
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName(cb.getDriver());

			// データベースと接続
			con = DriverManager.getConnection(cb.getHost(), cb.getName(), cb.getPass());

			// SQL文を生成
			ps = con.prepareStatement("INSERT INTO book_status_tb(b_id)VALUES(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11)");

			// SQLを実行
			flag = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			close();
		}
		close();

		return flag;
	}

	/**
	 * コネクションをクローズします.
	 */
	public void close() {
		flag = 0;
		try {

			// データベースとの接続を解除する
			if (con != null) {
				con.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException se) {

			// データベースとの接続解除に失敗した場合
			se.printStackTrace();
		}
	}

}
