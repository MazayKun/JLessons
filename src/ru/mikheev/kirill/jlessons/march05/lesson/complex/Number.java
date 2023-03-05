package ru.mikheev.kirill.jlessons.march05.lesson.complex;


/**
 *
 *
 * @version 1.0.0
 * @author Kirill Mikheev
 * {@link RealNumber#someMethod() }
 */
public interface Number {

    /**

     * @param anotherNumber
     * @return
     */
    Number add(Number anotherNumber);

    /**
     * @param anotherNumber
     * @return
     * @throws
     */
    Number sub(Number anotherNumber);


    Number multiply(Number anotherNumber);


    Number div(Number anotherNumber);

    double getNumberModulo();
}
