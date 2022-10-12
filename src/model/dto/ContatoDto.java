/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import java.lang.reflect.InvocationTargetException;
import model.entities.Contato;
import model.exceptions.ModelExceptions;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author giang
 */
public class ContatoDto {

    private String telefone;
    private String celular;

    public ContatoDto convertToDto(Contato contato) {
        try {
            BeanUtils.copyProperty(this, "paciente", contato);

        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ModelExceptions(e.getMessage());
        }
        return this;
    }

    public ContatoDto() {

    }

    public ContatoDto(String telefone, String celular) {
        this.telefone = telefone;
        this.celular = celular;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContatoDto{");
        sb.append("telefone=").append(telefone);
        sb.append(", celular=").append(celular);
        sb.append('}');
        return sb.toString();
    }

}
