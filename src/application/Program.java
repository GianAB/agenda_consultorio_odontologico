/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DentistaDao;
import model.dao.EspecialidadeDao;
import model.dao.ProcedimentoDao;
import model.entities.Procedimento;

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
        ProcedimentoDao procedimentoDao = DaoFactory.createProcedimentoDao();

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

        Dentista updateDentista = new Dentista(7, "Mark Knopfler");
        System.out.println("Antes do update:\n" + dentistaDao.findById(updateDentista.getId()));
        System.out.println("Linhas afetadas: " + dentistaDao.update(updateDentista));
        System.out.println("Depois do update:\n" + dentistaDao.findById(updateDentista.getId()));       
        System.out.println("Linhas afetadas: " + dentistaDao.deleteById(7));
         
        Especialidade esp1 = new Especialidade("Odontologia Estética");
        especialidadeDao.insert(esp1);
        System.out.println(esp1);
         
        System.out.println("FindById:\n" +  especialidadeDao.findById(1));
        System.out.println("FindByAll:\n" +  especialidadeDao.findAll());
        
        Especialidade espUpdate = new Especialidade(7, "Estética Odontológica");
        System.out.println("Linhas afetadas: " + especialidadeDao.update(espUpdate));
        System.out.println(especialidadeDao.findById(espUpdate.getId()));
        System.out.println("Linhas afetadas: " + especialidadeDao.deleteById(7));
       */ 
        
        System.out.println("FindById:\n" +  procedimentoDao.findById(1));
        System.out.println("FindByAll:\n" +  procedimentoDao.findAll());
        Procedimento proc1 = new Procedimento("Facetas de Porcelana", 5000f, especialidadeDao.findById(4));
        procedimentoDao.insert(proc1);
        Procedimento proc2 = new Procedimento(7, "Restauração simples", 100f);
        
        System.out.println("Linhas afetadas: " + procedimentoDao.update(proc2));
        System.out.println("Linhas Afetadas: " + procedimentoDao.deleteById(8));
        
        
        DB.closeConnection();
    }
}
