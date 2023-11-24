/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ep2;

/**
 *
 * @author sidin
 */
public class EP2 {

    public static void main(String[] args) {
        Processo var = new Processo("Teste", false, 1, 2, 3);
        System.out.println(var.getId());
        Processo var2 = new Processo("Teste2", false, 2, 3, 4);
        System.out.println(var2.getId());
    }
}
