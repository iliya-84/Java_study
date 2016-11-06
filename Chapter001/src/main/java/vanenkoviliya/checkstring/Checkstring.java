package vanenkoviliya.checkstring;

/**
 * @author ИЛЬЯ
 * @version 1
 * @since  6.11.2016
 */
public class Checkstring {

    /**
     * Поиск подстроки в строке
     *
     * @param origin строка
     * @param sub подстрока
     * @return true если подстрока содержится в строке, false если не содержится
     */
    boolean contains(String origin, String sub) {
        boolean answer = false;
        char[] arrayorigin = origin.toCharArray();
        char[] arraysub = sub.toCharArray();
        for (int i = 0; i < arrayorigin.length; i++) {
            if (arrayorigin[i] == arraysub[0] && arraysub.length <= arrayorigin.length - i && answer == false) {
                int k = 1;
                answer = true;
                for (int j = 1; j < arraysub.length; j++) {
                    if (arrayorigin[i + k] == arraysub[j]) {
                        k = k + 1;
                        answer = true;
                    } else {
                        answer = false;
                    }
                }
            }
        }
        return answer;
    }
}










