/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.impl;

import db.DB;
import db.DBException;
import java.util.List;
import model.dao.EspecialidadeDao;
import model.entities.Especialidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entities.Dentista;

/**
 *
 * @author giang
 */
public class EspecialidadeDaoJdbc implements EspecialidadeDao {

    private Connection conn;

    public EspecialidadeDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Especialidade especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Especialidade findById(Integer id) {
        ResultSet rs = null;
        Especialidade especialidade;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_especialidade WHERE id = ?");
            st.setInt(1, id);
            
            rs = st.executeQuery();

            if (rs.first()) {
                rs.first();
                especialidade = new Especialidade(rs.getInt("id"), rs.getString("descricao"));
                
                return especialidade;
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
            DB.closeResultset();
        }
        return null;
    }

    @Override
    public List<Especialidade> findAll() {
        ResultSet rs = null;
        List<Especialidade> especialidades = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_especialidade");
            rs = st.executeQuery();

            if (rs.first()) {
                rs.first();
                do{
                    especialidades.add(new Especialidade(rs.getInt("id"), rs.getString("descricao")));
                }while(rs.next());
                
                return especialidades;
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
            DB.closeResultset();
        }
        return null;
    }

    @Override
    public void update(Especialidade especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
