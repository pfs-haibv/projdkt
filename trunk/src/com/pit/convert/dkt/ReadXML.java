package com.pit.convert.dkt;

/**
 *
 * @author HAIBV
 */
import com.sap.conn.jco.JCoException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.util.ArrayList;
import java.io.File;

import com.pit.convert.datatype.*;
import com.pit.convert.utility.Utility;

public class ReadXML {

    private static DataNNT nnt;
    //<!--01.REGTAX_ID_ALL -->         
    private static ArrayList<REGTAX_ID2> regtax_id_all = new ArrayList<REGTAX_ID2>();
    //<!-- 02.TAX_PAYABLE_ORG -->
    private static ArrayList<TAX_PAYABLE> tax_payable = new ArrayList<TAX_PAYABLE>();
    //<!-- 03.BUSI_MAIN_ORG -->
    private static ArrayList<BUSI_MAIN> busi_main = new ArrayList<BUSI_MAIN>();
    //<!-- 05.BRANCH_ORG -->
    private static ArrayList<BRANCH_ORG> branch_org = new ArrayList<BRANCH_ORG>();
    //<!-- 06.SUBDIARY_ORG-->
    private static ArrayList<SUBDIARY> subdiary = new ArrayList<SUBDIARY>();
    //<!--07.JOIN_ORG-->
    private static ArrayList<JOIN_ORG> join_org = new ArrayList<JOIN_ORG>();
    //<!-- 08.WAREHOUSE_ORG -->
    private static ArrayList<WAREHOUSE_ORG> warehouse = new ArrayList<WAREHOUSE_ORG>();
    //<!-- 09.FOREIGNER_ORG -->
    private static ArrayList<FOREIGNER> foreigner = new ArrayList<FOREIGNER>();
    //<!-- 10.SUBCONT_ORG -->
    private static ArrayList<SUBCONT_ORG> subcont = new ArrayList<SUBCONT_ORG>();
    //<!-- 11.DIPLOMATIC_ORG-->
    private static ArrayList<DIPLOMATIC> diplomatic = new ArrayList<DIPLOMATIC>();
    //<!-- 12.PROJ_CONT_ORG -->
    private static ArrayList<PROJ_CONT> proj_cont = new ArrayList<PROJ_CONT>();
    //<!-- 13.REGFORM -->
    private static ArrayList<REGFORM> reg_form = new ArrayList<REGFORM>();

    /**
     * Thực hiện read từng file XML và load lên 1 Array
     * @param srcFolder
     * @param bckFile
     * @param num_thread
     * @param c_add
     * @param del_caco
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws ExceptionInInitializerError
     * @throws JCoException 
     */
    static void readXML(String srcFolder, String bckFile, int num_thread, String c_add, String del_caco) throws ParserConfigurationException, SAXException, IOException, ExceptionInInitializerError, JCoException {

        NodeList NodeList_ = null;
        Element Element_ = null;
        NodeList TextNodeList_ = null;
        // Source files
        String srcFile = "";
        Document doc = null;
        DocumentBuilderFactory docBuilderFactory = null;
        DocumentBuilder docBuilder = null;
        File f_xml = null;

        try {

            // Forder file scand
            File dirForder = new File(srcFolder);
            File dirFile, crtForder;

            //Scand list folder
            for (File f : dirForder.listFiles()) {
                //Clear file name
                setDir_file("");
                setFile_name("");
                //Dir forder chứa file xml
                dirFile = new File(srcFolder + "\\" + f.getName());

                //Scand list file on folder
                for (File l : dirFile.listFiles()) {
                    //Create forder backup
                    String tgrFld = bckFile + "\\" + f.getName();
                    crtForder = new File(tgrFld);
                    crtForder.mkdir();
                    // Source files
                    srcFile = dirFile + "\\" + l.getName();
                    // Set directory file XML
                    setDir_file(srcFile);
                    // Set file nam xml
                    setFile_name(l.getName());
                    // get file XML
                    int endIndex = l.getName().length();
                    int beginIndex = endIndex - 3;
                    // Scan file có định dạng .XML
                    if (l.getName().substring(beginIndex, endIndex).equals("XML")) {

                        docBuilderFactory = DocumentBuilderFactory.newInstance();
                        docBuilder = docBuilderFactory.newDocumentBuilder();
                        f_xml = new File(dirFile + "\\" + l.getName());

                        doc = docBuilder.parse(f_xml);

                        doc.getDocumentElement().normalize();

                        //Node List NNT
                        NodeList nodeListNNT = doc.getElementsByTagName("NNT");
                        // Data NNT
                        for (int s = 0; s < nodeListNNT.getLength(); s++) {
                            // Clear info nnt
                            nnt = null;
                            regtax_id_all.clear();
                            busi_main.clear();
                            branch_org.clear();
                            subdiary.clear();
                            join_org.clear();
                            warehouse.clear();
                            foreigner.clear();
                            subcont.clear();
                            tax_payable.clear();
                            diplomatic.clear();
                            proj_cont.clear();
                            reg_form.clear();

                            Node nodeNNT = nodeListNNT.item(s);

                            Header header_ = new Header();
                            //Element NNT
                            if (nodeNNT.getNodeType() == Node.ELEMENT_NODE) {

                                Element NNTElement = (Element) nodeNNT;

                                //*************** Get data header NNT **********************
                                NodeList nodeListHeader = NNTElement.getElementsByTagName("HEADER");

                                Node HeaderNode = nodeListHeader.item(0);

                                if (HeaderNode.getNodeType() == Node.ELEMENT_NODE) {

                                    NodeList_ = null;
                                    Element_ = null;
                                    TextNodeList_ = null;

                                    Element headerElement = (Element) HeaderNode;
                                    //01.MODE
                                    NodeList_ = headerElement.getElementsByTagName("MODE");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    header_.setMODE(((Node) TextNodeList_.item(0)).getNodeValue());

                                    //02.IDNUMBER
                                    NodeList_ = headerElement.getElementsByTagName("IDNUMBER");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    header_.setIDNUMBER(((Node) TextNodeList_.item(0)).getNodeValue());

                                    //03.INSTA
                                    NodeList_ = headerElement.getElementsByTagName("INSTA");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setINSTA(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //04.BUKRS
                                    NodeList_ = headerElement.getElementsByTagName("BUKRS");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUKRS(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //05.PRCTR
                                    NodeList_ = headerElement.getElementsByTagName("PRCTR");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setPRCTR(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //06.GSBER
                                    NodeList_ = headerElement.getElementsByTagName("GSBER");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setGSBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //07.FULLNAME
                                    NodeList_ = headerElement.getElementsByTagName("FULLNAME");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setFULLNAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }
                                    //08.BIRTHDATE
                                    NodeList_ = headerElement.getElementsByTagName("BIRTHDATE");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBIRTHDATE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //09.SEXMALE
                                    NodeList_ = headerElement.getElementsByTagName("SEXMALE");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setSEXMALE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //10.NATIONALITY
                                    NodeList_ = headerElement.getElementsByTagName("NATIONALITY");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setNATIONALITY(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //11.PERM_STREET
                                    NodeList_ = headerElement.getElementsByTagName("PERM_STREET");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setPERM_STREET(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //12.PERM_REGION
                                    NodeList_ = headerElement.getElementsByTagName("PERM_REGION");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setPERM_REGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //13.PERM_CITYNO
                                    NodeList_ = headerElement.getElementsByTagName("PERM_CITYNO");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setPERM_CITYNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //14.PERM_DISTRICTNO
                                    NodeList_ = headerElement.getElementsByTagName("PERM_DISTRICTNO");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setPERM_DISTRICTNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //15.PERM_COUNTRY                            
//                            NodeList_    = headerElement.getElementsByTagName("PERM_COUNTRY");
//                            Element_  = (Element)NodeList_.item(0);
//                            TextNodeList_    = Element_.getChildNodes();
                                    //Check PERM ADDRESS
                                    if (header_.getPERM_STREET() != null || header_.getPERM_REGION() != null
                                            || header_.getPERM_CITYNO() != null || header_.getPERM_DISTRICTNO() != null) {
//                                if(TextNodeList_.getLength() != 0)
//                                header_.setPERM_COUNTRY(((Node)TextNodeList_.item(0)).getNodeValue());
                                        header_.setPERM_COUNTRY("VN");
                                    }

                                    //16 HOME_STREET
                                    NodeList_ = headerElement.getElementsByTagName("HOME_STREET");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setHOME_STREET(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //17 HOME_REGION
                                    NodeList_ = headerElement.getElementsByTagName("HOME_REGION");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setHOME_REGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //18 HOME_CITYNO
                                    NodeList_ = headerElement.getElementsByTagName("HOME_CITYNO");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setHOME_CITYNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //19 HOME_DISTRICTNO
                                    NodeList_ = headerElement.getElementsByTagName("HOME_DISTRICTNO");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setHOME_DISTRICTNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //20 HOME_COUNTRY
//                            NodeList_    = headerElement.getElementsByTagName("HOME_COUNTRY");
//                            Element_  = (Element)NodeList_.item(0);
//                            TextNodeList_    = Element_.getChildNodes();

                                    //Check HOME ADDRESS
                                    if (header_.getHOME_STREET() != null || header_.getHOME_REGION() != null
                                            || header_.getHOME_CITYNO() != null || header_.getHOME_DISTRICTNO() != null) {
//                                if(TextNodeList_.getLength() != 0)
//                                header_.setHOME_COUNTRY(((Node)TextNodeList_.item(0)).getNodeValue());
                                        header_.setHOME_COUNTRY("VN");
                                    }
                                    //21 TELEPHONE
                                    NodeList_ = headerElement.getElementsByTagName("TELEPHONE");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setTELEPHONE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //22 E_MAIL
                                    NodeList_ = headerElement.getElementsByTagName("E_MAIL");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setE_MAIL(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //23 RECEIPT_DATE
                                    NodeList_ = headerElement.getElementsByTagName("RECEIPT_DATE");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setRECEIPT_DATE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //24 BPKIND
                                    NodeList_ = headerElement.getElementsByTagName("BPKIND");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    header_.setBPKIND(((Node) TextNodeList_.item(0)).getNodeValue());

                                    //25 TRADE_NAME
                                    NodeList_ = headerElement.getElementsByTagName("TRADE_NAME");
                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setTRADE_NAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //26 ONAME
                                    NodeList_ = headerElement.getElementsByTagName("ONAME");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setONAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //27 ORGSTA
                                    NodeList_ = headerElement.getElementsByTagName("ORGSTA");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setORGSTA(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //28 IMEX_CHK
                                    NodeList_ = headerElement.getElementsByTagName("IMEX_CHK");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setIMEX_CHK(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //29 NUMEP
                                    NodeList_ = headerElement.getElementsByTagName("NUMEP");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setNUMEP(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //30 FOUND_DAT
                                    NodeList_ = headerElement.getElementsByTagName("FOUND_DAT");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setFOUND_DAT(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //31 TOCAP
                                    NodeList_ = headerElement.getElementsByTagName("TOCAP");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setTOCAP(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //32 TOCAPW
                                    NodeList_ = headerElement.getElementsByTagName("TOCAPW");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setTOCAPW(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //33 STACAP
                                    NodeList_ = headerElement.getElementsByTagName("STACAP");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setSTACAP(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //34 FORECAP
                                    NodeList_ = headerElement.getElementsByTagName("FORECAP");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setFORECAP(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //35 OTHCAP
                                    NodeList_ = headerElement.getElementsByTagName("OTHCAP");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setOTHCAP(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //36 STACAPW
                                    NodeList_ = headerElement.getElementsByTagName("STACAPW");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setSTACAPW(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //37 FORECAPW
                                    NodeList_ = headerElement.getElementsByTagName("FORECAPW");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setFORECAPW(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //38 OTHCAPW
                                    NodeList_ = headerElement.getElementsByTagName("OTHCAPW");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setOTHCAPW(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //39 STATE_PROP
                                    NodeList_ = headerElement.getElementsByTagName("STATE_PROP");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setSTATE_PROP(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //40 FOREIGN_PRO
                                    NodeList_ = headerElement.getElementsByTagName("FOREIGN_PRO");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setFOREIGN_PRO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //41 OTHER_PRO
                                    NodeList_ = headerElement.getElementsByTagName("OTHER_PRO");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setOTHER_PRO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //42 TREA_ACCO
                                    NodeList_ = headerElement.getElementsByTagName("TREA_ACCO");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setTREA_ACCO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //43 TREA_CODE
                                    NodeList_ = headerElement.getElementsByTagName("TREA_CODE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setTREA_CODE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //44 LEGAL_ENTY
                                    NodeList_ = headerElement.getElementsByTagName("LEGAL_ENTY");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setLEGAL_ENTY(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //45 FINA_SDAT
                                    NodeList_ = headerElement.getElementsByTagName("FINA_SDAT");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setFINA_SDAT(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //46 FINA_EDAT
                                    NodeList_ = headerElement.getElementsByTagName("FINA_EDAT");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setFINA_EDAT(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //47 HASUB
                                    NodeList_ = headerElement.getElementsByTagName("HASUB");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setHASUB(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //48 HABRA
                                    NodeList_ = headerElement.getElementsByTagName("HABRA");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setHABRA(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //49 HAWHS
                                    NodeList_ = headerElement.getElementsByTagName("HAWHS");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setHAWHS(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //50 HAREP
                                    NodeList_ = headerElement.getElementsByTagName("HAREP");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setHAREP(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //51 HACWC
                                    NodeList_ = headerElement.getElementsByTagName("HACWC");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setHACWC(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //52 HAJOIN
                                    NodeList_ = headerElement.getElementsByTagName("HAJOIN");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setHAJOIN(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //53 REORG_ID
                                    NodeList_ = headerElement.getElementsByTagName("REORG_ID");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setREORG_ID(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //54 OLD_TIN
                                    NodeList_ = headerElement.getElementsByTagName("OLD_TIN");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setOLD_TIN(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //55 DIRNA
                                    NodeList_ = headerElement.getElementsByTagName("DIRNA");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setDIRNA(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //56 DIRFO
                                    NodeList_ = headerElement.getElementsByTagName("DIRFO");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setDIRFO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //57 ACCNA
                                    NodeList_ = headerElement.getElementsByTagName("ACCNA");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setACCNA(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //58 ACCFO
                                    NodeList_ = headerElement.getElementsByTagName("ACCFO");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setACCFO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //59 BU_STREET
                                    NodeList_ = headerElement.getElementsByTagName("BU_STREET");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBU_STREET(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //60 BU_REGION
                                    NodeList_ = headerElement.getElementsByTagName("BU_REGION");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBU_REGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //62 BU_CITY_CODE
                                    NodeList_ = headerElement.getElementsByTagName("BU_CITY_CODE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBU_CITY_CODE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //63 BU_DISTRICTNO
                                    NodeList_ = headerElement.getElementsByTagName("BU_DISTRICTNO");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBU_DISTRICTNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //61 BU_COUNTRY
//                            NodeList_    = headerElement.getElementsByTagName("BU_COUNTRY");
//
//                            Element_  = (Element)NodeList_.item(0);
//                            TextNodeList_    = Element_.getChildNodes();
                                    //Check add BU
                                    if (header_.getBU_STREET() != null || header_.getBU_REGION() != null
                                            || header_.getBU_CITY_CODE() != null || header_.getBU_DISTRICTNO() != null) {
//                                if(TextNodeList_.getLength() != 0)
//                                header_.setBU_COUNTRY(((Node)TextNodeList_.item(0)).getNodeValue());
                                        header_.setBU_COUNTRY("VN");
                                    }

                                    //64 BU_FAX_NUMBER
                                    NodeList_ = headerElement.getElementsByTagName("BU_FAX_NUMBER");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBU_FAX_NUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //65 BU_TEL_NUMBER
                                    NodeList_ = headerElement.getElementsByTagName("BU_TEL_NUMBER");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBU_TEL_NUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //66 BU_E_MAIL
                                    NodeList_ = headerElement.getElementsByTagName("BU_E_MAIL");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBU_E_MAIL(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //67 CO_STREET
                                    NodeList_ = headerElement.getElementsByTagName("CO_STREET");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCO_STREET(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //68 CO_REGION
                                    NodeList_ = headerElement.getElementsByTagName("CO_REGION");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCO_REGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //70 CO_CITY_CODE
                                    NodeList_ = headerElement.getElementsByTagName("CO_CITY_CODE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCO_CITY_CODE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //71 CO_DISTRICTNO
                                    NodeList_ = headerElement.getElementsByTagName("CO_DISTRICTNO");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCO_DISTRICTNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //69 CO_COUNTRY
//                            NodeList_    = headerElement.getElementsByTagName("CO_COUNTRY");
//
//                            Element_  = (Element)NodeList_.item(0);
//                            TextNodeList_    = Element_.getChildNodes();
                                    //Check address CO
                                    if (header_.getCO_STREET() != null || header_.getCO_REGION() != null
                                            || header_.getCO_CITY_CODE() != null || header_.getCO_DISTRICTNO() != null) {
//                                if(TextNodeList_.getLength() != 0)
//                                header_.setCO_COUNTRY(((Node)TextNodeList_.item(0)).getNodeValue());
                                        header_.setCO_COUNTRY("VN");
                                    }

                                    //72 CO_FAX_NUMBER
                                    NodeList_ = headerElement.getElementsByTagName("CO_FAX_NUMBER");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCO_FAX_NUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //73 CO_TEL_NUMBER
                                    NodeList_ = headerElement.getElementsByTagName("CO_TEL_NUMBER");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCO_TEL_NUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //74 CO_E_MAIL
                                    NodeList_ = headerElement.getElementsByTagName("CO_E_MAIL");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCO_E_MAIL(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //75 MANAG_TINOW
                                    NodeList_ = headerElement.getElementsByTagName("MANAG_TINOW");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setMANAG_TINOW(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //76 MANAG_STREET
                                    NodeList_ = headerElement.getElementsByTagName("MANAG_STREET");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setMANAG_STREET(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //77 MANAG_REGION
                                    NodeList_ = headerElement.getElementsByTagName("MANAG_REGION");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setMANAG_REGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //78 MANAG_ONAME
                                    NodeList_ = headerElement.getElementsByTagName("MANAG_ONAME");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setMANAG_ONAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //80 MANAG_CITY_CODE
                                    NodeList_ = headerElement.getElementsByTagName("MANAG_CITY_CODE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setMANAG_CITY_CODE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //81 MANAG_DISTRICTNO
                                    NodeList_ = headerElement.getElementsByTagName("MANAG_DISTRICTNO");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setMANAG_DISTRICTNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //79 MANAG_COUNTRY
//                            NodeList_    = headerElement.getElementsByTagName("MANAG_COUNTRY");
//
//                            Element_  = (Element)NodeList_.item(0);
//                            TextNodeList_    = Element_.getChildNodes();

                                    //Check address MANAG
                                    if (header_.getMANAG_STREET() != null || header_.getMANAG_REGION() != null
                                            || header_.getMANAG_CITY_CODE() != null || header_.getMANAG_DISTRICTNO() != null) {
//                                if(TextNodeList_.getLength() != 0)
//                                header_.setMANAG_COUNTRY(((Node)TextNodeList_.item(0)).getNodeValue());
                                        header_.setMANAG_COUNTRY("VN");
                                    }

                                    //82 MANAG_E_MAIL
                                    NodeList_ = headerElement.getElementsByTagName("MANAG_E_MAIL");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setMANAG_E_MAIL(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //83 BUINFO_NAME_FIRST
                                    NodeList_ = headerElement.getElementsByTagName("BUINFO_NAME_FIRST");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUINFO_NAME_FIRST(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //84 BUINFO_BIRTHDATE
                                    NodeList_ = headerElement.getElementsByTagName("BUINFO_BIRTHDATE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUINFO_BIRTHDATE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //85 BUINFO_STREET
                                    NodeList_ = headerElement.getElementsByTagName("BUINFO_STREET");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUINFO_STREET(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //86 BUINFO_TEL_NUMBER
                                    NodeList_ = headerElement.getElementsByTagName("BUINFO_TEL_NUMBER");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUINFO_TEL_NUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //87 BUINFO_CITY_CODE
                                    NodeList_ = headerElement.getElementsByTagName("BUINFO_CITY_CODE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUINFO_CITY_CODE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //88 BUINFO_DISTRICTNO
                                    NodeList_ = headerElement.getElementsByTagName("BUINFO_DISTRICTNO");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUINFO_DISTRICTNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //89 BUINFO_REGION
                                    NodeList_ = headerElement.getElementsByTagName("BUINFO_REGION");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUINFO_REGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //90 BUINFO_COUNTRY
//                            NodeList_    = headerElement.getElementsByTagName("BUINFO_COUNTRY");
//
//                            Element_  = (Element)NodeList_.item(0);
//                            TextNodeList_    = Element_.getChildNodes();

                                    //Check address BUINFO
                                    if (header_.getBUINFO_STREET() != null || header_.getBUINFO_REGION() != null
                                            || header_.getBUINFO_CITY_CODE() != null || header_.getBUINFO_DISTRICTNO() != null) {
//                                if(TextNodeList_.getLength() != 0)
//                                header_.setBUINFO_COUNTRY(((Node)TextNodeList_.item(0)).getNodeValue());
                                        header_.setBUINFO_COUNTRY("VN");
                                    }
                                    //91 BUINFO_FAX_NUMBER
                                    NodeList_ = headerElement.getElementsByTagName("BUINFO_FAX_NUMBER");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUINFO_FAX_NUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //92 BUINFO_E_MAIL
                                    NodeList_ = headerElement.getElementsByTagName("BUINFO_E_MAIL");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUINFO_E_MAIL(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //93 ADVN_STREET
                                    NodeList_ = headerElement.getElementsByTagName("ADVN_STREET");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setADVN_STREET(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //94 ADVN_CITY_CODE
                                    NodeList_ = headerElement.getElementsByTagName("ADVN_CITY_CODE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setADVN_CITY_CODE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //95 ADVN_DISTRICTNO
                                    NodeList_ = headerElement.getElementsByTagName("ADVN_DISTRICTNO");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setADVN_DISTRICTNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //96 ADVN_REGION
                                    NodeList_ = headerElement.getElementsByTagName("ADVN_REGION");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setADVN_REGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //97 ADVN_COUNTRY
//                            NodeList_    = headerElement.getElementsByTagName("ADVN_COUNTRY");
//
//                            Element_  = (Element)NodeList_.item(0);
//                            TextNodeList_    = Element_.getChildNodes();

                                    //Check address ADVN
                                    if (header_.getADVN_STREET() != null || header_.getADVN_REGION() != null
                                            || header_.getADVN_CITY_CODE() != null || header_.getADVN_DISTRICTNO() != null) {
//                                if(TextNodeList_.getLength() != 0)
//                                header_.setADVN_COUNTRY(((Node)TextNodeList_.item(0)).getNodeValue());
                                        header_.setADVN_COUNTRY("VN");
                                    }
                                    //98 ADVN_TEL_NUMBER
                                    NodeList_ = headerElement.getElementsByTagName("ADVN_TEL_NUMBER");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setADVN_TEL_NUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //99 ADVN_FAX_NUMBER
                                    NodeList_ = headerElement.getElementsByTagName("ADVN_FAX_NUMBER");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setADVN_FAX_NUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //100 ADVN_E_MAIL
                                    NodeList_ = headerElement.getElementsByTagName("ADVN_E_MAIL");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setADVN_E_MAIL(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //101 LEGAL_ORG
                                    NodeList_ = headerElement.getElementsByTagName("LEGAL_ORG");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setLEGAL_ORG(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //102 ECO_ID
                                    NodeList_ = headerElement.getElementsByTagName("ECO_ID");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setECO_ID(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //103 ACC_DEPEND
                                    NodeList_ = headerElement.getElementsByTagName("ACC_DEPEND");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setACC_DEPEND(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //104 JNT_CIRCULAR
                                    NodeList_ = headerElement.getElementsByTagName("JNT_CIRCULAR");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setJNT_CIRCULAR(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //105 REPL_PAYAGENCY
                                    NodeList_ = headerElement.getElementsByTagName("REPL_PAYAGENCY");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setREPL_PAYAGENCY(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //106 CONT_TINVN
                                    NodeList_ = headerElement.getElementsByTagName("CONT_TINVN");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCONT_TINVN(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //107 CONT_COFDA
                                    NodeList_ = headerElement.getElementsByTagName("CONT_COFDA");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCONT_COFDA(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //108 CONT_COTDA
                                    NodeList_ = headerElement.getElementsByTagName("CONT_COTDA");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCONT_COTDA(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //109 CONT_WADDR
                                    NodeList_ = headerElement.getElementsByTagName("CONT_WADDR");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setCONT_WADDR(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //110 ATT_DOC
                                    NodeList_ = headerElement.getElementsByTagName("ATT_DOC");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setATT_DOC(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //111 ORRES
                                    NodeList_ = headerElement.getElementsByTagName("ORRES");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setORRES(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //112 FRN_STREET
                                    NodeList_ = headerElement.getElementsByTagName("FRN_STREET");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setFRN_STREET(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //113 FRN_TEL_NUMBER
                                    NodeList_ = headerElement.getElementsByTagName("FRN_TEL_NUMBER");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setFRN_TEL_NUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //114 FRN_FAX_NUMBER
                                    NodeList_ = headerElement.getElementsByTagName("FRN_FAX_NUMBER");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setFRN_FAX_NUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //115 FRN_COUNTRY
//                            NodeList_    = headerElement.getElementsByTagName("FRN_COUNTRY");
//
//                            Element_  = (Element)NodeList_.item(0);
//                            TextNodeList_    = Element_.getChildNodes();
                                    //Check address FRN
                                    if (header_.getFRN_STREET() != null) {
                                        header_.setFRN_COUNTRY("ZZ");
                                    }
                                    //116 TWD_TIN
                                    NodeList_ = headerElement.getElementsByTagName("TWD_TIN");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setTWD_TIN(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //117 REG_CASE_ID
                                    NodeList_ = headerElement.getElementsByTagName("REG_CASE_ID");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setREG_CASE_ID(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //118 BANK_NAME_TEXT
                                    NodeList_ = headerElement.getElementsByTagName("BANK_NAME_TEXT");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBANK_NAME_TEXT(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //119 BANK_ACC_TEXT
                                    NodeList_ = headerElement.getElementsByTagName("BANK_ACC_TEXT");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBANK_ACC_TEXT(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //120 END_TEMP_CLOSE_DATE
                                    NodeList_ = headerElement.getElementsByTagName("END_TEMP_CLOSE_DATE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setET_CLOSE_DATE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //121 NNKD
                                    NodeList_ = headerElement.getElementsByTagName("NNKD");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setNNKD(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //122 BRAN_TYPE
                                    NodeList_ = headerElement.getElementsByTagName("BRAN_TYPE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBRAN_TYPE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //123 RESTORE_DATE
                                    NodeList_ = headerElement.getElementsByTagName("RESTORE_DATE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setRESTORE_DATE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //124 START_TEMP_CLOSE_DATE
                                    NodeList_ = headerElement.getElementsByTagName("START_TEMP_CLOSE_DATE");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setST_CLOSE_DATE(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //125 INFDA 
                                    NodeList_ = headerElement.getElementsByTagName("INFDA");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setINFDA(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //126 ORFDA
                                    NodeList_ = headerElement.getElementsByTagName("ORFDA");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setORFDA(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //127 VATID
                                    NodeList_ = headerElement.getElementsByTagName("VATID");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setVATID(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //128 ACTI_GOAL
                                    NodeList_ = headerElement.getElementsByTagName("ACTI_GOAL");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setACTI_GOAL(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //129 ODA
                                    NodeList_ = headerElement.getElementsByTagName("ODA");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setODA(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //130 ORRESBK
                                    NodeList_ = headerElement.getElementsByTagName("ORRESBK");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setORRESBK(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //131 PROV_DES
                                    NodeList_ = headerElement.getElementsByTagName("PROV_DES");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setPROV_DES(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //132 BUKRN
                                    NodeList_ = headerElement.getElementsByTagName("BUKRN");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setBUKRN(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //133 YN_NBRS
                                    NodeList_ = headerElement.getElementsByTagName("YN_NBRS");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setYN_NBRS(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }

                                    //134 ENTERPRISE_ID
                                    NodeList_ = headerElement.getElementsByTagName("ENTERPRISE_ID");

                                    Element_ = (Element) NodeList_.item(0);
                                    TextNodeList_ = Element_.getChildNodes();

                                    if (TextNodeList_.getLength() != 0) {
                                        header_.setENTERPRISE_ID(((Node) TextNodeList_.item(0)).getNodeValue());
                                    }


                                }//End IF - Element Header

                                //** <!--01.REGTAX_ID_ALL -->
                                NodeList nodeListDetail_01 = NNTElement.getElementsByTagName("DATA_01");

                                for (int d = 0; d < nodeListDetail_01.getLength(); d++) {
                                    Node Detail_01Node = nodeListDetail_01.item(d);

                                    if (Detail_01Node.getNodeType() == Node.ELEMENT_NODE) {

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        REGTAX_ID2 tax_all = new REGTAX_ID2();

                                        Element Detail_01Element = (Element) Detail_01Node;
                                        //TYPE
                                        NodeList_ = Detail_01Element.getElementsByTagName("TYPE");
                                        Element_ = (Element) NodeList_.item(0);
                                        TextNodeList_ = Element_.getChildNodes();

                                        if (TextNodeList_.getLength() != 0) {
                                            tax_all.setTYPE(((Node) TextNodeList_.item(0)).getNodeValue());
                                        }


                                        //IDNUMBER
                                        NodeList_ = Detail_01Element.getElementsByTagName("IDNUMBER");
                                        Element_ = (Element) NodeList_.item(0);
                                        TextNodeList_ = Element_.getChildNodes();

                                        if (TextNodeList_.getLength() != 0) {
                                            tax_all.setIDNUMBER(((Node) TextNodeList_.item(0)).getNodeValue());
                                        }

                                        //INSTITUTE
                                        NodeList_ = Detail_01Element.getElementsByTagName("INSTITUTE");
                                        Element_ = (Element) NodeList_.item(0);
                                        TextNodeList_ = Element_.getChildNodes();

                                        if (TextNodeList_.getLength() != 0) {
                                            tax_all.setINSTITUTE(((Node) TextNodeList_.item(0)).getNodeValue());
                                        }

                                        //ENTRY_DATE
                                        NodeList_ = Detail_01Element.getElementsByTagName("ENTRY_DATE");
                                        Element_ = (Element) NodeList_.item(0);
                                        TextNodeList_ = Element_.getChildNodes();

                                        if (TextNodeList_.getLength() != 0) {
                                            tax_all.setENTRY_DATE(((Node) TextNodeList_.item(0)).getNodeValue());
                                        }

                                        // Get data and add to array
                                        regtax_id_all.add(tax_all);

                                    }

                                }

                                //** <!-- 02.TAX_PAYABLE_ORG -->                                  

                                NodeList nodeListDetail_02 = NNTElement.getElementsByTagName("DATA_02");
                                //Check xem có tồn tại detail hay không
                                if (nodeListDetail_02.getLength() != 0) {
                                    for (int d2 = 0; d2 < nodeListDetail_02.getLength(); d2++) {
                                        Node DetailNode = nodeListDetail_02.item(d2);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (DetailNode.getNodeType() == Node.ELEMENT_NODE) {

                                            TAX_PAYABLE tax_pay = new TAX_PAYABLE();

                                            Element DetailElement = (Element) DetailNode;
                                            // Get ITEM_ID
                                            NodeList_ = DetailElement.getElementsByTagName("ITEM_ID");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                tax_pay.setItem_id(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            tax_payable.add(tax_pay);
                                        }

                                    }

                                }//End check

                                //** <!-- 03.BUSI_MAIN_ORG -->                                    

                                NodeList nodeListDetail_03 = NNTElement.getElementsByTagName("DATA_03");

                                //Check tồn tại detail
                                if (nodeListDetail_03.getLength() != 0) {

                                    for (int d3 = 0; d3 < nodeListDetail_03.getLength(); d3++) {
                                        Node Detail_Node = nodeListDetail_03.item(d3);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (Detail_Node.getNodeType() == Node.ELEMENT_NODE) {

                                            BUSI_MAIN busi_main_ = new BUSI_MAIN();

                                            Element DetailElement = (Element) Detail_Node;

                                            //IND_SECTOR
                                            NodeList_ = DetailElement.getElementsByTagName("IND_SECTOR");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                busi_main_.setIND_SECTOR(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //ISDEF
                                            NodeList_ = DetailElement.getElementsByTagName("ISDEF");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                busi_main_.setISDEF(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            busi_main.add(busi_main_);
                                        }

                                    }

                                } //End check

                                //** <!-- 05.BRANCH_ORG -->                                       

                                NodeList nodeListDetail_05 = NNTElement.getElementsByTagName("DATA_05");
                                //Check tồn tại detail
                                if (nodeListDetail_05.getLength() != 0) {

                                    for (int d2 = 0; d2 < nodeListDetail_05.getLength(); d2++) {
                                        Node DetailNode = nodeListDetail_05.item(d2);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (DetailNode.getNodeType() == Node.ELEMENT_NODE) {

                                            BRANCH_ORG branch = new BRANCH_ORG();

                                            Element DetailElement = (Element) DetailNode;

                                            //BRA_TIN
                                            NodeList_ = DetailElement.getElementsByTagName("BRA_TIN");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                branch.setBRA_TIN(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //NAME
                                            NodeList_ = DetailElement.getElementsByTagName("NAME");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                branch.setNAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //ADDRESS
                                            NodeList_ = DetailElement.getElementsByTagName("ADDRESS");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                branch.setADDRESS(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //REGION
                                            NodeList_ = DetailElement.getElementsByTagName("REGION");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                branch.setREGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CITY_CODE
                                            NodeList_ = DetailElement.getElementsByTagName("CITY_CODE");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                branch.setCITY_CODE(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //STATUS
                                            NodeList_ = DetailElement.getElementsByTagName("STATUS");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                branch.setSTATUS(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //TYPE
                                            NodeList_ = DetailElement.getElementsByTagName("TYPE");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                branch.setTYPE(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            branch_org.add(branch);

                                        }

                                    }

                                }//End check

                                //** <!-- 06.SUBDIARY_ORG-->                        

                                NodeList nodeListDetail_06 = NNTElement.getElementsByTagName("DATA_06");
                                //Check tồn tại detail
                                if (nodeListDetail_06.getLength() != 0) {

                                    for (int d2 = 0; d2 < nodeListDetail_06.getLength(); d2++) {
                                        Node DetailNode = nodeListDetail_06.item(d2);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (DetailNode.getNodeType() == Node.ELEMENT_NODE) {

                                            SUBDIARY subdiary_ = new SUBDIARY();


                                            Element DetailElement = (Element) DetailNode;
                                            //SUB_TIN
                                            NodeList_ = DetailElement.getElementsByTagName("SUB_TIN");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subdiary_.setSUB_TIN(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //SUB_ID_TINC
                                            NodeList_ = DetailElement.getElementsByTagName("SUB_ID_TINC");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subdiary_.setSUB_ID_TINC(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //NAME
                                            NodeList_ = DetailElement.getElementsByTagName("NAME");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subdiary_.setNAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //ADDRESS
                                            NodeList_ = DetailElement.getElementsByTagName("ADDRESS");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subdiary_.setADDRESS(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //REGION
                                            NodeList_ = DetailElement.getElementsByTagName("REGION");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subdiary_.setREGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }
                                            //CITY_CODE
                                            NodeList_ = DetailElement.getElementsByTagName("CITY_CODE");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subdiary_.setCITY_CODE(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            // Get data and add to array
                                            subdiary.add(subdiary_);

                                        }

                                    }

                                }//End check

                                //** <!--07.JOIN_ORG -->                                          

                                NodeList nodeListDetail_07 = NNTElement.getElementsByTagName("DATA_07");
                                //Check tồn tại detail
                                if (nodeListDetail_07.getLength() != 0) {

                                    for (int d2 = 0; d2 < nodeListDetail_07.getLength(); d2++) {
                                        Node DetailNode = nodeListDetail_07.item(d2);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (DetailNode.getNodeType() == Node.ELEMENT_NODE) {

                                            JOIN_ORG join_org_ = new JOIN_ORG();


                                            Element DetailElement = (Element) DetailNode;
                                            //JOIN_TIN
                                            NodeList_ = DetailElement.getElementsByTagName("JOIN_TIN");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                join_org_.setJOIN_TIN(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //JOIN_ID_TINC
                                            NodeList_ = DetailElement.getElementsByTagName("JOIN_ID_TINC");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                join_org_.setJOIN_ID_TINC(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //NAME
                                            NodeList_ = DetailElement.getElementsByTagName("NAME");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                join_org_.setNAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //ADDRESS
                                            NodeList_ = DetailElement.getElementsByTagName("ADDRESS");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                join_org_.setADDRESS(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //REGION
                                            NodeList_ = DetailElement.getElementsByTagName("REGION");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                join_org_.setREGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CITY
                                            NodeList_ = DetailElement.getElementsByTagName("CITY");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                join_org_.setCITY(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            // Get data and add to array
                                            join_org.add(join_org_);
                                        }
                                    }

                                }//End check

                                //** <!-- 08.WAREHOUSE_ORG -->                                    *

                                NodeList nodeListDetail_08 = NNTElement.getElementsByTagName("DATA_08");
                                //Check tồn tại detail
                                if (nodeListDetail_08.getLength() != 0) {

                                    for (int d2 = 0; d2 < nodeListDetail_08.getLength(); d2++) {
                                        Node DetailNode = nodeListDetail_08.item(d2);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (DetailNode.getNodeType() == Node.ELEMENT_NODE) {

                                            WAREHOUSE_ORG warehouse_org_ = new WAREHOUSE_ORG();


                                            Element DetailElement = (Element) DetailNode;
                                            //TIN_WARE_ID
                                            NodeList_ = DetailElement.getElementsByTagName("TIN_WARE_ID");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                warehouse_org_.setTIN_WARE_ID(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //DKDN_WAR_ID
                                            NodeList_ = DetailElement.getElementsByTagName("DKDN_WAR_ID");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                warehouse_org_.setDKDN_WAR_ID(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //NAME
                                            NodeList_ = DetailElement.getElementsByTagName("NAME");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                warehouse_org_.setNAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //ADDRESS
                                            NodeList_ = DetailElement.getElementsByTagName("ADDRESS");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                warehouse_org_.setADDRESS(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //REGION
                                            NodeList_ = DetailElement.getElementsByTagName("REGION");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                warehouse_org_.setREGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CITY
                                            NodeList_ = DetailElement.getElementsByTagName("CITY");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                warehouse_org_.setCITY(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //TYPE
                                            NodeList_ = DetailElement.getElementsByTagName("TYPE");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                warehouse_org_.setTYPE(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            // Get data and add to array
                                            warehouse.add(warehouse_org_);

                                        }

                                    }

                                }//End check

                                //** <!-- 09.FOREIGNER_ORG  -->                                   

                                NodeList nodeListDetail_09 = NNTElement.getElementsByTagName("DATA_09");

                                //Check tồn tại detail
                                if (nodeListDetail_09.getLength() != 0) {

                                    for (int d2 = 0; d2 < nodeListDetail_09.getLength(); d2++) {
                                        Node DetailNode = nodeListDetail_09.item(d2);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (DetailNode.getNodeType() == Node.ELEMENT_NODE) {

                                            FOREIGNER foreigner_ = new FOREIGNER();

                                            Element DetailElement = (Element) DetailNode;
                                            //CONT_ID
                                            NodeList_ = DetailElement.getElementsByTagName("CONT_ID_TINC");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setCONT_ID_TINC(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //NAME
                                            NodeList_ = DetailElement.getElementsByTagName("NAME");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setNAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //COUNTRY
                                            NodeList_ = DetailElement.getElementsByTagName("COUNTRY");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setCOUNTRY(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //TINVN
                                            NodeList_ = DetailElement.getElementsByTagName("TINVN");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setTINVN(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //TINFR
                                            NodeList_ = DetailElement.getElementsByTagName("TINFR");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setTINFR(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CTNO
                                            NodeList_ = DetailElement.getElementsByTagName("CTNO");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setCTNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CTVAL
                                            NodeList_ = DetailElement.getElementsByTagName("CTVAL");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setCTVAL(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CTVALW
                                            NodeList_ = DetailElement.getElementsByTagName("CTVALW");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setCTVALW(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //COFDA
                                            NodeList_ = DetailElement.getElementsByTagName("COFDA");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setCOFDA(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //COTDA
                                            NodeList_ = DetailElement.getElementsByTagName("COTDA");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setCOTDA(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //EMPNB
                                            NodeList_ = DetailElement.getElementsByTagName("EMPNB");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setEMPNB(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //BUSS_LICE
                                            NodeList_ = DetailElement.getElementsByTagName("BUSS_LICE");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setBUSS_LICE(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //BUSS_DATE
                                            NodeList_ = DetailElement.getElementsByTagName("BUSS_DATE");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setBUSS_DATE(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //BUSS_OFFI
                                            NodeList_ = DetailElement.getElementsByTagName("BUSS_OFFI");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setBUSS_OFFI(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CONT_OBJECT
                                            NodeList_ = DetailElement.getElementsByTagName("CONT_OBJECT");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setCONT_OBJECT(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CONT_LOCA
                                            NodeList_ = DetailElement.getElementsByTagName("CONT_LOCA");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setCONT_LOCA(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //BEGIN_DATE
                                            NodeList_ = DetailElement.getElementsByTagName("BEGIN_DATE");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setBEGIN_DATE(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //YN_CONT
                                            NodeList_ = DetailElement.getElementsByTagName("YN_CONT");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setYN_CONT(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //VAT_ITEM
                                            NodeList_ = DetailElement.getElementsByTagName("VAT_ITEM");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setVAT_ITEM(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //REVE_ITEM
                                            NodeList_ = DetailElement.getElementsByTagName("REVE_ITEM");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setREVE_ITEM(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //INCO_ITEM
                                            NodeList_ = DetailElement.getElementsByTagName("INCO_ITEM");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setINCO_ITEM(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //RESU_METH
                                            NodeList_ = DetailElement.getElementsByTagName("RESU_METH");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setRESU_METH(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CONT_TYPE
                                            NodeList_ = DetailElement.getElementsByTagName("CONT_TYPE");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setCONT_TYPE(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //ATT_DOC
                                            NodeList_ = DetailElement.getElementsByTagName("ATT_DOC");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                foreigner_.setATT_DOC(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            // Get data and add to array                                
                                            foreigner.add(foreigner_);
                                        }

                                    }

                                }//End check


                                //** <!-- 10.SUBCONT_ORG -->                                      

                                NodeList nodeListDetail_10 = NNTElement.getElementsByTagName("DATA_10");
                                //Check tồn tại detail
                                if (nodeListDetail_10.getLength() != 0) {

                                    for (int d2 = 0; d2 < nodeListDetail_10.getLength(); d2++) {
                                        Node DetailNode = nodeListDetail_10.item(d2);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (DetailNode.getNodeType() == Node.ELEMENT_NODE) {

                                            SUBCONT_ORG subcont_org_ = new SUBCONT_ORG();


                                            Element DetailElement = (Element) DetailNode;
                                            //CONT_ID_TINC
                                            NodeList_ = DetailElement.getElementsByTagName("CONT_ID_TINC");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setCONT_ID_TINC(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //SUBCON_ID_TINC
                                            NodeList_ = DetailElement.getElementsByTagName("SUBCON_ID_TINC");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setSUBCON_ID_TINC(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //NAME
                                            NodeList_ = DetailElement.getElementsByTagName("NAME");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setNAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //COUNTRY
                                            NodeList_ = DetailElement.getElementsByTagName("COUNTRY");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setCOUNTRY(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //TINFR
                                            NodeList_ = DetailElement.getElementsByTagName("TINFR");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setTINFR(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //TINVN
                                            NodeList_ = DetailElement.getElementsByTagName("TINVN");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setTINVN(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CTNO
                                            NodeList_ = DetailElement.getElementsByTagName("CTNO");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setCTNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CTVAL
                                            NodeList_ = DetailElement.getElementsByTagName("CTVAL");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setCTVAL(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CTVALW
                                            NodeList_ = DetailElement.getElementsByTagName("CTVALW");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setCTVALW(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CONT_LOCA
                                            NodeList_ = DetailElement.getElementsByTagName("CONT_LOCA");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setCONT_LOCA(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //EMPNB
                                            NodeList_ = DetailElement.getElementsByTagName("EMPNB");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                subcont_org_.setEMPNB(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            // Get data and add to array
                                            subcont.add(subcont_org_);

                                        }

                                    }

                                }//End check

                                //** <!-- 11.DIPLOMATIC_ORG  -->                                  

                                NodeList nodeListDetail_11 = NNTElement.getElementsByTagName("DATA_11");

                                //Check tồn tại detail
                                if (nodeListDetail_11.getLength() != 0) {

                                    for (int d2 = 0; d2 < nodeListDetail_11.getLength(); d2++) {
                                        Node DetailNode = nodeListDetail_11.item(d2);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (DetailNode.getNodeType() == Node.ELEMENT_NODE) {

                                            DIPLOMATIC diplomatic_org_ = new DIPLOMATIC();


                                            Element DetailElement = (Element) DetailNode;
                                            //STAFF_ID
                                            NodeList_ = DetailElement.getElementsByTagName("STAFF_ID_TINC");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                diplomatic_org_.setSTAFF_ID_TINC(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //NAME
                                            NodeList_ = DetailElement.getElementsByTagName("NAME");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                diplomatic_org_.setNAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //NATIONALITY
                                            NodeList_ = DetailElement.getElementsByTagName("NATIONALITY");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                diplomatic_org_.setNATIONALITY(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //STAFF_POS
                                            NodeList_ = DetailElement.getElementsByTagName("STAFF_POS");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                diplomatic_org_.setSTAFF_POS(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //ID_CARD_NO
                                            NodeList_ = DetailElement.getElementsByTagName("ID_CARD_NO");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                diplomatic_org_.setID_CARD_NO(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            diplomatic.add(diplomatic_org_);

                                        }

                                    }

                                }//End check

                                //** <!-- 12.PROJ_CONT_ORG -->                                    

                                NodeList nodeListDetail_12 = NNTElement.getElementsByTagName("DATA_12");

                                //Check tồn tại detail
                                if (nodeListDetail_12.getLength() != 0) {

                                    for (int d2 = 0; d2 < nodeListDetail_12.getLength(); d2++) {
                                        Node DetailNode = nodeListDetail_12.item(d2);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (DetailNode.getNodeType() == Node.ELEMENT_NODE) {

                                            PROJ_CONT proj_cont_org_ = new PROJ_CONT();


                                            Element DetailElement = (Element) DetailNode;
                                            //PROCON_TIN
                                            NodeList_ = DetailElement.getElementsByTagName("PROCON_TIN");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setPROCON_TIN(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //NAME
                                            NodeList_ = DetailElement.getElementsByTagName("NAME");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setNAME(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //COUNTRY
                                            NodeList_ = DetailElement.getElementsByTagName("COUNTRY");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setCOUNTRY(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //REGION
                                            NodeList_ = DetailElement.getElementsByTagName("REGION");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setREGION(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CITY_CODE
                                            NodeList_ = DetailElement.getElementsByTagName("CITY_CODE");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setCITY_CODE(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CTNO
                                            NodeList_ = DetailElement.getElementsByTagName("CTNO");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setCTNO(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CTVAL
                                            NodeList_ = DetailElement.getElementsByTagName("CTVAL");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setCTVAL(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CTVALW
                                            NodeList_ = DetailElement.getElementsByTagName("CTVALW");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setCTVALW(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CONT_DATE
                                            NodeList_ = DetailElement.getElementsByTagName("CONT_DATE");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setCONT_DATE(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //EMPL_NO
                                            NodeList_ = DetailElement.getElementsByTagName("EMPL_NO");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setEMPL_NO(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //STATUS
                                            NodeList_ = DetailElement.getElementsByTagName("STATUS");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                proj_cont_org_.setSTATUS(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            // Get data and add to array
                                            proj_cont.add(proj_cont_org_);
                                        }
                                    }

                                }//End check

                                //** <!-- 13.REG_FORM -->                                  

                                NodeList nodeListDetail_13 = NNTElement.getElementsByTagName("DATA_13");

                                //Check tồn tại detail
                                if (nodeListDetail_13.getLength() != 0) {

                                    for (int i = 0; i < nodeListDetail_13.getLength(); i++) {
                                        Node Detail_Node = nodeListDetail_13.item(i);

                                        NodeList_ = null;
                                        Element_ = null;
                                        TextNodeList_ = null;

                                        if (Detail_Node.getNodeType() == Node.ELEMENT_NODE) {

                                            REGFORM reg_frm = new REGFORM();

                                            Element DetailElement = (Element) Detail_Node;

                                            //REGCER_RVK
                                            NodeList_ = DetailElement.getElementsByTagName("REGCER_RVK");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                reg_frm.setREGCER_RVK(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //REGCER_LST
                                            NodeList_ = DetailElement.getElementsByTagName("REGCER_LST");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                reg_frm.setREGCER_LST(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //FINAL_TAX
                                            NodeList_ = DetailElement.getElementsByTagName("FINAL_TAX");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                reg_frm.setFINAL_TAX(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //BILL_SETTELED
                                            NodeList_ = DetailElement.getElementsByTagName("BILL_SETTELED");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                reg_frm.setBILL_SETTELED(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //BILL_NOTUSED
                                            NodeList_ = DetailElement.getElementsByTagName("BILL_NOTUSED");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                reg_frm.setBILL_NOTUSED(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //CUSDUTY_FSH
                                            NodeList_ = DetailElement.getElementsByTagName("CUSDUTY_FSH");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                reg_frm.setCUSDUTY_FSH(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //BUSCER_RVK
                                            NodeList_ = DetailElement.getElementsByTagName("BUSCER_RVK");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                reg_frm.setBUSCER_RVK(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //NO_DEBT
                                            NodeList_ = DetailElement.getElementsByTagName("NO_DEBT");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                reg_frm.setNO_DEBT(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            //BRH_TIN_CLS
                                            NodeList_ = DetailElement.getElementsByTagName("BRH_TIN_CLS");
                                            Element_ = (Element) NodeList_.item(0);
                                            TextNodeList_ = Element_.getChildNodes();

                                            if (TextNodeList_.getLength() != 0) {
                                                reg_frm.setBRH_TIN_CLS(((Node) TextNodeList_.item(0)).getNodeValue());
                                            }

                                            // Get data and add to array
                                            reg_form.add(reg_frm);
                                        }

                                    }

                                } //End check

                            }//End element NNT

                            nnt = new DataNNT(header_, regtax_id_all, tax_payable, busi_main, branch_org,
                                    subdiary, join_org, warehouse, foreigner, subcont, diplomatic, proj_cont, reg_form);

                            //******************* CONVERT & BACKUP ************************
                            //-------------------------------------------------------------                    
                            // Load data từng file lên queue                    
                            ConvertDKT.loadQueue(nnt);

                        }//End for - Data NNT             
                        //Load BP
                        ConvertDKT.loadBP(c_add);
                        //
                        // Convert từng file xml
                        ConvertDKT.runConvert(num_thread, c_add, del_caco);
                        // Move file
                        Utility.moveFiles(srcFile, tgrFld);
                    }//EndIF - get file XML

                }//End for - End scand forder

                //sưa

            }//End for - End scand files
        } catch (SAXParseException err) {
            //Check Parser XML and close file        
            err.printStackTrace();
            throw new RuntimeException("Lỗi SAXParseException trong XML file name: " + ReadXML.getFile_name() + ", lines: " + err.getLineNumber(), err.getException());
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi trong XML file name: " + ReadXML.getFile_name(), e);
        } catch (ExceptionInInitializerError ExInt) {
            //throw new RuntimeException("Lỗi ExceptionInInitializerError trong XML file name: "+ReadXML.getFile_name(), ExInt);
        }
    }
    //Tên file XML đang quét
    private static String file_name;

    public static String getFile_name() {
        return file_name;
    }

    public static void setFile_name(String file_name) {
        ReadXML.file_name = file_name;
    }
    //Đường dẫn và file XML đang quét
    private static String dir_file;

    public static String getDir_file() {
        return dir_file;
    }

    public static void setDir_file(String dir_file) {
        ReadXML.dir_file = dir_file;
    }
}