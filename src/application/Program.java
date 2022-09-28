/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import entities.Contato;
import entities.Paciente;

/**
 *
 * @author giang
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Paciente pa1 = new Paciente("Gian", "Antonio", "32837737463");
        Contato co1 = new Contato("3338475225", "33918273354", pa1);
        
        System.out.println(co1);
                
    }
    
}
