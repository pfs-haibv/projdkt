package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class REGTAX_ID2 extends DKT {

    private String DESCRIPTION;//Description
    private String IDNUMBER;//Identification Number
    private String INSTITUTE;//Responsible Institution for ID Number
    private String ENTRY_DATE;//Date of Entry for ID Number
    private String REGION_NAME;//Description
    private String COUNTRY_NAME;//Country Name
    private String ID_EXT;//ID extension

    public REGTAX_ID2() {
    }    

    public String getCOUNTRY_NAME() {
        return COUNTRY_NAME;
    }

    public void setCOUNTRY_NAME(String COUNTRY_NAME) {
        this.COUNTRY_NAME = COUNTRY_NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getENTRY_DATE() {
        return ENTRY_DATE;
    }

    public void setENTRY_DATE(String ENTRY_DATE) {
        this.ENTRY_DATE = ENTRY_DATE;
    }

    public String getIDNUMBER() {
        return IDNUMBER;
    }

    public void setIDNUMBER(String IDNUMBER) {
        this.IDNUMBER = IDNUMBER;
    }

    public String getID_EXT() {
        return ID_EXT;
    }

    public void setID_EXT(String ID_EXT) {
        this.ID_EXT = ID_EXT;
    }

    public String getINSTITUTE() {
        return INSTITUTE;
    }

    public void setINSTITUTE(String INSTITUTE) {
        this.INSTITUTE = INSTITUTE;
    }

    public String getREGION_NAME() {
        return REGION_NAME;
    }

    public void setREGION_NAME(String REGION_NAME) {
        this.REGION_NAME = REGION_NAME;
    }

}
