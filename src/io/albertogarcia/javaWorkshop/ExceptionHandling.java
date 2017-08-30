package io.albertogarcia.javaWorkshop;

public class ExceptionHandling {

    public void AddException() {
        int denominator = 0;
        int numerator = 1;

        try {
            System.out.println(numerator/denominator);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("We caught the exception.");
        }
    }
}
