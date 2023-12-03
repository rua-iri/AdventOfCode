import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.xml.transform.Templates;

import java.io.BufferedReader;

public class SupplyStacks {

    public static void main(String[] args) {

        try {
            File file = new File("./input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            boolean readInstructions = false;

            ArrayList<LinkedList<Character>> suppStacks = new ArrayList<>(9);
            for(int x=0; x<9; x++) {
                suppStacks.add(new LinkedList<Character>());
            }
            

            while (line != null) {

                if (readInstructions) {
                    suppStacks.toString();
                    processInstructions(line, suppStacks);
                    
                } else if(line.length()!=0 && line.charAt(1)!='1') {
                    drawLayout(line, suppStacks);
                }

                if (line.length() == 0) {
                    readInstructions = true;
                }

                line = br.readLine();
            }

            System.out.println("Part One Answer:");
            for(int i=0; i<suppStacks.size(); i++) {
                System.out.print(suppStacks.get(i).peek());
            }
            System.out.println();


            br.close();
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void processInstructions(String instructSet, ArrayList<LinkedList<Character>> queAra) {

        int moveQuantity, moveFrom, moveTo;
        char moveChar;

        LinkedList<Character> tempList = new LinkedList<Character>();


        String[] instructAra = instructSet.split(" ");
        moveQuantity = Integer.parseInt(instructAra[1]);
        moveFrom = Integer.parseInt(instructAra[3]) - 1;
        moveTo = Integer.parseInt(instructAra[5]) - 1;




        // move boxes for a given ammount of times (part one)
        // for (int i = 0; i < moveQuantity; i++) {
        //     moveChar = queAra.get(moveFrom).remove();
        //     queAra.get(moveTo).addFirst(moveChar);
        // }

        //add all elements in order to a new linkedlist then add them to the given linkedlist
        for(int i=0; i<moveQuantity; i++) {
            moveChar = queAra.get(moveFrom).remove();
            tempList.add(moveChar);
            System.out.println(moveChar);
        }

        for(int i=tempList.size(); i>0; i--) {
            queAra.get(moveTo).addFirst(tempList.removeLast());
        }

        System.out.println(tempList);

    }

    public static void drawLayout(String lne, ArrayList<LinkedList<Character>> queAra) {

        int queueCount = 0;
        LinkedList<Character> currentQue;
        char boxContents;


        //iterate through each element in the line and add to the respective queue
        for(int i=1; i<lne.length(); i+=4) {
            boxContents = lne.charAt(i);
            currentQue = queAra.get(queueCount);

            if(boxContents!=' ') {
                currentQue.add(boxContents);

                // remove old queue and add the new
                queAra.remove(queueCount);
                queAra.add(queueCount, currentQue);
            }

            queueCount++;
        }

    }


}