/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entities.Procedimento;

/**
 *
 * @author giang
 */
public interface ProcedimentoDao {

    void insert(Procedimento procedimento);

    Procedimento findById(Integer id);
    
    List<Procedimento> findAll();

    void update(Procedimento procedimento);

    void deleteById(Integer id);

}
