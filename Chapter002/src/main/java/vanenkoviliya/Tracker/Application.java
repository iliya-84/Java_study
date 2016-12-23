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
    int quantityOfComments = 0;
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
        comments[quantityOfComments]= new Comment();
        comments[quantityOfComments].text = text;
        comments[quantityOfComments].number = quantityOfComments+1;
        quantityOfComments++;
    }
    /**
     * Метод возвращает массив комментариев.
     * @return массив комментариев.
     */
    Comment[] getAllComments() {
        Comment[] getComments = new Comment[quantityOfComments];
        for(int i =0; i<quantityOfComments;i++)
        getComments[i]= comments[i];
        return getComments;
    }
    /**
     * Переопределяю метод toString().
     * @return поля заявки и комментарий.
     */
    @Override
    public String toString()
    {
        String appToString;
       appToString = "id:"+this.id+" Имя:"+this.name+" Описание:"+this.description+" Дата:"+this.date+" Комментарий:";
        for (Comment comments : getAllComments()) {
            appToString = appToString + comments.text;
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


