import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class WordGUI extends JFrame{
   JMenuBar menuBar = new JMenuBar();
   /**
    * Word GUI Constructor
    * @param list: Linked list to store the words from the file we pass in
    */
   public WordGUI() {
      setTitle("Project 4"); 
      setSize(800,600);
      setLocation(220,50);
      setLayout(new GridLayout(1,2));
      createFileMenu();
      createListMenu();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
      setJMenuBar(menuBar); //sets menu bar to the JFrame menu bar.
   }
   
   /**
    * createFileMenu
    * @param list: WordLinkedList
    */
   private void createFileMenu() {
      JMenuItem item;
      JMenu fileMenu = new JMenu("File");
      FileMenuHandler fmh = new FileMenuHandler(this); //pass in .this JFrame & the linked list.

      item = new JMenuItem("Open");    //Open...
      item.addActionListener(fmh); 
      fileMenu.add(item);

      fileMenu.addSeparator();           
    
      item = new JMenuItem("Quit");       //Quit
      item.addActionListener(fmh);
      fileMenu.add(item);

      
      menuBar.add(fileMenu);   
   } //createMenu
   
   /**
    * createListMenu
    * @param list: WordLinkedList
    */
   private void createListMenu() {
      JMenuItem item;
      JMenu listMenu = new JMenu("List");
      VowelMenuHandler vmh = new VowelMenuHandler(this); //pass in this JFrame and the linked list.
      
      item = new JMenuItem("A");    //'A' option
      item.addActionListener(vmh);
      listMenu.add(item);
      listMenu.addSeparator();          

      item = new JMenuItem("E");    //'E' option
      item.addActionListener(vmh);
      listMenu.add(item);
      listMenu.addSeparator();          

      item = new JMenuItem("I");    //'I' option
      item.addActionListener(vmh);
      listMenu.add(item);
      listMenu.addSeparator();          

      item = new JMenuItem("O");    //'O' option
      item.addActionListener(vmh);
      listMenu.add(item);
      listMenu.addSeparator();          

      item = new JMenuItem("U");    //'U' option
      item.addActionListener(vmh);
      listMenu.add(item);

      menuBar.add(listMenu); 
   }//create List menu
   
}
