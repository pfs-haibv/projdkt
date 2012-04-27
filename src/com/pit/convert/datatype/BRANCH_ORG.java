package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class BRANCH_ORG extends DKT {

private String BRA_ID;//Number range of Branch ID
private String BRA_TIN;//Identification Number
private String REGIONNAME;//Description
private String CITY_CODE;//City code for city/street file

    public BRANCH_ORG() {        
    }      
    
    public String getBRA_ID() {
        return BRA_ID;
    }

    public void setBRA_ID(String BRA_ID) {
        this.BRA_ID = BRA_ID;
    }

    public String getBRA_TIN() {
        return BRA_TIN;
    }

    public void setBRA_TIN(String BRA_TIN) {
        this.BRA_TIN = BRA_TIN;
    }

    public String getCITY_CODE() {
        return CITY_CODE;
    }

    public void setCITY_CODE(String CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
    }

    public String getREGIONNAME() {
        return REGIONNAME;
    }

    public void setREGIONNAME(String REGIONNAME) {
        this.REGIONNAME = REGIONNAME;
    }

}
