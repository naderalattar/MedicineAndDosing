package com;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MedicineSuplier {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        File medicineFile=new File("D:\\my career\\testing\\medicine\\src\\main\\resources\\test2.txt");
        Scanner fileScanner=new Scanner(medicineFile);

        Medicine medicine;
        List<Medicine> medicines=new LinkedList<>();
        while (fileScanner.hasNextLine()){



            String line=fileScanner.nextLine();
            Scanner lineScanner=new Scanner(line);

//          lineScanner.useDelimiter("\\s+");
            lineScanner.useDelimiter("\\t");

            medicine=new Medicine();
            medicine.setApplNo(lineScanner.next());
            medicine.setProductNo(lineScanner.next());
            medicine.setFrom(lineScanner.next());
            medicine.setStrength(lineScanner.next());
            medicine.setReferenceDrug(lineScanner.next());
            medicine.setDrugName(lineScanner.next());

            if(lineScanner.hasNext()){
                medicine.setActiveIngredient(lineScanner.next());
            }
            if(lineScanner.hasNext()){
                medicine.setReferenceStandard(lineScanner.next());
            }
            medicines.add(medicine);

//            System.out.println(medicine);
        }
//        System.out.println(medicines.size());

     createInsertionFile(medicines);

    }

    static void createInsertionFile(List<Medicine> medicines){
        File insertionFile=new File("D:\\my career\\testing\\medicine\\src\\main\\resources\\insertion.txt");
        try {
//            PrintWriter printWriter=new PrintWriter(insertionFile);
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(insertionFile));
            int duplicatedStrength=0;
            for (Medicine tempMedicine:medicines){

                String[] categoryAndRoute=tempMedicine.getFrom().split(";");
                String category=categoryAndRoute[0];
                String routeAdmin;



                if(categoryAndRoute.length>=2){
                    routeAdmin=categoryAndRoute[1];
                }
                else
                    routeAdmin="UNKNOWEN";



                String[] activateIngredients=tempMedicine.getActiveIngredient().split(";");
                String activateIngredient=activateIngredients[0];

                if (activateIngredients.length>=2){
                    activateIngredient=activateIngredient+" and "+activateIngredients[1];
                }



                String[] strenghts=tempMedicine.getStrength().split(";");
                String strenght=strenghts[0];
                if (strenghts.length>=2){
                    for(int i=1;i>strenghts.length;i++){
                       strenght=strenghts[i];
                        String insertStatment="insert into final_smart.medicine (name,strength,category,route_admin,active_ingredient) values("
                                +"\""+tempMedicine.getDrugName()+"\",\""+strenght+"\",\""+category+"\",\""+routeAdmin+"\",\""+activateIngredient+"\");";
                        bufferedWriter.write(insertStatment);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();


                    }
                   
                }
                strenght=strenghts[0];


                String insertStatment="insert into final_smart.medicine (name,strength,category,route_admin,active_ingredient) values("
                        +"\""+tempMedicine.getDrugName()+"\",\""+strenght+"\",\""+category+"\",\""+routeAdmin+"\",\""+activateIngredient+"\");";
                bufferedWriter.write(insertStatment);
                bufferedWriter.newLine();
                bufferedWriter.flush();

            }
            System.out.println(duplicatedStrength);


        } catch (FileNotFoundException e) {
           System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }




    }




}
