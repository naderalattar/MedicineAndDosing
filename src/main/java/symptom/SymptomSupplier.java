package symptom;

import java.io.*;
import java.util.Scanner;

public class SymptomSupplier {
    public static void main(String[] args) {

        File symptomFile=new File("D:\\my career\\testing\\medicine\\src\\main\\resources\\symptoms.txt");
        File symptomInsertionFile=new File("D:\\my career\\testing\\medicine\\src\\main\\resources\\symptomsInsertion.txt");


        try {

            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(symptomInsertionFile));
            Scanner scanner=new Scanner(symptomFile);
            String insertStatment;
            while (scanner.hasNextLine()){
                insertStatment="insert into final_smart.symptom (name) value(\""+scanner.nextLine().trim()+"\");";
                bufferedWriter.write(insertStatment);
                bufferedWriter.newLine();
                bufferedWriter.flush();


            }
        } catch (FileNotFoundException e) {
            System.err.println("nader "+e.getMessage());
        } catch (IOException e) {
            System.err.println("nader "+e.getMessage());
        }
    }
}
