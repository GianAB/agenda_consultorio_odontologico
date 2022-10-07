/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entities.Especialidade;

/**
 *
 * @author giang
 */
public interface EspecialidadeDao {

    void insert(Especialidade especialidade);

    Especialidade findById(Integer id);

    List<Especialidade> findAll();

    int update(Especialidade especialidade);

    int deleteById(Integer id);
    
}
