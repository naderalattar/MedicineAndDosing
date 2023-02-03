package egy;

import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.XlsReader;
import io.github.millij.poi.ss.reader.XlsxReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EgyMedicineSuplier {
    public static void main(String[] args) {

        File xlsxFile=new File("D:\\my career\\testing\\medicine\\src\\main\\resources\\test.xlsx");
        XlsxReader xlsxReader=new XlsxReader();
        List<EgyMedicine> medicines=null;
        try {
             medicines=xlsxReader.read(EgyMedicine.class,xlsxFile);
        } catch (SpreadsheetReadException e) {
            System.err.println("nader "+e.getMessage());
        }



        File sqlFile=new File("D:\\my career\\testing\\medicine\\src\\main\\resources\\sqlTest.sql");
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(sqlFile));
            for (EgyMedicine tempMedicine:medicines){

                String insertStatment="INSERT INTO final_smart.medicine (trade_name,`usage`,producing_company) VALUES ("
                      +"\"" +tempMedicine.getTradeName()+"\",\""+tempMedicine.getUsage()+"\",\""+tempMedicine.getProducingCompany()+"\");" ;
                bufferedWriter.write(insertStatment);
                bufferedWriter.newLine();
                bufferedWriter.flush();

            }

        } catch (IOException e) {
            System.err.println("nader "+e.getMessage());
        }

    }
}
