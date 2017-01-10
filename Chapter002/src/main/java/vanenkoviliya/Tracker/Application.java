package vanenkoviliya.Tracker;

import java.util.Date;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.11.2016
 **/
public class Application {
    String id;
    String name;
    String description;
    Date date = new Date();
    Comment[] comments = new Comment[10];

    /**
     * Метод возвращает id заявки.
     * @return id заявке.
     */
    String getId() {
       return id;
    }
    /**
     * Метод присваивает id заявке.
     * @param id новый id заявки.
     */
     void setId(String id) {
        this.id=id;
    }
    /**
     * Метод добавляет комментарий к заявке заявке.
     * @param text текст комментария.
     */
    void addComment(String text) {
        for (int i = 0; i < comments.length; i++) {
            if (comments[i] == null) {
                comments[i] = new Comment();
                comments[i].text = text;
                break;
            }
        }
    }
    /**
     * Метод возвращает массив комментариев.
     * @return массив комментариев.
     */
    Comment[] getAllComments() {
        Comment[] getComments = new Comment[comments.length];
            int i=0;
        for(Comment comment : comments) {
            getComments[i]= comment;
            i++;
        }
        return getComments;
    }
    /**
     * Переопределяю метод toString().
     * @return поля заявки и комментарий.
     */
    @Override
    public String toString()
    {
        String appToString = "id:"+this.id+" Имя:"+this.name+" Описание:"+this.description+" Дата:"+this.date;
        for (Comment comment : getAllComments()) {
            if (comment != null) {
                appToString = appToString  + " Комментарий:"+comment.text;
            }
    }
        return appToString;
    }
    /**
     * Переопределяю метод equals().
     * @return поля заявки и комментарий.
     */
    @Override
    public boolean equals(Object obj) {
        Application other = (Application) obj;
        if (id == other.id && name == other.name && description == other.description)
            return true;
        return false;
    }
    /**
     * Переопределяю метод hashCode().
     * @return поля заявки и комментарий.
     */
    @Override
    public int hashCode() {
        int code = 11;
        int k = 7;
        code = k*code + id.hashCode();
        code = k*code + name.hashCode();
        code = k*code + description.hashCode();
        return code;
    }
}


