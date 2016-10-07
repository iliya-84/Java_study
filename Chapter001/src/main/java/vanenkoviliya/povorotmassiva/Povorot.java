package vanenkoviliya.povorotmassiva;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 06.10.2016
 **/
public class Povorot
{
    /**
     * Поворот массива на 90 градусов по часовой стрелке
     * @param array массив для поворота
     */
    void pov(int[][] array) {
        int[][] temp = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                temp[i][j] = array[array.length - j-1][i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = temp[i][j];
            }
        }
    }
}