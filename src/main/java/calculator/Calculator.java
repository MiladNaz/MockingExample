package calculator;


public class Calculator {

    public int add(String numbers) {

        int addingNumbers = 0;

        String[] arrayNumbers = numbers.split("[/\n;,]");
        for (String arrayNumber : arrayNumbers) {
            if (!arrayNumber.isEmpty()) {
                addingNumbers += Integer.parseInt(arrayNumber);
            }
        }

        return addingNumbers;

    }
}
