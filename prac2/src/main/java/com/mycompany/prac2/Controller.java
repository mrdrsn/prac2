/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prac2;

/**
 *
 * @author nsoko
 */
public class Controller {
    public static void createData(int number){
        
         for(int i = 0; i < number; i++){
            Heretic example = DataGenerator.generator();
            example.addToList(example);
        }
         System.out.println("Контроллер создал " + number + " еретиков.");
        Heretic.printList();
    }
}
