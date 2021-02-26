public class Point{
	private double x,y;
  
	//construct a point given coordinates
	public Point(double X, double Y){
	  x=X;
	  y=Y;
	}
  
	//construct a point given a point  (redundant , just provides flexibility)
	public Point(Point p){
	  x= p.x;  //private access in the same file is allowed!
	  y= p.y;
	}
  
	public double getX(){
	  return x;
	}
  
	public double getY(){
	  return y;
	}

	public double distanceTo(Point other) {
		double xDist = Math.pow(this.x - other.x, 2);
		double yDist = Math.pow(this.y - other.y, 2);

		return Math.sqrt(xDist + yDist);
	}

	public boolean equals(Point other) {
		return other != null && this.x == other.x && this.y == other.y;
	}
  
}