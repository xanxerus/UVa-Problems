import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class Main{
	public static void main(String args[]) throws Throwable {
		//~ System.setIn(new FileInputStream("fyl.in"));
		Scanner scn = new Scanner(System.in);
		
		for(;;){
			int L = scn.nextInt();
			
			if(L==0)
				break;
			
			int it = scn.nextInt();
			int[] points = new int[it+2];
			for(int x = 1; x <= it; x++)
				points[x] = scn.nextInt();
			points[it+1] = L;
			out.printf("The minimum cutting is %d.\n", dpsoln(points));
		}
	}
	
	public static int dpsoln(int[] points){
		int q = points.length;
		int[][] arr = new int[q][];
		for(int x = 1; x < q; x++)
			arr[x] = new int[x];

		//~ printm(arr);

		
		for(int r0 = 2; r0 < q; r0++){
			for(int d = 0; d < q-r0; d++){
				int min = -1;
				for(int g = 1; g < r0; g++){
					int pot = arr[r0+d][d+g] + arr[d+g][d] + points[r0+d] - points[d];
					if(min == -1 || pot < min)
						min = pot;
				}
				
				arr[r0+d][d] = min;
				//~ printm(arr);
			}
		}
		
		return arr[q-1][0];
	}
	
	public static void printm(int[][] arr){
		for(int[] row : arr)
			out.println(Arrays.toString(row));
	}
}
