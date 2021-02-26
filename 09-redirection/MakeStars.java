import java.util.*;
public class MakeStars{
  public static void main( String[]args ){
      Scanner n = new Scanner(System.in);
      while (n.hasNextLine()){
        Scanner l= new Scanner (n.nextLine());
        while (l.hasNext()) {
          Scanner w=new Scanner(l.next());
          while (w.hasNext()) {
			  int hold = w.next().length();
            for (int i=0; i<hold; i++){
              System.out.print("*");
            }
          }
          if (l.hasNext()) System.out.print(" ");
        }
        if (n.hasNext()) System.out.println();
      }
  }
}