package com;

public class Medicine {
    private String ApplNo;
    private String ProductNo;
    private String From;
    private String Strength;
    private String ReferenceDrug;
    private String DrugName;
    private String ActiveIngredient;
    private String ReferenceStandard;

    public Medicine(){

    }

    public String getApplNo() {
        return ApplNo;
    }

    public void setApplNo(String applNo) {
        ApplNo = applNo;
    }

    public String getProductNo() {
        return ProductNo;
    }

    public void setProductNo(String productNo) {
        ProductNo = productNo;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getStrength() {
        return Strength;
    }

    public void setStrength(String strength) {
        Strength = strength;
    }

    public String getReferenceDrug() {
        return ReferenceDrug;
    }

    public void setReferenceDrug(String referenceDrug) {
        ReferenceDrug = referenceDrug;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String drugName) {
        DrugName = drugName;
    }

    public String getActiveIngredient() {
        return ActiveIngredient;
    }

    public void setActiveIngredient(String activeIngredient) {
        ActiveIngredient = activeIngredient;
    }

    public String getReferenceStandard() {
        return ReferenceStandard;
    }

    public void setReferenceStandard(String referenceStandard) {
        ReferenceStandard = referenceStandard;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "ApplNo=" + ApplNo +
                ", ProductNo=" + ProductNo +
                ", From='" + From + '\'' +
                ", Strength='" + Strength + '\'' +
                ", ReferenceDrug='" + ReferenceDrug + '\'' +
                ", DrugName='" + DrugName + '\'' +
                ", ActiveIngredient='" + ActiveIngredient + '\'' +
                ", ReferenceStandard='" + ReferenceStandard + '\'' +
                '}';
    }
}
