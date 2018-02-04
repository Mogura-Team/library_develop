package common;

/**
 * @作成日 2018/02/04
 * @ファイル名 ConnectionBean.java
 * @description DBアクセスのパラメータを定義するクラス.
 *
 */
public class ConnectionBean {
  private String driver = "com.mysql.jdbc.Driver";
  private String host = "jdbc:mysql://localhost:3306/lib_db";// ?autoReconnect=true&useSSL=false
  private String name = "root";
  private String pass = "pass";

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

}
