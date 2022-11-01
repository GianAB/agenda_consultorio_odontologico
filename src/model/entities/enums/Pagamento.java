/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model.entities.enums;

/**
 *
 * @author giang
 */
public enum Pagamento {
    PENDENTE((byte) 1, "Pendente"),
    PAGO((byte) 2, "Pago"),
    CANCELADO((byte) 3, "Cancelado");

    private Byte cod;
    private String valor;

    private Pagamento() {

    }

    private Pagamento(Byte cod, String valor) {
        this.cod = cod;
        this.valor = valor;
    }

    public static Pagamento toEnum(Byte cod) {
        if (cod == null) {
            throw new NullPointerException("Código de Pagamento inválido!");
        }

        for (Pagamento x : Pagamento.values()) {
           if(cod.equals(x.getCod())){
               return x;
           }
        }
        throw new IndexOutOfBoundsException("Este código não corresponde à nenhuma enumeração!");
    }

    public static Pagamento toEnum(String valor) {
        if (valor == null) {
            throw new NullPointerException("Tipo de pagamento inválido!");
        }

        for (Pagamento x : Pagamento.values()) {
           if(valor.equals(x.toString()) || valor.equals(x.getValor())){
               return x;
           }
        }
        throw new IndexOutOfBoundsException("Este código não corresponde à nenhuma enumeração!");
    }

    public Byte getCod() {
        return cod;
    }
    
    public String getValor() {
        return valor;
    }
}
