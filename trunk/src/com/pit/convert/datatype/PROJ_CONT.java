package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class PROJ_CONT extends DKT {

private String PROCON_TIN;//Identification Number
private String COUNTRYT;//Country Name
private String REGION;//Region (State, Province, County)
private String REGIONNAME;//Description
private String CITY_CODE;//City code for city/street file
private String CITYNAME;//City
private String DISTRICTNO;//District code for city and street file
private String DISTRICT;//District
private String CTNO;//Contract No
private String CTVAL;//Contact Value
private String CTVALW;//Transaction Currency
private String CONT_DATE;//Date of Entry for ID Number
private String EMPL_NO;//Number of employee

    public String getCITYNAME() {
        return CITYNAME;
    }

    public void setCITYNAME(String CITYNAME) {
        this.CITYNAME = CITYNAME;
    }

    public String getCITY_CODE() {
        return CITY_CODE;
    }

    public void setCITY_CODE(String CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
    }

    public String getCONT_DATE() {
        return CONT_DATE;
    }

    public void setCONT_DATE(String CONT_DATE) {
        this.CONT_DATE = CONT_DATE;
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

    public String getEMPL_NO() {
        return EMPL_NO;
    }

    public void setEMPL_NO(String EMPL_NO) {
        this.EMPL_NO = EMPL_NO;
    }

    public String getPROCON_TIN() {
        return PROCON_TIN;
    }

    public void setPROCON_TIN(String PROCON_TIN) {
        this.PROCON_TIN = PROCON_TIN;
    }

    public String getREGION() {
        return REGION;
    }

    public void setREGION(String REGION) {
        this.REGION = REGION;
    }

    public String getREGIONNAME() {
        return REGIONNAME;
    }

    public void setREGIONNAME(String REGIONNAME) {
        this.REGIONNAME = REGIONNAME;
    }

}
