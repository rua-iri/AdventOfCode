import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.io.BufferedReader;


public class CampCleanup{

    public static void main(String[] args) {

        String[] elfPair;
        int overLapPairs = 0;


        try {
            File file = new File("./input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            //continue reading file as long as line is not empty
            while (line!=null) {

                elfPair = line.split(",");

                // convert the values for each elf into an integer array
                int[] elfpointsOne = Arrays.stream(elfPair[0].split("-")).mapToInt(Integer::parseInt).toArray();
                int[] elfpointsTwo = Arrays.stream(elfPair[1].split("-")).mapToInt(Integer::parseInt).toArray();

                //check if either elf overlaps the other completely
                if(elfpointsOne[0]>=elfpointsTwo[0] && elfpointsOne[1]<=elfpointsTwo[1]) {
                    overLapPairs++;
                    System.out.println(Arrays.toString(elfpointsOne) + " - " + Arrays.toString(elfpointsTwo));
                } else if(elfpointsTwo[0]>=elfpointsOne[0] && elfpointsTwo[1]<=elfpointsOne[1]) {
                    overLapPairs++;
                    System.out.println(Arrays.toString(elfpointsOne) + " - " + Arrays.toString(elfpointsTwo));
                }

                //read new line of the input.txt
                line = br.readLine();

            }

            System.out.println("Part One Solution:");
            System.out.println(overLapPairs);





            


            br.close();
            fr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}