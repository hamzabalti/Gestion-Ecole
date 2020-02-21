/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataBase.DataBase;
import Entité.Apprenant;
import IService.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import Entité.Class;
import Entité.Matiere;
import GUI.SupprimerclassController;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Hamza
 */
public class ServiceClass {
    
     private Connection con;
    private Statement ste;
    private PreparedStatement pre;
    private ResultSet rs;
    //SupprimerclassController s;
    
    
    public ServiceClass() {
        con = DataBase.getInstance().getConnection();

    }
    
    //Ajouter Class 
    public void ajouter(Class c) throws SQLException{
    PreparedStatement pre=con.prepareStatement("INSERT INTO `ecole`.`class` ( `niveau`, `type`) VALUES ( ?, ?);");
    pre.setInt(1, c.getNiveau());
    pre.setString(2, c.getType());
    pre.executeUpdate();
        
        }
    

    //delete class
    public void delete( int id ) throws SQLException {
        String req2="SELECT * FROM class WHERE id_class="+id;
        pre=con.prepareStatement(req2);
        pre.execute(req2);
        rs=pre.getResultSet();
        if(rs.next()){
        String req1="DELETE FROM class WHERE id_class="+id;
        PreparedStatement pre=con.prepareStatement(req1);
        System.out.println("Class supprimer");      
        pre.executeUpdate();
        }else{
        System.out.println("pas de class");      

        }
  
    }
    //chercher  du class existe ou nn
//    public int rechercherParNiveau(int niv) throws SQLException{
//     String req1="SELECT * FROM class WHERE niveau="+niv;
//       // PreparedStatement pre=con.prepareStatement(req1);
//        ste=con.createStatement();
//        rs=ste.executeQuery(req1);
//        rs.last();
//        int nbrRow=rs.getRow();
//        
//        if(nbrRow ==1){
//                 
//            return niv;  
//
////            System.out.println("Class trouver");
//        }else{
//             System.out.println("Class non trouve");
//
//        }
//       return niv;  
//    }
 
    //modifier les champ du class a partir de l'id_class
    public boolean update(Class c) throws SQLException {

   ste = con.createStatement();
 String query = ("UPDATE class SET niveau = '"+c.getNiveau()+"', type = '"+c.getType()+"'WHERE id_class = '"+c.getId_class()+"'");
   if(ste.executeUpdate(query)!=0){
        System.out.println("Class est modifier");
    return true;
    }else{
    return false;
    }
    }
    
     //lister les class
    public List<Class> afficher() throws SQLException {    
    List<Class> arr=new ArrayList<Class>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from ecole.`class`");
     while (rs.next()) {                
               
     arr.add(new Class(rs.getInt(1), rs.getInt(2), rs.getString("type")));
             


     }

   return arr;
    }
    
     public Class findById(int id) {
        String req="Select* from class where id_class="+id+";";
        Class c=null;
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(req);
            if(rs.next()){
                c= new Class(rs.getInt(1), rs.getInt(2), rs.getString("type"));
            }
            return c; 
            
        } catch (SQLException ex) {
            return null;
        }
    }
     
     public List<String> classlist() throws SQLException{
    String req2="select * from class ";
        ste=con.createStatement();
        rs=ste.executeQuery(req2);
        List<String> list =new ArrayList<>();
        while(rs.next()){
                //System.out.println(rs.getString("nom")+rs.getInt("note_orale")+rs.getString("nom_matiere"));
           list.add("Class:"+" "+
                   rs.getInt("niveau")+" "
                   +
                   rs.getString("type")+" "
                   );
        
        }
        list.forEach(System.out::println);
        return list;

    }
     
     
       public Class TriClassParNiveau(int id) {
        String sql="Select* from class where id_class="+id+" ORDER by niveau";
        Class c=null;
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(sql);
            if(rs.next()){
                c= new Class(rs.getInt("id_class"));
            }
            return c; 
            
        } catch (SQLException ex) {
            return null;
        }
    }
       
         public List<Class> TrieNiveau() throws SQLException{
    String req2="select * from class ORDER BY  niveau";
        ste=con.createStatement();
        rs=ste.executeQuery(req2);
        List<Class> list =new ArrayList<>();
        while(rs.next()){
         list.add(new Class(rs.getInt("id_class"), rs.getInt("niveau"), rs.getString("type")));
        
        }
        return list;

    }
       
}
