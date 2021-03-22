package calculator;

public class Calculator {

    public int add(String numbers) {

        if (numbers.equals("")) {
            return 0;
        }

        String[] arrayNumbers;
        int addingNumbers = 0;

        arrayNumbers = numbers.split(",");
        for (String arrayNumber : arrayNumbers) {
            addingNumbers += Integer.parseInt(arrayNumber);
        }

        return addingNumbers;

    }
}
