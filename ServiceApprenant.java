/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataBase.DataBase;
import Entité.Apprenant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hamza
 */
public class ServiceApprenant {
     private Connection con;
    private Statement ste;
    private PreparedStatement pre;
    private ResultSet rs;

 public ServiceApprenant() {
        con = DataBase.getInstance().getConnection();

    }
  public Apprenant findById(int id) {
        String sql="Select* from apprenant where id_apprenant="+id+";";
        Apprenant a=null;
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(sql);
            if(rs.next()){
                a= new Apprenant(rs.getString(1));
            }
            return a; 
            
        } catch (SQLException ex) {
            return null;
        }
    }
  public List<String> findByName() throws SQLException {
      List<String> list =new ArrayList<>();
      ste=con.createStatement();

     String sql="select * from apprenant";
         
            rs=ste.executeQuery(sql);
            while(rs.next()){
//                int id_apprenant=rs.getInt(1);
//               String id_app=String.valueOf(id_apprenant);
//                
//                String nom=rs.getString(2);
                list.add(rs.getInt("id_apprenant")+" "+rs.getString("nom"));

//                list.add(nom);
            }
            return list;
            
     
        } 
  
  public List<String> findidnom() throws SQLException {
        
    List<String> l=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select id_apprenant,nom from ecole.`apprenant`");
     while (rs.next()) {                
                
//              String nom=rs.getString(1);
//              String id_app=(String.valueOf(rs.getInt(2)));
             // String aa=String.valueOf(a);
             //l.add(nom_matieree,aa);
           Apprenant a =new Apprenant(rs.getInt(1),rs.getString(2));
            int c=  a.getId_apprenant();
            String cc= a.getNom();
            String id="  ID:  ";
            String nomapp="  Nom Apprenant:  ";
            String nom=String.valueOf(c);
            String x=id.concat(nom);
            String ww=nomapp.concat(cc);
            String w=ww.concat(x);
            l.add(w);
            
     } 
    return l ;
    }
  
    public String FindNomApp(String nom) {
        String sql="Select* from apprenant where nom="+nom+";";
        Apprenant a=null;
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(sql);
            if(rs.next()){
                a= new Apprenant(rs.getString("nom"));
            }
            return nom; 
            
        } catch (SQLException ex) {
            return null;
        }
    }
    
        public Apprenant getApprenant(Apprenant a) throws SQLException { 
        Apprenant ap = new Apprenant();
        PreparedStatement pre = con.prepareStatement("SELECT * FROM apprenant WHERE id_apprenant LIKE ? ;");

        pre.setInt(1, ap.getId_apprenant());
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            int id_apprenant = rs.getInt("id_apprenant");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");

            ap.setId_apprenant(id_apprenant);
            ap.setNom(nom);
            ap.setPrenom(prenom);
           
        }
        return ap;

    }
}
