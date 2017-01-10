package vanenkoviliya.Tracker;

/**
 * @author ИЛЬЯ
 * @version 1
 * @since 11.12.2016
 */
public class StubInput implements Input {
    String answer[];
    int i=0;
    /** Конструктор присваивает массиву строк answer[] заданные значения.
     * @param answer массив строк.
     */
    public StubInput (String[] answer) {
        this.answer = answer;
    }
    /** Вывод строк, эмулирующих ввод пользователем.
     * @param question вопрос пользователю.
     * @return ответ пользователя.
     */
    public String ask(String question) {
        if (i < this.answer.length) {
        return answer[i++];
        }
        else return "6";
    }

    public int ask(String question, int[] range)  {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key && key != 0) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("*В меню нет такого пункта.");
        }
    }

}
