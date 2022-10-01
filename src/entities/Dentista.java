/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giang
 */
public class Dentista {
    private Integer id;
    private String nome;
    private String cro;
    private List<Especialidade> especialidades;
    
    public Dentista()   {
        this.especialidades = new ArrayList<>();
    }

    public Dentista(String nome, String cro) {
        this.nome = nome;
        this.cro = cro;
        this.especialidades = new ArrayList<>();
    }
    
    public Dentista(Integer id, String nome, String cro) {
        this.id = id;
        this.nome = nome;
        this.cro = cro;
        this.especialidades = new ArrayList<>();
    }
    public void addEspecialidade(Especialidade especialidade) {
        this.especialidades.add(especialidade);
    }

    public Especialidade getDenstita(Integer index) {
        return this.especialidades.get(index);
    }

    public void removeDentista(Integer index) {
        this.especialidades.remove(index);
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
        sb.append("Dentista{");
        sb.append("id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", cro=").append(cro);
        sb.append(", especialidades=");
        this.especialidades.forEach(x -> sb.append(x.toString()).append(", "));
        sb.append('}');
        return sb.toString();
    }
}
