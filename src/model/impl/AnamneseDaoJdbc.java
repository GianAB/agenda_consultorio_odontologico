/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.impl;

import java.sql.Connection;
import db.DB;
import db.DBException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import model.dao.AnamneseDao;
import model.dao.ConsultaDao;
import model.dao.DaoFactory;
import model.dao.ProcedimentoDao;
import model.entities.Anamnese;
import model.entities.Consulta;
import model.entities.enums.Pagamento;

/**
 *
 * @author giang
 */
public class AnamneseDaoJdbc implements AnamneseDao {

    private Connection conn;
    private static ConsultaDao consultaDao = DaoFactory.createConsultaDao();
    private static ProcedimentoDao procedimentoDao = DaoFactory.createProcedimentoDao();

    public AnamneseDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Anamnese anamnese) {

        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO tb_anamnese(id_consulta, id_procedimento, quantidade, valor) "
                    + "VALUES(?, ?, ?, ?)");

            st.setInt(1, anamnese.getConsulta().getId());
            st.setInt(2, anamnese.getProcedimento().getId());
            st.setShort(3, anamnese.getQuantidade());
            st.setFloat(4, anamnese.getValor());

            st.execute();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
    }

    @Override
    public Anamnese findByIdConsultaAndIdProcedimento(Integer idConsulta, Integer idProcedimento) {
        Anamnese anamnese = new Anamnese();

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_anamnese WHERE id_consulta = ? AND id_procedimento = ?");
            st.setInt(1, idConsulta);
            st.setInt(2, idProcedimento);

            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                rs.first();
                anamnese.setConsulta(consultaDao.findById(rs.getInt("id_consulta")));
                anamnese.setProcedimento(procedimentoDao.findById(rs.getInt("id_procedimento")));
                anamnese.setQuantidade(rs.getShort("quantidade"));
                anamnese.setPagamento(rs.getString("pagamento"));

                return anamnese;
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
    public List<Anamnese> findAllAnamnesePerIdConsulta(Integer idConsulta) {
        ResultSet rs = null;
        List<Anamnese> anamneses;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_anamnese WHERE id_consulta = ?");
            st.setInt(1, idConsulta);

            rs = st.executeQuery();

            if (rs.first()) {
                rs.first();
                anamneses = new ArrayList<>();
                do {
                    anamneses.add(new Anamnese(
                            consultaDao.findById(rs.getInt("id_consulta")),
                            procedimentoDao.findById(rs.getInt("id_procedimento")),
                            rs.getShort("quantidade"),
                            Pagamento.toEnum(rs.getString("pagamento"))));

                } while (rs.next());

                return anamneses;
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
    public int update(Anamnese anamnese) {
        //Quantidade, EnumPagamento e Valor do Pagamento
        int rowsAffected;

        if (anamnese.getConsulta().getId() == null  || anamnese.getProcedimento().getId() == null) {
            throw new NullPointerException("Nenhuma consulta ou nenhum procedimento foi selecionado nesta operação!");
        }

        try {
            PreparedStatement st = conn.prepareStatement("UPDATE tb_anamnese SET quantidade = ?, pagamento = ?, valor = ?"
                    + " WHERE id_consulta = ? AND id_procedimento = ?");
            
            st.setShort(1, anamnese.getQuantidade());
            st.setString(2, anamnese.getPagamento().toString());
            st.setFloat(3, anamnese.getValor());
            st.setInt(4, anamnese.getConsulta().getId());
            st.setInt(5, anamnese.getProcedimento().getId());
            
            rowsAffected = st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
        return rowsAffected;
    }

    @Override
    public int deleteByIdConsultaAndIdProcedimento(Integer idConsulta, Integer idProcedimento) {
         if (idConsulta == null  || idProcedimento == null) {
            throw new NullPointerException("Nenhuma consulta ou nenhum procedimento foi selecionado nesta operação!");
        }

        int rowsAffected;

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM tb_anamnese WHERE id_consulta = ? AND id_procedimento = ?");
            st.setInt(1, idConsulta);
            st.setInt(2, idProcedimento);
            
            rowsAffected = st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
        return rowsAffected;
    }

    @Override
    public int deleteByIdConsulta(Integer idConsulta) {
         if (idConsulta == null) {
            throw new NullPointerException("Nenhuma consulta foi selecionado nesta operação!");
        }

        int rowsAffected;

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM tb_anamnese WHERE id_consulta = ?");
            st.setInt(1, idConsulta);
            
            rowsAffected = st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
        return rowsAffected;
    }

}
