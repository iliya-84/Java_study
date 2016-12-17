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
     * @return массив комментариев
     */
    Comment[] getAllComments() {
        Comment[] getComments = new Comment[quantityOfComments];
        for(int i =0; i<quantityOfComments;i++)
        getComments[i]= comments[i];
        return getComments;
    }
}


