import java.util.HashMap;


class Point{
	int x;
	int y;
	Point(){
		x = 0;
		y = 0;
	}
	
	Point(int a, int b){
		x = a;
		y = b;
	}
}

public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		if(points.length < 3)
			return points.length;
		int result = 0;
		
		HashMap<Double, Integer> map = new HashMap<>();
		for(int i = 0; i < points.length; ++i){
			map.clear();
			int samePoint = 0;
			int pointsInLine = 1;
			for(int j = i + 1; j < points.length; ++j){
				double slope = 0.0;
				if(points[i].x == points[j].x){
					slope = Double.POSITIVE_INFINITY;
					if(points[i].y == points[j].y){
						samePoint++;
						continue;
					}
				}else if(points[i].y == points[j].y){
					slope = 0;
				}else{
					slope = 1.0*(points[i].y - points[j].y)/(points[i].x - points[j].x);
				}
				
				int count = 0;
				if(map.containsKey(slope) == true){
					count = map.get(slope) + 1;
					map.put(slope, count);
				}else{
					count = 2;
					map.put(slope, 2);
				}
				
				if(pointsInLine < count)
					pointsInLine = count;
			}
			result = Math.max(result, pointsInLine + samePoint);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Point[] points = new Point[3];
		points[0] = new Point(2,3);
		points[1] = new Point(3,3);
		points[2] = new Point(-5,3);
		
		MaxPointsOnALine ma = new MaxPointsOnALine();
		System.out.println(ma.maxPoints(points));
	}
}
