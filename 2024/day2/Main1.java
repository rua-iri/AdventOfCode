/*
1. read file input
2. iterate over each line
3. compare each element to the next element
4. if the level increases or decreases by an unsafe amount
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main1 {

    public static void main(String[] args) {
        int safeReportCount = 0;
        ArrayList<String> reportList = readFile();

        for (int i = 0; i < reportList.size(); i++) {
            safeReportCount += evaluateReport(reportList.get(i));
            // System.out.println(reportList.get(i) + ": " +
            // evaluateReport(reportList.get(i)));
        }

        System.out.println(safeReportCount);

    }

    public static int evaluateReport(String reportLine) {

        String[] levelsArray = reportLine.split(" ");
        boolean isLevelsIncreasing = true;

        for (int i = 0; i < levelsArray.length - 1; i++) {
            int levelsDifference = Integer.parseInt(levelsArray[i]) - Integer.parseInt(levelsArray[i + 1]);

            if (i == 0) {
                isLevelsIncreasing = levelsDifference > 0;
            }

            int absoluteLevelsDifference = Math.abs(levelsDifference);
            if (absoluteLevelsDifference < 1
                    || absoluteLevelsDifference > 3
                    || isLevelsIncreasing != levelsDifference > 0) {
                return 0;
            }
        }

        return 1;
    }

    public static ArrayList<String> readFile() {

        File inputFile = new File("input.txt");
        ArrayList<String> reportList = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String fileLine = bufferedReader.readLine();

            while (fileLine != null) {
                reportList.add(fileLine);
                fileLine = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        System.out.println(reportList.get(0));

        return reportList;
    }

}