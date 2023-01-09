public class LinkedList{
   Node first = new Node(null);
   Node last = first;
   private int length = 0;
   
   /**
    * Adds in sorted order
    * @param d: instance of WordLine.
    */
   public void add(WordLine d){
      Node newNode = new Node(d);  
      Node currentNode;

       // Special case for head node. When first is empty or current is less than first. 
       if(first.next == null || newNode.data.word.toLowerCase().compareTo(first.next.data.word.toLowerCase())< 0) {
           newNode.next = first.next;
           first.next = newNode;
       }
       else {

           // Locate the node before point of insertion. 
           currentNode = first.next;
           //increments until the current.next is equal to null or current.next is greater than the new Node.
           while (currentNode.next != null && currentNode.next.data.word.toLowerCase().compareTo(newNode.data.word.toLowerCase()) < 0)
               currentNode = currentNode.next;

           newNode.next = currentNode.next;
           currentNode.next = newNode;
       }
   }
   /**
    * 
    * @param w: pass in the string to compare to.
    * @return false if there does not contain a node in the linked list.
    */
   public boolean contains(String w) {
      Node e = first.next;
      while(e!=null) {
         try {
            if(w.equals(e.data.word)) {
               return true;
            }
         }catch(NullPointerException npe) {
            System.out.println("Null Pointer");
         }finally {
            e = e.next;
         }
      }
      return false;
   }
   
   /**
    * 
    * @param w: the string to compare to.
    * @param l: the line number of the word.
    * adds the duplicates to the line Num Array. 
    */
   public void addDuplicateLines(String w, int l) {
      Node e = first.next;
      while(e!=null) {
         try {
            if(w.equals(e.data.word)) {
               e.data.lineNums.add(l);
            }
         }
         catch(NullPointerException npe) {
            
         }finally {
            e = e.next;
         }
      }
   }
   
   /**
    * resets the first and last pointers.
    */
   public void clear() {
      first = new Node(null);
      last = first;
   }

   
}
