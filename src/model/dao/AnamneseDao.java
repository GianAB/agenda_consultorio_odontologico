/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entities.Anamnese;

/**
 *
 * @author giang
 */
public interface AnamneseDao {

    void insert(Anamnese anamnese);

    Anamnese findById(Integer idConsulta, Integer idProcedimento);
    
    List<Anamnese> findAllPerConsulta(Integer idConsulta);

    void update(Anamnese anamnese);

    void deleteById(Integer idConsulta, Integer idProcedimento);

}
