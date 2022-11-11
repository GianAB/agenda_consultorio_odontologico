/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import db.DB;
import db.DBException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.EspecialidadeDao;
import model.dao.ProcedimentoDao;
import model.dto.ProcedimentoDto;
import model.entities.Especialidade;
import model.entities.Procedimento;

/**
 *
 * @author giang
 */
public class ProcedimentoDaoJdbc implements ProcedimentoDao {

    private Connection conn;
    private EspecialidadeDao especialidadeDao = DaoFactory.createEspecialidadeDao();

    public ProcedimentoDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Procedimento procedimento) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO tb_procedimento(descricao, valor,  id_especialidade) VALUES(?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, procedimento.getDescricao());
            st.setFloat(2, procedimento.getValor());
            st.setInt(3, procedimento.getEspecialidade().getId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                rs.first();
                procedimento.setId(rs.getInt(1));
                DB.closeResultset();
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
    }

    @Override
    public Procedimento findById(Integer id) {
        Procedimento procedimento = null;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_procedimento WHERE id = ?");
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                rs.first();
                Especialidade especialidade = especialidadeDao.findById(rs.getInt("id_especialidade"));
                procedimento = new Procedimento(rs.getInt("id"), rs.getString("descricao"), rs.getFloat("valor"), especialidade);

                return procedimento;
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
    public List<ProcedimentoDto> findAll() {
        List<ProcedimentoDto> procedimentosDto = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_procedimento");
            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                rs.first();

                do {
                    procedimentosDto.add(new ProcedimentoDto(rs.getInt("id"), rs.getString("descricao"), rs.getFloat("valor")));

                } while (rs.next());

                return procedimentosDto;
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
    public int update(Procedimento procedimento) {
        int rowsAffected;

        if (procedimento.getId() == null) {
            throw new NullPointerException("Não existe procedimento com id nulo!");
        }

        try {
            PreparedStatement st = conn.prepareStatement("UPDATE tb_procedimento SET descricao = ?, valor = ? WHERE id = ?");
            st.setString(1, procedimento.getDescricao());
            st.setFloat(2,procedimento.getValor());
            st.setInt(3, procedimento.getId());

            rowsAffected = st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } catch (NullPointerException e) {
            throw new NullPointerException("Nenhuma linha afetada!");
            
        } finally {
            DB.closeStatement();
        }
        return rowsAffected;
    }

    @Override
    public int deleteById(Integer id) {
        if (id == null) {
            throw new NullPointerException("Não existe procedimento com id nulo!");
        }

        int rowsAffected;

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM tb_procedimento WHERE id = ?");
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
