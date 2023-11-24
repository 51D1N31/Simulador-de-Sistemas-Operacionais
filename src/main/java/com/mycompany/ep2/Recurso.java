/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

/**
 *
 * @author sidin
 */
public class Recurso extends ContadorDeTempo{
    private String nome;
    
    public Recurso(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
}
