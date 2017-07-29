
package hangman;


import java.awt.*;
import java.util.Random ;
import java.util.Scanner ;
import java.util.Arrays ;
import javax.swing.* ;
import javax.swing.border.EmptyBorder;
import java.awt.event.* ;





class Play extends JFrame {
   
    
    Scanner scan = new Scanner(System.in,"UTF-8") ;
    
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

    JPanel  mn , p1 , p2 , p3 , p4 ,p5 ;
    JLabel l1 , l2 , l3 , l4 , l5 , l6 , l7;
    JTextField text ;
    ImageIcon img = new ImageIcon("Hangman-1.png");
    JButton again ;
    char letter ;
    int wrongGuess = 0 ;
   
    
    
    
    
    Play() {
    super("لعبة الرجل المشنوق") ;
    
        JPanel frame = new JPanel();
        frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        add(frame) ;
    
        
    p1 = new JPanel();
    l1 = new JLabel("خمن حرف واحد :") ;
    
    text = new JTextField(3) ;
    p1.add(text) ;
    p1.add(l1) ;
    p1.setAlignmentX(Component.CENTER_ALIGNMENT);
    frame.add(p1) ;

        p2 = new JPanel() ;
    l2 = new JLabel(img) ;
    p2.add(l2) ;
    p2.setAlignmentX(Component.CENTER_ALIGNMENT);
    frame.add(p2) ;


    p3 = new JPanel() ;
    p3.setAlignmentX(Component.CENTER_ALIGNMENT);
    frame.add(p3) ;
    l3 = new JLabel("الدولة هي :      ") ;
    l3.setHorizontalAlignment(JLabel.CENTER);
    p3.setBorder(new EmptyBorder(20, 20, 20, 20));

    
    for(int i = 0 ; i < chooseCountry.length ; i++ ){
       countryName[i] = '-' ;
    }
    
    l4 = new JLabel(new String(countryName));
    p3.add(l4); 
    p3.add(l3) ;


    p4 = new JPanel();
    p4.setAlignmentX(Component.CENTER_ALIGNMENT);
    frame.add(p4) ;
    l6 = new JLabel("") ;
    p4.add(l6) ;

    p5 = new JPanel();
    p5.setAlignmentX(Component.CENTER_ALIGNMENT);
    frame.add(p5) ;
    again = new JButton("ألعب مرة أخرى") ;
    again.setVisible(false);
    p5.add(again);
            
    ChangeButton handler = new ChangeButton() ;
    text.addActionListener(handler);
    again.addActionListener(handler);

        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    private class ChangeButton implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == text){
                letter = text.getText().charAt(0);
                text.setText("");
            System.out.println("i nd");

            System.out.println(chooseCountry);
            System.out.println(countryName);

            System.out.println("ii");


            if (check(letter) == 0) {
                ++wrongGuess;
                draw(wrongGuess);
                l2.setIcon(img);
            }

            l4.setText(new String(countryName));


            if (wrongGuess > 5) {
                afterWonOrLose(new ImageIcon("Hangman-6.png"), "لقد خسرت :(" );
                l4.setText(new String(chooseCountry));


            }

            if (Arrays.equals(chooseCountry, countryName)) {
                afterWonOrLose(new ImageIcon("hangwons.gif"), "لقد ربحت :)" );

            }


        }
        if (event.getSource() == again){
                new Play();
                Play.this.setVisible(false);


        }
    }

    }
    
    
    private int check(char letter ){
        
        int no = 0 ;
      for(int j = 0 ; j < chooseCountry.length ; j++ ){
            if (chooseCountry[j] == letter){
                countryName[j] = letter ;
                no++ ;
            }  
    }
     return no ; 
    }
    
    private void draw(int tryno){
        switch(tryno){
            case 1 :
                img = new ImageIcon("Hangman-2.png") ;
                break;
                
            case 2 :
                img = new ImageIcon("Hangman-3.png") ;
                break;
                
            case 3 :
                img = new ImageIcon("Hangman-4.png") ;
                break;   
                
            case 4 :
                img = new ImageIcon("Hangman-5.png") ;
                break; 
                
            case 5 :
                img = new ImageIcon("Hangman-6-2.png") ;
                break;
                 
        }
        
    }

    private void afterWonOrLose(ImageIcon myIcon , String txt){
        text.setText("");
        text.setEditable(false);
        img.setImage(myIcon.getImage());
        l2.setIcon(img);
        l6.setText(txt);
        again.setVisible(true);

    }

   
    
}


public class HangMan {

    
    public static void main(String[] args) {
        
        Play p = new Play();

    }
    
}
