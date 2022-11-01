/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.impl;

import db.DB;
import db.DBException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Paciente;

/**
 *
 * @author giang
 */
public class PacienteDaoJdbc implements PacienteDao {

    private Connection conn;

    private static ContatoDao contatoDao = DaoFactory.createContatoDao();

    public PacienteDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Paciente paciente) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO tb_paciente(nome, sobrenome, cpf) VALUES(?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, paciente.getNome());
            st.setString(2, paciente.getSobrenome());
            st.setString(3, paciente.getCpf());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                rs.first();
                paciente.setId(rs.getInt(1));
                DB.closeResultset();
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
    }

    @Override
    public Paciente findById(Integer id) {
        Paciente  paciente;

        try {
            PreparedStatement st = conn.prepareStatement(" SELECT * FROM tb_paciente WHERE id = ?");
            
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                rs.first();
                paciente = new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("cpf"));

                return paciente;
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
    public List<Paciente> findAll() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_paciente");
            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                rs.first();

                do {
                    pacientes.add(new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("cpf")));
                } while (rs.next());

                return pacientes;
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
    public int update(Paciente paciente) {
        int rowsAffected;

        if (paciente.getId() == null) {
            throw new NullPointerException("Não existe paciente com id nulo!");
        }

        try {
            PreparedStatement st = conn.prepareStatement("UPDATE tb_paciente SET nome = ?, sobrenome = ? WHERE id = ?");
            st.setString(1, paciente.getNome());
            st.setString(2, paciente.getSobrenome());
            st.setInt(3, paciente.getId());

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
            throw new NullPointerException("Não existe paciente com id nulo!");
        }

        int rowsAffected;

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM tb_paciente WHERE id = ?");
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
