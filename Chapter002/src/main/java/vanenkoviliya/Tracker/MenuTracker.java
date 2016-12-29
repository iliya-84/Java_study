package vanenkoviliya.Tracker;

import java.util.Random;

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
     * Возвращает массив ключей, которые допустимы для ввода в меню.
     * @return - массив ключей.
     */
    public int[] getKeys() {
        for (int i = 0; i < this.actions.length; i++) {
            if (actions[i] != null) {
                keys[i] = this.actions[i].key();
            }
        }
        return this.keys;
    }


    /**
     * Запуск выбранного действия меню.
     * @param key - номер действия.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * Создает новую заявку, присваивает значения полям, создает комментарий. Заявке случайным образом присваиваится id. Также происходит проверка на совпадение с уже существующими id. Передает заявку в трекер в медод add().
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
            Random random = new Random();
            boolean repeatId = false;
            String randomId = "0";
            Application newapplication = new Application();

            while (repeatId == false) {
                repeatId = true;
                randomId = Integer.toString(random.nextInt(1000));
                for (Application applications : tracker.getAllApplications()) {
                    if (applications != null && randomId == applications.id) repeatId = false;
                }
            }
            newapplication.id = randomId;
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
     * Редактирование заявки. Создает новую заявку и передает в трекер в медод edit() для замены.
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
            if(tracker.getdApplicationById(id)!= null) {
                Application newApplication = new Application();
                newApplication.id = id;
                newApplication.name = input.ask("*Введите новое имя:");
                newApplication.description = input.ask("*Введите новое описание:");
                tracker.edit(newApplication);
                System.out.println("*Заявка id" + id + " изменена.");
            } else  System.out.println("*Заявки с данны id не существует.");
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

                String deleteid = input.ask("*Выберите id заявки для удаления:");
                if(tracker.getdApplicationById(deleteid)!= null) {
                tracker.delete(deleteid);
                System.out.println("*Заявка id" + deleteid + " удалена.");
                } else  System.out.println("*Заявки с данны id не существует.");
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
            int quantityFind = 0;
            for (Application applications : tracker.getAllApplications()) {
                if(applications != null) {
                    System.out.println(applications.toString());
                    quantityFind++;
                }
            }
            if (quantityFind == 0)
                System.out.println("*Нет заявок.");
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
            String pozition = input.ask("*Для вывода списка по имени нажмите 1\n*Для вывода списка по описанию 2:");
            String searchString = null;
            int quantityFind = 0;
            if (pozition.equals("1")) {
                searchString = input.ask("*Введите имя для поиска:");
            } else if (pozition.equals("2")) {
                searchString = input.ask("*Введите описание для поиска:");
            } else System.out.println("*Неверный ввод");
            for (Application application : tracker.getApplicationsByFiltr(searchString, pozition)) {
                if (application != null) {
                    System.out.println(application.toString());
                    quantityFind++;
                }
            }
            if (quantityFind == 0 && (pozition.equals("1") || pozition.equals("2")))
                System.out.println("*Нет заявок по вашему запросу.");

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





}




