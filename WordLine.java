import java.util.ArrayList;

/**
 * 
 * WordLine class: data Node for Linked List.
 *
 */
public class WordLine {
   String word; 
   ArrayList <Integer> lineNums = new ArrayList<Integer>();
   /**
    * 
    * @param w: String for specific word
    * @param l: integer for the line number of the word
    */
   public WordLine(String w, int l) {
      if(l < 1) { //if the line number being passed is less than one, throw a WordLine Exception
         throw new InvalidWordLineException();
      }else {
         word = w;
         lineNums.add(l);  
      }//set the word and lineNum to the values passed in.
   }
   
}
