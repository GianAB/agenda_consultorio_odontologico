/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import java.lang.reflect.InvocationTargetException;
import model.entities.Dentista;
import model.exceptions.ModelExceptions;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author giang
 */
public class DentistaDto {

    private Integer id;
    private String nome;
    private String cro;

    public DentistaDto convertToDto(Dentista dentista) {
        try {
            BeanUtils.copyProperty(this, "especialidades", dentista);

        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ModelExceptions(e.getMessage());
        }
        return this;
    }

    public DentistaDto() {

    }

    public DentistaDto(String nome, String cro) {
        this.nome = nome;
        this.cro = cro;
    }

    public DentistaDto(Integer id, String nome, String cro) {
        this.id = id;
        this.nome = nome;
        this.cro = cro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DentistaDto{");
        sb.append("id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", cro=").append(cro);
        sb.append('}');
        return sb.toString();
    }

}
