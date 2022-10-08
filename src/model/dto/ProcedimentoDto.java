/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import java.lang.reflect.InvocationTargetException;
import model.entities.Procedimento;
import model.exceptions.ModelExceptions;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author giang
 */
public class ProcedimentoDto {

    private Integer id;
    private String descricao;
    private Float valor;

    public ProcedimentoDto convertToDto(Procedimento procedimento) {
        try {
            BeanUtils.copyProperty(this, "especialidade", procedimento);

        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ModelExceptions(e.getMessage());
        }
        return this;
    }

    public ProcedimentoDto() {

    }

    public ProcedimentoDto(Integer id, String descricao, Float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProcedimentoDto{");
        sb.append("id=").append(id);
        sb.append(", descricao=").append(descricao);
        sb.append(", valor=").append(valor);
        sb.append('}');
        return sb.toString();
    }

}
