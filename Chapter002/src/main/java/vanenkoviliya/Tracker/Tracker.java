package vanenkoviliya.Tracker;

import java.util.Random;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.11.2016
 **/
public class Tracker {
    Application[] applications = new Application[100];

    /**
     * Добавление заявки,реданной из трекера.
     *
     * @param newapplication заявка для добавления.
     */
    void add(Application newapplication) {
        for (int i = 0; i < this.applications.length; i++) {
            if (this.applications[i] == null) {
                this.applications[i] = newapplication;
                break;
            }
        }

    }

    /**
     * Редактирования заявки. Передает заявку, сформированную в меню в трекер. Присваивает ей комментарии старой заявки. Записывает новую заявку на место старой.
     *
     * @param newApplication измененная заявка.
     */
    void edit(Application newApplication) {
        newApplication.comments = getdApplicationById(newApplication.id).comments;
        applications[getdById(newApplication.id)] = newApplication;
    }

    /**
     * Удаления заявки.
     *
     * @param id id заявки.
     */
    void delete(String id) {
        for (int i = 0; i < this.applications.length; i++) {
            if (applications[i] != null && applications[i].getId().equals(id)) {
                applications[i] = null;
            }
        }
    }

    /**
     * Поиск заявки по id.
     * @param id заявки.
     * @return номер в массиве заявки с заданным id.
     */
    int getdById(String id) {
        for (int i=0; i< applications.length; i++) {
            if (applications[i] != null && applications[i].id.equals(id)) return i;
        }
        return -1;
    }

    /**
     * Поиск заявки по id.
     *
     * @param id заявки.
     * @return заявка с заданным id.
     */
    Application getdApplicationById(String id) {
        for (Application application : this.applications) {
            if (application != null && application.getId().equals(id)) return application;
        }
        return null;
    }

    /**
     * Возвращает весь массив заявок.
     * @return массив заявок
     */
    Application[] getAllApplications() {
        Application[] getApplications = new Application[this.applications.length];
        int i = 0;
        for (Application application : this.applications) {
            getApplications[i] = application;
            i++;
        }
        return getApplications;
    }

    /**
     * Возвращает весь массив заявок по фильтру.
     * @param searchString строка для поиска в трекере.
     * @param pozition поле для поиска в трекере 1 - по имени, 2 -  по описанию.
     * @return массив заявок, удовлетворяющих параметрам поиска.
     */
    Application[] getApplicationsByFiltr(String searchString, String pozition) {
        Application[] getApplications = new Application[this.applications.length];
        int i = 0;
        if (pozition.equals("1")) {
            for (Application application : this.applications) {
                if (application != null && containsSubstring(application.name, searchString) == true)
                    getApplications[i] = application;
                i++;
            }
        }
        if (pozition.equals("2")) {
            for (Application application : this.applications) {
                if (application != null && containsSubstring(application.description, searchString) == true)
                    getApplications[i] = application;
                i++;
            }
        }
        return getApplications;
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


