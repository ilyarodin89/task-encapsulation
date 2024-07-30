package ru.stepup;

public class MainApp {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 5);
        Fraction f3 = new Fraction(7, 8);
        Fraction result = f1.sum(f2).sum(f3).minus(5);
        System.out.println(result);
    }
}

class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator <= 0)
            throw new IllegalArgumentException("Числитель дроби должен быть положительным целым числом");
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction sum(Fraction fraction) {
        if (this.denominator == fraction.denominator) {
            return new Fraction(this.numerator + fraction.numerator, this.denominator);
        } else {
            int newDenominator = this.denominator * fraction.denominator;
            return new Fraction((this.numerator * (newDenominator / this.denominator))
                    + (fraction.numerator * (newDenominator / fraction.denominator)), newDenominator);
        }
    }

    public Fraction sum(int number) {
        return new Fraction(this.numerator + (number * this.denominator), this.denominator);
    }

    public Fraction minus(Fraction fraction) {
        if (this.denominator == fraction.denominator) {
            return new Fraction(this.numerator - fraction.numerator, this.denominator);
        } else {
            int newDenominator = this.denominator * fraction.denominator;
            return new Fraction((this.numerator * (newDenominator / this.denominator))
                    - (fraction.numerator * (newDenominator / fraction.denominator)), newDenominator);
        }
    }

    public Fraction minus(int number) {
        return new Fraction(this.numerator - (number * this.denominator), this.denominator);
    }
}
