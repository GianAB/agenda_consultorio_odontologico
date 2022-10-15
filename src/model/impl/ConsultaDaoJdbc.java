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
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.dao.ConsultaDao;
import model.dao.DaoFactory;
import model.dao.DentistaDao;
import model.dao.PacienteDao;
import model.dao.ProcedimentoDao;
import model.entities.Anamnese;
import model.entities.Consulta;
import model.entities.enums.Pagamento;

/**
 *
 * @author giang
 */
public class ConsultaDaoJdbc implements ConsultaDao {

    private Connection conn;

    private static DentistaDao dentistaDao = DaoFactory.createDentistaDao();
    private static PacienteDao pacienteDao = DaoFactory.createPacienteDao();

    public ConsultaDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Consulta consulta) {

        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO tb_consulta(dt_inicio, id_dentista, id_paciente) VALUES(?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setTimestamp(1, java.sql.Timestamp.from(consulta.getDt_inicio()));
            st.setInt(2, consulta.getDentista().getId());
            st.setInt(3, consulta.getPaciente().getId());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                rs.first();
                consulta.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
    }

    @Override
    public Consulta findById(Integer id) {
        Consulta consulta = new Consulta();

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_consulta WHERE id = ?");

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                rs.first();
                consulta.setId(rs.getInt("id"));
                consulta.setDt_inicio(Instant.from(rs.getTimestamp("dt_inicio").toInstant()));
                consulta.setDt_termino((rs.getTimestamp("dt_termino") == null) ? null : Instant.from(rs.getTimestamp("dt_termino").toInstant()));
                consulta.setDentista(dentistaDao.findById(rs.getInt("id_dentista")));
                consulta.setPaciente(pacienteDao.findById(rs.getInt("id_paciente")));

                return consulta;
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
    public List<Consulta> findPerDayOfTheWeek(LocalDate dt_consulta) {
        ResultSet rs = null;
        List<Consulta> consultas;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_consulta WHERE DATE(dt_inicio) = ?");
            st.setDate(1, java.sql.Date.valueOf(dt_consulta));

            rs = st.executeQuery();

            if (rs.first()) {
                rs.first();
                consultas = new ArrayList<>();
                do {
                    consultas.add(new Consulta(rs.getInt("id"),
                            Instant.from(rs.getTimestamp("dt_inicio").toInstant()),
                            (rs.getTimestamp("dt_termino") == null) ? null : Instant.from(rs.getTimestamp("dt_termino").toInstant()),
                            dentistaDao.findById(rs.getInt("id_dentista")),
                            pacienteDao.findById(rs.getInt("id_paciente"))));

                } while (rs.next());

                return consultas;
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
    public int update(Consulta consulta) {
        int rowsAffected;

        if (consulta.getId() == null) {
            throw new NullPointerException("Não existe dentista com id nulo!");
        }

        try {
            PreparedStatement st = conn.prepareStatement("UPDATE tb_consulta SET dt_termino = ? WHERE id = ?");
            st.setTimestamp(1, java.sql.Timestamp.from(consulta.getDt_termino()));
            st.setInt(2, consulta.getId());

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
            throw new NullPointerException("Não existe dentista com este id!");
        }

        int rowsAffected;

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM tb_consulta WHERE id = ?");
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
