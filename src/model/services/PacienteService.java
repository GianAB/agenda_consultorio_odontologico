/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Paciente;

/**
 *
 * @author giang
 */
public class PacienteService {

    private PacienteDao dao = DaoFactory.createPacienteDao();

    public List<Paciente> findAll() {
        return dao.findAll();
    }
}
