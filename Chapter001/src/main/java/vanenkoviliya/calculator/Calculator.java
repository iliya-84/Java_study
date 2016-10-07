package vanenkoviliya.calculator;

/**
 * @author vanenkov
 * @since 1.10.16.
 * @version 1
 * */
public class Calculator{
    double result;

    /**
     *Сложение.
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void add (double first, double second) {
        this.result=first+second;
    }

    /**
     *Вычитание.
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void substract (double first, double second) {
        this.result=first-second;
    }

    /**
     *Деление.
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void div (double first, double second) {
        if (second != 0d) {
            this.result = first / second;
        } else {
            throw new ArithmeticException("Could not div by zero");
        }
    }

    /**
     *Умножение.
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void multiple (double first, double second) {
        this.result=first*second;
    }
}
