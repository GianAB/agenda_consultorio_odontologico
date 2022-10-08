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
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO tb_especialidade(descricao) VALUES(?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, especialidade.getDescricao());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                rs.first();
                especialidade.setId(rs.getInt(1));
                DB.closeResultset();
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
    }

    @Override
    public Especialidade findById(Integer id) {
        Especialidade especialidade;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_especialidade WHERE id = ?");
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

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
        List<Especialidade> especialidades = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_especialidade");
            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                rs.first();
                
                do {
                    especialidades.add(new Especialidade(rs.getInt("id"), rs.getString("descricao")));
                } while (rs.next());

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
    public int update(Especialidade especialidade) {
        int rowsAffected;

        if (especialidade.getId() == null) {
            throw new NullPointerException("Não existe especialidade com este id!");
        }

        try {
            PreparedStatement st = conn.prepareStatement("UPDATE tb_especialidade SET descricao = ? WHERE id = ?");
            st.setString(1, especialidade.getDescricao());
            st.setInt(2, especialidade.getId());

            rowsAffected = st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
        return rowsAffected;
    }

    @Override
    public int deleteById(Integer id) {
        if (id == null) {
            throw new NullPointerException("Não existe especialidade com id nulo!");
        }

        int rowsAffected;

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM tb_especialidade WHERE id = ?");
            st.setInt(1, id);
            rowsAffected = st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
        return rowsAffected;
    }

}
