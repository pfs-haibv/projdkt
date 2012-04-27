package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class FOREIGNER extends DKT {

private String CONT_ID;//Id of Foreigner Contractor
private String COUNTRYT;//Country Name
private String TINVN;//Identification Number
private String TINFR;//Ma so thue DTNN tai nuoc ngoai
private String CTNO;//Contract No
private String CTVAL;//Contact Value
private String CTVALW;//Transaction Currency
private String COFDA;//From date of contract
private String COTDA;//To date of contract
private String EMPNB;//Number of employee
private String BUSS_LICE;//Identification Number
private String BUSS_DATE;//Date of Entry for ID Number
private String BUSS_OFFI;//Responsible Institution for ID Number
private String CONT_OBJECT;//Activity Goal
private String CONT_LOCA;//Working addr as contract
private String LOCA_REGION;//Region (State, Province, County)
private String REGIONNAME;//Description
private String BEGIN_DATE;//Ngày bắt đầu hoạt động
private String YN_CONT;//Có nhà thầu phụ. 1-Yes , 0- No
private String VAT_ITEM;//Có phải nộp thuế GTGT không, 1-Phải nộp, 0-Nếu không
private String REVE_ITEM;//Có phải nộp thuế TNDN không, 1-Có, 0-Không
private String INCO_ITEM;//Có phái nộp thuế TNCN không, 1-Có, 0-Không
private String RESU_METH;//Phương thức chia lãi
private String CONT_TYPE;//Type of Foreigner contractor
private String ATT_DOC;//Attach Document
private String CONT_ID_TINC;//Sequence from tinc system

    public String getATT_DOC() {
        return ATT_DOC;
    }

    public void setATT_DOC(String ATT_DOC) {
        this.ATT_DOC = ATT_DOC;
    }

    public String getBEGIN_DATE() {
        return BEGIN_DATE;
    }

    public void setBEGIN_DATE(String BEGIN_DATE) {
        this.BEGIN_DATE = BEGIN_DATE;
    }

    public String getBUSS_DATE() {
        return BUSS_DATE;
    }

    public void setBUSS_DATE(String BUSS_DATE) {
        this.BUSS_DATE = BUSS_DATE;
    }

    public String getBUSS_LICE() {
        return BUSS_LICE;
    }

    public void setBUSS_LICE(String BUSS_LICE) {
        this.BUSS_LICE = BUSS_LICE;
    }

    public String getBUSS_OFFI() {
        return BUSS_OFFI;
    }

    public void setBUSS_OFFI(String BUSS_OFFI) {
        this.BUSS_OFFI = BUSS_OFFI;
    }

    public String getCOFDA() {
        return COFDA;
    }

    public void setCOFDA(String COFDA) {
        this.COFDA = COFDA;
    }

    public String getCONT_ID() {
        return CONT_ID;
    }

    public void setCONT_ID(String CONT_ID) {
        this.CONT_ID = CONT_ID;
    }

    public String getCONT_LOCA() {
        return CONT_LOCA;
    }

    public void setCONT_LOCA(String CONT_LOCA) {
        this.CONT_LOCA = CONT_LOCA;
    }

    public String getCONT_OBJECT() {
        return CONT_OBJECT;
    }

    public void setCONT_OBJECT(String CONT_OBJECT) {
        this.CONT_OBJECT = CONT_OBJECT;
    }

    public String getCONT_TYPE() {
        return CONT_TYPE;
    }

    public void setCONT_TYPE(String CONT_TYPE) {
        this.CONT_TYPE = CONT_TYPE;
    }

    public String getCOTDA() {
        return COTDA;
    }

    public void setCOTDA(String COTDA) {
        this.COTDA = COTDA;
    }

    public String getCOUNTRYT() {
        return COUNTRYT;
    }

    public void setCOUNTRYT(String COUNTRYT) {
        this.COUNTRYT = COUNTRYT;
    }

    public String getCTNO() {
        return CTNO;
    }

    public void setCTNO(String CTNO) {
        this.CTNO = CTNO;
    }

    public String getCTVAL() {
        return CTVAL;
    }

    public void setCTVAL(String CTVAL) {
        this.CTVAL = CTVAL;
    }

    public String getCTVALW() {
        return CTVALW;
    }

    public void setCTVALW(String CTVALW) {
        this.CTVALW = CTVALW;
    }

    public String getEMPNB() {
        return EMPNB;
    }

    public void setEMPNB(String EMPNB) {
        this.EMPNB = EMPNB;
    }

    public String getINCO_ITEM() {
        return INCO_ITEM;
    }

    public void setINCO_ITEM(String INCO_ITEM) {
        this.INCO_ITEM = INCO_ITEM;
    }

    public String getLOCA_REGION() {
        return LOCA_REGION;
    }

    public void setLOCA_REGION(String LOCA_REGION) {
        this.LOCA_REGION = LOCA_REGION;
    }

    public String getREGIONNAME() {
        return REGIONNAME;
    }

    public void setREGIONNAME(String REGIONNAME) {
        this.REGIONNAME = REGIONNAME;
    }

    public String getRESU_METH() {
        return RESU_METH;
    }

    public void setRESU_METH(String RESU_METH) {
        this.RESU_METH = RESU_METH;
    }

    public String getREVE_ITEM() {
        return REVE_ITEM;
    }

    public void setREVE_ITEM(String REVE_ITEM) {
        this.REVE_ITEM = REVE_ITEM;
    }

    public String getTINFR() {
        return TINFR;
    }

    public void setTINFR(String TINFR) {
        this.TINFR = TINFR;
    }

    public String getTINVN() {
        return TINVN;
    }

    public void setTINVN(String TINVN) {
        this.TINVN = TINVN;
    }

    public String getVAT_ITEM() {
        return VAT_ITEM;
    }

    public void setVAT_ITEM(String VAT_ITEM) {
        this.VAT_ITEM = VAT_ITEM;
    }

    public String getYN_CONT() {
        return YN_CONT;
    }

    public void setYN_CONT(String YN_CONT) {
        this.YN_CONT = YN_CONT;
    }

    public String getCONT_ID_TINC() {
        return CONT_ID_TINC;
    }

    public void setCONT_ID_TINC(String CONT_ID_TINC) {
        this.CONT_ID_TINC = CONT_ID_TINC;
    }       

}
