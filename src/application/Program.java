/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import entities.Anamnese;
import entities.Consulta;
import entities.Contato;
import entities.Dentista;
import entities.Especialidade;
import entities.Paciente;
import entities.Procedimento;
import entities.enums.Pagamento;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author giang
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.of("UTC"));

        Paciente pa1 = new Paciente("Gian", "Antonio", "32837737463");
        Paciente pa2 = new Paciente("Jade", "Antonio", "32837457432");

        Contato co1 = new Contato("3338475225", "33918273354", pa1);
        Contato co2 = new Contato("3336778725", "33918903390", pa2);

        Dentista de1 = new Dentista("Jackcele Antonio", "SP493847327");
        Dentista de2 = new Dentista("Giliard Antonio", "MG493347323");

        Especialidade es1 = new Especialidade("Ortodontista");
        Especialidade es2 = new Especialidade("Clínico Geral");
        
        de1.addEspecialidade(es1);
        es1.addDentista(de1);
        de2.addEspecialidade(es2);
        es2.addDentista(de2);
        
        Consulta con1 = new Consulta(Instant.from(formatter.parse("01/10/2022 08:00")), de1, pa1);
        Consulta con2 = new Consulta(Instant.from(formatter.parse("01/10/2022 09:00")), de1, pa2);
     
        Procedimento pro1 = new Procedimento("Instalação de Aparelho", 100f, es1);
        Procedimento pro2 = new Procedimento("Manutenção de Aparelho", 50f, es1);
        Procedimento pro3 = new Procedimento("Remoção de Caries", 100f, es2);
        Procedimento pro4 = new Procedimento("Limpeza", 200f, es2);
        Procedimento pro5 = new Procedimento("Aplicação de resina", 50f, es2);
        
        Anamnese an1 = new Anamnese(con2, pro1, (short) 2);
        
        an1.setPagamento(Pagamento.PAGO.getCod());
        
        con2.setDt_termino(Instant.from(formatter.parse("01/10/2022 09:40")));
        
        /*
        System.out.println(co1);
        System.out.println(de1);
        System.out.println(con1);
        */
        System.out.println(con2);
        /*
        System.out.println(pro1);
        System.out.println(pro2);
        System.out.println(pro3);
        System.out.println(pro4);
        System.out.println(pro5);
        */
        System.out.println(an1);
        System.out.println("con2");
    }

}
