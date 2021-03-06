import java.util.*;
public class Radix{
  public static int nth(int n, int col) {
    return ((n/(int)(Math.pow(10, col))) % 10);
  }

  public static int length(int n) {
    return (int)(Math.ceil(Math.log10(n)));
  }

  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets){
    for(int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[]buckets = new SortableLinkedList[10];
    for(int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }
    int max = maxDigits(data);
    for(int i = 0; i < max; i++) {
      while(data.size() > 0) {
        int x = data.remove(0);
        buckets[nth(x , i)].add(x);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList pos = new SortableLinkedList();
    SortableLinkedList neg = new SortableLinkedList();
    int size = data.size();
    for (int i = 0; i < size; i++) {
      int x = data.remove(i);
      if(x >= 0) {
        pos.add(x);
      } else {
        neg.add(x);
      }
    }
    radixSortSimple(pos);
    radixSortSimple(neg);
    data.extend(pos);
    while(neg.size() > 0) {
      int a = neg.remove(0);
      data.add(0, a);
    }
  }

  private static int maxDigits(SortableLinkedList data) {
    int digits = 0;
    for(int i = 0; i < data.size(); i++) {
      int x = data.remove(0);
      if (length(x) > digits) {
        digits = length(x);
      }
      data.add(x);
    }
    return digits;
  }
}
