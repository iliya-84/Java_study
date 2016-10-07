package vanenkoviliya.dublicat;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 06.10.2016
 **/
public class Dublicat {
    /**
     * Удаление дубликатов из массива
     * @param array массив для обработки
     */
    void udalenie(String[] array) {
        String[] temp = new String[10];
        int k=0;
        for (int i = 0; i < array.length-1; i++) {
           for (int j = i+1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = "";
                }
            }
        }


    }
}