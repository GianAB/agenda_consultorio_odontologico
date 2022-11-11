/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import db.DB;
import java.util.List;
import model.dao.DentistaDao;
import model.entities.Dentista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.DBException;
import java.util.ArrayList;
import model.dao.DaoFactory;
import model.dto.DentistaDto;
import model.dao.EspecialidadeDao;
import model.entities.Especialidade;

/**
 *
 * @author giang
 */
public class DentistaDaoJdbc implements DentistaDao {

    private Connection conn;
    private static EspecialidadeDao especialidadeDao = DaoFactory.createEspecialidadeDao();

    public DentistaDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Dentista dentista) {

        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO tb_dentista(nome, cro) VALUES (?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, dentista.getNome());
            st.setString(2, dentista.getCro());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                rs.first();
                dentista.setId(rs.getInt(1));

            }

            for (Especialidade especialidade : dentista.getEspecialidades()) {
                try {
                    st = conn.prepareStatement("INSERT INTO tb_dentista_especialidade(id_dentista, id_especialidade) VALUES (?, ?)");
                    st.setInt(1, dentista.getId());
                    st.setInt(2, especialidade.getId());
                    st.execute();

                } catch (SQLException e) {
                    throw new DBException(e.getMessage());

                } finally {
                    DB.closeStatement();
                    DB.closeResultset();
                }
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
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
                rs.first();

                dentista.setId(rs.getInt("id_dentista"));
                dentista.setNome(rs.getString("dentista"));
                dentista.setCro(rs.getString("cro"));

                dentista.getEspecialidades().addAll(this.findEspecialidadesByDentistaId(rs.getInt("id_especialidade")));

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
    public List<DentistaDto> findAll() {
        ResultSet rs = null;
        List<DentistaDto> dentistasDto;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT  * FROM tb_dentista");
            rs = st.executeQuery();

            if (rs.first()) {
                rs.first();
                dentistasDto = new ArrayList<>();
                do {
                    dentistasDto.add(new DentistaDto(rs.getInt("id"), rs.getString("nome"), rs.getString("cro")));
                } while (rs.next());

                return dentistasDto;
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
    public int update(Dentista dentista) {
        int rowsAffected;

        if (dentista.getId() == null) {
            throw new NullPointerException("Não existe dentista com id nulo!");
        }

        try {
            PreparedStatement st = conn.prepareStatement("UPDATE tb_dentista SET nome = ? WHERE id = ?");
            st.setString(1, dentista.getNome());
            st.setInt(2, dentista.getId());
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
            PreparedStatement st = conn.prepareStatement("DELETE FROM tb_dentista WHERE id = ?");
            st.setInt(1, id);
            rowsAffected = st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());

        } finally {
            DB.closeStatement();
        }
        return rowsAffected;
    }

    private List<Especialidade> findEspecialidadesByDentistaId(Integer idDentista) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM tb_dentista_especialidade WHERE id_dentista = ?");
            st.setInt(1, idDentista);
            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                rs.first();

                List<Especialidade> especialidades = new ArrayList<>();

                do {
                    especialidades.add(especialidadeDao.findById(rs.getInt("id_especialidade")));
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
}
