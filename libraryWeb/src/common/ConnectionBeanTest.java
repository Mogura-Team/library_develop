package common;

import junit.framework.TestCase;

import org.junit.Test;

public class ConnectionBeanTest extends TestCase {
  ConnectionBean cb = new ConnectionBean();

  ///testコミット
  @Test
  public void testGetDriver() {
    String driver = "com.mysql.jdbc.Driver";
    assertEquals("結果が相違してます。", driver, cb.getDriver());
  }

  @Test
  public void testGetName() {
    String name = "root";

    assertEquals("結果が相違してます。", name, cb.getName());
  }

  @Test
  public void testGetPass() {
    String pass = "pass";
    assertEquals("結果が相違してます。", pass, cb.getPass());
  }

  @Test
  public void testGetHost() {
    String host = "jdbc:mysql://localhost:3306/lib_db";
    assertEquals("結果が相違してます。", host, cb.getHost());
  }
}
