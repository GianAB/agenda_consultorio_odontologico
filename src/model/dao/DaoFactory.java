/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import db.DB;
import model.dao.impl.AnamneseDaoJdbc;
import model.dao.impl.ConsultaDaoJdbc;
import model.dao.impl.ContatoDaoJdbc;
import model.dao.impl.DentistaDaoJdbc;
import model.dao.impl.EspecialidadeDaoJdbc;
import model.dao.impl.PacienteDaoJdbc;
import model.dao.impl.ProcedimentoDaoJdbc;

/**
 *
 * @author giang
 */
public class DaoFactory {

    public static DentistaDao createDentistaDao() {
        return new DentistaDaoJdbc(DB.getConnection());
    }

    public static EspecialidadeDao createEspecialidadeDao() {
        return new EspecialidadeDaoJdbc(DB.getConnection());
    }

    public static ProcedimentoDao createProcedimentoDao() {
        return new ProcedimentoDaoJdbc(DB.getConnection());
    }

    public static PacienteDao createPacienteDao() {
        return new PacienteDaoJdbc(DB.getConnection());
    }

    public static ContatoDao createContatoDao() {
        return new ContatoDaoJdbc(DB.getConnection());
    }

    public static ConsultaDao createConsultaDao() {
        return new ConsultaDaoJdbc(DB.getConnection());
    }

    public static AnamneseDao createAnamneseDao() {
        return new AnamneseDaoJdbc(DB.getConnection());
    }

}
