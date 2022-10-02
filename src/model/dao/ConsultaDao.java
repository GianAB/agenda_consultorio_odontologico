/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entities.Anamnese;
import model.entities.Consulta;

/**
 *
 * @author giang
 */
public interface ConsultaDao {

    void insert(Consulta consulta);

    Consulta findById(Integer id);
    
    List<Consulta> findAll();
    
    void update(Consulta consulta);

    void deleteById(Integer id);

    List<Anamnese> findAnamnesesByConsulta(Integer id);

}
