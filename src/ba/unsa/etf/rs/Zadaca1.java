package ba.unsa.etf.rs;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Zadaca1 {

    public static String najveciGrad(String input_values) {
        int i = 0;
        String cityMax = null, countryMax = null;
        String cityInput = null, countryInput = null;
        int peopleMax = 0, peopleInput = 0;
        for (String line: input_values.split("\n")) {
            i = 0;
            inner: for (String word: line.split(",")) {
                switch (i) {
                    case 0: {
                        //trim odsjece blanko znake na pocetku i kraju stringa
                        cityInput = word.trim();
                        i++;
                        break;
                    }
                    case 1: {
                        countryInput = word.trim();
                        i++;
                        break;
                    }
                    case 2: {
                        //replaceAll radi isto sto i trim
                        word = word.replaceAll("\\s+","");
                        peopleInput = Integer.parseInt(word);
                        i++;
                        break;
                    }
                    default: {
                        break inner;
                    }
                }
            }
            if (peopleInput > peopleMax) {
                peopleMax = peopleInput;
                cityMax = cityInput;
                countryMax = countryInput;
            }
        }
        System.out.println(cityMax);
        return countryMax;
    }


    public static long najvecaSuma(int...numbers) {
        long maxValue = Long.MIN_VALUE;
        int actualValue = 0;
        for (int number: numbers) {
            long temp = Math.abs( (long)number );
            long sum = 0;
            while (temp != 0) {
                sum = sum + (temp % 10);
                temp = temp / 10;
            }
            if (sum > maxValue) {
                maxValue = sum;
                actualValue = number;
            }
        }
        return actualValue;
    }


    public static double[] najmanjaSrednjaVrijednost(double[][] matrix) {
        double averageValue = Double.MAX_VALUE;
        double sum = 0;
        double[] largestAvgRow = {};
        for (double[] row: matrix) {
            sum = 0;
            for (double number: row) {
                sum = sum + number;
            }
            double tempAvg = sum / row.length;
            if (tempAvg < averageValue) {
                averageValue = tempAvg;
                largestAvgRow = row;
            }
        }
    return largestAvgRow;

    }


    public static void main(String[] args) {
        System.out.print("Unesite string sa gradovima (prazan red za kraj): ");
        Scanner input = new Scanner(System.in);
        String input_values = "";
        String line;
        while ( !(line = input.nextLine()).equals("") ) {
            input_values += line;
            input_values += '\n';
        }
        String cityMax = najveciGrad(input_values);
        System.out.println(cityMax);



        System.out.print("Unesite članove niza cijelih brojeva (0 za kraj): ");
        //Vector numbers = new Vector();
        int[] numbers = new int[10000];
        int i = 0;
        int temp = input.nextInt();
        while (temp != 0) {
            numbers[i] = temp;
            temp = input.nextInt();
            i++;
        }
        System.out.print("Broj sa najvećom sumom cifara je: " + najvecaSuma(numbers) + "\n");


        
        //Vector<Vector<Integer>> matrix = new Vector<Vector<Integer>>();
        System.out.print("Unesite broj redova matrice: ");
        int rows = input.nextInt();
        //Vector[][] matrix = new Vector[rows][];
        double matrix[][] = new double[rows][];
        i = 0;
        while (i < rows) {
            System.out.print("Unesite broj elemenata u " + (i+1) + ". redu: ");
            int columns = input.nextInt();
            int j = 0;
            matrix[i] = new double[columns];
            System.out.print("Unesite elemente: ");
            while (j < columns) {
                matrix[i][j] = input.nextDouble();
                j++;
            }
            i++;
        }
        DecimalFormat format = new DecimalFormat("############.############");
        System.out.print("Red sa najmanjom srednjom vrijednošću glasi:\n");
        double[] row = najmanjaSrednjaVrijednost(matrix);
        i = 0;
        int n = row.length;
        for (double number: row) {
            if (i == n-1) {
                System.out.print(format.format(number));
            } else {
                System.out.print(format.format(number) + " ");
            }
            i++;
        }
    }
}
