/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import db.DB;
import db.DBException;
import model.dao.ContatoDao;
import model.entities.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dto.ContatoDto;

/**
 *
 * @author giang
 */
public class ContatoDaoJdbc implements ContatoDao {

    private Connection conn;

    public ContatoDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Contato contato) {

        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO tb_contato(telefone, celular, id_paciente) VALUES(?, ?, ?)");

            st.setString(1, contato.getTelefone());
            st.setString(2, contato.getCelular());
            st.setInt(3, contato.getPaciente().getId());

            st.execute();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
    }

    @Override
    public ContatoDto findContatoByPacienteId(Integer idPaciente) {
        ContatoDto contatoDto;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_contato WHERE id_paciente = ?");
            st.setInt(1, idPaciente);

            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                rs.first();

                contatoDto = new ContatoDto(rs.getString("telefone"), rs.getString("celular"));

                return contatoDto;
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
    public int update(Contato contato) {
        int rowsAffected;

        if (contato.getPaciente().getId() == null) {
            throw new NullPointerException("Precisa de um Id de paciente diferente de nulo!");
        }

        try {
            PreparedStatement st = conn.prepareStatement("UPDATE tb_contato SET telefone = ?, celular = ? WHERE id_paciente = ?");
            st.setString(1, contato.getTelefone());
            st.setString(2, contato.getCelular());
            st.setInt(3, contato.getPaciente().getId());

            rowsAffected = st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
        return rowsAffected;
    }

    @Override
    public int deleteContatoByIdPaciente(Integer idPaciente) {
        if (idPaciente == null) {
            throw new NullPointerException("Precisa de um Id de paciente diferente de nulo!");
        }

        int rowsAffected;

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM tb_contato WHERE id_paciente = ?");
            st.setInt(1, idPaciente);
            rowsAffected = st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
        return rowsAffected;
    }

}
