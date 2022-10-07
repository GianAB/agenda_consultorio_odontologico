/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entities.Dentista;

/**
 *
 * @author giang
 */
public interface DentistaDao {

    void insert(Dentista dentista);

    Dentista findById(Integer id);

    List<DentistaDto> findAll();

    int update(Dentista dentista);

    int deleteById(Integer id);
}
