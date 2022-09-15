package utils;

import java.util.Properties;

public class TestDataLoader {
  private static Properties testData = new Properties();

  static {
    try {
      testData.load(TestDataLoader.class.getResourceAsStream("/testdata.properties"));
    } catch (Exception e) {
      System.out.println("Error while reading testdata.properties");
    }
  }

  public static String getProperty(String property) {
    return testData.getProperty(property);
  }
}
