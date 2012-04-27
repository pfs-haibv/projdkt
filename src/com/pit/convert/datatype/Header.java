package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class Header {

private String MODE;// Flag Inser or Update
private String PARTNER;//Business Partner Number
private String PARTNERINFO;//Short name of business partner
private String IDNUMBER_OLD;//Tax Identification Number giữ lại MST trường hợp BP = MST
private String IDNUMBER;//Tax Identification Number
private String INSTA;//Status for individual
private String INSTAT;//Status description for BP
private String ENTRY_DATE;//Validity Start for ID Number
private String CLOSE_DATE;//Validity End for ID Number
private String INRES;//Reason ID for individual status
private String INREST;//Reason description for BP status
private String BUKRS;//Company Code
private String BUTXT;//Name of Company Code or Company
private String PRCTR;//Profit Center
private String LTEXT;//Name of profit center
private String GSBER;//Business Area
private String GTEXT;//Business area description
private String FULLNAME;//Full Name
private String BIRTHDATE;//Date of birth of business partner
private String SEXMALE;//Selection: Business partner is male
private String SEXFEMALE;//Selection: Business partner is female
private String NATIONALITY;//Nationality
private String NATIO_COUNTRY;//Country Name
private String PERM_STREET;//Street
private String PERM_REGION;//Region (State, Province, County)
private String PERM_REGIONNAME;//Description
private String PERM_CITYNO;//City Code for City/Street File
private String PERM_CITY;//City
private String PERM_DISTRICTNO;//District code for city and street file
private String PERM_DISTRICT;//District
private String PERM_COUNTRY;//Country Key
private String PERM_COUNTRYNAME;//Country Name
private String PERM_GUID;//UUID in character form
private String HOME_STREET;//Street
private String HOME_REGION;//Region (State, Province, County)
private String HOME_REGIONNAME;//Description
private String HOME_CITYNO;//City Code for City/Street File
private String HOME_CITY;//City
private String HOME_DISTRICTNO;//District code for city and street file
private String HOME_DISTRICT;//District
private String HOME_COUNTRY;//Country Key
private String HOME_COUNTRYNAME;//Country Name
private String HOME_GUID;//UUID in character form
private String TELEPHONE;//Telephone no.: dialling code+number
private String EXTENSION;//Telephone no.: Extension
private String TELEPHONEID;//Sequence number
private String MOBIPHONE;//Telephone no.: dialling code+number
private String MOBIPHONEID;//Sequence number
private String E_MAIL;//E-Mail Address
private String FILEID;//File ID
private String RECEIPT_DATE;//Receipt date
private String MARK;//Indicator: Line selected
private String BPKIND;//Business Partner Type
private String TEXT40;//Text, 40 Characters Long
private String TRADE_NAME;//Trade Name
private String ONAME;//Name of non-individual part
private String ORGSTA;//Status for organization
private String ORGSTAT;//Status description for BP
private String IMEX_CHK;//Import, export check
private String NONIE_CHK;//Not import and export
private String NUMEP;//Number of employee
private String FOUND_DAT;//Date organization founded
private String CONT_CTNO;//Contract No
private String CONT_CTVAL;//Contact Value
private String CONT_CTVALW;//Transaction Currency
private String TOCAP;//Total Capital
private String TOCAPW;//Transaction Currency
private String STACAP;//State budget
private String FORECAP;//Foreign capital
private String OTHCAP;//Other capital
private String STACAPW;//Transaction Currency
private String FORECAPW;//Transaction Currency
private String OTHCAPW;//Transaction Currency
private String STATE_PROP;//Proportion of state capital
private String FOREIGN_PRO;//Proportion of foreign capital
private String OTHER_PRO;//Proportion of other capital
private String TREA_ACCO;//Account of Treasury
private String TREA_CODE;//Mã Kho bạc
private String TREA_NAME;//Treasury Name
private String LEGAL_ENTY;//BP: Legal form of organization
private String LEGAL_ENTYT;//Description
private String FINA_SDAT;//Start of financial year
private String FINA_EDAT;//End of financial year
private String HASUB;//There is units member
private String HABRA;//There is unit under
private String HAWHS;//There is Warehouse
private String HAREP;//There is representative office
private String HACWC;//Contracts with contractors, subcontractors overseas
private String HAJOIN;//Work in partnership
private String REORG_ID;//Status before reopen organization
private String REORG_NAME;//Name of Status Org
private String OLD_TIN;//Previously TIN
private String DIRNA;//Director name
private String DIRFO;//First telephone no.: dialling code+number
private String ACCNA;//Accountant name
private String ACCFO;//First telephone no.: dialling code+number
private String BU_STREET;//Street
private String BU_REGION;//Region (State, Province, County)
private String BU_REGIONNAME;//Description
private String BU_COUNTRY;//Country Key
private String BU_COUNTRYNAME;//Country Name
private String BU_CITY_CODE;//City code for city/street file
private String BU_CITYNAME;//City
private String BU_DISTRICTNO;//District code for city and street file
private String BU_DISTRICT;//District
private String BU_FAX_NUMBER;//First fax no.: dialling code+number
private String BU_TEL_NUMBER;//First telephone no.: dialling code+number
private String BU_E_MAIL;//E-Mail Address
private String BU_GUID;//UUID in character form
private String CO_GUID;//UUID in character form
private String CO_STREET;//Street
private String CO_REGION;//Region (State, Province, County)
private String CO_REGIONNAME;//Description
private String CO_COUNTRY;//Country Key
private String CO_COUNTRYNAME;//Country Name
private String CO_CITY_CODE;//City code for city/street file
private String CO_CITYNAME;//City
private String CO_DISTRICTNO;//District code for city and street file
private String CO_DISTRICT;//District
private String CO_FAX_NUMBER;//First fax no.: dialling code+number
private String CO_TEL_NUMBER;//First telephone no.: dialling code+number
private String CO_E_MAIL;//E-Mail Address
private String ESTAB_IDNUMBER;//Identification Number
private String ESTAB_INSTITUTE;//Responsible Institution for ID Number
private String ESTAB_ENTRY_DATE;//Date of Entry for ID Number
private String BUSIN_REGION;//Region (State, Province, County)
private String BUSIN_REGIONNAME;//Description
private String BUSIN_IDNUMBE;//Identification Number
private String BUSIN_INSTITUT;//Responsible Institution for ID Number
private String BUSIN_ENTRY_DATE;//Date of Entry for ID Number
private String MANAG_TINOW;//TIN of owner (organization)
private String MANAG_STREET;//Street
private String MANAG_REGION;//Region (State, Province, County)
private String MANAG_REGIONNAME;//Description
private String MANAG_ONAME;//Name of non-individual part
private String MANAG_COUNTRY;//Country Key
private String MANAG_COUNTRYNAME;//Country Name
private String MANAG_CITY_CODE;//City code for city/street file
private String MANAG_CITYNAME;//City
private String MANAG_DISTRICTNO;//District code for city and street file
private String MANAG_DISTRICT;//District
private String MANAG_E_MAIL;//E-Mail Address
private String MANAG_GUID;//UUID in character form
private String BUINFO_NAME_FIRST;//First name of business partner (person)
private String BUINFO_BIRTHDATE;//Date of birth of business partner
private String BUINFO_STREET;//Street
private String BUINFO_TEL_NUMBER;//First telephone no.: dialling code+number
private String BUINFO_CITY_CODE;//City code for city/street file
private String BUINFO_CITYNAME;//City
private String BUINFO_DISTRICTNO;//District code for city and street file
private String BUINFO_DISTRICT;//District
private String BUINFO_REGION;//Region (State, Province, County)
private String BUINFO_REGIONNAME;//Description
private String BUINFO_COUNTRY;//Country Key
private String BUINFO_COUNTRYNAME;//Country Name
private String BUINFO_FAX_NUMBER;//First fax no.: dialling code+number
private String BUINFO_E_MAIL;//E-Mail Address
private String BUINFO_GUID;//UUID in character form
private String ADVN_STREET;//Street
private String ADVN_CITY_CODE;//City code for city/street file
private String ADVN_CITYNAME;//City
private String ADVN_DISTRICTNO;//District code for city and street file
private String ADVN_DISTRICT;//District
private String ADVN_REGION;//Region (State, Province, County)
private String ADVN_REGIONNAME;//Description
private String ADVN_COUNTRY;//Country Key
private String ADVN_COUNTRYNAME;//Country Name
private String ADVN_TEL_NUMBER;//First telephone no.: dialling code+number
private String ADVN_FAX_NUMBER;//First fax no.: dialling code+number
private String ADVN_E_MAIL;//E-Mail Address
private String ADVN_GUID;//UUID in character form
private String VATID;//VAT Method
private String VATDESC;//Description for VAT Method
private String LEGAL_ORG;//Legal Entity of Organization
private String LEGAL_ORGT;//Name
private String ECO_ID;//ID of Economy detail
private String ECO_DESCX;//Description of Economy detail
private String ACC_DEPEND;//Accounting Dependent
private String ACC_INDEPEND;//Accounting Independent
private String ODA;//ODA
private String JNT_CIRCULAR;//Joint circular
private String REPL_PAYAGENCY;//Replacement pay agency
private String CONT_TINVN;//TIN at Vietnam side
private String CONT_COFDA;//From date of contract
private String CONT_COTDA;//To date of contract
private String CONT_ENTRY_DATE;//Date of Entry for ID Number
private String CONT_WADDR;//Working addr as contract
private String CONT_INSTITUTE;//Responsible Institution for ID Number
private String ACTI_GOAL;//Activity Goal
private String ATT_DOC;//Attach Document
private String ORRES;//Reason ID for organization status
private String ORREST;//Reason description for BP status
private String INTDA;//To date for Individual status
private String INFDA;//From date for individual status
private String ORFDA;//From date for individual status
private String ORTDA;//To date for Individual status
private String FRN_STREET;//Street
private String FRN_TEL_NUMBER;//First telephone no.: dialling code+number
private String FRN_FAX_NUMBER;//First fax no.: dialling code+number
private String FRN_E_MAIL;//E-Mail Address
private String FRN_REGION;//Region (State, Province, County)
private String FRN_REGIONNAME;//Description
private String FRN_COUNTRY;//Country Key
private String FRN_COUNTRYNAME;//Country Name
private String FRN_CITY_CODE;//City code for city/street file
private String FRN_CITYNAME;//City
private String FRN_DISTRICTNO;//District code for city and street file
private String FRN_DISTRICT;//District
private String FRN_GUID;//UUID in character form
private String MINVN_NAME;//Name of manager's in VN
private String MINVN_ADDRESS;//Street
private String MINVN_PHONE;//First telephone no.: dialling code+number
private String MINVN_EMAIL;//E-Mail Address
private String TWD_TIN;//Identification Number
private String TWD_NAME;//Tax withholding name
private String TWD_ADD;//Street
private String REG_CASE_ID;//Mã trạng thái đăng ký thuế
private String REG_CASE_DETAIL;//Chi tiểt trạng thái đăng ký thuế
private String BANK_NAME_TEXT;//Bank's name (dkdn transport to PIT)
private String BANK_ACC_TEXT;//Bank's acc (dkdn transport to PIT)
private String ST_CLOSE_DATE;//Start Temp close date
private String ET_CLOSE_DATE;//End temp close date
private String NNKD;//Ngành nghề kinh doanh
private String BRAN_TYPE;//Kiểu của bản kê
private String RESTORE_DATE;//Restore date
private String ORRESBK;//Reason of organization business breaking
private String PROV_DES;// (tỉnh chuyển đến)
private String BUKRN; // CQT chuyển đến
private String YN_NBRS;//Transfer from NBRS
private String YN_BILL_STA;//Bill  status
private String YN_FTAX;//RegTax certification lost
private String YN_REGCER_STA;//RegTax certification status
private String YN_CUSDUTYFSH;//Customs      duty finished
private String YN_BUSCER_RVK;//Business certification revoked
private String ENTERPRISE_ID;

    public Header() {
    }

    public String getMODE() {
        return MODE;
    }

    public void setMODE(String MODE) {
        this.MODE = MODE;
    }


    public String getACCFO() {
        return ACCFO;
    }

    public void setACCFO(String ACCFO) {
        this.ACCFO = ACCFO;
    }

    public String getACCNA() {
        return ACCNA;
    }

    public void setACCNA(String ACCNA) {
        this.ACCNA = ACCNA;
    }

    public String getACC_DEPEND() {
        return ACC_DEPEND;
    }

    public void setACC_DEPEND(String ACC_DEPEND) {
        this.ACC_DEPEND = ACC_DEPEND;
    }

    public String getACC_INDEPEND() {
        return ACC_INDEPEND;
    }

    public void setACC_INDEPEND(String ACC_INDEPEND) {
        this.ACC_INDEPEND = ACC_INDEPEND;
    }

    public String getACTI_GOAL() {
        return ACTI_GOAL;
    }

    public void setACTI_GOAL(String ACTI_GOAL) {
        this.ACTI_GOAL = ACTI_GOAL;
    }

    public String getADVN_CITYNAME() {
        return ADVN_CITYNAME;
    }

    public void setADVN_CITYNAME(String ADVN_CITYNAME) {
        this.ADVN_CITYNAME = ADVN_CITYNAME;
    }

    public String getADVN_CITY_CODE() {
        return ADVN_CITY_CODE;
    }

    public void setADVN_CITY_CODE(String ADVN_CITY_CODE) {
        this.ADVN_CITY_CODE = ADVN_CITY_CODE;
    }

    public String getADVN_COUNTRY() {
        return ADVN_COUNTRY;
    }

    public void setADVN_COUNTRY(String ADVN_COUNTRY) {
        this.ADVN_COUNTRY = ADVN_COUNTRY;
    }

    public String getADVN_COUNTRYNAME() {
        return ADVN_COUNTRYNAME;
    }

    public void setADVN_COUNTRYNAME(String ADVN_COUNTRYNAME) {
        this.ADVN_COUNTRYNAME = ADVN_COUNTRYNAME;
    }

    public String getADVN_DISTRICT() {
        return ADVN_DISTRICT;
    }

    public void setADVN_DISTRICT(String ADVN_DISTRICT) {
        this.ADVN_DISTRICT = ADVN_DISTRICT;
    }

    public String getADVN_DISTRICTNO() {
        return ADVN_DISTRICTNO;
    }

    public void setADVN_DISTRICTNO(String ADVN_DISTRICTNO) {
        this.ADVN_DISTRICTNO = ADVN_DISTRICTNO;
    }

    public String getADVN_E_MAIL() {
        return ADVN_E_MAIL;
    }

    public void setADVN_E_MAIL(String ADVN_E_MAIL) {
        this.ADVN_E_MAIL = ADVN_E_MAIL;
    }

    public String getADVN_FAX_NUMBER() {
        return ADVN_FAX_NUMBER;
    }

    public void setADVN_FAX_NUMBER(String ADVN_FAX_NUMBER) {
        this.ADVN_FAX_NUMBER = ADVN_FAX_NUMBER;
    }

    public String getADVN_GUID() {
        return ADVN_GUID;
    }

    public void setADVN_GUID(String ADVN_GUID) {
        this.ADVN_GUID = ADVN_GUID;
    }

    public String getADVN_REGION() {
        return ADVN_REGION;
    }

    public void setADVN_REGION(String ADVN_REGION) {
        this.ADVN_REGION = ADVN_REGION;
    }

    public String getADVN_REGIONNAME() {
        return ADVN_REGIONNAME;
    }

    public void setADVN_REGIONNAME(String ADVN_REGIONNAME) {
        this.ADVN_REGIONNAME = ADVN_REGIONNAME;
    }

    public String getADVN_STREET() {
        return ADVN_STREET;
    }

    public void setADVN_STREET(String ADVN_STREET) {
        this.ADVN_STREET = ADVN_STREET;
    }

    public String getADVN_TEL_NUMBER() {
        return ADVN_TEL_NUMBER;
    }

    public void setADVN_TEL_NUMBER(String ADVN_TEL_NUMBER) {
        this.ADVN_TEL_NUMBER = ADVN_TEL_NUMBER;
    }

    public String getATT_DOC() {
        return ATT_DOC;
    }

    public void setATT_DOC(String ATT_DOC) {
        this.ATT_DOC = ATT_DOC;
    }

    public String getBIRTHDATE() {
        return BIRTHDATE;
    }

    public void setBIRTHDATE(String BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;
    }

    public String getBPKIND() {
        return BPKIND;
    }

    public void setBPKIND(String BPKIND) {
        this.BPKIND = BPKIND;
    }

    public String getBUINFO_BIRTHDATE() {
        return BUINFO_BIRTHDATE;
    }

    public void setBUINFO_BIRTHDATE(String BUINFO_BIRTHDATE) {
        this.BUINFO_BIRTHDATE = BUINFO_BIRTHDATE;
    }

    public String getBUINFO_CITYNAME() {
        return BUINFO_CITYNAME;
    }

    public void setBUINFO_CITYNAME(String BUINFO_CITYNAME) {
        this.BUINFO_CITYNAME = BUINFO_CITYNAME;
    }

    public String getBUINFO_CITY_CODE() {
        return BUINFO_CITY_CODE;
    }

    public void setBUINFO_CITY_CODE(String BUINFO_CITY_CODE) {
        this.BUINFO_CITY_CODE = BUINFO_CITY_CODE;
    }

    public String getBUINFO_COUNTRY() {
        return BUINFO_COUNTRY;
    }

    public void setBUINFO_COUNTRY(String BUINFO_COUNTRY) {
        this.BUINFO_COUNTRY = BUINFO_COUNTRY;
    }

    public String getBUINFO_COUNTRYNAME() {
        return BUINFO_COUNTRYNAME;
    }

    public void setBUINFO_COUNTRYNAME(String BUINFO_COUNTRYNAME) {
        this.BUINFO_COUNTRYNAME = BUINFO_COUNTRYNAME;
    }

    public String getBUINFO_DISTRICT() {
        return BUINFO_DISTRICT;
    }

    public void setBUINFO_DISTRICT(String BUINFO_DISTRICT) {
        this.BUINFO_DISTRICT = BUINFO_DISTRICT;
    }

    public String getBUINFO_DISTRICTNO() {
        return BUINFO_DISTRICTNO;
    }

    public void setBUINFO_DISTRICTNO(String BUINFO_DISTRICTNO) {
        this.BUINFO_DISTRICTNO = BUINFO_DISTRICTNO;
    }

    public String getBUINFO_E_MAIL() {
        return BUINFO_E_MAIL;
    }

    public void setBUINFO_E_MAIL(String BUINFO_E_MAIL) {
        this.BUINFO_E_MAIL = BUINFO_E_MAIL;
    }

    public String getBUINFO_FAX_NUMBER() {
        return BUINFO_FAX_NUMBER;
    }

    public void setBUINFO_FAX_NUMBER(String BUINFO_FAX_NUMBER) {
        this.BUINFO_FAX_NUMBER = BUINFO_FAX_NUMBER;
    }

    public String getBUINFO_GUID() {
        return BUINFO_GUID;
    }

    public void setBUINFO_GUID(String BUINFO_GUID) {
        this.BUINFO_GUID = BUINFO_GUID;
    }

    public String getBUINFO_NAME_FIRST() {
        return BUINFO_NAME_FIRST;
    }

    public void setBUINFO_NAME_FIRST(String BUINFO_NAME_FIRST) {
        this.BUINFO_NAME_FIRST = BUINFO_NAME_FIRST;
    }

    public String getBUINFO_REGION() {
        return BUINFO_REGION;
    }

    public void setBUINFO_REGION(String BUINFO_REGION) {
        this.BUINFO_REGION = BUINFO_REGION;
    }

    public String getBUINFO_REGIONNAME() {
        return BUINFO_REGIONNAME;
    }

    public void setBUINFO_REGIONNAME(String BUINFO_REGIONNAME) {
        this.BUINFO_REGIONNAME = BUINFO_REGIONNAME;
    }

    public String getBUINFO_STREET() {
        return BUINFO_STREET;
    }

    public void setBUINFO_STREET(String BUINFO_STREET) {
        this.BUINFO_STREET = BUINFO_STREET;
    }

    public String getBUINFO_TEL_NUMBER() {
        return BUINFO_TEL_NUMBER;
    }

    public void setBUINFO_TEL_NUMBER(String BUINFO_TEL_NUMBER) {
        this.BUINFO_TEL_NUMBER = BUINFO_TEL_NUMBER;
    }

    public String getBUKRS() {
        return BUKRS;
    }

    public void setBUKRS(String BUKRS) {
        this.BUKRS = BUKRS;
    }

    public String getBUSIN_ENTRY_DATE() {
        return BUSIN_ENTRY_DATE;
    }

    public void setBUSIN_ENTRY_DATE(String BUSIN_ENTRY_DATE) {
        this.BUSIN_ENTRY_DATE = BUSIN_ENTRY_DATE;
    }

    public String getBUSIN_IDNUMBE() {
        return BUSIN_IDNUMBE;
    }

    public void setBUSIN_IDNUMBE(String BUSIN_IDNUMBE) {
        this.BUSIN_IDNUMBE = BUSIN_IDNUMBE;
    }

    public String getBUSIN_INSTITUT() {
        return BUSIN_INSTITUT;
    }

    public void setBUSIN_INSTITUT(String BUSIN_INSTITUT) {
        this.BUSIN_INSTITUT = BUSIN_INSTITUT;
    }

    public String getBUSIN_REGION() {
        return BUSIN_REGION;
    }

    public void setBUSIN_REGION(String BUSIN_REGION) {
        this.BUSIN_REGION = BUSIN_REGION;
    }

    public String getBUSIN_REGIONNAME() {
        return BUSIN_REGIONNAME;
    }

    public void setBUSIN_REGIONNAME(String BUSIN_REGIONNAME) {
        this.BUSIN_REGIONNAME = BUSIN_REGIONNAME;
    }

    public String getBUTXT() {
        return BUTXT;
    }

    public void setBUTXT(String BUTXT) {
        this.BUTXT = BUTXT;
    }

    public String getBU_CITYNAME() {
        return BU_CITYNAME;
    }

    public void setBU_CITYNAME(String BU_CITYNAME) {
        this.BU_CITYNAME = BU_CITYNAME;
    }

    public String getBU_CITY_CODE() {
        return BU_CITY_CODE;
    }

    public void setBU_CITY_CODE(String BU_CITY_CODE) {
        this.BU_CITY_CODE = BU_CITY_CODE;
    }

    public String getBU_COUNTRY() {
        return BU_COUNTRY;
    }

    public void setBU_COUNTRY(String BU_COUNTRY) {
        this.BU_COUNTRY = BU_COUNTRY;
    }

    public String getBU_COUNTRYNAME() {
        return BU_COUNTRYNAME;
    }

    public void setBU_COUNTRYNAME(String BU_COUNTRYNAME) {
        this.BU_COUNTRYNAME = BU_COUNTRYNAME;
    }

    public String getBU_DISTRICT() {
        return BU_DISTRICT;
    }

    public void setBU_DISTRICT(String BU_DISTRICT) {
        this.BU_DISTRICT = BU_DISTRICT;
    }

    public String getBU_DISTRICTNO() {
        return BU_DISTRICTNO;
    }

    public void setBU_DISTRICTNO(String BU_DISTRICTNO) {
        this.BU_DISTRICTNO = BU_DISTRICTNO;
    }

    public String getBU_E_MAIL() {
        return BU_E_MAIL;
    }

    public void setBU_E_MAIL(String BU_E_MAIL) {
        this.BU_E_MAIL = BU_E_MAIL;
    }

    public String getBU_FAX_NUMBER() {
        return BU_FAX_NUMBER;
    }

    public void setBU_FAX_NUMBER(String BU_FAX_NUMBER) {
        this.BU_FAX_NUMBER = BU_FAX_NUMBER;
    }

    public String getBU_GUID() {
        return BU_GUID;
    }

    public void setBU_GUID(String BU_GUID) {
        this.BU_GUID = BU_GUID;
    }

    public String getBU_REGION() {
        return BU_REGION;
    }

    public void setBU_REGION(String BU_REGION) {
        this.BU_REGION = BU_REGION;
    }

    public String getBU_REGIONNAME() {
        return BU_REGIONNAME;
    }

    public void setBU_REGIONNAME(String BU_REGIONNAME) {
        this.BU_REGIONNAME = BU_REGIONNAME;
    }

    public String getBU_STREET() {
        return BU_STREET;
    }

    public void setBU_STREET(String BU_STREET) {
        this.BU_STREET = BU_STREET;
    }

    public String getBU_TEL_NUMBER() {
        return BU_TEL_NUMBER;
    }

    public void setBU_TEL_NUMBER(String BU_TEL_NUMBER) {
        this.BU_TEL_NUMBER = BU_TEL_NUMBER;
    }

    public String getCLOSE_DATE() {
        return CLOSE_DATE;
    }

    public void setCLOSE_DATE(String CLOSE_DATE) {
        this.CLOSE_DATE = CLOSE_DATE;
    }

    public String getCONT_COFDA() {
        return CONT_COFDA;
    }

    public void setCONT_COFDA(String CONT_COFDA) {
        this.CONT_COFDA = CONT_COFDA;
    }

    public String getCONT_COTDA() {
        return CONT_COTDA;
    }

    public void setCONT_COTDA(String CONT_COTDA) {
        this.CONT_COTDA = CONT_COTDA;
    }

    public String getCONT_CTNO() {
        return CONT_CTNO;
    }

    public void setCONT_CTNO(String CONT_CTNO) {
        this.CONT_CTNO = CONT_CTNO;
    }

    public String getCONT_CTVAL() {
        return CONT_CTVAL;
    }

    public void setCONT_CTVAL(String CONT_CTVAL) {
        this.CONT_CTVAL = CONT_CTVAL;
    }

    public String getCONT_CTVALW() {
        return CONT_CTVALW;
    }

    public void setCONT_CTVALW(String CONT_CTVALW) {
        this.CONT_CTVALW = CONT_CTVALW;
    }

    public String getCONT_ENTRY_DATE() {
        return CONT_ENTRY_DATE;
    }

    public void setCONT_ENTRY_DATE(String CONT_ENTRY_DATE) {
        this.CONT_ENTRY_DATE = CONT_ENTRY_DATE;
    }

    public String getCONT_INSTITUTE() {
        return CONT_INSTITUTE;
    }

    public void setCONT_INSTITUTE(String CONT_INSTITUTE) {
        this.CONT_INSTITUTE = CONT_INSTITUTE;
    }

    public String getCONT_TINVN() {
        return CONT_TINVN;
    }

    public void setCONT_TINVN(String CONT_TINVN) {
        this.CONT_TINVN = CONT_TINVN;
    }

    public String getCONT_WADDR() {
        return CONT_WADDR;
    }

    public void setCONT_WADDR(String CONT_WADDR) {
        this.CONT_WADDR = CONT_WADDR;
    }

    public String getCO_CITYNAME() {
        return CO_CITYNAME;
    }

    public void setCO_CITYNAME(String CO_CITYNAME) {
        this.CO_CITYNAME = CO_CITYNAME;
    }

    public String getCO_CITY_CODE() {
        return CO_CITY_CODE;
    }

    public void setCO_CITY_CODE(String CO_CITY_CODE) {
        this.CO_CITY_CODE = CO_CITY_CODE;
    }

    public String getCO_COUNTRY() {
        return CO_COUNTRY;
    }

    public void setCO_COUNTRY(String CO_COUNTRY) {
        this.CO_COUNTRY = CO_COUNTRY;
    }

    public String getCO_COUNTRYNAME() {
        return CO_COUNTRYNAME;
    }

    public void setCO_COUNTRYNAME(String CO_COUNTRYNAME) {
        this.CO_COUNTRYNAME = CO_COUNTRYNAME;
    }

    public String getCO_DISTRICT() {
        return CO_DISTRICT;
    }

    public void setCO_DISTRICT(String CO_DISTRICT) {
        this.CO_DISTRICT = CO_DISTRICT;
    }

    public String getCO_DISTRICTNO() {
        return CO_DISTRICTNO;
    }

    public void setCO_DISTRICTNO(String CO_DISTRICTNO) {
        this.CO_DISTRICTNO = CO_DISTRICTNO;
    }

    public String getCO_E_MAIL() {
        return CO_E_MAIL;
    }

    public void setCO_E_MAIL(String CO_E_MAIL) {
        this.CO_E_MAIL = CO_E_MAIL;
    }

    public String getCO_FAX_NUMBER() {
        return CO_FAX_NUMBER;
    }

    public void setCO_FAX_NUMBER(String CO_FAX_NUMBER) {
        this.CO_FAX_NUMBER = CO_FAX_NUMBER;
    }

    public String getCO_GUID() {
        return CO_GUID;
    }

    public void setCO_GUID(String CO_GUID) {
        this.CO_GUID = CO_GUID;
    }

    public String getCO_REGION() {
        return CO_REGION;
    }

    public void setCO_REGION(String CO_REGION) {
        this.CO_REGION = CO_REGION;
    }

    public String getCO_REGIONNAME() {
        return CO_REGIONNAME;
    }

    public void setCO_REGIONNAME(String CO_REGIONNAME) {
        this.CO_REGIONNAME = CO_REGIONNAME;
    }

    public String getCO_STREET() {
        return CO_STREET;
    }

    public void setCO_STREET(String CO_STREET) {
        this.CO_STREET = CO_STREET;
    }

    public String getCO_TEL_NUMBER() {
        return CO_TEL_NUMBER;
    }

    public void setCO_TEL_NUMBER(String CO_TEL_NUMBER) {
        this.CO_TEL_NUMBER = CO_TEL_NUMBER;
    }

    public String getDIRFO() {
        return DIRFO;
    }

    public void setDIRFO(String DIRFO) {
        this.DIRFO = DIRFO;
    }

    public String getDIRNA() {
        return DIRNA;
    }

    public void setDIRNA(String DIRNA) {
        this.DIRNA = DIRNA;
    }

    public String getECO_DESCX() {
        return ECO_DESCX;
    }

    public void setECO_DESCX(String ECO_DESCX) {
        this.ECO_DESCX = ECO_DESCX;
    }

    public String getECO_ID() {
        return ECO_ID;
    }

    public void setECO_ID(String ECO_ID) {
        this.ECO_ID = ECO_ID;
    }

    public String getENTRY_DATE() {
        return ENTRY_DATE;
    }

    public void setENTRY_DATE(String ENTRY_DATE) {
        this.ENTRY_DATE = ENTRY_DATE;
    }

    public String getESTAB_ENTRY_DATE() {
        return ESTAB_ENTRY_DATE;
    }

    public void setESTAB_ENTRY_DATE(String ESTAB_ENTRY_DATE) {
        this.ESTAB_ENTRY_DATE = ESTAB_ENTRY_DATE;
    }

    public String getESTAB_IDNUMBER() {
        return ESTAB_IDNUMBER;
    }

    public void setESTAB_IDNUMBER(String ESTAB_IDNUMBER) {
        this.ESTAB_IDNUMBER = ESTAB_IDNUMBER;
    }

    public String getESTAB_INSTITUTE() {
        return ESTAB_INSTITUTE;
    }

    public void setESTAB_INSTITUTE(String ESTAB_INSTITUTE) {
        this.ESTAB_INSTITUTE = ESTAB_INSTITUTE;
    }

    public String getEXTENSION() {
        return EXTENSION;
    }

    public void setEXTENSION(String EXTENSION) {
        this.EXTENSION = EXTENSION;
    }

    public String getE_MAIL() {
        return E_MAIL;
    }

    public void setE_MAIL(String E_MAIL) {
        this.E_MAIL = E_MAIL;
    }

    public String getFILEID() {
        return FILEID;
    }

    public void setFILEID(String FILEID) {
        this.FILEID = FILEID;
    }

    public String getFINA_EDAT() {
        return FINA_EDAT;
    }

    public void setFINA_EDAT(String FINA_EDAT) {
        this.FINA_EDAT = FINA_EDAT;
    }

    public String getFINA_SDAT() {
        return FINA_SDAT;
    }

    public void setFINA_SDAT(String FINA_SDAT) {
        this.FINA_SDAT = FINA_SDAT;
    }

    public String getFORECAP() {
        return FORECAP;
    }

    public void setFORECAP(String FORECAP) {
        this.FORECAP = FORECAP;
    }

    public String getFORECAPW() {
        return FORECAPW;
    }

    public void setFORECAPW(String FORECAPW) {
        this.FORECAPW = FORECAPW;
    }

    public String getFOREIGN_PRO() {
        return FOREIGN_PRO;
    }

    public void setFOREIGN_PRO(String FOREIGN_PRO) {
        this.FOREIGN_PRO = FOREIGN_PRO;
    }

    public String getFOUND_DAT() {
        return FOUND_DAT;
    }

    public void setFOUND_DAT(String FOUND_DAT) {
        this.FOUND_DAT = FOUND_DAT;
    }

    public String getFRN_CITYNAME() {
        return FRN_CITYNAME;
    }

    public void setFRN_CITYNAME(String FRN_CITYNAME) {
        this.FRN_CITYNAME = FRN_CITYNAME;
    }

    public String getFRN_CITY_CODE() {
        return FRN_CITY_CODE;
    }

    public void setFRN_CITY_CODE(String FRN_CITY_CODE) {
        this.FRN_CITY_CODE = FRN_CITY_CODE;
    }

    public String getFRN_COUNTRY() {
        return FRN_COUNTRY;
    }

    public void setFRN_COUNTRY(String FRN_COUNTRY) {
        this.FRN_COUNTRY = FRN_COUNTRY;
    }

    public String getFRN_COUNTRYNAME() {
        return FRN_COUNTRYNAME;
    }

    public void setFRN_COUNTRYNAME(String FRN_COUNTRYNAME) {
        this.FRN_COUNTRYNAME = FRN_COUNTRYNAME;
    }

    public String getFRN_DISTRICT() {
        return FRN_DISTRICT;
    }

    public void setFRN_DISTRICT(String FRN_DISTRICT) {
        this.FRN_DISTRICT = FRN_DISTRICT;
    }

    public String getFRN_DISTRICTNO() {
        return FRN_DISTRICTNO;
    }

    public void setFRN_DISTRICTNO(String FRN_DISTRICTNO) {
        this.FRN_DISTRICTNO = FRN_DISTRICTNO;
    }

    public String getFRN_E_MAIL() {
        return FRN_E_MAIL;
    }

    public void setFRN_E_MAIL(String FRN_E_MAIL) {
        this.FRN_E_MAIL = FRN_E_MAIL;
    }

    public String getFRN_FAX_NUMBER() {
        return FRN_FAX_NUMBER;
    }

    public void setFRN_FAX_NUMBER(String FRN_FAX_NUMBER) {
        this.FRN_FAX_NUMBER = FRN_FAX_NUMBER;
    }

    public String getFRN_GUID() {
        return FRN_GUID;
    }

    public void setFRN_GUID(String FRN_GUID) {
        this.FRN_GUID = FRN_GUID;
    }

    public String getFRN_REGION() {
        return FRN_REGION;
    }

    public void setFRN_REGION(String FRN_REGION) {
        this.FRN_REGION = FRN_REGION;
    }

    public String getFRN_REGIONNAME() {
        return FRN_REGIONNAME;
    }

    public void setFRN_REGIONNAME(String FRN_REGIONNAME) {
        this.FRN_REGIONNAME = FRN_REGIONNAME;
    }

    public String getFRN_STREET() {
        return FRN_STREET;
    }

    public void setFRN_STREET(String FRN_STREET) {
        this.FRN_STREET = FRN_STREET;
    }

    public String getFRN_TEL_NUMBER() {
        return FRN_TEL_NUMBER;
    }

    public void setFRN_TEL_NUMBER(String FRN_TEL_NUMBER) {
        this.FRN_TEL_NUMBER = FRN_TEL_NUMBER;
    }

    public String getFULLNAME() {
        return FULLNAME;
    }

    public void setFULLNAME(String FULLNAME) {
        this.FULLNAME = FULLNAME;
    }

    public String getGSBER() {
        return GSBER;
    }

    public void setGSBER(String GSBER) {
        this.GSBER = GSBER;
    }

    public String getGTEXT() {
        return GTEXT;
    }

    public void setGTEXT(String GTEXT) {
        this.GTEXT = GTEXT;
    }

    public String getHABRA() {
        return HABRA;
    }

    public void setHABRA(String HABRA) {
        this.HABRA = HABRA;
    }

    public String getHACWC() {
        return HACWC;
    }

    public void setHACWC(String HACWC) {
        this.HACWC = HACWC;
    }

    public String getHAJOIN() {
        return HAJOIN;
    }

    public void setHAJOIN(String HAJOIN) {
        this.HAJOIN = HAJOIN;
    }

    public String getHAREP() {
        return HAREP;
    }

    public void setHAREP(String HAREP) {
        this.HAREP = HAREP;
    }

    public String getHASUB() {
        return HASUB;
    }

    public void setHASUB(String HASUB) {
        this.HASUB = HASUB;
    }

    public String getHAWHS() {
        return HAWHS;
    }

    public void setHAWHS(String HAWHS) {
        this.HAWHS = HAWHS;
    }

    public String getHOME_CITY() {
        return HOME_CITY;
    }

    public void setHOME_CITY(String HOME_CITY) {
        this.HOME_CITY = HOME_CITY;
    }

    public String getHOME_CITYNO() {
        return HOME_CITYNO;
    }

    public void setHOME_CITYNO(String HOME_CITYNO) {
        this.HOME_CITYNO = HOME_CITYNO;
    }

    public String getHOME_COUNTRY() {
        return HOME_COUNTRY;
    }

    public void setHOME_COUNTRY(String HOME_COUNTRY) {
        this.HOME_COUNTRY = HOME_COUNTRY;
    }

    public String getHOME_COUNTRYNAME() {
        return HOME_COUNTRYNAME;
    }

    public void setHOME_COUNTRYNAME(String HOME_COUNTRYNAME) {
        this.HOME_COUNTRYNAME = HOME_COUNTRYNAME;
    }

    public String getHOME_DISTRICT() {
        return HOME_DISTRICT;
    }

    public void setHOME_DISTRICT(String HOME_DISTRICT) {
        this.HOME_DISTRICT = HOME_DISTRICT;
    }

    public String getHOME_DISTRICTNO() {
        return HOME_DISTRICTNO;
    }

    public void setHOME_DISTRICTNO(String HOME_DISTRICTNO) {
        this.HOME_DISTRICTNO = HOME_DISTRICTNO;
    }

    public String getHOME_GUID() {
        return HOME_GUID;
    }

    public void setHOME_GUID(String HOME_GUID) {
        this.HOME_GUID = HOME_GUID;
    }

    public String getHOME_REGION() {
        return HOME_REGION;
    }

    public void setHOME_REGION(String HOME_REGION) {
        this.HOME_REGION = HOME_REGION;
    }

    public String getHOME_REGIONNAME() {
        return HOME_REGIONNAME;
    }

    public void setHOME_REGIONNAME(String HOME_REGIONNAME) {
        this.HOME_REGIONNAME = HOME_REGIONNAME;
    }

    public String getHOME_STREET() {
        return HOME_STREET;
    }

    public void setHOME_STREET(String HOME_STREET) {
        this.HOME_STREET = HOME_STREET;
    }

    public String getIDNUMBER() {
        return IDNUMBER;
    }

    public void setIDNUMBER(String IDNUMBER) {
        this.IDNUMBER = IDNUMBER;
    }

    public String getIMEX_CHK() {
        return IMEX_CHK;
    }

    public void setIMEX_CHK(String IMEX_CHK) {
        this.IMEX_CHK = IMEX_CHK;
    }

    public String getINFDA() {
        return INFDA;
    }

    public void setINFDA(String INFDA) {
        this.INFDA = INFDA;
    }

    public String getINRES() {
        return INRES;
    }

    public void setINRES(String INRES) {
        this.INRES = INRES;
    }

    public String getINREST() {
        return INREST;
    }

    public void setINREST(String INREST) {
        this.INREST = INREST;
    }

    public String getINSTA() {
        return INSTA;
    }

    public void setINSTA(String INSTA) {
        this.INSTA = INSTA;
    }

    public String getINSTAT() {
        return INSTAT;
    }

    public void setINSTAT(String INSTAT) {
        this.INSTAT = INSTAT;
    }

    public String getINTDA() {
        return INTDA;
    }

    public void setINTDA(String INTDA) {
        this.INTDA = INTDA;
    }

    public String getJNT_CIRCULAR() {
        return JNT_CIRCULAR;
    }

    public void setJNT_CIRCULAR(String JNT_CIRCULAR) {
        this.JNT_CIRCULAR = JNT_CIRCULAR;
    }

    public String getLEGAL_ENTY() {
        return LEGAL_ENTY;
    }

    public void setLEGAL_ENTY(String LEGAL_ENTY) {
        this.LEGAL_ENTY = LEGAL_ENTY;
    }

    public String getLEGAL_ENTYT() {
        return LEGAL_ENTYT;
    }

    public void setLEGAL_ENTYT(String LEGAL_ENTYT) {
        this.LEGAL_ENTYT = LEGAL_ENTYT;
    }

    public String getLEGAL_ORG() {
        return LEGAL_ORG;
    }

    public void setLEGAL_ORG(String LEGAL_ORG) {
        this.LEGAL_ORG = LEGAL_ORG;
    }

    public String getLEGAL_ORGT() {
        return LEGAL_ORGT;
    }

    public void setLEGAL_ORGT(String LEGAL_ORGT) {
        this.LEGAL_ORGT = LEGAL_ORGT;
    }

    public String getLTEXT() {
        return LTEXT;
    }

    public void setLTEXT(String LTEXT) {
        this.LTEXT = LTEXT;
    }

    public String getMANAG_CITYNAME() {
        return MANAG_CITYNAME;
    }

    public void setMANAG_CITYNAME(String MANAG_CITYNAME) {
        this.MANAG_CITYNAME = MANAG_CITYNAME;
    }

    public String getMANAG_CITY_CODE() {
        return MANAG_CITY_CODE;
    }

    public void setMANAG_CITY_CODE(String MANAG_CITY_CODE) {
        this.MANAG_CITY_CODE = MANAG_CITY_CODE;
    }

    public String getMANAG_COUNTRY() {
        return MANAG_COUNTRY;
    }

    public void setMANAG_COUNTRY(String MANAG_COUNTRY) {
        this.MANAG_COUNTRY = MANAG_COUNTRY;
    }

    public String getMANAG_COUNTRYNAME() {
        return MANAG_COUNTRYNAME;
    }

    public void setMANAG_COUNTRYNAME(String MANAG_COUNTRYNAME) {
        this.MANAG_COUNTRYNAME = MANAG_COUNTRYNAME;
    }

    public String getMANAG_DISTRICT() {
        return MANAG_DISTRICT;
    }

    public void setMANAG_DISTRICT(String MANAG_DISTRICT) {
        this.MANAG_DISTRICT = MANAG_DISTRICT;
    }

    public String getMANAG_DISTRICTNO() {
        return MANAG_DISTRICTNO;
    }

    public void setMANAG_DISTRICTNO(String MANAG_DISTRICTNO) {
        this.MANAG_DISTRICTNO = MANAG_DISTRICTNO;
    }

    public String getMANAG_E_MAIL() {
        return MANAG_E_MAIL;
    }

    public void setMANAG_E_MAIL(String MANAG_E_MAIL) {
        this.MANAG_E_MAIL = MANAG_E_MAIL;
    }

    public String getMANAG_GUID() {
        return MANAG_GUID;
    }

    public void setMANAG_GUID(String MANAG_GUID) {
        this.MANAG_GUID = MANAG_GUID;
    }

    public String getMANAG_ONAME() {
        return MANAG_ONAME;
    }

    public void setMANAG_ONAME(String MANAG_ONAME) {
        this.MANAG_ONAME = MANAG_ONAME;
    }

    public String getMANAG_REGION() {
        return MANAG_REGION;
    }

    public void setMANAG_REGION(String MANAG_REGION) {
        this.MANAG_REGION = MANAG_REGION;
    }

    public String getMANAG_REGIONNAME() {
        return MANAG_REGIONNAME;
    }

    public void setMANAG_REGIONNAME(String MANAG_REGIONNAME) {
        this.MANAG_REGIONNAME = MANAG_REGIONNAME;
    }

    public String getMANAG_STREET() {
        return MANAG_STREET;
    }

    public void setMANAG_STREET(String MANAG_STREET) {
        this.MANAG_STREET = MANAG_STREET;
    }

    public String getMANAG_TINOW() {
        return MANAG_TINOW;
    }

    public void setMANAG_TINOW(String MANAG_TINOW) {
        this.MANAG_TINOW = MANAG_TINOW;
    }

    public String getMARK() {
        return MARK;
    }

    public void setMARK(String MARK) {
        this.MARK = MARK;
    }

    public String getMINVN_ADDRESS() {
        return MINVN_ADDRESS;
    }

    public void setMINVN_ADDRESS(String MINVN_ADDRESS) {
        this.MINVN_ADDRESS = MINVN_ADDRESS;
    }

    public String getMINVN_EMAIL() {
        return MINVN_EMAIL;
    }

    public void setMINVN_EMAIL(String MINVN_EMAIL) {
        this.MINVN_EMAIL = MINVN_EMAIL;
    }

    public String getMINVN_NAME() {
        return MINVN_NAME;
    }

    public void setMINVN_NAME(String MINVN_NAME) {
        this.MINVN_NAME = MINVN_NAME;
    }

    public String getMINVN_PHONE() {
        return MINVN_PHONE;
    }

    public void setMINVN_PHONE(String MINVN_PHONE) {
        this.MINVN_PHONE = MINVN_PHONE;
    }

    public String getMOBIPHONE() {
        return MOBIPHONE;
    }

    public void setMOBIPHONE(String MOBIPHONE) {
        this.MOBIPHONE = MOBIPHONE;
    }

    public String getMOBIPHONEID() {
        return MOBIPHONEID;
    }

    public void setMOBIPHONEID(String MOBIPHONEID) {
        this.MOBIPHONEID = MOBIPHONEID;
    }

    public String getNATIONALITY() {
        return NATIONALITY;
    }

    public void setNATIONALITY(String NATIONALITY) {
        this.NATIONALITY = NATIONALITY;
    }

    public String getNATIO_COUNTRY() {
        return NATIO_COUNTRY;
    }

    public void setNATIO_COUNTRY(String NATIO_COUNTRY) {
        this.NATIO_COUNTRY = NATIO_COUNTRY;
    }

    public String getNONIE_CHK() {
        return NONIE_CHK;
    }

    public void setNONIE_CHK(String NONIE_CHK) {
        this.NONIE_CHK = NONIE_CHK;
    }

    public String getNUMEP() {
        return NUMEP;
    }

    public void setNUMEP(String NUMEP) {
        this.NUMEP = NUMEP;
    }

    public String getODA() {
        return ODA;
    }

    public void setODA(String ODA) {
        this.ODA = ODA;
    }

    public String getOLD_TIN() {
        return OLD_TIN;
    }

    public void setOLD_TIN(String OLD_TIN) {
        this.OLD_TIN = OLD_TIN;
    }

    public String getONAME() {
        return ONAME;
    }

    public void setONAME(String ONAME) {
        this.ONAME = ONAME;
    }

    public String getORFDA() {
        return ORFDA;
    }

    public void setORFDA(String ORFDA) {
        this.ORFDA = ORFDA;
    }

    public String getORGSTA() {
        return ORGSTA;
    }

    public void setORGSTA(String ORGSTA) {
        this.ORGSTA = ORGSTA;
    }

    public String getORGSTAT() {
        return ORGSTAT;
    }

    public void setORGSTAT(String ORGSTAT) {
        this.ORGSTAT = ORGSTAT;
    }

    public String getORRES() {
        return ORRES;
    }

    public void setORRES(String ORRES) {
        this.ORRES = ORRES;
    }

    public String getORREST() {
        return ORREST;
    }

    public void setORREST(String ORREST) {
        this.ORREST = ORREST;
    }

    public String getORTDA() {
        return ORTDA;
    }

    public void setORTDA(String ORTDA) {
        this.ORTDA = ORTDA;
    }

    public String getOTHCAP() {
        return OTHCAP;
    }

    public void setOTHCAP(String OTHCAP) {
        this.OTHCAP = OTHCAP;
    }

    public String getOTHCAPW() {
        return OTHCAPW;
    }

    public void setOTHCAPW(String OTHCAPW) {
        this.OTHCAPW = OTHCAPW;
    }

    public String getOTHER_PRO() {
        return OTHER_PRO;
    }

    public void setOTHER_PRO(String OTHER_PRO) {
        this.OTHER_PRO = OTHER_PRO;
    }

    public String getPARTNER() {
        return PARTNER;
    }

    public void setPARTNER(String PARTNER) {
        this.PARTNER = PARTNER;
    }

    public String getPARTNERINFO() {
        return PARTNERINFO;
    }

    public void setPARTNERINFO(String PARTNERINFO) {
        this.PARTNERINFO = PARTNERINFO;
    }

    public String getPERM_CITY() {
        return PERM_CITY;
    }

    public void setPERM_CITY(String PERM_CITY) {
        this.PERM_CITY = PERM_CITY;
    }

    public String getPERM_CITYNO() {
        return PERM_CITYNO;
    }

    public void setPERM_CITYNO(String PERM_CITYNO) {
        this.PERM_CITYNO = PERM_CITYNO;
    }

    public String getPERM_COUNTRY() {
        return PERM_COUNTRY;
    }

    public void setPERM_COUNTRY(String PERM_COUNTRY) {
        this.PERM_COUNTRY = PERM_COUNTRY;
    }

    public String getPERM_COUNTRYNAME() {
        return PERM_COUNTRYNAME;
    }

    public void setPERM_COUNTRYNAME(String PERM_COUNTRYNAME) {
        this.PERM_COUNTRYNAME = PERM_COUNTRYNAME;
    }

    public String getPERM_DISTRICT() {
        return PERM_DISTRICT;
    }

    public void setPERM_DISTRICT(String PERM_DISTRICT) {
        this.PERM_DISTRICT = PERM_DISTRICT;
    }

    public String getPERM_DISTRICTNO() {
        return PERM_DISTRICTNO;
    }

    public void setPERM_DISTRICTNO(String PERM_DISTRICTNO) {
        this.PERM_DISTRICTNO = PERM_DISTRICTNO;
    }

    public String getPERM_GUID() {
        return PERM_GUID;
    }

    public void setPERM_GUID(String PERM_GUID) {
        this.PERM_GUID = PERM_GUID;
    }

    public String getPERM_REGION() {
        return PERM_REGION;
    }

    public void setPERM_REGION(String PERM_REGION) {
        this.PERM_REGION = PERM_REGION;
    }

    public String getPERM_REGIONNAME() {
        return PERM_REGIONNAME;
    }

    public void setPERM_REGIONNAME(String PERM_REGIONNAME) {
        this.PERM_REGIONNAME = PERM_REGIONNAME;
    }

    public String getPERM_STREET() {
        return PERM_STREET;
    }

    public void setPERM_STREET(String PERM_STREET) {
        this.PERM_STREET = PERM_STREET;
    }

    public String getPRCTR() {
        return PRCTR;
    }

    public void setPRCTR(String PRCTR) {
        this.PRCTR = PRCTR;
    }

    public String getRECEIPT_DATE() {
        return RECEIPT_DATE;
    }

    public void setRECEIPT_DATE(String RECEIPT_DATE) {
        this.RECEIPT_DATE = RECEIPT_DATE;
    }

    public String getREG_CASE_DETAIL() {
        return REG_CASE_DETAIL;
    }

    public void setREG_CASE_DETAIL(String REG_CASE_DETAIL) {
        this.REG_CASE_DETAIL = REG_CASE_DETAIL;
    }

    public String getREG_CASE_ID() {
        return REG_CASE_ID;
    }

    public void setREG_CASE_ID(String REG_CASE_ID) {
        this.REG_CASE_ID = REG_CASE_ID;
    }

    public String getREORG_ID() {
        return REORG_ID;
    }

    public void setREORG_ID(String REORG_ID) {
        this.REORG_ID = REORG_ID;
    }

    public String getREORG_NAME() {
        return REORG_NAME;
    }

    public void setREORG_NAME(String REORG_NAME) {
        this.REORG_NAME = REORG_NAME;
    }

    public String getREPL_PAYAGENCY() {
        return REPL_PAYAGENCY;
    }

    public void setREPL_PAYAGENCY(String REPL_PAYAGENCY) {
        this.REPL_PAYAGENCY = REPL_PAYAGENCY;
    }

    public String getSEXFEMALE() {
        return SEXFEMALE;
    }

    public void setSEXFEMALE(String SEXFEMALE) {
        this.SEXFEMALE = SEXFEMALE;
    }

    public String getSEXMALE() {
        return SEXMALE;
    }

    public void setSEXMALE(String SEXMALE) {
        this.SEXMALE = SEXMALE;
    }

    public String getSTACAP() {
        return STACAP;
    }

    public void setSTACAP(String STACAP) {
        this.STACAP = STACAP;
    }

    public String getSTACAPW() {
        return STACAPW;
    }

    public void setSTACAPW(String STACAPW) {
        this.STACAPW = STACAPW;
    }

    public String getSTATE_PROP() {
        return STATE_PROP;
    }

    public void setSTATE_PROP(String STATE_PROP) {
        this.STATE_PROP = STATE_PROP;
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(String TELEPHONE) {
        this.TELEPHONE = TELEPHONE;
    }

    public String getTELEPHONEID() {
        return TELEPHONEID;
    }

    public void setTELEPHONEID(String TELEPHONEID) {
        this.TELEPHONEID = TELEPHONEID;
    }

    public String getTEXT40() {
        return TEXT40;
    }

    public void setTEXT40(String TEXT40) {
        this.TEXT40 = TEXT40;
    }

    public String getTOCAP() {
        return TOCAP;
    }

    public void setTOCAP(String TOCAP) {
        this.TOCAP = TOCAP;
    }

    public String getTOCAPW() {
        return TOCAPW;
    }

    public void setTOCAPW(String TOCAPW) {
        this.TOCAPW = TOCAPW;
    }

    public String getTRADE_NAME() {
        return TRADE_NAME;
    }

    public void setTRADE_NAME(String TRADE_NAME) {
        this.TRADE_NAME = TRADE_NAME;
    }

    public String getTREA_ACCO() {
        return TREA_ACCO;
    }

    public void setTREA_ACCO(String TREA_ACCO) {
        this.TREA_ACCO = TREA_ACCO;
    }

    public String getTREA_CODE() {
        return TREA_CODE;
    }

    public void setTREA_CODE(String TREA_CODE) {
        this.TREA_CODE = TREA_CODE;
    }

    public String getTREA_NAME() {
        return TREA_NAME;
    }

    public void setTREA_NAME(String TREA_NAME) {
        this.TREA_NAME = TREA_NAME;
    }

    public String getTWD_ADD() {
        return TWD_ADD;
    }

    public void setTWD_ADD(String TWD_ADD) {
        this.TWD_ADD = TWD_ADD;
    }

    public String getTWD_NAME() {
        return TWD_NAME;
    }

    public void setTWD_NAME(String TWD_NAME) {
        this.TWD_NAME = TWD_NAME;
    }

    public String getTWD_TIN() {
        return TWD_TIN;
    }

    public void setTWD_TIN(String TWD_TIN) {
        this.TWD_TIN = TWD_TIN;
    }

    public String getVATDESC() {
        return VATDESC;
    }

    public void setVATDESC(String VATDESC) {
        this.VATDESC = VATDESC;
    }

    public String getVATID() {
        return VATID;
    }

    public void setVATID(String VATID) {
        this.VATID = VATID;
    }

    public String getBANK_ACC_TEXT() {
        return BANK_ACC_TEXT;
    }

    public void setBANK_ACC_TEXT(String BANK_ACC_TEXT) {
        this.BANK_ACC_TEXT = BANK_ACC_TEXT;
    }

    public String getBANK_NAME_TEXT() {
        return BANK_NAME_TEXT;
    }

    public void setBANK_NAME_TEXT(String BANK_NAME_TEXT) {
        this.BANK_NAME_TEXT = BANK_NAME_TEXT;
    }

    public String getET_CLOSE_DATE() {
        return ET_CLOSE_DATE;
    }

    public void setET_CLOSE_DATE(String ET_CLOSE_DATE) {
        this.ET_CLOSE_DATE = ET_CLOSE_DATE;
    }

    public String getST_CLOSE_DATE() {
        return ST_CLOSE_DATE;
    }

    public void setST_CLOSE_DATE(String ST_CLOSE_DATE) {
        this.ST_CLOSE_DATE = ST_CLOSE_DATE;
    }

    public String getNNKD() {
        return NNKD;
    }

    public void setNNKD(String NNKD) {
        this.NNKD = NNKD;
    }

    public String getBRAN_TYPE() {
        return BRAN_TYPE;
    }

    public void setBRAN_TYPE(String BRAN_TYPE) {
        this.BRAN_TYPE = BRAN_TYPE;
    }

    public String getRESTORE_DATE() {
        return RESTORE_DATE;
    }

    public void setRESTORE_DATE(String RESTORE_DATE) {
        this.RESTORE_DATE = RESTORE_DATE;
    }

    public String getORRESBK() {
        return ORRESBK;
    }

    public void setORRESBK(String ORRESBK) {
        this.ORRESBK = ORRESBK;
    }

    public String getBUKRN() {
        return BUKRN;
    }

    public void setBUKRN(String BUKRN) {
        this.BUKRN = BUKRN;
    }

    public String getPROV_DES() {
        return PROV_DES;
    }

    public void setPROV_DES(String PROV_DES) {
        this.PROV_DES = PROV_DES;
    }

    public String getIDNUMBER_OLD() {
        return IDNUMBER_OLD;
    }

    public void setIDNUMBER_OLD(String IDNUMBER_OLD) {
        this.IDNUMBER_OLD = IDNUMBER_OLD;
    }

    public String getYN_BILL_STA() {
        return YN_BILL_STA;
    }

    public void setYN_BILL_STA(String YN_BILL_STA) {
        this.YN_BILL_STA = YN_BILL_STA;
    }

    public String getYN_BUSCER_RVK() {
        return YN_BUSCER_RVK;
    }

    public void setYN_BUSCER_RVK(String YN_BUSCER_RVK) {
        this.YN_BUSCER_RVK = YN_BUSCER_RVK;
    }

    public String getYN_CUSDUTYFSH() {
        return YN_CUSDUTYFSH;
    }

    public void setYN_CUSDUTYFSH(String YN_CUSDUTYFSH) {
        this.YN_CUSDUTYFSH = YN_CUSDUTYFSH;
    }

    public String getYN_FTAX() {
        return YN_FTAX;
    }

    public void setYN_FTAX(String YN_FTAX) {
        this.YN_FTAX = YN_FTAX;
    }

    public String getYN_NBRS() {
        return YN_NBRS;
    }

    public void setYN_NBRS(String YN_NBRS) {
        this.YN_NBRS = YN_NBRS;
    }

    public String getYN_REGCER_STA() {
        return YN_REGCER_STA;
    }

    public void setYN_REGCER_STA(String YN_REGCER_STA) {
        this.YN_REGCER_STA = YN_REGCER_STA;
    }

    public String getENTERPRISE_ID() {
        return ENTERPRISE_ID;
    }

    public void setENTERPRISE_ID(String ENTERPRISE_ID) {
        this.ENTERPRISE_ID = ENTERPRISE_ID;
    }   
    
}