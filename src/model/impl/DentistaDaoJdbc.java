/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.impl;

import db.DB;
import java.util.List;
import model.dao.DentistaDao;
import model.entities.Dentista;
import model.entities.Especialidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.DBException;
import model.dao.DaoFactory;
import model.dao.EspecialidadeDao;

/**
 *
 * @author giang
 */
public class DentistaDaoJdbc implements DentistaDao {

    private Connection conn;

    public DentistaDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Dentista dentista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Dentista findById(Integer id) {
        ResultSet rs = null;
        Dentista dentista = new Dentista();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT de.id_dentista, d.nome AS 'dentista', d.cro, de.id_especialidade "
                    + "FROM tb_dentista_especialidade AS de "
                    + "INNER JOIN tb_dentista AS d ON de.id_dentista = d.id "
                    + "INNER JOIN tb_especialidade AS e ON de.id_especialidade = e.id "
                    + "WHERE de.id_dentista = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.first()) {
                EspecialidadeDao especialidadeDao = DaoFactory.createEspecialidadeDao();
                dentista.setId(rs.getInt("id_dentista"));
                dentista.setNome(rs.getString("dentista"));
                dentista.setCro(rs.getString("cro"));
                rs.first();
                
                do {
                    
                    dentista.addEspecialidade(especialidadeDao.findById(rs.getInt("id_especialidade")));

                } while (rs.next());

                return dentista;
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
    public List<Dentista> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Dentista dentista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
