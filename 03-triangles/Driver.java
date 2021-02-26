public class Driver{
	public static double distance(Point a, Point b){
	  return Math.sqrt(Math.pow(a.getX()-b.getX(),2)+Math.pow(a.getY()-b.getY(),2));
	}
  
	public static void main(String[]args){
	  Point p1 = new Point(1.5,1.5);
	  Point p2 = new Point(2.5,2.5);
	  Point p3 = null;
	  System.out.println("Should be false : p1==p2 is "+p1.equals(p2));
	  System.out.println("Should be true  : p2==p3 is "+p2.equals(p3));
	  System.out.println();
	  System.out.println("Testing the distance 2 ways, should be sqrt(2)");
	  System.out.println(  distance(p1,p2)); //static in the Driver class
	  System.out.println(  p1.distanceTo(p2)); //non-static in the Point class.
  
	  System.out.println("\nTesting 2 similar traingles, perimeter = 2+sqrt(2) area = 0.5, the larger is double that");
	  Triangle t1 = new Triangle(0,0,0,1,1,0);
	  Triangle t2 = new Triangle(new Point(-1,0),new Point(1,2),new Point(1,0));
	  System.out.println( t1+" is a " + t1.classify() + " triangle.");
	  System.out.println( "Perimeter: " + t1.getPerimeter() );
	  System.out.println( "Area: " + t1.getArea() );
	  System.out.println();
	  System.out.println( t2+" is a " + t2.classify() + " triangle.");
	  System.out.println( "Perimeter: " + t2.getPerimeter() );
	  System.out.println( "Area: " + t2.getArea() );
  
	  System.out.println("\nTesting a 3/4/5 triangle");
	  t1 = new Triangle(-1,-1, 2,3, 2,-1);
	  System.out.println( t1 );
	  System.out.println( t1.getPerimeter() );
  
	  System.out.println("\nTesting setPoint in the 3/4/5 triangle");
	  t1.setVertex(0,new Point(9,9));
	  t1.setVertex(1,new Point(-9,9));
	  t1.setVertex(2,new Point(9,-9));
	  System.out.println( t1 );
	}
   }