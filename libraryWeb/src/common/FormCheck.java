package common;

/**
 * @作成日 2018/02/04
 * @ファイル名 FormCheck.java
 * @description フォームのチェックを行うクラス.
 */
public class FormCheck {

  /**
   * 文字列中の文字数を半角文字基準でチェックする
   *
   * @param input
   *          チェック対象の文字列
   * @param min
   *          許容最小文字数
   * @param max
   *          許容最大文字数
   * @return チェック結果。0なら許容内。負の値なら不足分。正の値なら超過分。
   */
  public int stringLengthCheck(String input, int min, int max) {
    // 全角の場合の対処も考慮して、何バイト分の長さであるかを取得
    int length = input.getBytes().length;
    if (length < min) { // 最小文字数よりも少なかった場合
      return length - min;
    }
    if (length > max) { // 最大文字数よりも多かった場合
      return length - max;
    }
    return 0; // 許容内であった場合
  }

  /**
   * 文字列が半角英数のみで構成されているかをチェックする
   *
   * @param input
   *          チェック対象の文字列
   * @return チェック結果。半角英数のみなら true そうでなければ false
   */
  public boolean digitAlphabetCheck(String input) {
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if ((c < '0' || c > '9') && // 数字でない
          (c < 'a' || c > 'z') && // 小文字アルファベットでない
          (c < 'A' || c > 'Z') // 大文字アルファベットでない
      ) {
        return false;
      }
    }
    return true;
  }

  /**
   * 文字列の長さをチェックし範囲を超えていたらエラーメッセージを返す
   *
   * @param input
   *          チェック対象の文字列
   * @param min
   *          許容最小文字数
   * @param max
   *          許容最大文字数
   * @param paramName
   *          エラーメッセージ内に出力するパラメータ名
   * @return エラーメッセージ。エラーが無ければ空の文字列
   */
  public String getLengthError(String input,
      int min, int max, String paramName) {
    String message = "";
    int checkResult = stringLengthCheck(input, min, max);
    if (checkResult < 0) {
      message = "<li>[" + paramName +
          "] が短すぎます" +
          "(" + min + "～" + max + "文字)。<br>";
    } else if (checkResult > 0) {
      message = "<li>[" + paramName +
          "] が長すぎます" +
          "(" + min + "～" + max + "文字)。<br>";
    }
    return message;
  }

  /**
   * 文字列が半角英数のみで構成されているかをチェックし、
   * 半角英数以外の文字が使われていたらエラーメッセージを返す
   *
   * @param input
   *          チェック対象の文字列
   * @param paramName
   *          エラーメッセージ内に出力するパラメータ名
   * @return エラーメッセージ。エラーが無ければ空の文字列
   */
  public String getDigitAlphabetError(String input, String paramName) {
    String message = "";
    if (!digitAlphabetCheck(input)) {
      message = "<li>[" + paramName +
          "] に半角英数以外の文字は使用できません。<br>";
    }
    return message;
  }

  public String sexCheck(String paramSex) {
    String message = "";
    if (paramSex == null) {
      message = "<li>[性別]にチェックがありません。<br>";
    }
    return message;

  }

}
