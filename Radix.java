public class Radix{
  public static int nth(int n, int col) {
    if(col >= length(n)) {
      throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }
    if (col == 0) {
      return (n % 10);
    } else {
      int value = (n % Math.pow(10, (col + 1))) - (n % Math.pow(10, (col)));
      return value/(Math.pow(10, col));
    }
  }

  public static int length(int n) {
    return Math.ceil(Math.log10(n));
  }

  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets){
    for(int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }
}
