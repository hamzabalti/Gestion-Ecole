/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataBase.DataBase;
import Entité.Apprenant;
import Entité.Matiere;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entité.Matiere;
/**
 *
 * @author Hamza
 */
public class ServiceMatiere {
     private Connection con;
    private Statement ste;
    private PreparedStatement pre;
    private ResultSet rs;
    
     public ServiceMatiere() {
        con = DataBase.getInstance().getConnection();

    }
       public Matiere findById(int id) {
        String req="Select* from matiere where id_matiere="+id+";";
        Matiere m=null;
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(req);
            if(rs.next()){
                m= new Matiere(rs.getInt(1), rs.getString("nom_matiere"), rs.getInt(3));
            }
            return m; 
            
        } catch (SQLException ex) {
            return null;
        }
    }
       
           public List<Matiere> displayAll() {
       String sql="Select * from matiere";
        List<Matiere> list=new ArrayList<>();
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(sql);
            while(rs.next()){
                list.add(new Matiere(rs.getInt(1), 
                        rs.getString("nom_matiere"),
                        rs.getInt(3)));
            }
            return list;
        } catch (SQLException ex) {
        }
        return list; 
          }
           
           
     public List<String> findByName() throws SQLException {
      List<String> list =new ArrayList<>();
      ste=con.createStatement();

     String sql="select nom_matiere from matiere";
         
            rs=ste.executeQuery(sql);
            while(rs.next()){
                String nom_matiere=rs.getString(1);
                list.add(nom_matiere);
            }
            return list;
            
     
        }    

 public String FindNomMatiere(String nommat) {
        String sql="Select* from matiere where nom_matiere="+nommat+";";
        Matiere m=null;
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(sql);
            if(rs.next()){
                m= new Matiere(rs.getString("nom_matiere"));
            }
            return nommat; 
            
        } catch (SQLException ex) {
            return null;
        }
    }
}

