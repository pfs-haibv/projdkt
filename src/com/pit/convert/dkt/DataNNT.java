package com.pit.convert.dkt;

import com.pit.convert.datatype.*;
import java.util.ArrayList;

/**
 *
 * @author HAIBV
 */
public class DataNNT {
    
    //Header
    Header hdr                = new Header();
    UpdateRegTax retax_update = new UpdateRegTax() ;
    //<!--01.REGTAX_ID_ALL -->
    ArrayList <REGTAX_ID2> regtax_id_all = new ArrayList<REGTAX_ID2>();
    //<!-- 02.TAX_PAYABLE_ORG -->
    ArrayList <TAX_PAYABLE> tax_payable  = new ArrayList<TAX_PAYABLE>();
    //<!-- 03.BUSI_MAIN_ORG -->
    ArrayList <BUSI_MAIN> busi_main      = new ArrayList<BUSI_MAIN>();
    //<!-- 05.BRANCH_ORG -->
    ArrayList <BRANCH_ORG> branch_org    = new ArrayList<BRANCH_ORG>();
    //<!-- 06.SUBDIARY_ORG-->
    ArrayList <SUBDIARY> subdiary        = new ArrayList<SUBDIARY>();
    //<!--07.JOIN_ORG-->
    ArrayList <JOIN_ORG> join_org        = new ArrayList<JOIN_ORG>();
    //<!-- 08.WAREHOUSE_ORG -->
    ArrayList <WAREHOUSE_ORG> warehouse  = new ArrayList<WAREHOUSE_ORG>();
    //<!-- 09.FOREIGNER_ORG -->
    ArrayList <FOREIGNER> foreigner      = new ArrayList<FOREIGNER>();
    //<!-- 10.SUBCONT_ORG -->
    ArrayList <SUBCONT_ORG> subcont      = new ArrayList<SUBCONT_ORG>();
    //<!-- 11.DIPLOMATIC_ORG-->
    ArrayList <DIPLOMATIC> Diplomatic    = new ArrayList<DIPLOMATIC>();
    //<!-- 12.PROJ_CONT_ORG -->
    ArrayList <PROJ_CONT> proj_cont      = new ArrayList<PROJ_CONT>();
    //<!-- 13.REGFORM -->
    ArrayList <REGFORM> reg_form         = new ArrayList<REGFORM>();
    

    // Khởi tạo mảng NNT
    public DataNNT(Header hdr, ArrayList <REGTAX_ID2> regtax_id_all,ArrayList <TAX_PAYABLE> tax_payable,ArrayList <BUSI_MAIN> busi_main,
                   ArrayList <BRANCH_ORG> branch_org,ArrayList <SUBDIARY> subdiary,ArrayList <JOIN_ORG> join_org,ArrayList <WAREHOUSE_ORG> warehouse,
                   ArrayList <FOREIGNER> foreigner,ArrayList <SUBCONT_ORG> subcont,ArrayList <DIPLOMATIC> Diplomatic,ArrayList <PROJ_CONT> proj_cont,
                   ArrayList <REGFORM> reg_form
            ) {

        this.hdr = hdr;
        
        for (int i=0; i<regtax_id_all.size();i++)
            this.regtax_id_all.add(regtax_id_all.get(i));

        for (int i=0; i<tax_payable.size();i++)
            this.tax_payable.add(tax_payable.get(i));

        for (int i=0; i<busi_main.size();i++)
            this.busi_main.add(busi_main.get(i));

        for (int i=0; i<branch_org.size();i++)
            this.branch_org.add(branch_org.get(i));

        for (int i=0; i<subdiary.size();i++)
            this.subdiary.add(subdiary.get(i));

        for (int i=0; i<join_org.size();i++)
            this.join_org.add(join_org.get(i));

        for (int i=0; i<warehouse.size();i++)
            this.warehouse.add(warehouse.get(i));

        for (int i=0; i<foreigner.size();i++)
            this.foreigner.add(foreigner.get(i));

        for (int i=0; i<subcont.size();i++)
            this.subcont.add(subcont.get(i));

        for (int i=0; i<Diplomatic.size();i++)
            this.Diplomatic.add(Diplomatic.get(i));        

        for (int i=0; i<proj_cont.size();i++)
            this.proj_cont.add(proj_cont.get(i));
        
        for (int i=0; i<reg_form.size();i++)
            this.reg_form.add(reg_form.get(i));        
    }

}