package ru.mikheev.kirill.jlessons.march05.lesson.complex;


public class ComplexNumber implements Number {

    private final double re, im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    /**
     * Метод прибавляет к текущему числу другое
     *
     * @param anotherNumber - Первое слагаемое
     * @return результат сложения
     */
    @Override
    public Number add(Number anotherNumber) {
        if(anotherNumber instanceof ComplexNumber) {
            return add((ComplexNumber) anotherNumber);
        }
        return new ComplexNumber(re + anotherNumber.getNumberModulo(), im);
    }

    public ComplexNumber add(ComplexNumber anotherNumber) {
        return new ComplexNumber(
                re + anotherNumber.re,
                im + anotherNumber.im
        );
    }

    /**
     * Метод вычитает из текущего числа другое
     *
     * @param anotherNumber - Вычитаемое
     * @return результат вычитания
     */
    @Override
    public Number sub(Number anotherNumber) {
        if(anotherNumber instanceof ComplexNumber) {
            return sub((ComplexNumber) anotherNumber);
        }
        return new ComplexNumber(re - anotherNumber.getNumberModulo(), im);
    }

    public ComplexNumber sub(ComplexNumber anotherNumber) {
        return new ComplexNumber(
                re - anotherNumber.re,
                im - anotherNumber.im
        );
    }

    @Override
    public Number multiply(Number anotherNumber) {
        return null;
    }

    @Override
    public Number div(Number anotherNumber) {
        return null;
    }

    @Override
    public double getNumberModulo() {
        return Math.sqrt(re*re + im*im);
    }



    private ComplexNumber conjugate(ComplexNumber complexNumber) {
        return new ComplexNumber(complexNumber.re, -1 * complexNumber.im);
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }

}
