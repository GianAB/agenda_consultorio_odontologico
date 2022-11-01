/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import model.entities.enums.Pagamento;

/**
 *
 * @author giang
 */
public class Anamnese {

    private Consulta consulta;
    private Procedimento procedimento;
    private Short quantidade;
    private Pagamento pagamento;

    public Anamnese() {

    }

    public Anamnese(Consulta consulta, Procedimento procedimento, Short quantidade) {
        this.consulta = consulta;
        this.procedimento = procedimento;
        this.quantidade = quantidade;
        this.pagamento = Pagamento.PENDENTE;
    }

    public Anamnese(Consulta consulta, Procedimento procedimento, Short quantidade, Pagamento pagamento) {
        this.consulta = consulta;
        this.procedimento = procedimento;
        this.quantidade = quantidade;
        this.pagamento = pagamento;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Short quantidade) {
        this.quantidade = quantidade;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Byte cod) {
        this.pagamento = Pagamento.toEnum(cod);
    }
    
    public void setPagamento(String valor) {
        this.pagamento = Pagamento.toEnum(valor);
    }

    public Float getValor() {
        return this.quantidade * this.procedimento.getValor();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Anamnese{");
        sb.append("consulta=").append(consulta);
        sb.append(", procedimento=").append(procedimento);
        sb.append(", quantidade=").append(quantidade);
        sb.append(", Valor total=").append(this.getValor());
        sb.append(", pagamento=").append(pagamento.getValor());
        sb.append('}');
        return sb.toString();
    }

}
