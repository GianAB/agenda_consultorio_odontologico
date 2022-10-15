/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import db.DB;
import static db.DB.closeConnection;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import model.dao.AnamneseDao;
import model.dao.ConsultaDao;
import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.dao.DentistaDao;
import model.dao.EspecialidadeDao;
import model.dao.PacienteDao;
import model.dao.ProcedimentoDao;
import model.entities.Anamnese;
import model.entities.Consulta;
import model.entities.enums.Pagamento;

/**
 *
 * @author giang
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.of("UTC"));

        DentistaDao dentistaDao = DaoFactory.createDentistaDao();
        EspecialidadeDao especialidadeDao = DaoFactory.createEspecialidadeDao();
        ProcedimentoDao procedimentoDao = DaoFactory.createProcedimentoDao();
        PacienteDao pacienteDao = DaoFactory.createPacienteDao();
        ContatoDao contatoDao = DaoFactory.createContatoDao();
        ConsultaDao consultaDao = DaoFactory.createConsultaDao();
        AnamneseDao anamneseDao = DaoFactory.createAnamneseDao();

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
         */
        //System.out.println("findAllPerDayOfTheWeek:\n" + consultaDao.findAllPerDayOfTheWeek(LocalDate.parse("2022-09-19")));
        System.out.println("FindById:\n" + consultaDao.findById(1));
        //Consulta con1 = new Consulta(Instant.from(formatter.parse("15/10/2022 08:00")), dentistaDao.findById(1), pacienteDao.findById(2));
        //consultaDao.insert(con1);
        //System.out.println(con1);
        //Consulta conUpdate = consultaDao.findById(4);
        //conUpdate.setDt_termino(Instant.from(formatter.parse("15/10/2022 09:00")));
        //System.out.println("Linhas afetadas: " + consultaDao.update(conUpdate));
        //System.out.println("Linhas afetadas: "+  consultaDao.deleteById(4));
        //Anamnese anm1 = new Anamnese(consultaDao.findById(1), procedimentoDao.findById(6), (short) 2);
        //anamneseDao.insert(anm1);
        //System.out.println("findByIdConsultaAndIdProcedimento:\n" + anamneseDao.findByIdConsultaAndIdProcedimento(1, 5));
        //System.out.println("findAllAnamnesePerIdConsulta:\n"+ anamneseDao.findAllAnamnesePerIdConsulta(1)); 
        //Anamnese anmUpdate = anamneseDao.findByIdConsultaAndIdProcedimento(1, 5);
        //anmUpdate.setQuantidade((short) 4);
        //anmUpdate.setPagamento(Pagamento.PAGO.toString());
        //System.out.println("Linhas afetadas: " + anamneseDao.update(anmUpdate));
        /*
        Anamnese anm2 = new Anamnese(consultaDao.findById(3), procedimentoDao.findById(3), (short) 1);
        Anamnese anm3 = new Anamnese(consultaDao.findById(3), procedimentoDao.findById(2), (short) 3);
        Anamnese anm4 = new Anamnese(consultaDao.findById(3), procedimentoDao.findById(5), (short) 6);
        
        anamneseDao.insert(anm2);
        anamneseDao.insert(anm3);
        anamneseDao.insert(anm4);
         */

        //System.out.println("Linhas afetadas: " + anamneseDao.deleteByIdConsultaAndIdProcedimento(3, 2));
        //System.out.println("Linhas afetadas: " + anamneseDao.deleteByIdConsulta(3));

        DB.closeConnection();
    }
}
