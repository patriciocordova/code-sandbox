package code.chapter9;

/*
 * 9.2 Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can
 * only move in two directions: right and down. How many possible paths are there
 * for the robot to go from (0,0) to (X,Y)?
 * FOLLOW UP
 * Imagine certain spots are "off limits," such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom
 * right.
 */
public class Robot {
	
	public static void main(String[] args) {
		int[][] limits = new int[][]{{1,1},{2,2}};
		System.out.println(paths(0,0,3,3,"0,0"));
		System.out.println(pathsWithLimits(0,0,3,3,limits,"0,0"));
	}
	
	public static int paths(int curX, int curY, int desX, int desY, String path) {		
		int sum = 0;
		if(curX <= desX && curY <= desY){
			if(curX == desX && curY == desY){
				System.out.println(path);
				sum++;
			}
			sum += paths(curX+1,curY,desX,desY,path+"|"+(curX+1)+","+curY); //Move right
			sum += paths(curX,curY+1,desX,desY,path+"|"+curX+","+(curY+1)); //Move down
		}
		return sum;
	}
	
	public static int pathsWithLimits(int curX, int curY, int desX, int desY, int[][] limits, String path) {
		if(checkLimits(curX, curY, limits)){
			return 0;
		}
		int sum = 0;
		if(curX <= desX && curY <= desY){
			if(curX == desX && curY == desY){
				System.out.println(path);
				sum++;
			}
			sum += pathsWithLimits(curX+1,curY,desX,desY,limits,path+"|"+(curX+1)+","+curY); //Move right
			sum += pathsWithLimits(curX,curY+1,desX,desY,limits,path+"|"+curX+","+(curY+1)); //Move down
		}
		return sum;
	}
	
	public static boolean checkLimits(int curX,int curY,int[][] limits){
		for(int i=0;i<limits.length;i++){
			if(curX == limits[i][0] && curY == limits[i][1]){
				System.out.println(limits[i][0]+" "+limits[i][1]);
				return true;
			}
		}
		return false;
	}
}
