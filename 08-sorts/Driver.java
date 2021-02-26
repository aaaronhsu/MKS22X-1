import java.util.Arrays;
public class Driver{

  public static void main(String[]args){
    //args 0 must be size of the Array
    //args 1 must be "bubble" or "test" (unless you add more)
    int[] randData = new int[Integer.parseInt(args[0])];

    for(int i = 0 ; i < randData.length; i++){
      randData[i] =(int)(Math.random()*10000);
    }

    if(args[1].equals("bubble")){
      Sorts.bubbleSort(randData);
    }
    if(args[1].equals("test")){
      int[] randDataBubble = Arrays.copyOf(randData,randData.length);
      Arrays.sort(randData);
      Sorts.bubbleSort(randDataBubble);


      if( Arrays.equals(randData,randDataBubble)){
        System.out.println("Bubble Correct!");
      }else{
       System.out.println("Bubble Not Correct!!!!!!!!!11oneeleven");
      }
    }
  }
}