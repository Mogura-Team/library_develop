/**
 * CommonMethod.java
 * 2017/11/03
 */
package common;

import java.util.ArrayList;

/**
 * @作成日 2018/02/04
 * @ファイル名 CommonMethod.java
 * @description 共通で扱うメソッドを定義するクラス.
 */
public class CommonMethod {
  //配列からarraylistに変換


/**
 * @method: CommonMethod
 * @discription: 受けとった配列をArrayListに代入する.
 * @projectPass: libraryWeb.common.CommonMethod.java
 * @param temp
 * @return ArrayList
 */
public ArrayList<String> ConvertingFromArrayToArraylist(String[] temp) {

    ArrayList<String> arrayList = new ArrayList<String>();

    //IDを配列に一時格納
    temp = temp[0].split(",", 0);

    //temp配列からarrayListに格納
    for (int i = 0; i < temp.length; i++) {
      arrayList.add(temp[i]);
    }
    return arrayList;
  }

}
