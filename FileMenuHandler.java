import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FileMenuHandler implements ActionListener {
   //instances...
   JFrame jframe;
   LinkedList list = Project4.list;
   TextArea myTextArea = new TextArea(); //text area for the passed in file.

   /**
    * 
    * @param jf: set the JFrame passed in as the JFrame instance of this class.
    * @param l: pass in the Linked list to set the list instance of this class.
    */
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }    
   /**
    * @param event: the users inputs/events.
    */
   public void actionPerformed(ActionEvent event) {
      jframe.getContentPane().removeAll(); //clears everything in the JFrame when the File event is called. Used to avoid duplication of calling multiple files.
      
      String  menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile(); 
      else if (menuName.equals("Quit"))
         System.exit(0);
   } //actionPerformed

    private void openFile() {
       JFileChooser chooser;
       int status;
       chooser = new JFileChooser();
       status = chooser.showOpenDialog(null);
       if (status == JFileChooser.APPROVE_OPTION) 
          readSource(chooser.getSelectedFile());
       else 
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
    
    /**
     * 
     * @param chosenFile: file user selected from dir.
     */
    private void readSource(File chosenFile) {
       list.clear(); //clears everything in the linked list so no overlap between multiple files.
       myTextArea.setText(null);

       String chosenFileName = chosenFile.getAbsolutePath();
       Container myContentPane = jframe.getContentPane();
       myContentPane.add(myTextArea, BorderLayout.WEST);
       
       String line;
       int lineNum = 1;
       
       Pattern p;
       Matcher m;
       String wordValidation = "[a-zA-Z]+"; //regex key to scan through each word.
       p = Pattern.compile(wordValidation); //compile the pattern.
       
       TextFileInput inFile = new TextFileInput(chosenFileName);
       line = inFile.readLine();
       while (line != null) { //while there are lines to read
          StringTokenizer tokens = new StringTokenizer(line, " ");
          
          try {
             tokenToLinkedList(tokens, lineNum);
          }catch(InvalidWordLineException iwle) {
             JOptionPane.showMessageDialog(null, "Invalid Line number. Verify Line number.");
             break;
          }
          myTextArea.append(lineNum + ":\t" +line+"\n"); //append the text area
          line = inFile.readLine(); //increments the lines in the file.
          lineNum++; //increments the line number.
       } //while
       jframe.setVisible(true);  
    }
    
    /**
     * @description Takes in the tokens and adds them into the LinkedList.
     * @param tokens: the tokens you pass in through the tokenizer. Checks each word
     * @param lineNum: the corresponding line number
     */
    private void tokenToLinkedList(StringTokenizer tokens, int lineNum) {
       Pattern p;
       Matcher m;
       String wordValidation = "[a-zA-Z]+"; //regex key to scan through each word.
       p = Pattern.compile(wordValidation); //compile the pattern.
       while(tokens.hasMoreTokens()) { //while there are more tokens in each line
          String token = tokens.nextToken();
          m = p.matcher(token);
          if(m.find()) { //checks the tokens that matches with the patterns
             
             if(list.contains(m.group(0))) {
                list.addDuplicateLines(m.group(0),lineNum);
             }else {
                WordLine word = new WordLine(m.group(0), lineNum);
                list.add(word); //add the tokens that match to the linked list in sorted order.
             }
                
             
          }      
       }
    }
    
    
    
    
    
}