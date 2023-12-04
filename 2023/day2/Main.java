import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    static final int redLimit = 12;
    static final int greenLimit = 13;
    static final int blueLimit = 14;
    static int redCount = 0;
    static int greenCount = 0;
    static int blueCount = 0;
    static int totalIDSum = 0;
    static int currentID;

    public static void main(String[] args) {

        int powerCount = 0;

        File file = new File("./input.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {
                currentID = Integer.parseInt(line.split(": ")[0].substring(5));

                line = line.split(": ")[1];

                // for solution to part one
                // if (lineParser(line)) {
                // totalIDSum += currentID;
                // }
                powerCount += linePowerParser(line);

                resetCounts();
                line = bufferedReader.readLine();
            }

            // System.out.println("Total ID Sum: " + totalIDSum);
            System.out.println(powerCount);

            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for part two
    public static int linePowerParser(String line) {

        String[] subsegmentArray = line.split("; ");
        for (String subsegment : subsegmentArray) {
            subsegmentPowerParser(subsegment);
        }

        System.out.println(line);

        System.out.println("RedCount: " + redCount);
        System.out.println("greenCount: " + greenCount);
        System.out.println("blueCount: " + blueCount);
        System.out.println("redCount * greenCount * blueCount = " + redCount * greenCount * blueCount + "\n");

        return redCount * greenCount * blueCount;
    }

    public static void subsegmentPowerParser(String subsegment) {
        for (String colour : subsegment.split(", ")) {
            String[] colourData = colour.split(" ");
            switch (colourData[1]) {
                case "red":
                    if (Integer.parseInt(colourData[0]) > redCount) {
                        redCount = Integer.parseInt(colourData[0]);
                    }
                    break;
                case "blue":
                    if (Integer.parseInt(colourData[0]) > blueCount) {
                        blueCount = Integer.parseInt(colourData[0]);
                    }
                    break;
                case "green":
                    if (Integer.parseInt(colourData[0]) > greenCount) {
                        greenCount = Integer.parseInt(colourData[0]);
                    }

                    break;
                default:
                    System.out.println("This shouldn't happen");
                    break;
            }
        }
    }

    // Method for part one
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

    // Method for part one
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
