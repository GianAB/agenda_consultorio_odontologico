/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import db.DB;
import model.entities.Anamnese;
import model.entities.Consulta;
import model.entities.Contato;
import model.entities.Dentista;
import model.entities.Especialidade;
import model.entities.Paciente;
import model.entities.Procedimento;
import model.entities.enums.Pagamento;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import model.dao.DaoFactory;
import model.dao.DentistaDao;
import model.dao.EspecialidadeDao;
import model.impl.DentistaDaoJdbc;

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
        
        System.out.println(dentistaDao.findById(1));
        System.out.println(especialidadeDao.findAll());
        
        DB.closeConnection();
    }
}
