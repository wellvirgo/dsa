package string;

public class CamelCaseConversion {
  public static void main(String[] args) {
    String str = "i am Dang The Hao";
    long start1 = System.nanoTime();
    System.out.println(camelCaseV1(str));
    long end1 = System.nanoTime();
    long elapsed1 = end1 - start1;

    long start2 = System.nanoTime();
    System.out.println(camelCaseV2(str));
    long end2 = System.nanoTime();
    long elapsed2 = end2 - start2;
    System.out.println("============");
    System.out.println("Elapsed time 1: " + (elapsed1 / 1000000) + "ms");
    System.out.println("Elapsed time 2: " + (elapsed2 / 1000000) + "ms");
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(n)
   * */
  static String camelCaseV1(String str) {
    String[] separated = str.split(" ");
    for (int i = 1; i < separated.length; i++) {
      String firstChar = separated[i].substring(0, 1);
      separated[i] = firstChar.toUpperCase() + separated[i].substring(1);
    }

    StringBuilder builder = new StringBuilder();
    for (String s : separated) {
      builder.append(s);
    }

    return builder.toString();
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static String camelCaseV2(String str) {
    StringBuilder res = new StringBuilder();
    boolean capitalizeNext = false;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') capitalizeNext = true;
      else if (capitalizeNext) {
        res.append(Character.toUpperCase(str.charAt(i)));
        capitalizeNext = false;
      } else res.append(str.charAt(i));
    }

    return res.toString();
  }
}
