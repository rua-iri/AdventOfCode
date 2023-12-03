import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;


public class CampCleanup{

    public static void main(String[] args) {

        String[] elfPair;
        int completeOverLapPairs = 0;
        int partialOverlapPairs = 0;


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
                    completeOverLapPairs++;
                } else if(elfpointsTwo[0]>=elfpointsOne[0] && elfpointsTwo[1]<=elfpointsOne[1]) {
                    completeOverLapPairs++;
                }


                //create a new arraylist for one of the elves and check if they have any of the same values
                ArrayList<Integer> elfRangeOne = new ArrayList<Integer>();
                for(int i=elfpointsOne[0]; i<=elfpointsOne[1]; i++) {
                    elfRangeOne.add(i);
                }

                for(int i=elfpointsTwo[0]; i<=elfpointsTwo[1]; i++) {
                    if(elfRangeOne.contains(i)) {
                        partialOverlapPairs++;
                        break;
                    }
                }


                //read new line of the input.txt
                line = br.readLine();

            }

            System.out.println("Part One Solution:");
            System.out.println(completeOverLapPairs);

            System.out.println("Part Two Solution:");
            System.out.println(partialOverlapPairs);

          


            br.close();
            fr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}