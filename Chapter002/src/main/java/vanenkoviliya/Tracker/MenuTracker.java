package vanenkoviliya.Tracker;

/**
 * @author ИЛЬЯ
 * @version 1
 * @since 16.12.2016
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int[] keys = new int[this.actions.length];

    /**
     * Конструктор. Присваивает полям класса введенных значений input и tracker.
     * @param input ввод данных.
     * @param tracker трекер с заявками.
     **/
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Заполнение массива действий.
     */
    public void fillActions() {
        this.actions[1] = this.new AddApplication();
        this.actions[2] = this.new EditApplication();
        this.actions[3] = this.new DeleteApplication();
        this.actions[4] = new MenuTracker.GetList();
        this.actions[5] = this.new GetListByFiltr();
        this.actions[6] = new MenuTracker.Out();
    }

    /**
     * Вывод в консоль меню.
     */
    public void showMenu() {
        System.out.println ();
        System.out.println (String.format("МЕНЮ:"));
        for (UserAction action : actions) {
            if(action != null) {
                System.out.println(action.info());
            }
        }
    }
    /**
     * Запуск выбранного действия меню.
     * @param key - номер действия.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * Создает новую заявку, присваивает значения полям, создает комментарий, передает заявку в трекер в медод add().
     */
    private class AddApplication implements UserAction {
        /**
         * Ключ действия.
         * @return ключ.
         */
        @Override
        public int key() {
            return 1;
        }
        /**
         * Действие, выбранное пользователем.
         * @param input ввод данных.
         * @param tracker трекер с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Application newapplication = new Application();
            newapplication.name = input.ask("*Ведите имя:");
            newapplication.description = input.ask("*Ведите описание:");
            String comment = input.ask("*Ведите комментарий:");
            if (comment.equals("") == false) {
                newapplication.addComment(comment);
            }
            tracker.add(newapplication);
            System.out.println("*Заявка добавлена.");
        }
        /**
         * Сообщает, что делает данный метод
         * @return описание метода.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавление новой заявки.");
        }
    }

    /**
     * Редактирование заявки. Моздает новую заявку и передает в трекер в медод edit() для замены.
     **/
    private class EditApplication implements UserAction {
        /**
         * Ключ действия.
         * @return ключ.
         */
        @Override
        public int key() {
            return 2;
        }
        /**
         * Действие, выбранное пользователем.
         * @param input ввод данных.
         * @param tracker трекер с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("*Выберите id заявки для редактирования:");
            System.out.println(tracker.getdApplicationById(id).toString());
            Application newApplication = new Application();
            newApplication.id = id;
            newApplication.name = input.ask("*Введите новое имя:");
            newApplication.description = input.ask("*Введите новое описание:");
            tracker.edit(newApplication);
            System.out.println("*Заявка id" + id + " изменена.");

        }
        /**
         * Сообщает, что делает данный метод
         * @return описание метода.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Редактирование заявки.");
        }
    }
     /**
     * Запрашивает id заяыки для удаления.Передает id в трекер в медод delete().
     **/
    private class DeleteApplication implements UserAction {
        /**
         * Ключ действия.
         * @return ключ.
         */
        @Override
        public int key() {
            return 3;
        }
        /**
         * Действие, выбранное пользователем.
         * @param input ввод данных.
         * @param tracker трекер с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            try {
                String deleteid = input.ask("*Выберите id заявки для удаления:");
                tracker.delete(deleteid);
                System.out.println("*Заявка id" + deleteid + " удалена.");
            } catch (NullPointerException e) {
                System.out.println("*Заявка с данным id не существует.");
            }
        }
        /**
         * Сообщает, что делает данный метод
         * @return описание метода.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удаление заявки.");
        }
    }

    /**
     * Вывод в консоль списка заявок.
     **/
    private static class GetList implements UserAction {
        /**
         * Ключ действия.
         * @return ключ.
         */
        @Override
        public int key() {
            return 4;
        }
        /**
         * Действие, выбранное пользователем.
         * @param input ввод данных.
         * @param tracker трекер с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Application applications : tracker.getAllApplications()) {
                System.out.println(applications.toString());
            }

        }
        /**
         * Сообщает, что делает данный метод
         * @return описание метода.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Вывод списка заявок.");
        }
    }
     /**
     * Вывод в консоль списка заявок по фильтру. Поиск происходит по содержанию подстроки в строке.
     */
    private class GetListByFiltr implements UserAction {
        /**
         * Ключ действия.
         * @return ключ.
         */
        @Override
        public int key() {
            return 5;
        }
        /**
         * Действие, выбранное пользователем.
         * @param input ввод данных.
         * @param tracker трекер с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String read = input.ask("*Для вывода списка по имени нажмите 1\n*Для вывода списка по описанию 2");
            if (read.equals("1")) {
                String searchname;
                searchname = input.ask("*Введите имя для поиска");
                for (Application applications : tracker.getAllApplications()) {
                    if (containsSubstring(applications.name, searchname) == true)
                        System.out.println(applications.toString());
                }
            }
            else if (read.equals("2")) {

                String searchdate;
                searchdate = input.ask("*Введите описание для поиска");
                for (Application applications : tracker.getAllApplications()) {
                    if (containsSubstring(applications.description, searchdate)== true)
                        System.out.println(applications.toString());
                }
            }
            else System.out.println("*Неверный ввод");
            }

        /**
         * Сообщает, что делает данный метод
         * @return описание метода.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Вывод списка заявок по фильтру.");
        }
    }
    /**
     * Выход из программы.
     */
    private static class Out implements UserAction {
        /**
         * Ключ действия.
         * @return ключ.
         */
        @Override
        public int key() {
            return 6;
        }
        /**
         * Действие, выбранное пользователем.
         * @param input ввод данных.
         * @param tracker трекер с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            StartUi.breakLoop = true;
        }

        /**
         * Сообщает, что делает данный метод
         * @return описание метода.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Выход.");
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




