public class Radix{
  public static int nth(int n, int col) {
    if (col == 0) {
      return (n % 10);
    } else {
      int value = (n % Math.pow(10, (col + 1))) - (n % Math.pow(10, (col)));
      return value/(Math.pow(10, col));
    }
  }
}
