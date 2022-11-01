/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entities.Paciente;

/**
 *
 * @author giang
 */
public interface PacienteDao {

    void insert(Paciente paciente);

    Paciente findById(Integer id);

    List<Paciente> findAll();

    int update(Paciente paciente);

    int deleteById(Integer id);

}
