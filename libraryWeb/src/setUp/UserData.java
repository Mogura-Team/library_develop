//package setUp;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//public class UserData {
//
//	private String userData;
//
//	UserData() {
//		this.userData = "";
//	}
//
//	public String setUserData() {
//		Calendar c = Calendar.getInstance();
//		SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");
//
//		userData = " (' ichirou ' , ' 鈴木一郎 ' , ' 沖縄県 ' , ' 男 ' , ' ichirou ' , '30' , ' " + s.format(c.getTime())
//				+ "'),"
//				+ "( ' jirou ' , ' 田中次郎 ' , ' 沖縄県 ' , ' 男 ' , ' jirou ' ,' 31' , ' " + s.format(c.getTime()) + "'),"
//				+ "( ' saburou ' , ' 佐藤三郎 ' , ' 沖縄県 ' , ' 男 ' , ' saburou ' ,' 32 ', ' " + s.format(c.getTime())
//				+ "'),"
//				+ "( ' shirou ' , ' 山田四朗 ' , ' 沖縄県 ' , ' 男 ' , ' shirou ' ,' 33' , ' " + s.format(c.getTime()) + "'),"
//				+ "( ' gorou ' , ' 高橋五郎 ' , ' 沖縄県 ' , ' 男 ' , ' gorou', '34 ', ' " + s.format(c.getTime()) + "')";
//
//		return userData;
//	}
//}
