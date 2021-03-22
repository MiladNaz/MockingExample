package calculator;


public class Calculator {

    public int add(String numbers) {

        int addingNumbers = 0;
        StringBuilder negativeNumbers = new StringBuilder();
        boolean containsNegativeNumbers = false;

        String[] arrayNumbers = numbers.split("[/\n;,]");

        for (String arrayNumber : arrayNumbers) {

            if (!arrayNumber.isEmpty() && Integer.parseInt(arrayNumber) <= 1000) {

                addingNumbers += Integer.parseInt(arrayNumber);

                if (Integer.parseInt(arrayNumber) < 0) {
                    containsNegativeNumbers = true;
                    negativeNumbers.append(" ").append(arrayNumber);

                }
            }
        }

        if (containsNegativeNumbers) {
            throw new IllegalArgumentException("negatives not allowed" + negativeNumbers);
        }
        return addingNumbers;

    }
}
