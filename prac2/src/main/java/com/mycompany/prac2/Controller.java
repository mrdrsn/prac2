package com.mycompany.prac2;

import java.util.ArrayList;

public class Controller {
    
    public static void createData(int number){
         for(int i = 0; i < number; i++){
            Heretic example = DataGenerator.generator();
            example.addToList(example);
        }
         System.out.println("Контроллер создал " + number + " еретиков.");
    }
    
    public static void previewData(){
        Heretic.printList();
    }
    
    public static ArrayList<Heretic> getHerList(){
       return Heretic.getList();
    }
    
    public static String getHerNames(Heretic ex){
       return ex.getName();
    }
    
}
