package vanenkoviliya.arrayconnection;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 01.11.2016
 **/
public class Arrayconnection {
    /**
     * Метода соединяет два отсортированных массива в и сортирует полученный массив.
     * @param a массив для сортировки
     * @param b массив для сортировки
     * @return полученный в результатае сложения массив
     */

    public int[] sum (int[]a,int[]b) {

        int[]c=new int[a.length+b.length];
        int i=0,j=0,k=0;

        while (i<a.length && j<b.length) {
            if(a[i]<b[j]) {
                c[k]=a[i];
                i++;
                k++;
            }
            else if (a[i]==b[j]){
                c[k]=a[i];
                i++;
                j++;
                k++;
            }
            else {
                c[k]=b[j];
                j++;
                k++;
            }
        }

        if(i==a.length) {
            while (j<b.length) {
                c[k] = b[j];
                j++;
                k++;
            }
        }
        else if(j==b.length) {
            while (i<a.length) {
                c[k] = a[i];
                i++;
                k++;
            }
        }
        return c;
    }
}
