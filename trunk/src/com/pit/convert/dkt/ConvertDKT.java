package com.pit.convert.dkt;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoRuntimeException;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;
import com.sap.conn.jco.ext.JCoSessionReference;
import com.sap.conn.jco.ext.SessionException;
import com.sap.conn.jco.ext.SessionReferenceProvider;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.pit.convert.system.Constants;

public class ConvertDKT {

    static String DESTINATION_NAME1 = "ABAP_AS_WITHOUT_POOL";
    static String DESTINATION_NAME2 = "ABAP_AS_WITH_POOL";

    static {
        Properties connectProperties = new Properties();
//        Connection type: Custom Application server 
//        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "10.64.111.14");
//        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "60");
//        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "600");
//        connectProperties.setProperty(DestinationDataProvider.JCO_USER, "haibv2");
//        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "haibv2");
//        connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "en");       
//        createDataFile(DESTINATION_NAME1, "jcoDestination", connectProperties);
//        connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "70");
//        connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "50");
//        createDataFile(DESTINATION_NAME2, "jcoDestination", connectProperties);
        //Connection type: Group/Server Selection   
        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "500"); 
        connectProperties.setProperty(DestinationDataProvider.JCO_MSHOST, "10.64.85.12");
        connectProperties.setProperty(DestinationDataProvider.JCO_R3NAME, "PE1");
        connectProperties.setProperty(DestinationDataProvider.JCO_GROUP, "PE1-GROUP");         
        connectProperties.setProperty(DestinationDataProvider.JCO_USER, "convert_dkt1");
        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "1234567");
        connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "en"); 
        createDataFile(DESTINATION_NAME1, "jcoDestination", connectProperties);
        connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "70");
        connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "50");
        createDataFile(DESTINATION_NAME2, "jcoDestination", connectProperties);

    }
    private static BlockingQueue<MultiStepJob> queue = new LinkedBlockingQueue<MultiStepJob>();
    private static long start_f1, end_f2, result;
    private static JCoFunctionTemplate convertDKTTemplate, convertLoadBPTemplate;
    private static JCoTable tblExCity, tblExDistrict, tblExLoadBP, tblExCountry, tbleExAddressGui, tbleRegtaxUpdate;
    //Danh sách NNT          
    private static ArrayList<DataNNT> arrNNT = new ArrayList<DataNNT>();
    // Log
    static LogManager lm = LogManager.getLogManager();
    static Logger logger;

    static void createDataFile(String name, String suffix, Properties properties) {
        File cfg = new File(name + "." + suffix);
        if (!cfg.exists()) {
            try {
                FileOutputStream fos = new FileOutputStream(cfg, false);
                properties.store(fos, "for tests only !");
                fos.close();
                DESTINATION_NAME1.startsWith("100");
            } catch (Exception e) {
                // throw new RuntimeException("Unable to create the destination file " + cfg.getName(), e);
                logger.log(Level.WARNING, "Unable to create the destination file " + cfg.getName(), e);
            }
        }
    }

    static void createDestinationDataFile(String destinationName, Properties connectProperties) {
        File destCfg = new File(destinationName + ".jcoDestination");
        try {
            FileOutputStream fos = new FileOutputStream(destCfg, false);
            connectProperties.store(fos, "for tests only !");
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException("Unable to create the destination files", e);
        }
    }

    interface MultiStepJob {

        boolean isFinished();

        public void runNextStep();

        String getName();

        public void cleanUp();
    }

    static class StatelessMultiStepExample implements MultiStepJob {

        static AtomicInteger JOB_COUNT = new AtomicInteger(0);
        int jobID = JOB_COUNT.addAndGet(1);
        int calls;
        JCoDestination destination;
        int executedCalls = 0;
        Exception ex = null;
        int remoteCounter;

        StatelessMultiStepExample(JCoDestination destination, int calls) {
            this.calls = calls;
            this.destination = destination;
        }

        public boolean isFinished() {
            return executedCalls >= calls || ex != null;
        }

        public String getName() {
            return "stateless Job-" + jobID;
        }

        public JCoDestination getDestionation() {
            return this.destination;
        }

        public void runNextStep() {
//              try
//              {
//                  JCoFunction incrementCounter = incrementCounterTemplate.getFunction();
//                  incrementCounter.execute(destination);
//                  JCoFunction getCounter = getCounterTemplate.getFunction();
//                  executedCalls++;
//
//                  if(isFinished())
//                  {
//                      getCounter.execute(destination);
//                      remoteCounter = getCounter.getExportParameterList().getInt("GET_VALUE");
//                  }
//              }
//              catch(JCoException je)
//              {
//                  ex = je;
//              }
//              catch(RuntimeException re)
//              {
//                  ex = re;
//              }
        }

        public void cleanUp() {
            StringBuilder sb = new StringBuilder("Task ").append(getName()).append(" is finished ");
            if (ex != null) {
                sb.append("with exception ").append(ex.toString());
            } else {
                sb.append("successful. Counter is ").append(remoteCounter);
            }
        }
    }

    static class StatefulMultiStepNNTExample extends StatelessMultiStepExample {

        DataNNT nnt = null;
        String c_add = "";
        String del_caco = "";

        StatefulMultiStepNNTExample(JCoDestination destination, int calls, DataNNT nnt, String c_add, String del_caco) {
            super(destination, calls);
            this.nnt = nnt;
            this.c_add = c_add;
            this.del_caco = del_caco;
        }

        @Override
        public String getName() {
            return "stateful Job-" + jobID;
        }

        @Override
        public synchronized void runNextStep() {

            JCoFunction fnConvertDKT = convertDKTTemplate.getFunction();
            try {

                JCoContext.begin(destination);
                //Header NNT
                JCoStructure strDataImport = fnConvertDKT.getImportParameterList().getStructure("I_REGTAX_ALL");
                /**
                 * Detail NNT
                 */
                //<!--01.REGTAX_ID_ALL -->
                JCoTable tDetail_01 = fnConvertDKT.getTableParameterList().getTable("T_REGTAX_ID_ALL");
                //<!-- 02.TAX_PAYABLE_ORG -->
                JCoTable tDetail_02 = fnConvertDKT.getTableParameterList().getTable("T_TAX_PAYABLE_ORG");
                //<!-- 03.BUSI_MAIN_ORG -->
                JCoTable tDetail_03 = fnConvertDKT.getTableParameterList().getTable("T_BUSI_MAIN_ORG");
                //<!-- 05.BRANCH_ORG -->
                JCoTable tDetail_05 = fnConvertDKT.getTableParameterList().getTable("T_BRANCH_ORG");
                //<!--06.SUBDIARY_ORG-->
                JCoTable tDetail_06 = fnConvertDKT.getTableParameterList().getTable("T_SUBDIARY_ORG");
                //<!-- 07.JOIN_ORG -->
                JCoTable tDetail_07 = fnConvertDKT.getTableParameterList().getTable("T_JOIN_ORG");
                //<!-- 08.WAREHOUSE_ORG -->
                JCoTable tDetail_08 = fnConvertDKT.getTableParameterList().getTable("T_WAREHOUSE_ORG");
                //<!-- 09.FOREIGNER_ORG -->
                JCoTable tDetail_09 = fnConvertDKT.getTableParameterList().getTable("T_FOREIGNER_ORG");
                //<!-- 10.SUBCONT_ORG-->
                JCoTable tDetail_10 = fnConvertDKT.getTableParameterList().getTable("T_SUBCONT_ORG");
                //<!-- 11.DIPLOMATIC_ORG -->
                JCoTable tDetail_11 = fnConvertDKT.getTableParameterList().getTable("T_DIPLOMATIC_ORG");
                //<!-- 12.PROJ_CONT_ORG-->
                JCoTable tDetail_12 = fnConvertDKT.getTableParameterList().getTable("T_PROJ_CONT_ORG");
                //<!-- 13.REGFORM -->
                JCoStructure strCloseConT = fnConvertDKT.getImportParameterList().getStructure("I_CLOSE_CONTI_ALL");
                //<!-- REGTAX_UPDATE -->
                JCoStructure strRegtaxUpdate = fnConvertDKT.getImportParameterList().getStructure("I_REGTAX_UPDATE");

                //**-----------------------------------------------------------------------*
                //**<!--Header NNT -->                                                     *
                //**-----------------------------------------------------------------------*

                fnConvertDKT.getImportParameterList().setValue("I_MODE_ALL", nnt.hdr.getMODE());//MODE 
                fnConvertDKT.getImportParameterList().setValue("I_CNVADDR", c_add);//Convert address
                fnConvertDKT.getImportParameterList().setValue("I_RM_COR_FLG", del_caco);//Delete CACO

                strDataImport.setValue("PARTNER", nnt.hdr.getPARTNER()); //IDNUMBER
                strDataImport.setValue("IDNUMBER", nnt.hdr.getIDNUMBER()); //IDNUMBER
                strDataImport.setValue("INSTA", nnt.hdr.getINSTA()); //INSTA
                strDataImport.setValue("BUKRS", nnt.hdr.getBUKRS()); //BUKRS                
                strDataImport.setValue("PRCTR", nnt.hdr.getPRCTR()); //PRCTR
                strDataImport.setValue("GSBER", nnt.hdr.getGSBER()); //GSBER
                strDataImport.setValue("FULLNAME", nnt.hdr.getFULLNAME()); //FULLNAME  
                strDataImport.setValue("BIRTHDATE", nnt.hdr.getBIRTHDATE()); // BIRTHDATE
                strDataImport.setValue("SEXMALE", nnt.hdr.getSEXMALE()); //SEXMALE
                strDataImport.setValue("NATIONALITY", nnt.hdr.getNATIONALITY()); //NATIONALITY                
                strDataImport.setValue("PERM_STREET", nnt.hdr.getPERM_STREET()); //PERM_STREET
                strDataImport.setValue("PERM_REGION", nnt.hdr.getPERM_REGION()); //PERM_REGION
                strDataImport.setValue("PERM_CITYNO", nnt.hdr.getPERM_CITYNO()); //PERM_CITYNO
                strDataImport.setValue("PERM_CITY", nnt.hdr.getPERM_CITY()); //PERM_CITY
                strDataImport.setValue("PERM_DISTRICTNO", nnt.hdr.getPERM_DISTRICTNO()); //PERM_DISTRICTNO
                strDataImport.setValue("PERM_DISTRICT", nnt.hdr.getPERM_DISTRICT()); //PERM_DISTRICT
                strDataImport.setValue("PERM_GUID", nnt.hdr.getPERM_GUID()); //PERM_GUID
                strDataImport.setValue("PERM_COUNTRY", nnt.hdr.getPERM_COUNTRY()); //PERM_COUNTRY                
                strDataImport.setValue("HOME_STREET", nnt.hdr.getHOME_STREET()); //HOME_STREET
                strDataImport.setValue("HOME_REGION", nnt.hdr.getHOME_REGION()); //HOME_REGION
                strDataImport.setValue("HOME_CITY", nnt.hdr.getHOME_CITY()); //HOME_CITY
                strDataImport.setValue("HOME_CITYNO", nnt.hdr.getHOME_CITYNO()); //HOME_CITYNO
                strDataImport.setValue("HOME_DISTRICTNO", nnt.hdr.getHOME_DISTRICTNO()); //HOME_DISTRICTNO
                strDataImport.setValue("HOME_DISTRICT", nnt.hdr.getHOME_DISTRICT()); //HOME_DISTRICT
                strDataImport.setValue("HOME_GUID", nnt.hdr.getHOME_GUID()); //HOME_GUID
                strDataImport.setValue("HOME_COUNTRY", nnt.hdr.getHOME_COUNTRY()); //HOME_COUNTRY               
                strDataImport.setValue("TELEPHONE", nnt.hdr.getTELEPHONE()); //TELEPHONE
                strDataImport.setValue("E_MAIL", nnt.hdr.getE_MAIL()); //E_MAIL
                strDataImport.setValue("RECEIPT_DATE", nnt.hdr.getRECEIPT_DATE()); //RECEIPT_DATE
                strDataImport.setValue("BPKIND", nnt.hdr.getBPKIND()); //BPKIND
                strDataImport.setValue("TRADE_NAME", nnt.hdr.getTRADE_NAME()); //TRADE_NAME
                strDataImport.setValue("ONAME", nnt.hdr.getONAME()); //ONAME
                strDataImport.setValue("ORGSTA", nnt.hdr.getORGSTA()); //ORGSTA
                strDataImport.setValue("IMEX_CHK", nnt.hdr.getIMEX_CHK()); //IMEX_CHK                
                strDataImport.setValue("NUMEP", nnt.hdr.getNUMEP()); //NUMEP                           
                strDataImport.setValue("FOUND_DAT", nnt.hdr.getFOUND_DAT()); //FOUND_DAT
                if (nnt.hdr.getTOCAP() != null) {
                    strDataImport.setValue("TOCAP", nnt.hdr.getTOCAP().replace(',', '.')); //TOCAP
                }                
                strDataImport.setValue("TOCAPW", nnt.hdr.getTOCAPW()); //TOCAPW
                if (nnt.hdr.getSTACAP() != null) {
                    strDataImport.setValue("STACAP", nnt.hdr.getSTACAP().replace(',', '.')); //STACAP
                }    
                if (nnt.hdr.getFORECAP() != null) {
                    strDataImport.setValue("FORECAP", nnt.hdr.getFORECAP().replace(',', '.')); //FORECAP
                }     
                if (nnt.hdr.getOTHCAP() != null) {
                    strDataImport.setValue("OTHCAP", nnt.hdr.getOTHCAP().replace(',', '.')); //OTHCAP
                }                
                strDataImport.setValue("STACAPW", nnt.hdr.getSTACAPW()); //STACAPW
                strDataImport.setValue("FORECAPW", nnt.hdr.getFORECAPW()); //FORECAPW
                strDataImport.setValue("OTHCAPW", nnt.hdr.getOTHCAPW()); //OTHCAPW
                if (nnt.hdr.getSTATE_PROP() != null) {
                    strDataImport.setValue("STATE_PROP", nnt.hdr.getSTATE_PROP().replace(',', '.')); //STATE_PROP
                }
                if (nnt.hdr.getFOREIGN_PRO() != null) {
                    strDataImport.setValue("FOREIGN_PRO", nnt.hdr.getFOREIGN_PRO().replace(',', '.')); //FOREIGN_PRO
                }
                if (nnt.hdr.getOTHER_PRO() != null) {
                    strDataImport.setValue("OTHER_PRO", nnt.hdr.getOTHER_PRO().replace(',', '.')); //OTHER_PRO
                }
                strDataImport.setValue("TREA_ACCO", nnt.hdr.getTREA_ACCO()); //TREA_ACCO
                strDataImport.setValue("TREA_CODE", nnt.hdr.getTREA_CODE()); //TREA_CODE
                strDataImport.setValue("LEGAL_ENTY", nnt.hdr.getLEGAL_ENTY()); //LEGAL_ENTY
                strDataImport.setValue("FINA_SDAT", nnt.hdr.getFINA_SDAT()); //FINA_SDAT
                strDataImport.setValue("FINA_EDAT", nnt.hdr.getFINA_EDAT()); //FINA_EDAT
                strDataImport.setValue("HASUB", nnt.hdr.getHASUB()); //HASUB
                strDataImport.setValue("HABRA", nnt.hdr.getHABRA()); //HABRA
                strDataImport.setValue("HAWHS", nnt.hdr.getHAWHS()); //HAWHS
                strDataImport.setValue("HAREP", nnt.hdr.getHAREP()); //HAREP
                strDataImport.setValue("HACWC", nnt.hdr.getHACWC()); //HACWC
                strDataImport.setValue("HAJOIN", nnt.hdr.getHAJOIN()); //HAJOIN
                strDataImport.setValue("REORG_ID", nnt.hdr.getREORG_ID()); //REORG_ID
                strDataImport.setValue("OLD_TIN", nnt.hdr.getOLD_TIN()); //OLD_TIN
                strDataImport.setValue("DIRNA", nnt.hdr.getDIRNA()); //DIRNA
                strDataImport.setValue("DIRFO", nnt.hdr.getDIRFO()); //DIRFO
                strDataImport.setValue("ACCNA", nnt.hdr.getACCNA()); //ACCNA
                strDataImport.setValue("ACCFO", nnt.hdr.getACCFO()); //ACCFO
                strDataImport.setValue("BU_STREET", nnt.hdr.getBU_STREET()); //BU_STREET
                strDataImport.setValue("BU_REGION", nnt.hdr.getBU_REGION()); //BU_REGION
                strDataImport.setValue("BU_COUNTRY", nnt.hdr.getBU_COUNTRY()); //BU_COUNTRY                
                strDataImport.setValue("BU_CITY_CODE", nnt.hdr.getBU_CITY_CODE()); //BU_CITY_CODE
                strDataImport.setValue("BU_CITYNAME", nnt.hdr.getBU_CITYNAME()); //BU_CITYNAME
                strDataImport.setValue("BU_DISTRICTNO", nnt.hdr.getBU_DISTRICTNO()); //BU_DISTRICTNO
                strDataImport.setValue("BU_DISTRICT", nnt.hdr.getBU_DISTRICT()); //BU_DISTRICT
                strDataImport.setValue("BU_GUID", nnt.hdr.getBU_GUID()); //BU_GUID
                strDataImport.setValue("BU_FAX_NUMBER", nnt.hdr.getBU_FAX_NUMBER()); //BU_FAX_NUMBER
                strDataImport.setValue("BU_TEL_NUMBER", nnt.hdr.getBU_TEL_NUMBER()); //BU_TEL_NUMBER
                strDataImport.setValue("BU_E_MAIL", nnt.hdr.getBU_E_MAIL()); //BU_E_MAIL
                strDataImport.setValue("CO_STREET", nnt.hdr.getCO_STREET()); //CO_STREET
                strDataImport.setValue("CO_REGION", nnt.hdr.getCO_REGION()); //CO_REGION
                strDataImport.setValue("CO_COUNTRY", nnt.hdr.getCO_COUNTRY()); //CO_COUNTRY                
                strDataImport.setValue("CO_CITY_CODE", nnt.hdr.getCO_CITY_CODE()); //CO_CITY_CODE
                strDataImport.setValue("CO_CITYNAME", nnt.hdr.getCO_CITYNAME()); //CO_CITYNAME
                strDataImport.setValue("CO_DISTRICTNO", nnt.hdr.getCO_DISTRICTNO()); //CO_DISTRICTNO
                strDataImport.setValue("CO_DISTRICT", nnt.hdr.getCO_DISTRICT()); //CO_DISTRICT
                strDataImport.setValue("CO_GUID", nnt.hdr.getCO_GUID()); //CO_GUID
                strDataImport.setValue("CO_FAX_NUMBER", nnt.hdr.getCO_FAX_NUMBER()); //CO_FAX_NUMBER
                strDataImport.setValue("CO_TEL_NUMBER", nnt.hdr.getCO_TEL_NUMBER()); //CO_TEL_NUMBER
                strDataImport.setValue("CO_E_MAIL", nnt.hdr.getCO_E_MAIL()); //CO_E_MAIL
                strDataImport.setValue("MANAG_TINOW", nnt.hdr.getMANAG_TINOW()); //MANAG_TINOW
                strDataImport.setValue("MANAG_STREET", nnt.hdr.getMANAG_STREET()); //MANAG_STREET
                strDataImport.setValue("MANAG_REGION", nnt.hdr.getMANAG_REGION()); //MANAG_REGION
                strDataImport.setValue("MANAG_ONAME", nnt.hdr.getMANAG_ONAME()); //MANAG_ONAME
                strDataImport.setValue("MANAG_COUNTRY", nnt.hdr.getMANAG_COUNTRY()); //MANAG_COUNTRY                
                strDataImport.setValue("MANAG_CITY_CODE", nnt.hdr.getMANAG_CITY_CODE()); //MANAG_CITY_CODE
                strDataImport.setValue("MANAG_CITYNAME", nnt.hdr.getMANAG_CITYNAME()); //MANAG_CITYNAME
                strDataImport.setValue("MANAG_DISTRICTNO", nnt.hdr.getMANAG_DISTRICTNO()); //MANAG_DISTRICTNO
                strDataImport.setValue("MANAG_DISTRICT", nnt.hdr.getMANAG_DISTRICT()); //MANAG_DISTRICT
                strDataImport.setValue("MANAG_E_MAIL", nnt.hdr.getMANAG_E_MAIL()); //MANAG_E_MAIL
                strDataImport.setValue("BUINFO_NAME_FIRST", nnt.hdr.getBUINFO_NAME_FIRST()); //BUINFO_NAME_FIRST
                strDataImport.setValue("BUINFO_BIRTHDATE", nnt.hdr.getBUINFO_BIRTHDATE()); //BUINFO_BIRTHDATE
                strDataImport.setValue("BUINFO_STREET", nnt.hdr.getBUINFO_STREET()); //BUINFO_STREET
                strDataImport.setValue("BUINFO_TEL_NUMBER", nnt.hdr.getBUINFO_TEL_NUMBER()); //BUINFO_TEL_NUMBER
                strDataImport.setValue("BUINFO_CITY_CODE", nnt.hdr.getBUINFO_CITY_CODE()); //BUINFO_CITY_CODE
                strDataImport.setValue("BUINFO_CITYNAME", nnt.hdr.getBUINFO_CITYNAME()); //BUINFO_CITYNAME
                strDataImport.setValue("BUINFO_DISTRICTNO", nnt.hdr.getBUINFO_DISTRICTNO()); //BUINFO_DISTRICTNO
                strDataImport.setValue("BUINFO_DISTRICT", nnt.hdr.getBUINFO_DISTRICT()); //BUINFO_DISTRICT
                strDataImport.setValue("BUINFO_GUID", nnt.hdr.getBUINFO_GUID()); //BUINFO
                strDataImport.setValue("BUINFO_REGION", nnt.hdr.getBUINFO_REGION()); //BUINFO_REGION
                strDataImport.setValue("BUINFO_COUNTRY", nnt.hdr.getBUINFO_COUNTRY()); //BUINFO_COUNTRY               
                strDataImport.setValue("BUINFO_FAX_NUMBER", nnt.hdr.getBUINFO_FAX_NUMBER()); //BUINFO_FAX_NUMBER
                strDataImport.setValue("BUINFO_E_MAIL", nnt.hdr.getBUINFO_E_MAIL()); //BUINFO_E_MAIL
                strDataImport.setValue("ADVN_STREET", nnt.hdr.getADVN_STREET()); //ADVN_STREET
                strDataImport.setValue("ADVN_CITY_CODE", nnt.hdr.getADVN_CITY_CODE()); //ADVN_CITY_CODE
                strDataImport.setValue("ADVN_CITYNAME", nnt.hdr.getADVN_CITYNAME()); //ADVN_CITYNAME
                strDataImport.setValue("ADVN_DISTRICTNO", nnt.hdr.getADVN_DISTRICTNO()); //ADVN_DISTRICTNO
                strDataImport.setValue("ADVN_DISTRICT", nnt.hdr.getADVN_DISTRICT()); //ADVN_DISTRICT
                strDataImport.setValue("ADVN_GUID", nnt.hdr.getADVN_GUID()); //ADVN_GUID
                strDataImport.setValue("ADVN_REGION", nnt.hdr.getADVN_REGION()); //ADVN_REGION
                strDataImport.setValue("ADVN_COUNTRY", nnt.hdr.getADVN_COUNTRY()); //ADVN_COUNTRY                
                strDataImport.setValue("ADVN_TEL_NUMBER", nnt.hdr.getADVN_TEL_NUMBER()); //ADVN_TEL_NUMBER
                strDataImport.setValue("ADVN_FAX_NUMBER", nnt.hdr.getADVN_FAX_NUMBER()); //ADVN_FAX_NUMBER
                strDataImport.setValue("ADVN_E_MAIL", nnt.hdr.getADVN_E_MAIL()); //ADVN_E_MAIL
                strDataImport.setValue("LEGAL_ORG", nnt.hdr.getLEGAL_ORG()); //LEGAL_ORG
                strDataImport.setValue("ECO_ID", nnt.hdr.getECO_ID()); //ECO_ID
                strDataImport.setValue("ACC_DEPEND", nnt.hdr.getACC_DEPEND()); //ACC_DEPEND
                strDataImport.setValue("JNT_CIRCULAR", nnt.hdr.getJNT_CIRCULAR()); //JNT_CIRCULAR
                strDataImport.setValue("REPL_PAYAGENCY", nnt.hdr.getREPL_PAYAGENCY()); //REPL_PAYAGENCY
                strDataImport.setValue("CONT_TINVN", nnt.hdr.getCONT_TINVN()); //CONT_TINVN
                strDataImport.setValue("CONT_COFDA", nnt.hdr.getCONT_COFDA()); //CONT_COFDA
                strDataImport.setValue("CONT_COTDA", nnt.hdr.getCONT_COTDA()); //CONT_COTDA
                strDataImport.setValue("CONT_WADDR", nnt.hdr.getCONT_WADDR()); //CONT_WADDR
                strDataImport.setValue("ATT_DOC", nnt.hdr.getATT_DOC()); //ATT_DOC
                strDataImport.setValue("ORRES", nnt.hdr.getORRES()); //ORRES
                strDataImport.setValue("FRN_STREET", nnt.hdr.getFRN_STREET()); //FRN_STREET
                strDataImport.setValue("FRN_TEL_NUMBER", nnt.hdr.getFRN_TEL_NUMBER()); //FRN_TEL_NUMBER
                strDataImport.setValue("FRN_FAX_NUMBER", nnt.hdr.getFRN_FAX_NUMBER()); //FRN_FAX_NUMBER
                strDataImport.setValue("FRN_COUNTRY", nnt.hdr.getFRN_COUNTRY()); //FRN_COUNTRY          
                strDataImport.setValue("FRN_GUID", nnt.hdr.getFRN_GUID()); //FRN_GUID
                strDataImport.setValue("TWD_TIN", nnt.hdr.getTWD_TIN()); //TWD_TIN
                strDataImport.setValue("REG_CASE_ID", nnt.hdr.getREG_CASE_ID()); //REG_CASE_ID
                strDataImport.setValue("BANK_NAME_TEXT", nnt.hdr.getBANK_NAME_TEXT());//BANK_NAME_TEXT
                strDataImport.setValue("BANK_ACC_TEXT", nnt.hdr.getBANK_ACC_TEXT());//BANK_ACC_TEXT
                strDataImport.setValue("ET_CLOSE_DATE", nnt.hdr.getET_CLOSE_DATE());//ET_CLOSE_DATE
                strDataImport.setValue("NNKD", nnt.hdr.getNNKD());//NNKD
                strDataImport.setValue("BRAN_TYPE", nnt.hdr.getBRAN_TYPE());//BRAN_TYPE
                strDataImport.setValue("RESTORE_DATE", nnt.hdr.getRESTORE_DATE());//RESTORE_DATE
                strDataImport.setValue("ST_CLOSE_DATE", nnt.hdr.getST_CLOSE_DATE());//ST_CLOSE_DATE
                strDataImport.setValue("INFDA", nnt.hdr.getINFDA());//INFDA
                strDataImport.setValue("ORFDA", nnt.hdr.getORFDA());//ORFDA   
                strDataImport.setValue("VATID", nnt.hdr.getVATID());//VATID
                strDataImport.setValue("ACTI_GOAL", nnt.hdr.getACTI_GOAL());//ACTI_GOAL
                strDataImport.setValue("ODA", nnt.hdr.getODA());//ODA
                strDataImport.setValue("ORRESBK", nnt.hdr.getORRESBK());//ORRESBK
                strDataImport.setValue("PROV_DES", nnt.hdr.getPROV_DES());//PROV_DES
                strDataImport.setValue("BUKRN", nnt.hdr.getBUKRN());//BUKRN            
                strDataImport.setValue("YN_NBRS", nnt.hdr.getYN_NBRS());//YN_NBRS   
                strDataImport.setValue("ENTERPRISE_ID", nnt.hdr.getENTERPRISE_ID());//ENTERPRISE_ID

                //**-----------------------------------------------------------------------*
                //**<!--01.REGTAX_ID_ALL -->                                               *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < nnt.regtax_id_all.size(); r++) {

                    // Kiểm tra TYPE ko có thì ko truyền sang
                    if (nnt.regtax_id_all.get(r).getTYPE() != null && nnt.regtax_id_all.get(r).getIDNUMBER() != null) {                        
                        tDetail_01.appendRow();
                        tDetail_01.setValue("TYPE", nnt.regtax_id_all.get(r).getTYPE());
                        if(nnt.regtax_id_all.get(r).getTYPE().equals(Constants.IDTYPE_1010)){
                            tDetail_01.setValue("COUNTRY", "VN");                            
                        }                                                                
                        tDetail_01.setValue("IDNUMBER", nnt.regtax_id_all.get(r).getIDNUMBER().toUpperCase());
                        tDetail_01.setValue("INSTITUTE", nnt.regtax_id_all.get(r).getINSTITUTE());
                        tDetail_01.setValue("ENTRY_DATE", nnt.regtax_id_all.get(r).getENTRY_DATE());
                    }
                }

                //**-----------------------------------------------------------------------*
                //**<!-- 02.TAX_PAYABLE_ORG -->                                            *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < nnt.tax_payable.size(); r++) {
                    tDetail_02.appendRow();
                    tDetail_02.setValue("ITEM_ID", nnt.tax_payable.get(r).getItem_id());
                }

                //**-----------------------------------------------------------------------*
                //**<!-- 03.BUSI_MAIN_ORG -->                                              *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < nnt.busi_main.size(); r++) {
                    tDetail_03.appendRow();
                    tDetail_03.setValue("IND_SECTOR", nnt.busi_main.get(r).getIND_SECTOR());
                    tDetail_03.setValue("ISDEF", nnt.busi_main.get(r).getISDEF());
                }

                //**-----------------------------------------------------------------------*
                //**<!-- 05.BRANCH_ORG -->                                                 *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < nnt.branch_org.size(); r++) {
                    tDetail_05.appendRow();                    
                    tDetail_05.setValue("BRA_TIN", nnt.branch_org.get(r).getBRA_TIN());
                    tDetail_05.setValue("NAME", nnt.branch_org.get(r).getNAME());
                    tDetail_05.setValue("ADDRESS", nnt.branch_org.get(r).getADDRESS());
                    tDetail_05.setValue("REGION", nnt.branch_org.get(r).getREGION());
                    tDetail_05.setValue("CITY_CODE", nnt.branch_org.get(r).getCITY_CODE());
                    tDetail_05.setValue("STATUS", nnt.branch_org.get(r).getSTATUS());
                    tDetail_05.setValue("TYPE", nnt.branch_org.get(r).getTYPE());
                }
                //**-----------------------------------------------------------------------*
                //**<!--06.SUBDIARY_ORG-->                                                 *
                //**-----------------------------------------------------------------------*
                for (int r = 0; r < nnt.subdiary.size(); r++) {
                    tDetail_06.appendRow();
                    tDetail_06.setValue("SUB_TIN", nnt.subdiary.get(r).getSUB_TIN());
                    tDetail_06.setValue("SUB_ID_TINC", nnt.subdiary.get(r).getSUB_ID_TINC());
                    tDetail_06.setValue("NAME", nnt.subdiary.get(r).getNAME());
                    tDetail_06.setValue("ADDRESS", nnt.subdiary.get(r).getADDRESS());
                    tDetail_06.setValue("REGION", nnt.subdiary.get(r).getREGION());
                    tDetail_06.setValue("CITY_CODE", nnt.subdiary.get(r).getCITY_CODE());
                }
                //**-----------------------------------------------------------------------*
                //**<!-- 07.JOIN_ORG -->                                                   *
                //**-----------------------------------------------------------------------*
                for (int r = 0; r < nnt.join_org.size(); r++) {
                    tDetail_07.appendRow();
                    tDetail_07.setValue("JOIN_TIN", nnt.join_org.get(r).getJOIN_TIN());
                    tDetail_07.setValue("JOIN_ID_TINC", nnt.join_org.get(r).getJOIN_ID_TINC());
                    tDetail_07.setValue("NAME", nnt.join_org.get(r).getNAME());
                    tDetail_07.setValue("ADDRESS", nnt.join_org.get(r).getADDRESS());
                    tDetail_07.setValue("REGION", nnt.join_org.get(r).getREGION());
                    tDetail_07.setValue("CITY", nnt.join_org.get(r).getCITY());
                }

                //**-----------------------------------------------------------------------*
                //**<!-- 08.WAREHOUSE_ORG -->                                              *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < nnt.warehouse.size(); r++) {
                    tDetail_08.appendRow();
                    tDetail_08.setValue("TIN_WARE_ID", nnt.warehouse.get(r).getTIN_WARE_ID());
                    tDetail_08.setValue("DKDN_WAR_ID", nnt.warehouse.get(r).getDKDN_WAR_ID());
                    tDetail_08.setValue("NAME", nnt.warehouse.get(r).getNAME());
                    tDetail_08.setValue("ADDRESS", nnt.warehouse.get(r).getADDRESS());
                    tDetail_08.setValue("REGION", nnt.warehouse.get(r).getREGION());
                    tDetail_08.setValue("CITY", nnt.warehouse.get(r).getCITY());
                    tDetail_08.setValue("TYPE", nnt.warehouse.get(r).getTYPE());
                }

                //**-----------------------------------------------------------------------*
                //**<!-- 09.FOREIGNER_ORG -->                                              *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < nnt.foreigner.size(); r++) {
                    tDetail_09.appendRow();
                    tDetail_09.setValue("CONT_ID_TINC", nnt.foreigner.get(r).getCONT_ID_TINC());
                    tDetail_09.setValue("NAME", nnt.foreigner.get(r).getNAME());
                    tDetail_09.setValue("COUNTRY", nnt.foreigner.get(r).getCOUNTRY());
                    tDetail_09.setValue("TINVN", nnt.foreigner.get(r).getTINVN());
                    tDetail_09.setValue("TINFR", nnt.foreigner.get(r).getTINFR());
                    tDetail_09.setValue("CTNO", nnt.foreigner.get(r).getCTNO());
                    if (nnt.foreigner.get(r).getCTVAL() != null) {
                    tDetail_09.setValue("CTVAL", nnt.foreigner.get(r).getCTVAL().replace(',', '.')); //CTVAL
                    }                    
                    tDetail_09.setValue("CTVALW", nnt.foreigner.get(r).getCTVALW());
                    tDetail_09.setValue("COFDA", nnt.foreigner.get(r).getCOFDA());
                    tDetail_09.setValue("COTDA", nnt.foreigner.get(r).getCOTDA());
                    tDetail_09.setValue("EMPNB", nnt.foreigner.get(r).getEMPNB());
                    tDetail_09.setValue("BUSS_LICE", nnt.foreigner.get(r).getBUSS_LICE());
                    tDetail_09.setValue("BUSS_DATE", nnt.foreigner.get(r).getBUSS_DATE());
                    tDetail_09.setValue("BUSS_OFFI", nnt.foreigner.get(r).getBUSS_OFFI());
                    tDetail_09.setValue("CONT_OBJECT", nnt.foreigner.get(r).getCONT_OBJECT());
                    tDetail_09.setValue("CONT_LOCA", nnt.foreigner.get(r).getCONT_LOCA());
                    tDetail_09.setValue("BEGIN_DATE", nnt.foreigner.get(r).getBEGIN_DATE());
                    tDetail_09.setValue("YN_CONT", nnt.foreigner.get(r).getYN_CONT());
                    tDetail_09.setValue("VAT_ITEM", nnt.foreigner.get(r).getVAT_ITEM());
                    tDetail_09.setValue("REVE_ITEM", nnt.foreigner.get(r).getREVE_ITEM());
                    tDetail_09.setValue("INCO_ITEM", nnt.foreigner.get(r).getINCO_ITEM());
                    tDetail_09.setValue("RESU_METH", nnt.foreigner.get(r).getRESU_METH());
                    tDetail_09.setValue("CONT_TYPE", nnt.foreigner.get(r).getCONT_TYPE());
                    tDetail_09.setValue("ATT_DOC", nnt.foreigner.get(r).getATT_DOC());
                }
                //**-----------------------------------------------------------------------*
                //**<!-- 10.SUBCONT_ORG-->                                                 *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < nnt.subcont.size(); r++) {
                    tDetail_10.appendRow();
                    tDetail_10.setValue("CONT_ID_TINC", nnt.subcont.get(r).getCONT_ID_TINC()); 
                    tDetail_10.setValue("SUBCON_ID_TINC", nnt.subcont.get(r).getSUBCON_ID_TINC());
                    tDetail_10.setValue("NAME", nnt.subcont.get(r).getNAME());
                    tDetail_10.setValue("COUNTRY", nnt.subcont.get(r).getCOUNTRY());
                    tDetail_10.setValue("TINVN", nnt.subcont.get(r).getTINVN());
                    tDetail_10.setValue("TINFR", nnt.subcont.get(r).getTINFR());
                    tDetail_10.setValue("CTNO", nnt.subcont.get(r).getCTNO());
                    if (nnt.subcont.get(r).getCTVAL() != null) {
                    tDetail_10.setValue("CTVAL", nnt.subcont.get(r).getCTVAL().replace(',', '.')); //CTVAL
                    }
                    tDetail_10.setValue("CTVALW", nnt.subcont.get(r).getCTVALW());
                    tDetail_10.setValue("CONT_LOCA", nnt.subcont.get(r).getCONT_LOCA());
                    tDetail_10.setValue("EMPNB", nnt.subcont.get(r).getEMPNB());
                }
                //**-----------------------------------------------------------------------*
                //**<!-- 11.DIPLOMATIC_ORG -->                                             *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < nnt.Diplomatic.size(); r++) {
                    tDetail_11.appendRow();
                    tDetail_11.setValue("STAFF_ID_TINC", nnt.Diplomatic.get(r).getSTAFF_ID_TINC());
                    tDetail_11.setValue("NAME", nnt.Diplomatic.get(r).getNAME());
                    tDetail_11.setValue("NATIONALITY", nnt.Diplomatic.get(r).getNATIONALITY());
                    tDetail_11.setValue("STAFF_POS", nnt.Diplomatic.get(r).getSTAFF_POS());
                    tDetail_11.setValue("ID_CARD_NO", nnt.Diplomatic.get(r).getID_CARD_NO());
                }

                //**-----------------------------------------------------------------------*
                //**<!-- 12.PROJ_CONT_ORG-->                                               *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < nnt.proj_cont.size(); r++) {
                    tDetail_12.appendRow();
                    tDetail_12.setValue("PROCON_TIN", nnt.proj_cont.get(r).getPROCON_TIN());
                    tDetail_12.setValue("NAME", nnt.proj_cont.get(r).getNAME());                    
                    tDetail_12.setValue("COUNTRY", nnt.proj_cont.get(r).getCOUNTRY());
                    tDetail_12.setValue("REGION", nnt.proj_cont.get(r).getREGION());
                    tDetail_12.setValue("CITY_CODE", nnt.proj_cont.get(r).getCITY_CODE());
                    tDetail_12.setValue("CTNO", nnt.proj_cont.get(r).getCTNO());
                    if (nnt.proj_cont.get(r).getCTVAL() != null) {
                    tDetail_12.setValue("CTVAL", nnt.proj_cont.get(r).getCTVAL().replace(',', '.')); //CTVAL
                    }                    
                    tDetail_12.setValue("CTVALW", nnt.proj_cont.get(r).getCTVALW());
                    tDetail_12.setValue("CONT_DATE", nnt.proj_cont.get(r).getCONT_DATE());
                    tDetail_12.setValue("EMPL_NO", nnt.proj_cont.get(r).getEMPL_NO());
                    tDetail_12.setValue("STATUS", nnt.proj_cont.get(r).getSTATUS());
                }
                //**-----------------------------------------------------------------------*
                //**<!-- 13.REG_FORM -->                                                   *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < nnt.reg_form.size(); r++) {
                    /**                     
                     *       Phần này bên export để dạng table
                     *       Bên SAP nhận vào để dạng import tức 1 record truyền vào
                     *       Nên Tool sẽ làm nhận vào kiểu table nếu xẩy ra trường hợp > 1 record
                     *       thì sẽ chỉ sửa lại đầu SAP, đầu tool sửa lại chút thôi < hic .. hic>
                     */
                    strCloseConT.setValue("REGCER_RVK", nnt.reg_form.get(r).getREGCER_RVK());
                    strCloseConT.setValue("REGCER_LST", nnt.reg_form.get(r).getREGCER_LST());
                    strCloseConT.setValue("FINAL_TAX", nnt.reg_form.get(r).getFINAL_TAX());
                    strCloseConT.setValue("BILL_SETTELED", nnt.reg_form.get(r).getBILL_SETTELED());
                    strCloseConT.setValue("BILL_NOTUSED", nnt.reg_form.get(r).getBILL_NOTUSED());
                    strCloseConT.setValue("CUSDUTY_FSH", nnt.reg_form.get(r).getCUSDUTY_FSH());
                    strCloseConT.setValue("BUSCER_RVK", nnt.reg_form.get(r).getBUSCER_RVK());
                    strCloseConT.setValue("NO_DEBT", nnt.reg_form.get(r).getNO_DEBT());
                    strCloseConT.setValue("BRH_TIN_CLS", nnt.reg_form.get(r).getBRH_TIN_CLS());
                }

                //**-----------------------------------------------------------------------*
                //**<!-- REGTAX_UPDATE - Thông tin chung đăng ký thuế cho doanh  nghiệp  -->                                                    *
                //**-----------------------------------------------------------------------*
                //Modify by QuanPTT                  
                strRegtaxUpdate.setValue("PARTNER", nnt.retax_update.getPARTNER());
                strRegtaxUpdate.setValue("TYPE", nnt.retax_update.getTYPE());
                strRegtaxUpdate.setValue("ORSTA", nnt.retax_update.getORSTA());
                strRegtaxUpdate.setValue("ORRES", nnt.retax_update.getORRES());
                strRegtaxUpdate.setValue("BUKRS", nnt.retax_update.getBUKRS());
                strRegtaxUpdate.setValue("REDAT", nnt.retax_update.getREDAT());
                strRegtaxUpdate.setValue("PRCTR", nnt.retax_update.getPRCTR());
                strRegtaxUpdate.setValue("GSBER", nnt.retax_update.getGSBER());
                strRegtaxUpdate.setValue("BPKIND", nnt.retax_update.getBPKIND());

                //**-----------------------------------------------------------------------*
                //**Get value parameter and execute                                        *
                //**-----------------------------------------------------------------------*
                //Header
                fnConvertDKT.getImportParameterList().setValue("I_REGTAX_ALL", strDataImport);
                //REG_FORM
                fnConvertDKT.getImportParameterList().setValue("I_CLOSE_CONTI_ALL", strCloseConT);
                //REGTAX_UPDAT
                fnConvertDKT.getImportParameterList().setValue("I_REGTAX_UPDATE", strRegtaxUpdate);

                fnConvertDKT.execute(destination);

                executedCalls++;
                JCoContext.end(destination);

                //**-----------------------------------------------------------------------*
                //**Get execute result                                                     *
                //**-----------------------------------------------------------------------*       
                JCoTable tReturn = fnConvertDKT.getTableParameterList().getTable("T_RETURN_ALL");
                int rows = tReturn.getNumRows();
                tReturn.firstRow();
                logger = Logger.getLogger("ConvertDKT");
                for (int a = 0; a < rows; a++) {
                    //Write log Return error
                    if (tReturn.getString("TYPE").equals("E")) {
                        tReturn.setRow(a);
                        logger.log(Level.INFO, "{0}:{1}:{2}:{3}", new Object[]{ReadXML.getFile_name(), nnt.hdr.getIDNUMBER(), tReturn.getString("NUMBER"), tReturn.getString("MESSAGE")});
                    }
                }
            } catch (JCoException je) {
                je.printStackTrace();
                ex = je;
                logger.log(Level.WARNING, "JCoException: -- ", je + " *** INFO WARNING: File name: " + ReadXML.getFile_name() + " | TIN: " + nnt.hdr.getIDNUMBER());
            } catch (RuntimeException re) {
                ex = re;
                 re.printStackTrace();
                logger.log(Level.WARNING, "RunTimeException:-- ", re + " *** INFO WARNING: File name: " + ReadXML.getFile_name() + " | TIN: " + nnt.hdr.getIDNUMBER());
            } finally {
                executedCalls++;
            }

        }

        @Override
        public void cleanUp() {
            try {
                JCoContext.end(destination);
            } catch (JCoException je) {
                ex = je;
                logger.log(Level.WARNING, "JCoException: ", je);
            }
            super.cleanUp();
        }
    }

    static class MySessionReferenceProvider implements SessionReferenceProvider {

        public JCoSessionReference getCurrentSessionReference(String scopeType) {
            MySessionReference sesRef = WorkerThread.localSessionReference.get();
            if (sesRef != null) {
                return sesRef;
            }

            throw new RuntimeException("Unknown thread:" + Thread.currentThread().getId());
        }

        public boolean isSessionAlive(String sessionId) {
            Collection<MySessionReference> availableSessions = WorkerThread.sessions.values();
            for (MySessionReference ref : availableSessions) {
                if (ref.getID().equals(sessionId)) {
                    return true;
                }
            }
            return false;
        }

        public void jcoServerSessionContinued(String sessionID) throws SessionException {
        }

        public void jcoServerSessionFinished(String sessionID) {
        }

        public void jcoServerSessionPassivated(String sessionID) throws SessionException {
        }

        public JCoSessionReference jcoServerSessionStarted() throws SessionException {
            return null;
        }
    }

    static class MySessionReference implements JCoSessionReference {

        static AtomicInteger atomicInt = new AtomicInteger(0);
        private String id = "session-" + String.valueOf(atomicInt.addAndGet(1));

        ;

          public void contextFinished() {
        }

        public void contextStarted() {
        }

        public String getID() {
            return id;
        }
    }

    static class WorkerThread extends Thread {

        static Hashtable<MultiStepJob, MySessionReference> sessions = new Hashtable<MultiStepJob, MySessionReference>();
        static ThreadLocal<MySessionReference> localSessionReference = new ThreadLocal<MySessionReference>();
        private CountDownLatch doneSignal;

        WorkerThread(CountDownLatch doneSignal) {
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                for (;;) {
                    MultiStepJob job = queue.poll(0, TimeUnit.MILLISECONDS);

                    //stop if nothing to do
                    if (job == null) {
                        return;
                    }
                    MySessionReference sesRef = sessions.get(job);
                    if (sesRef == null) {
                        sesRef = new MySessionReference();
                        sessions.put(job, sesRef);
                    }
                    localSessionReference.set(sesRef);

                    //System.out.println("Task "+job.getName()+" is started.");
                    try {
                        job.runNextStep();
                    } catch (Throwable th) {
                    }
                    if (job.isFinished()) {
                        //System.out.println("Task "+job.getName()+" is finished.");                          
                        sessions.remove(job);
                        job.cleanUp();
                    } else {
                        System.out.println("Task " + job.getName() + " is passivated.");
                        queue.add(job);
                    }
                    localSessionReference.set(null);
                }
            } catch (InterruptedException e) {
                //just leave
                logger.log(Level.WARNING, "InterruptException:", e);
            } finally {
                doneSignal.countDown();
            }
        }
    }

    static void runJobs(JCoDestination destination, int num_thread, String c_add, String del_caco) throws ParserConfigurationException, SAXException, IOException, JCoException {
        int NumberOfNNT = arrNNT.size();
        //System.out.println("Start hàm 2 "+System.currentTimeMillis());          
        for (int i = 0; i < NumberOfNNT; i++) {

            queue.add(new StatefulMultiStepNNTExample(destination, 1, arrNNT.get(i), c_add, del_caco));
        }

        CountDownLatch doneSignal = new CountDownLatch(num_thread);

        for (int i = 0; i < num_thread; i++) {
            new WorkerThread(doneSignal).start();
        }

        try {
            doneSignal.await();
        } catch (InterruptedException ie) {
            //just leave
            logger.log(Level.WARNING, "InterruptException:", ie);
        }
        //04.Test performance         
        end_f2 = System.currentTimeMillis();
        result = (end_f2 - start_f1) / 1000;
        System.out.println("Result time: " + result + "s");

        //System.out.println(">>> Done");

        //************************ CLEAR ARRAY NNT ***************************
        arrNNT.clear();
        //Ghi lại thông tin file convert thành công
        logger.log(Level.OFF, "convert files: " + ReadXML.getFile_name());
        //Lấy file name đã convert 
        ConvertDKTView.getSuccesFile(">>> DONE FILE " + ReadXML.getFile_name() + " !!!");
    }

    // Load NNT sau khi đọc từng file xml
    static void loadQueue(DataNNT nnt)// throws AbapException
    {
        try {
            arrNNT.add(nnt);
        } catch (JCoRuntimeException jrex) {
            logger.log(Level.WARNING, "JCoRuntimeException :", jrex);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception:", ex);
        }
    }

    static void loadBP(String c_add) throws ParserConfigurationException, SAXException, IOException, JCoException {
        try {
            JCoDestination destination = JCoDestinationManager.getDestination(DESTINATION_NAME1);
            convertLoadBPTemplate = destination.getRepository().getFunctionTemplate("ZBAPI_CONVERT_DATA_LIST");//
            JCoFunction fnLoadBP = convertLoadBPTemplate.getFunction();
            //import parameter
            JCoTable tblInLoadBP = fnLoadBP.getImportParameterList().getTable("IT_PARTNER_IDNUMBER");//PARTNER_IDNUMBER
            JCoTable tblInCity = fnLoadBP.getImportParameterList().getTable("IT_ADDRESSCITY");//City address for convert data.
            JCoTable tblInDistrict = fnLoadBP.getImportParameterList().getTable("IT_ADDRESSDISTRICT");//District address for convert.
            JCoTable tblInCountry = fnLoadBP.getImportParameterList().getTable("IT_COUNTRYMAP");//Table type Map country for convert data.

            fnLoadBP.getImportParameterList().setValue("I_CNVADDR", c_add);//Convert address 

            //export parameter
            tblExLoadBP = fnLoadBP.getExportParameterList().getTable("ET_PARTNER_IDNUMBER");
            tblExCity = fnLoadBP.getExportParameterList().getTable("ET_ADDRESSCITY");
            tblExDistrict = fnLoadBP.getExportParameterList().getTable("ET_ADDRESSDISTRICT");
            tblExCountry = fnLoadBP.getExportParameterList().getTable("ET_COUNTRYMAP");
            tbleExAddressGui = fnLoadBP.getExportParameterList().getTable("ET_ADDRESSGUID");
            tbleRegtaxUpdate = fnLoadBP.getTableParameterList().getTable("T_REGTAX_UPDATE");

            start_f1 = System.currentTimeMillis();

            int NumberOfNNT = arrNNT.size();
            for (int i = 0; i < NumberOfNNT; i++) {
                //IDNUMBER
                tblInLoadBP.appendRow();
                tblInLoadBP.setValue("IDNUMBER", arrNNT.get(i).hdr.getIDNUMBER());

                //ADDRESS, CITY_NO, DISTRICT
                //HOME_CITYNO
                if (arrNNT.get(i).hdr.getHOME_CITYNO() != null) {
                    tblInCity.appendRow();
                    tblInCity.setValue("CODE", arrNNT.get(i).hdr.getHOME_CITYNO());
                }
                //PERM_CITYNO
                if (arrNNT.get(i).hdr.getPERM_CITYNO() != null) {
                    tblInCity.appendRow();
                    tblInCity.setValue("CODE", arrNNT.get(i).hdr.getPERM_CITYNO());
                }
                //BU_CITY_CODE
                if (arrNNT.get(i).hdr.getBU_CITY_CODE() != null) {
                    tblInCity.appendRow();
                    tblInCity.setValue("CODE", arrNNT.get(i).hdr.getBU_CITY_CODE());
                }
                //CO_CITY_CODE
                if (arrNNT.get(i).hdr.getCO_CITY_CODE() != null) {
                    tblInCity.appendRow();
                    tblInCity.setValue("CODE", arrNNT.get(i).hdr.getCO_CITY_CODE());
                }
                //BUINFO_CITY_CODE
                if (arrNNT.get(i).hdr.getBUINFO_CITY_CODE() != null) {
                    tblInCity.appendRow();
                    tblInCity.setValue("CODE", arrNNT.get(i).hdr.getBUINFO_CITY_CODE());
                }
                //MANAG_CITY_CODE
                if (arrNNT.get(i).hdr.getMANAG_CITY_CODE() != null) {
                    tblInCity.appendRow();
                    tblInCity.setValue("CODE", arrNNT.get(i).hdr.getMANAG_CITY_CODE());
                }
                //ADVN_CITY_CODE
                if (arrNNT.get(i).hdr.getADVN_CITY_CODE() != null) {
                    tblInCity.appendRow();
                    tblInCity.setValue("CODE", arrNNT.get(i).hdr.getADVN_CITY_CODE());
                }

                /**   Tunning load ADDRESS DISTRICT_NO */
                //PERM_DISTRICTNO
                if (arrNNT.get(i).hdr.getPERM_DISTRICTNO() != null) {
                    tblInDistrict.appendRow();
                    tblInDistrict.setValue("CODE", arrNNT.get(i).hdr.getPERM_DISTRICTNO());
                }
                //HOME_DISTRICTNO
                if (arrNNT.get(i).hdr.getHOME_DISTRICTNO() != null) {
                    tblInDistrict.appendRow();
                    tblInDistrict.setValue("CODE", arrNNT.get(i).hdr.getHOME_DISTRICTNO());
                }
                //BU_DISTRICTNO
                if (arrNNT.get(i).hdr.getBU_DISTRICTNO() != null) {
                    tblInDistrict.appendRow();
                    tblInDistrict.setValue("CODE", arrNNT.get(i).hdr.getBU_DISTRICTNO());
                }
                //CO_DISTRICTNO
                if (arrNNT.get(i).hdr.getCO_DISTRICTNO() != null) {
                    tblInDistrict.appendRow();
                    tblInDistrict.setValue("CODE", arrNNT.get(i).hdr.getCO_DISTRICTNO());
                }
                //MANAG_DISTRICTNO
                if (arrNNT.get(i).hdr.getMANAG_DISTRICTNO() != null) {
                    tblInDistrict.appendRow();
                    tblInDistrict.setValue("CODE", arrNNT.get(i).hdr.getMANAG_DISTRICTNO());
                }
                //BUINFO_DISTRICTNO
                if (arrNNT.get(i).hdr.getBUINFO_DISTRICTNO() != null) {
                    tblInDistrict.appendRow();
                    tblInDistrict.setValue("CODE", arrNNT.get(i).hdr.getBUINFO_DISTRICTNO());
                }
                //ADVN_DISTRICTNO
                if (arrNNT.get(i).hdr.getADVN_DISTRICTNO() != null) {
                    tblInDistrict.appendRow();
                    tblInDistrict.setValue("CODE", arrNNT.get(i).hdr.getADVN_DISTRICTNO());
                }

                /** Tunning load map country */
                //NATIONALITY
                if (arrNNT.get(i).hdr.getNATIONALITY() != null) {
                    tblInCountry.appendRow();
                    tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).hdr.getNATIONALITY());
                }
                //PERM_COUNTRY
                if (arrNNT.get(i).hdr.getPERM_COUNTRY() != null) {
                    tblInCountry.appendRow();
                    tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).hdr.getPERM_COUNTRY());
                }
                //HOME_COUNTRY
                if (arrNNT.get(i).hdr.getHOME_COUNTRY() != null) {
                    tblInCountry.appendRow();
                    tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).hdr.getHOME_COUNTRY());
                }
                //BU_COUNTRY
                if (arrNNT.get(i).hdr.getBU_COUNTRY() != null) {
                    tblInCountry.appendRow();
                    tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).hdr.getBU_COUNTRY());
                }
                //CO_COUNTRY                
                if (arrNNT.get(i).hdr.getCO_COUNTRY() != null) {
                    tblInCountry.appendRow();
                    tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).hdr.getCO_COUNTRY());
                }
                //BUINFO_COUNTRY
                if (arrNNT.get(i).hdr.getBUINFO_COUNTRY() != null) {
                    tblInCountry.appendRow();
                    tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).hdr.getBUINFO_COUNTRY());
                }
                //MANAG_COUNTRY
                if (arrNNT.get(i).hdr.getMANAG_COUNTRY() != null) {
                    tblInCountry.appendRow();
                    tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).hdr.getMANAG_COUNTRY());
                }
                //ADVN_COUNTRY
                if (arrNNT.get(i).hdr.getADVN_COUNTRY() != null) {
                    tblInCountry.appendRow();
                    tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).hdr.getADVN_COUNTRY());
                }
                //FRN_COUNTRY
                if (arrNNT.get(i).hdr.getFRN_COUNTRY() != null) {
                    tblInCountry.appendRow();
                    tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).hdr.getFRN_COUNTRY());
                }

                /**
                 * Tunning load value in detail
                 * REGTAX_ID2, Diplomatic, Subcont, Foreigner,Project_Contractor
                 */
                //Detail Diplomatic               
                for (int r = 0; r < arrNNT.get(i).Diplomatic.size(); r++) {
                    if (arrNNT.get(i).Diplomatic.get(r).getNATIONALITY() != null) {
                        tblInCountry.appendRow();
                        tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).Diplomatic.get(r).getNATIONALITY());
                    }
                }

                //Detail Subcont
                for (int r = 0; r < arrNNT.get(i).subcont.size(); r++) {
                    if (arrNNT.get(i).subcont.get(r).getCOUNTRY() != null) {
                        tblInCountry.appendRow();
                        tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).subcont.get(r).getCOUNTRY());
                    }
                }

                //Detail Foreigner
                for (int r = 0; r < arrNNT.get(i).foreigner.size(); r++) {
                    if (arrNNT.get(i).foreigner.get(r).getCOUNTRY() != null) {
                        tblInCountry.appendRow();
                        tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).foreigner.get(r).getCOUNTRY());
                    }
                }

                //Detail Project_Contractor:
                for (int r = 0; r < arrNNT.get(i).proj_cont.size(); r++) {
                    if (arrNNT.get(i).proj_cont.get(r).getCOUNTRY() != null) {
                        tblInCountry.appendRow();
                        tblInCountry.setValue("COUNTRY_LEGACY", arrNNT.get(i).proj_cont.get(r).getCOUNTRY());
                    }
                }
            }
            //Execute
            fnLoadBP.execute(destination);

            /**            
             * try set value NNT
             */
            for (int a = 0; a < NumberOfNNT; a++) {

                /** Set Country name for Header */
                tblExCountry.firstRow();

                for (int i = 0; i < tblExCountry.getNumRows(); i++) {
                    tblExCountry.setRow(i);

                    //NATIONALITY
                    if (tblExCountry.getString("COUNTRY_LEGACY").equals(arrNNT.get(a).hdr.getNATIONALITY())) {
                        arrNNT.get(a).hdr.setNATIONALITY(tblExCountry.getString("COUNTRY_SAP"));
                    }
                    //Check BP: 0400, 0420, 0430 set FRN_COUNTRY = NATIONALITY
                    if (arrNNT.get(a).hdr.getFRN_STREET() != null && 
                            (arrNNT.get(a).hdr.getBPKIND().equals(Constants.BP_0400)
                            || arrNNT.get(a).hdr.getBPKIND().equals(Constants.BP_0420)
                            || arrNNT.get(a).hdr.getBPKIND().equals(Constants.BP_0430)) ) {
                        arrNNT.get(a).hdr.setFRN_COUNTRY(arrNNT.get(a).hdr.getNATIONALITY());
                    }

                }

                /** Set value PARTNER - IDNUMBER  - MODE */
                tblExLoadBP.setRow(a);

                if (tblExLoadBP.getNumRows() > 0) {
                    arrNNT.get(a).hdr.setMODE("I");
                    //Có PARTNER Set IDNUMBER = PARTNER, MODE = U  
                    if (!tblExLoadBP.getString("PARTNER").isEmpty()) {
                        arrNNT.get(a).hdr.setPARTNER(tblExLoadBP.getString("PARTNER"));
                        arrNNT.get(a).hdr.setMODE("U");
                    }
                }
                /** Set value ADDRESSCITY - DISTRICT */
                tblExCity.firstRow();
                tblExDistrict.firstRow();

                //SET ADDRESSCITY
                for (int r = 0; r < tblExCity.getNumRows(); r++) {
                    tblExCity.setRow(r);

                    //HOME_CITYNO                      
                    if (tblExCity.getString("CODE").equals(arrNNT.get(a).hdr.getHOME_CITYNO())) {
                        arrNNT.get(a).hdr.setHOME_CITY(tblExCity.getString("NAME"));
                    }
                    //PERM_CITYNO
                    if (tblExCity.getString("CODE").equals(arrNNT.get(a).hdr.getPERM_CITYNO())) {
                        arrNNT.get(a).hdr.setPERM_CITY(tblExCity.getString("NAME"));
                    }
                    //BU_CITY_CODE
                    if (tblExCity.getString("CODE").equals(arrNNT.get(a).hdr.getBU_CITY_CODE())) {
                        arrNNT.get(a).hdr.setBU_CITYNAME(tblExCity.getString("NAME"));
                    }
                    //CO_CITY_CODE
                    if (tblExCity.getString("CODE").equals(arrNNT.get(a).hdr.getCO_CITY_CODE())) {
                        arrNNT.get(a).hdr.setCO_CITYNAME(tblExCity.getString("NAME"));
                    }
                    //BUINFO_CITY_CODE
                    if (tblExCity.getString("CODE").equals(arrNNT.get(a).hdr.getBUINFO_CITY_CODE())) {
                        arrNNT.get(a).hdr.setBUINFO_CITYNAME(tblExCity.getString("NAME"));
                    }
                    //MANAG_CITY_CODE 	
                    if (tblExCity.getString("CODE").equals(arrNNT.get(a).hdr.getMANAG_CITY_CODE())) {
                        arrNNT.get(a).hdr.setMANAG_CITYNAME(tblExCity.getString("NAME"));
                    }
                    //ADVN_CITY_CODE
                    if (tblExCity.getString("CODE").equals(arrNNT.get(a).hdr.getADVN_CITY_CODE())) {
                        arrNNT.get(a).hdr.setADVN_CITYNAME(tblExCity.getString("NAME"));
                    }
                }

                /** Set value DISTRICT */
                for (int r = 0; r < tblExDistrict.getNumRows(); r++) {

                    tblExDistrict.setRow(r);

                    //PERM_DISTRICTNO
                    if (tblExDistrict.getString("CODE").equals(arrNNT.get(a).hdr.getPERM_DISTRICTNO())) {
                        arrNNT.get(a).hdr.setPERM_DISTRICT(tblExDistrict.getString("NAME"));
                    }
                    //HOME_DISTRICTNO
                    if (tblExDistrict.getString("CODE").equals(arrNNT.get(a).hdr.getHOME_DISTRICTNO())) {
                        arrNNT.get(a).hdr.setHOME_DISTRICT(tblExDistrict.getString("NAME"));
                    }
                    //BU_DISTRICTNO
                    if (tblExDistrict.getString("CODE").equals(arrNNT.get(a).hdr.getBU_DISTRICTNO())) {
                        arrNNT.get(a).hdr.setBU_DISTRICT(tblExDistrict.getString("NAME"));
                    }
                    //CO_DISTRICTNO
                    if (tblExDistrict.getString("CODE").equals(arrNNT.get(a).hdr.getCO_DISTRICTNO())) {
                        arrNNT.get(a).hdr.setCO_DISTRICT(tblExDistrict.getString("NAME"));
                    }
                    //MANAG_DISTRICTNO
                    if (tblExDistrict.getString("CODE").equals(arrNNT.get(a).hdr.getMANAG_DISTRICTNO())) {
                        arrNNT.get(a).hdr.setMANAG_DISTRICT(tblExDistrict.getString("NAME"));
                    }
                    //BUINFO_DISTRICTNO
                    if (tblExDistrict.getString("CODE").equals(arrNNT.get(a).hdr.getBUINFO_DISTRICTNO())) {
                        arrNNT.get(a).hdr.setBUINFO_DISTRICT(tblExDistrict.getString("NAME"));
                    }
                    //ADVN_DISTRICTNO
                    if (tblExDistrict.getString("CODE").equals(arrNNT.get(a).hdr.getADVN_DISTRICTNO())) {
                        arrNNT.get(a).hdr.setADVN_DISTRICT(tblExDistrict.getString("NAME"));
                    }
                }

                /** Set ADDRESS GUID for Header edit here */
                tbleExAddressGui.firstRow();
                for (int r = 0; r < tbleExAddressGui.getNumRows(); r++) {

                    tbleExAddressGui.setRow(r);

                    //ADR_KIND_PERM
                    if (tbleExAddressGui.getString("PARTNER").equals(arrNNT.get(a).hdr.getPARTNER())
                            && tbleExAddressGui.getString("ADR_KIND").equals(Constants.ADR_KIND_PERM)) {
                        arrNNT.get(a).hdr.setPERM_GUID(tbleExAddressGui.getString("GUID"));
                    }
                    //ADR_KIND_HOME
                    if (tbleExAddressGui.getString("PARTNER").equals(arrNNT.get(a).hdr.getPARTNER())
                            && tbleExAddressGui.getString("ADR_KIND").equals(Constants.ADR_KIND_HOME)) {
                        arrNNT.get(a).hdr.setHOME_GUID(tbleExAddressGui.getString("GUID"));
                    }
                    //ADR_KIND_BU
                    if (tbleExAddressGui.getString("PARTNER").equals(arrNNT.get(a).hdr.getPARTNER())
                            && tbleExAddressGui.getString("ADR_KIND").equals(Constants.ADR_KIND_BU)) {
                        arrNNT.get(a).hdr.setBU_GUID(tbleExAddressGui.getString("GUID"));
                    }
                    //ADR_KIND_CO
                    if (tbleExAddressGui.getString("PARTNER").equals(arrNNT.get(a).hdr.getPARTNER())
                            && tbleExAddressGui.getString("ADR_KIND").equals(Constants.ADR_KIND_CO)) {
                        arrNNT.get(a).hdr.setCO_GUID(tbleExAddressGui.getString("GUID"));
                    }
                    //ADR_KIND_FRN
                    if (tbleExAddressGui.getString("PARTNER").equals(arrNNT.get(a).hdr.getPARTNER())
                            && tbleExAddressGui.getString("ADR_KIND").equals(Constants.ADR_KIND_FRN)) {
                        arrNNT.get(a).hdr.setFRN_GUID(tbleExAddressGui.getString("GUID"));
                    }
                    //ADR_KIND_BUINFO
                    if (tbleExAddressGui.getString("PARTNER").equals(arrNNT.get(a).hdr.getPARTNER())
                            && tbleExAddressGui.getString("ADR_KIND").equals(Constants.ADR_KIND_BUINFO)) {
                        arrNNT.get(a).hdr.setBUINFO_GUID(tbleExAddressGui.getString("GUID"));
                    }
                    //ADR_KIND_ADVN
                    if (tbleExAddressGui.getString("PARTNER").equals(arrNNT.get(a).hdr.getPARTNER())
                            && tbleExAddressGui.getString("ADR_KIND").equals(Constants.ADR_KIND_ADVN)) {
                        arrNNT.get(a).hdr.setADVN_GUID(tbleExAddressGui.getString("GUID"));
                    }
                }

                // Modify by QuanPTT
                tbleRegtaxUpdate.firstRow();
                for (int r = 0; r < tbleRegtaxUpdate.getNumRows(); r++) {
                    tbleRegtaxUpdate.setRow(r);

                    if (tbleRegtaxUpdate.getString("PARTNER").equals(arrNNT.get(a).hdr.getPARTNER())) {
                        arrNNT.get(a).retax_update.setPARTNER(tbleRegtaxUpdate.getString("PARTNER"));
                        arrNNT.get(a).retax_update.setTYPE(tbleRegtaxUpdate.getString("TYPE"));
                        arrNNT.get(a).retax_update.setORSTA(tbleRegtaxUpdate.getString("ORSTA"));
                        arrNNT.get(a).retax_update.setORRES(tbleRegtaxUpdate.getString("ORRES"));
                        arrNNT.get(a).retax_update.setBUKRS(tbleRegtaxUpdate.getString("BUKRS"));
                        arrNNT.get(a).retax_update.setREDAT(tbleRegtaxUpdate.getString("REDAT"));
                        arrNNT.get(a).retax_update.setPRCTR(tbleRegtaxUpdate.getString("PRCTR"));
                        arrNNT.get(a).retax_update.setGSBER(tbleRegtaxUpdate.getString("GSBER"));
                        arrNNT.get(a).retax_update.setBPKIND(tbleRegtaxUpdate.getString("BPKIND"));
                        break;
                    }
                }
                
                //**-----------------------------------------------------------------------*
                //**<!-- 09.FOREIGNER_ORG -->                                              *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < arrNNT.get(a).foreigner.size(); r++) {
                    tblExCountry.firstRow();
                    for (int i = 0; i < tblExCountry.getNumRows(); i++) {
                        tblExCountry.setRow(i);
                        if (tblExCountry.getString("COUNTRY_LEGACY").equals(arrNNT.get(a).foreigner.get(r).getCOUNTRY())) {
                            arrNNT.get(a).foreigner.get(r).setCOUNTRY(tblExCountry.getString("COUNTRY_SAP"));
                             break;
                        }
                    }                    
                }
                //**-----------------------------------------------------------------------*
                //**<!-- 10.SUBCONT_ORG-->                                                 *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < arrNNT.get(a).subcont.size(); r++) {
                    tblExCountry.firstRow();
                    for (int i = 0; i < tblExCountry.getNumRows(); i++) {
                        tblExCountry.setRow(i);
                        if (tblExCountry.getString("COUNTRY_LEGACY").equals(arrNNT.get(a).subcont.get(r).getCOUNTRY())) {
                            arrNNT.get(a).subcont.get(r).setCOUNTRY(tblExCountry.getString("COUNTRY_SAP"));
                            break;
                        }
                    }
                }
                //**-----------------------------------------------------------------------*
                //**<!-- 11.DIPLOMATIC_ORG -->                                             *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < arrNNT.get(a).Diplomatic.size(); r++) {
                    tblExCountry.firstRow();
                    for (int i = 0; i < tblExCountry.getNumRows(); i++) {
                        tblExCountry.setRow(i);
                        if (tblExCountry.getString("COUNTRY_LEGACY").equals(arrNNT.get(a).Diplomatic.get(r).getNATIONALITY())) {
                            arrNNT.get(a).Diplomatic.get(r).setNATIONALITY(tblExCountry.getString("COUNTRY_SAP"));
                            break;
                        }
                    }                    
                }

                //**-----------------------------------------------------------------------*
                //**<!-- 12.PROJ_CONT_ORG-->                                               *
                //**-----------------------------------------------------------------------*

                for (int r = 0; r < arrNNT.get(a).proj_cont.size(); r++) {
                    tblExCountry.firstRow();
                    for (int i = 0; i < tblExCountry.getNumRows(); i++) {
                        tblExCountry.setRow(i);
                        if (tblExCountry.getString("COUNTRY_LEGACY").equals(arrNNT.get(a).proj_cont.get(r).getCOUNTRY())) {
                            arrNNT.get(a).proj_cont.get(r).setCOUNTRY(tblExCountry.getString("COUNTRY_SAP"));
                            break;
                        }
                    }
                }
                
            }
            
        } catch (JCoException je) {
            je.printStackTrace();
            logger.log(Level.WARNING, "JCoException: ", je.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

    //Thực hiện convert vào hệ thống từ file xml
    static void runConvert(int num_thread, String c_add, String del_caco) throws ParserConfigurationException, SAXException, IOException, JCoException {
        MySessionReferenceProvider mySessionRP = new MySessionReferenceProvider();
        Environment.registerSessionReferenceProvider(mySessionRP);
        try {
            //Get properties SAP, call function, and convert data to PIT
            JCoDestination destination = JCoDestinationManager.getDestination(DESTINATION_NAME2);
            //call function ZBAPI_CONVERT_DATA
            convertDKTTemplate = destination.getRepository().getFunctionTemplate("ZBAPI_CONVERT_DATA");
            if (convertDKTTemplate == null) {
                throw new RuntimeException("Service could not run due to lack of function");
            }
            runJobs(destination, num_thread, c_add, del_caco);
        } catch (JCoException je) {
            System.out.println(" je.printStackTrace(): " + je.getMessage());
            je.printStackTrace();
            logger.log(Level.WARNING, "JCoException: ", je.getMessage());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "Lỗi RuntimeExceptions trong cấu trúc file xml: " + ReadXML.getFile_name(), e.getMessage());
        }
        Environment.unregisterSessionReferenceProvider(mySessionRP);

    }
}