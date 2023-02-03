package egy;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Sheet
public class EgyMedicine {

    @SheetColumn("tradeName")
    String tradeName;

    @SheetColumn("usage")
    String usage;

    @SheetColumn("producingCompany")
    String producingCompany;

    public EgyMedicine(){

    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getProducingCompany() {
        return producingCompany;
    }

    public void setProducingCompany(String producingCompany) {
        this.producingCompany = producingCompany;
    }

    @Override
    public String toString() {
        return "EgyMedicine{" +
                "tradeName='" + tradeName + '\'' +
                ", usage='" + usage + '\'' +
                ", producingCompany='" + producingCompany + '\'' +
                '}';
    }
}
