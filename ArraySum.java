/*
 * Ian Green
 * Professor Kuijt
 * 2/20/2025
 * CMSC 204 CRNN 202530
 */
public class ArraySum {
    public int sumOfArray(Integer[] a, int index) {
       if (index == 0) 
    	   return a[index];
       else
    	   return a[index] + sumOfArray(a, index - 1);
    }
}
