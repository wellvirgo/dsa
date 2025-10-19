package common;

public class GCD {
  public static int gcd(int a, int b) {
    if (b > a) {
      int temp = a;
      a = b;
      b = temp;
    }

    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
