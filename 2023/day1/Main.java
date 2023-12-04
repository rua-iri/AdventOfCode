import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static final char[] numbersArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    public static HashMap<String, String> numbersMap = new HashMap<String, String>();

    public static void main(String[] args) {
        int totalCalibrationValue = 0;
        initialiseNumMap();

        File file = new File("input.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String ln = bufferedReader.readLine();

            while (ln != null) {
                System.out.println("Complete Line: " + ln);
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
            } else if (checkNumberMapMatch(line.substring(i), true)) {
                stringBuilder.append(getNumberMapMatch(line.substring(i), true));
                break;
            }
        }

        // append the final number that occurs
        for (int i = line.length() - 1; i >= 0; i--) {
            if (checkNumberMatch(line.charAt(i))) {
                stringBuilder.append(line.charAt(i));
                System.out.println("End Substring: " + line.substring(0, i));
                break;
            } else if (checkNumberMapMatch(line.substring(0, i+1), false)) {
                stringBuilder.append(getNumberMapMatch(line.substring(0, i+1), false));
                System.out.println("End Substring: " + line.substring(0, i+1));
                break;
            }
        }

        completeNumber = stringBuilder.toString();
        System.out.println("Complete Number: " + completeNumber + "\n");
        return Integer.parseInt(completeNumber);
    }

    public static boolean checkNumberMatch(char numChar) {
        for (char c : numbersArray) {

            if (numChar == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNumberMapMatch(String lineSubString, boolean isFirstNum) {

        for (String s : numbersMap.keySet()) {
            if (isFirstNum && lineSubString.startsWith(s)) {
                return true;
            } else if (!isFirstNum && lineSubString.endsWith(s)) {
                return true;
            }
        }

        return false;
    }

    public static String getNumberMapMatch(String lineSubString, boolean isFirstNum) {
        for (String s : numbersMap.keySet()) {
            if (isFirstNum && lineSubString.startsWith(s)) {
                return numbersMap.get(s);
            } else if (!isFirstNum && lineSubString.endsWith(s)) {
                return numbersMap.get(s);
            }
        }

        return "";
    }

    public static void initialiseNumMap() {
        numbersMap.put("one", "1");
        numbersMap.put("two", "2");
        numbersMap.put("three", "3");
        numbersMap.put("four", "4");
        numbersMap.put("five", "5");
        numbersMap.put("six", "6");
        numbersMap.put("seven", "7");
        numbersMap.put("eight", "8");
        numbersMap.put("nine", "9");
    }

}