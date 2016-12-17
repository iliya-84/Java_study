package vanenkoviliya.Tracker;

/**
 * @author ИЛЬЯ
 * @version 1
 * @since 16.12.2016
 */
public class Menu  {
    Input input = new ConsoleInput();
    Tracker tracker = new Tracker();
    /**
     * Конструктор. Присваивает полям класса введенных значений input и tracker.
     * @param input ввод данных.
     * @param tracker трекер с заявками.
     **/
    Menu (Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Запускает методы в зависимости от выбранного пользователем пункта меню.
     * @param userChoise строка, введенная пользователем.
     **/
    boolean choise (String userChoise) {
        boolean breakLoop;
        switch (userChoise) {
            case "1": add();
                breakLoop = false;
                break;
            case "2": edit();
                breakLoop = false;
                break;
            case "3": delete();
                breakLoop = false;
                break;
            case "4": getList(tracker);
                breakLoop = false;
                break;
            case "5":
                getListByFiltr(tracker);
                breakLoop = false;
                break;
            case "6":
                breakLoop = true;
                break;
            default: {
                System.out.println("Неверный ввод");
                breakLoop = false;
            }
        }
        return breakLoop;
    }
    /**
     * Соэдает новую заявку, присваивает значения полям, создает комментарий, передает заявку в трекер в медод add()..
     **/
    void add() {
        Application newapplication = new Application();
        newapplication.name = input.ask("*Ведите имя:");
        newapplication.description = input.ask("*Ведите описание:");
        String comment = input.ask("*Ведите комментарий:");
        if (comment.equals("") == false) {
            newapplication.addComment(comment);
        }
        tracker.add(newapplication);
    }
    /**
     * Запрашивает id заяыки для редактирования. Соэдает новую заявку, присваивает значения полям. Передает заявку и id в трекер в медод edit().
     **/
    void edit() {
        String id;
        String value;
        try {
            id = input.ask("*Выберите id заявки для редактирования:");
            printApplication(id, tracker);
            Application newApplication = new Application();
            value = input.ask("*Введите имя:");
            newApplication.name = value;
            value = input.ask("*Введите описание:");
            newApplication.description = value;
            tracker.edit(id,newApplication);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("*Заявка с данным id не существует");
        }
    }
    /**
     * Запрашивает id заяыки для удаления.Передает id в трекер в медод delete().
     **/
    void delete() {
        try {
            String deleteid = input.ask("*Выберите id заявки для удаления:");
            tracker.delete(deleteid);
            System.out.println("Заявка id" + deleteid + " удалена");
        } catch (NullPointerException e) {
            System.out.println("*Заявка с данным id не существует");
        }
    }

    /**
     * Вывод в консоль списка всех заявок.
     * @param tracker трекер с заявками.
     */
    void getList(Tracker tracker) {
        for (Application applications : tracker.getAllApplications()) {
            printApplication(applications.id, tracker);
        }
    }
    /**
     * Вывод в консоль списка заявок по фильтру. Поиск происходит по содержанию подстроки в строке.
     * @param tracker трекер с заявками.
     */
    void getListByFiltr(Tracker tracker)  {
        String read;
        read = input.ask("*Для вывода списка по имени нажмите 1\n*Для вывода списка по описанию 2");
        if (read.equals("1")) {
            String searchname;
            searchname = input.ask("*Введите имя для поиска");
            for (Application applications : tracker.getAllApplications()) {
                if (containsSubstring(applications.name, searchname) == true) printApplication(applications.id, tracker);;
            }
        }
        else if (read.equals("2")) {

            String searchdate;
            searchdate = input.ask("*Введите описание для поиска");
            for (Application applications : tracker.getAllApplications()) {
                if (containsSubstring(applications.description, searchdate)== true) printApplication(applications.id, tracker);;
            }
        }
        else System.out.println("*Неверный ввод");
    }
    /**
     * Вывод в консоль заявки по номеру.
     * @param id id заявки.
     * @param tracker трекер с заявками.
     */
    void printApplication(String id, Tracker tracker) {
        System.out.println("id:" + tracker.applications[tracker.getdById(id)].id + " Имя:" + tracker.applications[tracker.getdById(id)].name + " Дата создания: " + tracker.applications[tracker.getdById(id)].date + "  Описание: " + tracker.applications[tracker.getdById(id)].description);
        for (Comment comments : tracker.applications[tracker.getdById(id)].getAllComments()) {
            System.out.println("Комментарий " + ": " + comments.text);
        }
    }
    /**
     * Проверка содержания подстроки в строке.
     * @param origin строка.
     * @param sub подстрока.
     * @return true если одстрока в строке содержится, false если не содержится.
     */
    boolean containsSubstring(String origin, String sub) {
        boolean answer;
        if(origin.indexOf(sub) != -1) answer = true;
        else answer = false;
        return answer;
    }
}




