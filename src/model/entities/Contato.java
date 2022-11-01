/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

/**
 *
 * @author giang
 */
public class Contato {

    private String telefone;
    private String celular;
    private Paciente paciente;

    public Contato() {

    }

    public Contato(String telefone, String celular, Paciente paciente) {
        this.telefone = telefone;
        this.celular = celular;
        this.paciente = paciente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
        sb.append("Contato{");
        sb.append(", telefone=").append(telefone);
        sb.append(", celular=").append(celular);
        sb.append(", paciente=").append(paciente);
        sb.append('}');
        return sb.toString();
    }

}
