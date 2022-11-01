/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package db;

/**
 *
 * @author giang
 */
public class DBException extends RuntimeException {
   static final long serialVersionUID = 1;
   
    public DBException(String menssage){
        super(menssage);
    }
 }
