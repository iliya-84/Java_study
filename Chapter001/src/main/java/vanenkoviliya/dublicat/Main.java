package vanenkoviliya.dublicat;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.10.2016
 **/
public class Main {
    public static void main(String[] args) {
        String[] values = {"aa","aa","bb","cc","cc","bb","dd","bb","bb","ee","bb","ee"};
        Dublicat dublicat = new Dublicat();
        dublicat.udalenie(values);

        for (int i = 0; i < values.length; i++) {
           System.out.print (values[i]+" ");
        }
    }
}
