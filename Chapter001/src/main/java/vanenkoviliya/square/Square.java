package vanenkoviliya.square;

/**
 * @author vanenkov
 * @since 4.10.16.
 * @version 1
 * */
public class Square
{
    float a, b, c, x;
    /**
     *Присваивание переменным класса значения, переданные в конструктор.
     * @param a первый аргумент
     * @param b второй аргумент
     * @param c второй аргумент
     */
    Square(float a, float b, float c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     *Вычисление значения функции y.
     * @param x аргумент
     * @return результат
     */
    float calculate(float x) {
        return a*x*x + b * x + c;
    }
    /**
     *Вывод на экран значений функции y в заданном диапазоне с заданным шагом.
     * @param start аргумент начальное значение x
     * @param finish аргумент конечное значение x
     * @param step аргумент шаг x
     */
    void show(float start,float finish,float step) {
        for(x=start; x<=finish;x = x+step) {
            System.out.println(calculate(x));
        }
    }

}