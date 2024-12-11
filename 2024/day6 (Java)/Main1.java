import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main1 {

    public static void main(String[] args) {
        ArrayList<String> mapList = readFile();
        System.out.println(mapList);

        for (int i = 0; i < mapList.size(); i++) {
            System.err.println(mapList.get(i));

        }

    }

    public static ArrayList<String> readFile() {

        File inputFile = new File("input.txt");
        ArrayList<String> mapList = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String fileLine = bufferedReader.readLine();

            while (fileLine != null) {
                mapList.add(fileLine);
                fileLine = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        // System.out.println(mapList.get(0));

        return mapList;
    }
}