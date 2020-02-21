/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entité.Note;
import Service.ServiceClass;
import Service.ServiceNote;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class UpdatenoteController implements Initializable {

    @FXML
    private TextField norale;
    @FXML
    private TextField moy;
    @FXML
    private TextField necrit;
    @FXML
    private TextField tid;
    @FXML
    private Button btnmodfi;
    @FXML
    private Button retbtn;
    @FXML
    private Button suivanbtn;
    @FXML
    private Button btncon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void validermodifier(ActionEvent event) throws IOException, SQLException {
     ServiceNote sn=new ServiceNote();
       
     String no=norale.getText();
       int orale=Integer.parseInt(no);
       
       String mo=moy.getText();
       Double moy=Double.valueOf(mo);
       
       String ec=necrit.getText();
       int ecrit=Integer.parseInt(ec);
       
       String ti=tid.getText();
       int id=Integer.parseInt(ti);
        if( ecrit > 20 ){
                      JOptionPane.showMessageDialog(null, "Note Ecrit doit etre Inferieur 20");
        
        }else if( orale > 20 ){
                      JOptionPane.showMessageDialog(null, "Note Orale doit etre Inferieur 20");

    } else if( moy > 20 ){
                      JOptionPane.showMessageDialog(null, "Note Moyenne doit etre Inferieur 20");

//          JOptionPane.showMessageDialog(null, "ajout failed");
        //  JOptionPane.showMessageDialog(null, "ajout failed");

//        }else 
//                ;
//         Note note=new Note(new Matiere("Arabia"), torale, tecrit, tmoyenne, new Apprenant("cvc"));
//         sn.ajouter(note);
//         
      
        }else{
           try{
            sn.update(new Note(id, orale, ecrit, moy));
           }catch(Exception e){
               e.toString();
           }
            JOptionPane.showMessageDialog(null, "update effectuer");
            FXMLLoader fxml=new FXMLLoader(getClass().getResource("updatenote.fxml"));
            Parent root=fxml.load();
            necrit.getScene().setRoot(root);
    }
    
       }

    @FXML
    private void retourbtn(ActionEvent event) throws IOException {
        
         FXMLLoader fxml=new FXMLLoader(getClass().getResource("ConsulterNote.fxml"));
      Parent root=fxml.load();
       tid.getScene().setRoot(root);
        ConsulterNoteController cons=fxml.getController();
    }

    @FXML
    private void suivbtn(ActionEvent event) throws IOException {
         FXMLLoader fxml=new FXMLLoader(getClass().getResource("supprimernote.fxml"));
      Parent root=fxml.load();
       tid.getScene().setRoot(root);
        SupprimernoteController supp=fxml.getController();
    }

    @FXML
    private void btncon2(ActionEvent event) throws IOException {
        
      FXMLLoader fxml=new FXMLLoader(getClass().getResource("ConsulterNote.fxml"));
      Parent root=fxml.load();
       tid.getScene().setRoot(root);
        ConsulterNoteController con=fxml.getController();
    }
    
    }
    

