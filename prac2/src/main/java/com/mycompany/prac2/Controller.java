package com.mycompany.prac2;

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
    
    public static Heretic getInfo(int id){
       return Heretic.getList().get(id);
    }
}
