import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main{
	public static boolean[][] points;
	public static int mostLen = 0;
	public static int mostEnd = -1;
	
	public static void main(String args[]) throws Throwable {
		System.setIn(new FileInputStream("fyl.in"));
		Scanner scn = new Scanner(System.in);
		
		for(;;){
			int it = scn.nextInt();
			mostLen = 0;
			mostEnd = -1;
			
			if(it==0)
				break;
			
			int start = scn.nextInt()-1;
			points = new boolean[it][it];
			for(;;){
				int a = scn.nextInt()-1, b = scn.nextInt()-1;
				if(a == -1 || b == -1)
					break;
				points[a][b] = true;
			}
			
			r(start, 0);
			
			
			out.printf("The longest path from %d has length %d, finishing at %d.\n\n", start+1, mostLen, mostEnd+1);
		}
	}
	
	public static void r(int curr, int len){
		if(len > mostLen){
			mostLen = len;
			mostEnd = curr;
		}

		if(len == mostLen && curr < mostEnd)
			mostEnd = curr;

		for(int x = 0; x < points.length; x++)
			if(points[curr][x])
				r(x, len+1);
	}
}
