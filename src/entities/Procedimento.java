/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author giang
 */
public class Procedimento {

    private Integer id;
    private String descricao;
    private Float valor;
    private Especialidade especialidade;

    public Procedimento() {

    }

    public Procedimento(String descricao, Float valor, Especialidade especialidade) {
        this.descricao = descricao;
        this.valor = valor;
        this.especialidade = especialidade;
    }

    public Procedimento(Integer id, String descricao, Float valor, Especialidade especialidade) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.especialidade = especialidade;
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

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Procedimento{");
        sb.append("id=").append(id);
        sb.append(", descricao=").append(descricao);
        sb.append(", valor=").append(valor);
        sb.append(", especialidade=").append(especialidade);
        sb.append('}');
        return sb.toString();
    }

}
