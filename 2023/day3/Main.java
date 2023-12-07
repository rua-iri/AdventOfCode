import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> linesList = new ArrayList<String>();

        File file = new File("./input.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                linesList.add(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

            for (int i = 0; i < linesList.size(); i++) {

                if (i == 0) {
                    
                } else if (i == linesList.size() - 1) {

                } else {

                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
