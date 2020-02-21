/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataBase.DataBase;
import Entité.Apprenant;
import Entité.Matiere;
import Entité.Note;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Hamza
 */
public class ServiceNote {
    private Connection con;
    private Statement ste;
    private PreparedStatement pre;
    private ResultSet rs;
    
    public ServiceNote() {
        con = DataBase.getInstance().getConnection();

    }
     public void ajouter(Note n) throws SQLException{
    PreparedStatement pre=con.prepareStatement("INSERT INTO `ecole`.`note` ( `id_matiere`,`note_orale`, `note_ecrit`, `moyenne`, `id_apprenant`) VALUES ( ?,?, ?, ? ,?);");
    pre.setInt(1,n.getM().getId_matiere());
    pre.setInt(2, n.getNote_orale());
    pre.setInt(3, n.getNote_ecrit());
    pre.setDouble(4, n.getMoyenne());
    pre.setInt(5, n.getA().getId_apprenant());
    pre.executeUpdate();
    
     }
     public boolean delete( int id ) throws SQLException {
        String req1="DELETE FROM note WHERE id_note="+id;
        PreparedStatement pre=con.prepareStatement(req1);
        if(pre.executeUpdate()!=0){
           System.out.println("Note supprimer");     
    
            return true;
        }else{
           System.out.println("Pas de Note");     

        return false;
        }
        }
         public boolean rechercherParId(int id) throws SQLException{
     String req1="SELECT * FROM note WHERE id_apprenant="+id;
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
//       String req="select nom, note_orale, moyenne, note_ecrit, nom_matiere \"\n" +
//"//            + \"FROM note INNER JOIN apprenant ON note.id_apprenant = apprenant.id_apprenant\"\n" +
//"//            + \" INNER JOIN matiere ON note.id_matiere = matiere.id_matiere\"\n" +
//"";
         //Apprenant a=new Apprenant();
          //Matiere m=new Matiere();
         
    public List<Note> afficher() {   
 
          ServiceApprenant sa=new ServiceApprenant();
          ServiceMatiere sm=new ServiceMatiere();
    

        String req="select * from note";

        List<Note> list=new ArrayList<>();
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
           list.add(new Note(
                   sm.findById(rs.getInt("id_matiere")), 
                   rs.getInt(2), 
                   rs.getInt(4), 
                   rs.getDouble(3), 
                   sa.findById(rs.getInt("id_apprenant"))
           ));
           
            }
                   return list;             

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return list;             
        

    }
    
//    
//      public List<Note> displayAll() {
//       String req="Select* from note";
//        List<Note> list=new ArrayList<>();
//        try {
//            ste=con.createStatement();
//            rs=ste.executeQuery(req);
//            while(rs.next()){
//             list.add(new Note(rs.getInt(1), , rs.getFloat(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
//            }
//            return list;
//        } catch (SQLException ex) {
//                        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//        return list; 
//          }
      
    public boolean update(Note n) throws SQLException {

   ste = con.createStatement();
 String query = ("UPDATE note SET note_orale = '"+n.getNote_orale()+"', note_ecrit = '"+n.getNote_ecrit()+"', moyenne = '"+n.getMoyenne()+"'WHERE id_note = '"+n.getId_note()+"'");
    if(ste.executeUpdate(query)!=0){
        System.out.println("Note est modifier");
    return true;
    }else{
    return false;
    }

    }
   
    public List<String> affiche() {   
 
          ServiceApprenant sa=new ServiceApprenant();
          ServiceMatiere sm=new ServiceMatiere();
    

        String req="select * from note";

        List<String> list=new ArrayList<>();
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                int n1=rs.getInt("id_matiere");
                   Note n=new Note(
                   sm.findById(rs.getInt("id_matiere")), 
                   rs.getInt(2), 
                   rs.getInt(4), 
                   rs.getDouble(3), 
                   sa.findById(rs.getInt("id_apprenant"))
           );
                   
                   
                   Apprenant a=sa.findById(rs.getInt("id_apprenant"));
                
                System.out.println(sm.findById(n1)+" "+n.toString());
         String s=a.getNom();
             
                //System.out.println(s);
                   
                   int b=rs.getInt(2);
                   String ch=String.valueOf(b);
                 
                   int  c=rs.getInt(4) ;
                   String ch1=String.valueOf(c);

                   double d=rs.getDouble(3); 
                   String ch2=String.valueOf(d);
                Apprenant app=sa.findById(rs.getInt("id_apprenant"));
                String ch4=app.getNom();
                
              
              String ch6=s.concat(ch).concat(ch1).concat(ch2).concat(ch4);
              list.add(ch6);
           
            }
                                

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return list;  






}
    public List<String> addtable() throws SQLException{
    String req2="select * from note n ,apprenant a,matiere m where n.id_apprenant=a.id_apprenant and n.id_matiere=m.id_matiere  ";
        ste=con.createStatement();
        rs=ste.executeQuery(req2);
        List<String> list =new ArrayList<>();
        while(rs.next()){
                //System.out.println(rs.getString("nom")+rs.getInt("note_orale")+rs.getString("nom_matiere"));
           list.add("IDNote"+" "+rs.getInt("id_note")
                   +" "+"Nom Apprenant:"+" "+
                   rs.getString("nom")+" "
                   +"Note Orale:"+" "
                   +rs.getInt("note_orale")+" "
                   +"Note Ecrit:"+" "+rs.getInt("note_ecrit")+" "
                   +rs.getDouble("moyenne")+" "+"Moyenne"+" "
                   +"Nom du Matiere:"+" "+rs.getString("nom_matiere"));
        
        }
        list.forEach(System.out::println);
        return list;

    }

}
    

        
