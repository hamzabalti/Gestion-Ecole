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
public class Absence {
    
    private int id_absence;
    private int nb_absence;
    private Class c;
    private Apprenant a ;

    public Absence() {
    }

    public Absence(int id_absence, int nb_absence) {
        this.id_absence = id_absence;
        this.nb_absence = nb_absence;
    }
    

    public Absence(int id_absence, int nb_absence, Class c, Apprenant a) {
        this.id_absence = id_absence;
        this.nb_absence = nb_absence;
        this.c = c;
        this.a = a;
    }

    public Absence(int nb_absence, Class c, Apprenant a) {
        this.nb_absence = nb_absence;
        this.c = c;
        this.a = a;
    }

    public int getId_absence() {
        return id_absence;
    }

    public void setId_absence(int id_absence) {
        this.id_absence = id_absence;
    }

    public int getNb_absence() {
        return nb_absence;
    }

    public void setNb_absence(int nb_absence) {
        this.nb_absence = nb_absence;
    }

    public Class getC() {
        return c;
    }

    public void setC(Class c) {
        this.c = c;
    }

    public Apprenant getA() {
        return a;
    }

    public void setA(Apprenant a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Absence{" + "id_absence=" + id_absence + ", nb_absence=" + nb_absence + ", c=" + c + ", a=" + a + '}';
    }

    

}
