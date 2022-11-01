/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.time.Instant;

/**
 *
 * @author giang
 */
public class Consulta {

    private Integer id;
    private Instant dt_inicio;
    private Instant dt_termino;
    private Dentista dentista;
    private Paciente paciente;

    public Consulta() {

    }

    public Consulta(Integer id, Instant dt_termino) {
        this.id = id;
        this.dt_termino = dt_termino;
    }

    public Consulta(Instant dt_inicio, Dentista dentista, Paciente paciente) {
        this.dt_inicio = dt_inicio;
        this.dentista = dentista;
        this.paciente = paciente;
    }

    public Consulta(Integer id, Instant dt_inicio, Instant dt_termino, Dentista dentista, Paciente paciente) {
        this.id = id;
        this.dt_inicio = dt_inicio;
        this.dt_termino = dt_termino;
        this.dentista = dentista;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Instant dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public Instant getDt_termino() {
        return dt_termino;
    }

    public void setDt_termino(Instant dt_termino) {
        this.dt_termino = dt_termino;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Consulta{");
        sb.append("id=").append(id);
        sb.append(", dt_inicio=").append(dt_inicio);
        sb.append(", dt_termino=").append(dt_termino);
        sb.append(", dentista=").append(dentista);
        sb.append(", paciente=").append(paciente);
        sb.append('}');
        return sb.toString();
    }

}
