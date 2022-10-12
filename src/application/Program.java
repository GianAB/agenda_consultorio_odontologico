/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import db.DB;
import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.dao.DentistaDao;
import model.dao.EspecialidadeDao;
import model.dao.PacienteDao;
import model.dao.ProcedimentoDao;
import model.entities.Contato;
import model.entities.Paciente;

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
        PacienteDao pacienteDao = DaoFactory.createPacienteDao();
        ContatoDao contatoDao = DaoFactory.createContatoDao();

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
 
        System.out.println("FindById:\n" +  procedimentoDao.findById(1));
        System.out.println("FindByAll:\n" +  procedimentoDao.findAll());
        Procedimento proc1 = new Procedimento("Facetas de Porcelana", 5000f, especialidadeDao.findById(4));
        procedimentoDao.insert(proc1);
        Procedimento proc2 = new Procedimento(7, "Restauração simples", 100f);

        System.out.println("Linhas afetadas: " + procedimentoDao.update(proc2));
        System.out.println("Linhas Afetadas: " + procedimentoDao.deleteById(8));
        */
        Paciente pa1 = new Paciente("Tommy", "Aldridge", "01922938472");
        pacienteDao.insert(pa1);
        System.out.println(pa1);
        System.out.println("FindById:\n" + pacienteDao.findById(2));
        System.out.println("FindById:\n" + contatoDao.findContatoByPacienteId(2));
         System.out.println("FindByAll:\n"  + pacienteDao.findAll());
        Paciente pac2 = new Paciente(30, "Billy", "Gibbons");
        System.out.println("Linhas afetadas: " + pacienteDao.update(pac2));
        System.out.println("Linhas afetadas: " + pacienteDao.deleteById(4));
        
        contatoDao.insert(new Contato("1129384477", "11992837463", pacienteDao.findById(1)));
        System.out.println(contatoDao.findContatoByPacienteId(1));
        System.out.println("Linhas afetadas: " + contatoDao.update(new Contato("1123780998", "11998273635", pacienteDao.findById(1))));
        System.out.println(contatoDao.findContatoByPacienteId(1));
        System.out.println("Linhas afetadas: " + contatoDao.deleteContatoByIdPaciente(1));
         
        
        

        DB.closeConnection();
    }
}
