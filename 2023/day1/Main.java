import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static final char[] numbersArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static void main(String[] args) {
        int totalCalibrationValue = 0;

        File file = new File("input.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String ln = bufferedReader.readLine();

            while (ln != null) {
                System.out.println(ln);
                totalCalibrationValue += numbersParser(ln);
                ln = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

            System.out.println(totalCalibrationValue);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int numbersParser(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        String completeNumber = "";

        // append the first number that occurs
        for (int i = 0; i < line.length(); i++) {
            if (checkNumberMatch(line.charAt(i))) {
                stringBuilder.append(line.charAt(i));
                break;
            }
        }

        // append the final number that occurs
        for (int i = line.length() - 1; i >= 0; i--) {
            if (checkNumberMatch(line.charAt(i))) {
                stringBuilder.append(line.charAt(i));
                break;
            }
        }

        completeNumber = stringBuilder.toString();
        System.out.println(completeNumber);
        return Integer.parseInt(completeNumber);
    }

    public static boolean checkNumberMatch(char numChar) {
        for (char c : numbersArray) {
            
            if(numChar==c) {
                return true;
            }
        }
        return false;
    }

}