/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import db.DB;
import model.impl.DentistaDaoJdbc;
import model.impl.EspecialidadeDaoJdbc;
import model.impl.ProcedimentoDaoJdbc;

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

}
