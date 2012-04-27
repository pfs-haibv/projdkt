package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class DKT {

    private String NAME;//Branch Name
    private String COUNTRY;//Country Key
    private String ADDRESS;//Street
    private String REGION;//Region (State, Province, County)
    private String DISTRICTNO;//District code for city and street file
    private String DISTRICT;//District
    private String CITYNAME;//City
    private String STATUS;//Trạng thái của Đơn vị trực thuộc
    private String TYPE;//Kiểu của bản kê

    public DKT() {
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getCITYNAME() {
        return CITYNAME;
    }

    public void setCITYNAME(String CITYNAME) {
        this.CITYNAME = CITYNAME;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getDISTRICT() {
        return DISTRICT;
    }

    public void setDISTRICT(String DISTRICT) {
        this.DISTRICT = DISTRICT;
    }

    public String getDISTRICTNO() {
        return DISTRICTNO;
    }

    public void setDISTRICTNO(String DISTRICTNO) {
        this.DISTRICTNO = DISTRICTNO;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getREGION() {
        return REGION;
    }

    public void setREGION(String REGION) {
        this.REGION = REGION;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }


   
}
