package setUp;

import java.sql.SQLException;

public class setUp {

	public static void main(String[] args) throws SQLException {
		int flag = 0;
		SetUpDao su;

		su = new SetUpDao();
		flag = su.createManagementUserTable();
		if (flag == 0) {

		} else {

		}

		su = new SetUpDao();
		flag = su.createUserTable();
		if (flag == 0) {

		} else {

		}

		su = new SetUpDao();
		flag = su.createBookTable();
		if (flag == 0) {

		} else {

		}

		su = new SetUpDao();
		flag = su.createUserStatusTable();
		if (flag == 0) {

		} else {

		}

		su = new SetUpDao();
		flag = su.createBookStatusTable();
		if (flag == 0) {

		} else {

		}

		su = new SetUpDao();
		flag = su.createLendingBookTable();
		if (flag == 0) {

		} else {

		}

		su = new SetUpDao();
		flag = su.setUserData();
		if (flag == 0) {

		} else {

		}

		su = new SetUpDao();
		flag = su.setUserStatusData();
		if (flag == 0) {

		} else {

		}

		su = new SetUpDao();
		flag = su.setBookData();
		if (flag == 0) {

		} else {

		}

		su = new SetUpDao();
		flag = su.setBookStatusData();
		if (flag == 0) {

		} else {

		}

		su = new SetUpDao();
		flag = su.setManagementUserData();
		if (flag == 0) {

		} else {

		}
	}

}
