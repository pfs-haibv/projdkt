package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class WAREHOUSE_ORG extends DKT {

private String WAR_ID;//Number ranger of Warehouse
private String CITY;//City code for city/street file
private String REGIONNAME;
private String TIN_WARE_ID; //Sequence from tinc system
private String DKDN_WAR_ID; //Number ranger of Warehouse

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getWAR_ID() {
        return WAR_ID;
    }

    public void setWAR_ID(String WAR_ID) {
        this.WAR_ID = WAR_ID;
    }

    public String getREGIONNAME() {
        return REGIONNAME;
    }

    public void setREGIONNAME(String REGIONNAME) {
        this.REGIONNAME = REGIONNAME;
    }

    public String getDKDN_WAR_ID() {
        return DKDN_WAR_ID;
    }

    public void setDKDN_WAR_ID(String DKDN_WAR_ID) {
        this.DKDN_WAR_ID = DKDN_WAR_ID;
    }

    public String getTIN_WARE_ID() {
        return TIN_WARE_ID;
    }

    public void setTIN_WARE_ID(String TIN_WARE_ID) {
        this.TIN_WARE_ID = TIN_WARE_ID;
    }   

}
