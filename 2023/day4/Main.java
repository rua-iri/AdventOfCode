import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * main
 */
public class Main {

    public static void main(String[] args) {

        File file = new File("./input.txt");

        int winTotal = 0;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            String scratchcard;
            int scratchCardBinary;

            while (line != null) {

                scratchcard = line.split(": ")[1];
                scratchCardBinary = scratchcardParser(scratchcard);

                System.out.println(scratchCardBinary);

                // if (!scratchCardBinary.equals("")) {
                // winTotal += Integer.parseInt(scratchCardBinary, 2);
                // }
                winTotal += scratchCardBinary;

                line = bufferedReader.readLine();
            }

            System.out.println(winTotal);

            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static int scratchcardParser(String scratchcard) {

        int winCount = 0;
        String[] scratchCardArray = scratchcard.split("\\|");
        String[] winningNumbers = scratchCardArray[0].split(" ");
        String[] playerNumbers = scratchCardArray[1].split(" ");

        for (String winningNumber : winningNumbers) {
            for (String playerNumber : playerNumbers) {
                if (playerNumber.equals(winningNumber) && !playerNumber.equals("")) {
                    winCount = winCountIncrementer(winCount);
                    // System.out.println(playerNumber + " - " + winningNumber);
                }
            }
        }

        return winCount;
    }

    public static int winCountIncrementer(int winCount) {

        if (winCount == 0) {
            winCount = 1;
        } else {
            winCount = winCount * 2;
        }

        return winCount;
    }

}