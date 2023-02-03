package dosing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DosingCreator {
    public static void main(String[] args) throws InterruptedException {

        List<String> dosings=getDosing();
        createTestFile(dosings);


//        int counter=0;
//        for (String tempDos:dosings){
//            System.out.println(tempDos);
//
//            counter++;
//        }
//        System.out.println(counter);
    }

    static List<String> getDosing(){


           //                        حبوب

        String[] tab={"قرص","ثلاثة اقراص","قرصين"};
        String[] beforeOrAfter={"","قبل الاكل","قبل الاكل بربع ساعة","قبل الاكل بساعة","قبل الاكل بساعتين",
                "بعد الاكل بربع ساعة","بعد الاكل بساعة","بعد الاكل يساعة","قبل السحور","قبل السحور بساعة","قبل النوم","قبل السحور بساعتين","بعد الاكل"};
        String[] times={"3 مرات يوميا","مرتين يوميا","مرة واحدة يوميا ","كل 4 ساعات","كل 6 ساعات","كل 8 ساعات","كل 12 ساعة"};
        String[] ferqu={"","لمدة اسبوع","لمدة اسبوعين","لمدة 3 اسابيع","لمدة 4 اسابيع ","لمدة 6 اسابيع","لمدة 8 اسابيع","لمدة 12 اسبوع"};

        List<String> dosings=new LinkedList<>();
        String temTabpDos="";
        for(String tempTab :tab){
            for(String tempBeforeOrAfter:beforeOrAfter){
                for(String tempTimes:times){
                    for (String tempFerq:ferqu){
//                        temTabpDos=tempTab.trim()+" "+tempBeforeOrAfter+" "+tempTimes.trim()+" "+tempFerq.trim();
                        temTabpDos=tempTab.trim()+" ";
                        if(!tempBeforeOrAfter.isEmpty()){
                            temTabpDos+=tempBeforeOrAfter+" ";
                        }
                        temTabpDos+=tempTimes.trim()+" "+tempFerq.trim();
                        String insertStatment="insert into dosing(name) value(\""+temTabpDos.trim()+"\");";
                        dosings.add(insertStatment);
                    }
                }
            }
        }

            //                       قطره

        String[] eyeDrop={"حقنة","لبوسة","قطرة","لبوستين"};
        String[] times2 = {"مرة واحدة يوميا","مرتين يوميا","3 مرات يوميا"};
        String[] frequ2 = {"لمدة يومين","لمدة 3 ايام","لمدة 4 ايام","لمدة 5 ايام","لمدة 6 ايام","لمدة اسبوع","لمدة اسبوعين","لمدة شهر"};

        String tempEyeDropDos="";

        for(String tempEyeDrop:eyeDrop){
            for (String tempTimes:times2){
                for (String tempFerq:frequ2){
                    tempEyeDropDos=tempEyeDrop.trim()+" "+tempTimes.trim()+" "+tempFerq.trim();
                    String insertStatment="insert into dosing(name) value(\""+tempEyeDropDos.trim()+"\");".trim();
                    dosings.add(insertStatment);
                }
            }
        }


        return dosings;
    }
    static void createTestFile(List<String> dosings){
        File dosingFile=new File("D:\\my career\\testing\\medicine\\src\\main\\resources\\dosing.sql");
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(dosingFile));
            for (String tempDose:dosings){
                bufferedWriter.write(tempDose);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
