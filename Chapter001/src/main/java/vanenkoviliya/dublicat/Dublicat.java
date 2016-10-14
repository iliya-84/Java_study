package vanenkoviliya.dublicat;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 06.10.2016
 **/
public class Dublicat {
    /**
     * Удаление дубликатов из массива
     *
     * @param array массив для обработки
     */
    void deldubl(String[] array) {
        String temporary;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] != null && array[i].equals(array[j])) {
                    for (int k = j; k < array.length - 1; k++) {
                        array[k] = array[k + 1];
                    }
                    array[array.length - 1] = null;
                    j=j-1;
                }
            }
        }
    }
}