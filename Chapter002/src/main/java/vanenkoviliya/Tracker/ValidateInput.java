package vanenkoviliya.Tracker;

/**
 * @author ИЛЬЯ
 * @version 1
 * @since 26.12.2016
 */
public class ValidateInput extends ConsoleInput {

    /**
     /** Ввод строки из консоли с учетом перечня допустимых ключей.
     * @param question вопрос пользователю.
     * @param range массив допустимых ключей.
     * @return ответ пользователя при совпадении ответа с допустимыми ключами. Возвращает -1, если ответ не совпадает с допустимыми ключами.
     * */
<<<<<<< 495343dd80f4930fe6f7d2ed7685ee4b42069531
=======
    @Override
>>>>>>> 5578114f9fe906bc2b8c192d9d1b8b20977a1c8d
    public int ask(String question, int[] range) {
       boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch(MenuOutException moe) {
              System.out.println("*В меню нет такого пункта.");
            } catch(NumberFormatException nfe) {
                System.out.println("*Неверный символ.");
            }
        } while (invalid);
        return  value;
    }
}
