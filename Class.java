/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

/**
 *
 * @author Hamza
 */
public class Class  //implements Comparable<Class>//
{
    private int id_class;
    private int niveau;
    private String type;
 
    
    public Class() {
    }

    public Class(int id_class, int niveau, String type) {
        this.id_class = id_class;
        this.niveau = niveau;
        this.type = type;
     
    }

    public Class(int niveau, String type) {
        this.niveau = niveau;
        this.type = type;
    }

    public Class(int id_class, int niveau) {
        this.id_class = id_class;
        this.niveau = niveau;
    }

    public Class(int id_class) {
        this.id_class = id_class;
    }

 
    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

 
  

    

//    @Override
// public int compareTo(Class c) {
//  //trions les clas selon leur niveau dans l'ordre croiddant
//  //retroune un entier négative, zéro ou positive si le niveau 
//  //de cet class est moins que, égale à ou supérieur à l'objet comparé avec
//        return (this.niveau - c.niveau);
// }

    @Override
    public String toString() {
        return "Class{" + "id_class=" + id_class + ", niveau=" + niveau + ", type=" + type + '}';
    }



    
    
}
