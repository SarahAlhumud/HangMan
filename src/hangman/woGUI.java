/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author SARA
 */



import java.util.Random ;
import java.util.Scanner ;
import java.util.Arrays ;


class play1 {
   
    
    Scanner scan = new Scanner(System.in,"UTF-8") ;
    int maxTry = 5 ;
    
    String[] country = { "سوريا" ,
        "العراق" ,
        "بورما" , 
        "مصر" ,
        "باكستان" ,
        "مدغشقر" ,
        "فلسطين" ,
        "قطر" ,
        "الكويت" ,
        "اليمن" ,
        "تركستان" ,
        "المملكة" ,
        "السودان"
    };
    
    Random rand = new Random() ;
    int countryno = rand.nextInt(country.length) ;
    
    char[] countryName = new char[country[countryno].length()] ;
    char[] chooseCountry = country[countryno].toCharArray()  ;
    
    
    
    
    
    
   void guess(){
    
    
    
    char letter ;
    
    int wrongGuess = 0 ;
    
    
    for(int i = 0 ; i < chooseCountry.length ; i++ ){
       countryName[i] = '-' ;
    }

    
    
    while(wrongGuess != maxTry){
        
        System.out.println("\n");
        for(int j = 0 ; j < chooseCountry.length ; j++ ){
            System.out.print(countryName[j]);
        }
        if(Arrays.equals(chooseCountry, countryName)){
            System.out.println("\n ربحت  :) \n");
            break ;
        }
        
        System.out.print("\n\n خمن حرف واحد: ");
        letter = scan.next().charAt(0) ;
        
        
        if (check(letter) == 0){
            ++wrongGuess ;
            draw(wrongGuess);
           
        }
       
    }
    
    }
    
    
    public int check(char letter ){
        int no = 0 ;
      for(int j = 0 ; j < chooseCountry.length ; j++ ){
            if (chooseCountry[j] == letter){
                countryName[j] = letter ;
                no++ ;
            }  
    }
     return no ; 
    }
    
    public void draw(int tryno){
        switch(tryno){
            case 1 :
                System.out.println("  +----+ \n"
                        + "  |    |   \n"
                        + "  |    O   \n"
                        + "  |    |   \n"
                        + "  |        \n"
                        + "  |        \n"
                        + " ============= \n\n");
                break;
            case 2 :
                System.out.println("  +----+ \n"
                        + "  |    |   \n"
                        + "  |    O   \n"
                        + "  |   /|   \n"
                        + "  |        \n"
                        + "  |        \n"
                        + " ============= \n\n");
                break;
            case 3 :
                System.out.println("  +----+ \n"
                        + "  |    |   \n"
                        + "  |    O   \n"
                        + "  |   /|\\ \n"
                        + "  |        \n"
                        + "  |        \n"
                        + " ============= \n\n");
                break;   
                
            case 4 :
                System.out.println("  +----+ \n"
                        + "  |    |   \n"
                        + "  |    O   \n"
                        + "  |   /|\\ \n"
                        + "  |     \\ \n"
                        + "  |        \n"
                        + " ============= \n\n");
                break; 
            case 5 :
                System.out.println("  +----+ \n"
                        + "  |    |   \n"
                        + "  |    O   \n"
                        + "  |   /|\\ \n"
                        + "  |   / \\ \n"
                        + "   " + " لقد مت :(  \n"
                        + " ============= \n\n");
                System.out.println("\n\n لقد شنقت  .. \n الكلمة هي :" + country[countryno] );
                break; 
        }
    }

   
    
}


public class woGUI {

    
    public static void main(String[] args) {
        
        System.out.println("\t\t\t\t مرحبا بك في لعبة الرجل المشنوق !! \n");
        System.out.println("خمن دولة من دول العالم.  \n");
        System.out.println("اكتب حرف واحد فقط في كل محاولة \n");
        System.out.println("تمتلك خمس محاولات لتخمين الدولة. \n");
        
        play1 p1 = new play1();
        
        p1.guess();
        
     
        
       
        
    }
    
}

