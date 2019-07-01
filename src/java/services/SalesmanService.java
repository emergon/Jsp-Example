/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.SalesmanDao;
import entities.Salesman;
import java.util.List;

/**
 *
 * @author anastasios
 */
public class SalesmanService {
    SalesmanDao sdao;
    
    public SalesmanService(){
        sdao = new SalesmanDao();
    }
    
    
    public List<Salesman> getAllSalesmen(){
        return getSdao().getAllSalesmen();
    }
    
    private SalesmanDao getSdao(){
        if(sdao == null){
            sdao = new SalesmanDao();
        }
        return sdao;
    }
}
