import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class VowelMenuHandler implements ActionListener {
   JFrame jframe;
   TextArea vowelText = new TextArea();
   LinkedList list = Project4.list;
   
   /**
    * 
    * @param jf: Instance of Jframe passed in from WordGUI
    * @param l: list passed in
    */
   public VowelMenuHandler (JFrame jf) {
      jframe = jf;
   }
   /**
    * @param event: The action the user clicked on
    */
   public void actionPerformed(ActionEvent event) {
      vowelText.setText(null);
      jframe.getContentPane().remove(vowelText); //removes vowelText content pane 
      String  menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("A")) {
         displayVowels('a');
      }else if (menuName.equals("E")) {
         displayVowels('e');
      }else if (menuName.equals("I")) {
         displayVowels('i');
      }else if (menuName.equals("O")) {
         displayVowels('o');
      }else if (menuName.equals("U")) {
         displayVowels('u');
      }
   } //actionPerformed
   
   /**
    * diplayVowels
    * @param vowel: character/lower case.
    */
   private void displayVowels(char vowel) {
      Container myContentPane = jframe.getContentPane();
      myContentPane.add(vowelText, BorderLayout.EAST);
      
      String returnString = "";
      Node p = list.first.next;
      while(p!=null){ //while the node is not null
         if(Character.toLowerCase(p.data.word.charAt(0)) == vowel){ //checks the first character of the Node and matches to the vowel
            returnString +=  p.data.word + ":\t"+ p.data.lineNums + "\n";
         }
         p = p.next; //increments to next node.
      }
      vowelText.append(returnString);
      jframe.setVisible(true);  
      
   }
    
}