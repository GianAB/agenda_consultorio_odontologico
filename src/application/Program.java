/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DentistaDao;
import model.dao.EspecialidadeDao;
import model.entities.Dentista;
import model.entities.Especialidade;

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

        DentistaDao dentistaDao = DaoFactory.createDentistaDao();
        EspecialidadeDao especialidadeDao = DaoFactory.createEspecialidadeDao();
        /*
        Dentista novoDentista = new Dentista("Marquim das Meninas", "MG585732223");
        novoDentista.getEspecialidades().add(especialidadeDao.findById(1));
        novoDentista.getEspecialidades().add(especialidadeDao.findById(3));
        novoDentista.getEspecialidades().add(especialidadeDao.findById(4));

        System.out.println("Antes de inserir no Banco de Dados:\n" + novoDentista);
        dentistaDao.insert(novoDentista);
        System.out.println(dentistaDao.findById(8));        
        System.out.println(dentistaDao.findAll());
        System.out.println("Depois de inserir no Banco de Dados:\n" + novoDentista);
         */

 /*
        Dentista updateDentista = new Dentista(7, "Mark Knopfler");
        System.out.println("Antes do update:\n" + dentistaDao.findById(updateDentista.getId()));
        System.out.println("Linhas afetadas: " + dentistaDao.update(updateDentista));
        System.out.println("Depois do update:\n" + dentistaDao.findById(updateDentista.getId()));
         */
        
        System.out.println("Linhas afetadas: " + dentistaDao.deleteById(7));
        DB.closeConnection();
    }
}
