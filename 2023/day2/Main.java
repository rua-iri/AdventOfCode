import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    static final int redLimit = 12;
    static final int blueLimit = 14;
    static final int greenLimit = 13;
    static int redCount = 0;
    static int blueCount = 0;
    static int greenCount = 0;
    static int totalIDSum = 0;
    static int currentID;

    public static void main(String[] args) {

        File file = new File("./input.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {
                currentID = Integer.parseInt(line.split(": ")[0].substring(5));

                line = line.split(": ")[1];

                if (lineParser(line)) {
                    totalIDSum += currentID;
                }

                resetCounts();
                line = bufferedReader.readLine();
            }

            System.out.println("Total ID Sum: " + totalIDSum);

            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean lineParser(String line) {

        String[] subsegmentArray = line.split("; ");
        for (String subsegment : subsegmentArray) {
            subsegmentParser(subsegment);

            if (redCount > redLimit || blueCount > blueLimit || greenCount > greenLimit) {
                return false;
            }
            resetCounts();
        }
        System.out.println("Current Line: " + currentID);

        return true;
    }

    public static void subsegmentParser(String subsegment) {
        for (String colour : subsegment.split(", ")) {
            String[] colourData = colour.split(" ");
            switch (colourData[1]) {
                case "red":
                    redCount += Integer.parseInt(colourData[0]);
                    break;
                case "blue":
                    blueCount += Integer.parseInt(colourData[0]);
                    break;
                case "green":
                    greenCount += Integer.parseInt(colourData[0]);
                    break;
                default:
                    System.out.println("This shouldn't happen");
                    break;
            }
        }
    }

    public static void resetCounts() {
        redCount = 0;
        blueCount = 0;
        greenCount = 0;
    }

}
