/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giang
 */
public class Especialidade {

    private Integer id;
    private String descricao;
    private List<Dentista> dentistas;

    public Especialidade() {
        dentistas = new ArrayList<>();
    }

    public Especialidade(String descricao) {
        this.descricao = descricao;
        dentistas = new ArrayList<>();
    }

    public Especialidade(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        dentistas = new ArrayList<>();
    }

    public void addDentista(Dentista dentista) {
        this.dentistas.add(dentista);
    }

    public Dentista getDenstita(Integer index) {
        return this.dentistas.get(index);
    }

    public void removeDentista(Integer index) {
        this.dentistas.remove(index);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Especialidade{");
        sb.append("id=").append(id);
        sb.append(", descricao=").append(descricao);
        sb.append('}');
        return sb.toString();
    }

}
