package vanenkoviliya.sortirovkamassiva;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 05.10.2016
 **/
public class Sortirovka {
    /**
     * Сортировка мссива пузьрьковым методом от меньшего к большему
     * @param array массив для сортировки
     */
    void sort(int[] array) {
        int temporary;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > (array[j + 1])) {
                    temporary = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;
                }
            }
        }
    }
}
