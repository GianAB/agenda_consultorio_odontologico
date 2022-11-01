/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import model.dto.ContatoDto;
import model.entities.Contato;

/**
 *
 * @author giang
 */
public interface ContatoDao {

    void insert(Contato contato);

    ContatoDto findContatoByPacienteId(Integer idPaciente);

    int update(Contato contato);

    int deleteContatoByIdPaciente(Integer idPaciente);

}
