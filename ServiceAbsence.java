/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataBase.DataBase;
import Entité.Absence;
import Entité.Note;
import IService.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ServiceAbsence {
    private Connection con;
    private Statement ste;
    private PreparedStatement pre;
    private ResultSet rs;
    
    public ServiceAbsence() {
        con = DataBase.getInstance().getConnection();

    }
    public void affecter_absence(Absence a) throws SQLException{
    PreparedStatement pre=con.prepareStatement("INSERT INTO `ecole`.`absence` ( `nb_absence`,`id_class`, `id_apprenant`) VALUES ( ?, ?, ?);");
    pre.setInt(1, a.getNb_absence());
    pre.setInt(2, a.getC().getId_class());
    pre.setInt(3, a.getA().getId_apprenant());
    pre.executeUpdate();
    
    }
    
    //Absence Modifié
     public boolean update(Absence a) throws SQLException {

   ste = con.createStatement();
 String query = ("UPDATE absence SET nb_absence = '"+a.getNb_absence()+"'WHERE id_absence = '"+a.getId_absence()+"'");
    
   if(ste.executeUpdate(query)!=0){
        System.out.println("Absence est modifier");
    return true;
    }else{
    return false;
    }
     }
     
    
//         public List<Absence> afficher() throws SQLException {    
//    List<Absence> arr=new ArrayList<>();
//    ste=con.createStatement();
//    ResultSet rs=ste.executeQuery("SELECT  niveau, type, numero, nom, nb_absence "
//            + "FROM absence "
//            + "INNER JOIN apprenant ON apprenant.id_apprenant = absence.id_apprenant "
//            + "INNER JOIN class ON class.id_class = absence.id_class"
//            
//            
//                                    );
//
//     while (rs.next()) {            
//                System.out.println("---------------------------");
//                System.out.println("Niveau: "+rs.getInt(1)); 
//                System.out.println("Type: "+rs.getString("type"));
//                System.out.println("numero: "+rs.getInt(3));
//                System.out.println("Nom_apprenant: "+rs.getString("nom"));
//                System.out.println("nb_absence: "+rs.getInt(5));
//                // System.out.println("ID_Note: "+rs.getInt(5));
//
//             
// 
//     }
//
//    return arr;
//    }
         
      public boolean rechercherParCinParent(int cin_parent) throws SQLException{
     String req1="SELECT * FROM note WHERE id_apprenant="+cin_parent;
       // PreparedStatement pre=con.prepareStatement(req1);
        ste=con.createStatement();
        rs=ste.executeQuery(req1);
        rs.last();
        int nbrRow=rs.getRow();
         if(nbrRow ==1){
            System.out.println("Apprenant avec Note");
        }else{
             System.out.println("Apprenant sans Note");

        }
        return true; 
    }
         public List<Absence> afficher() {   
 
          ServiceClass sc=new ServiceClass();
          ServiceApprenant sap=new ServiceApprenant();
    

        String req="select * from absence";

        List<Absence> list=new ArrayList<>();
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(req);
                   

            while(rs.next()){
           list.add(new Absence(rs.getInt(1), 
            sc.findById(rs.getInt("id_class")), 
            sap.findById(rs.getInt("id_apprenant"))));
           
            }
                   return list;             

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return list;    
               }
         
         
         
         
         public List<String> nbabsenceliste() throws SQLException{
    String req2="select * from absence ab ,apprenant a,class c where ab.id_apprenant=a.id_apprenant and ab.id_class=c.id_class  ";
        ste=con.createStatement();
        rs=ste.executeQuery(req2);
        List<String> list =new ArrayList<>();
        while(rs.next()){
                //System.out.println(rs.getString("nom")+rs.getInt("note_orale")+rs.getString("nom_matiere"));
           list.add("IDAbsence "+rs.getInt("id_absence")+" "+"IDApprenant"+" "
                   +rs.getInt("id_apprenant")+" "+"Nom Apprenant:"+" "+
                   rs.getString("nom")+" "
                   +"Class:"+" "
                   +rs.getInt("niveau")+""
                   +""+rs.getString("type")+" "
                   +"Nombre d'absence:"+" "+rs.getInt("nb_absence")
                   );
        
        }
        list.forEach(System.out::println);
        return list;

    }
}
