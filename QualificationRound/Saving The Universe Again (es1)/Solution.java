import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; i++) {
			int capacity = in.nextInt();
			String moves = in.next();
			char[] arrayMoves = moves.toCharArray();
			int movesCount = 0;
			for (int y = arrayMoves.length-1 ; y >= 1; y-- ) {
				if (evaluateDamage(arrayMoves) <= capacity) break; 
				if (arrayMoves[y] == 'S' && arrayMoves[y-1] == 'C') {  // check
					arrayMoves = swap(arrayMoves, y);
					movesCount ++;
					int z = y;
					boolean flag=false;
					while (z < arrayMoves.length-1 && arrayMoves[z+1] == 'S') {
						if (evaluateDamage(arrayMoves) <= capacity) {
							flag=true;
							break; 
						}
						arrayMoves = swap(arrayMoves, z+1);
						movesCount ++;
						z++;
					}
					if(flag) break;
				}
			}
			if (evaluateDamage(arrayMoves) > capacity) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");  
			} 
			else {
				System.out.println("Case #" + i + ": " +  movesCount);  
			}
		}
	}
	
	private static int evaluateDamage(char[] arrayMoves) {
		int power = 1;
		int totalDamage = 0;
		for (char c : arrayMoves) {
			if (c == 'C') power = power * 2;
			else totalDamage = totalDamage + power;
		}
		return totalDamage;
	}
	
	private static char[] swap(char[] arrayMoves, int y) {
		char aux = arrayMoves[y];
		arrayMoves[y] = arrayMoves[y-1];
		arrayMoves[y-1] = aux;
		return arrayMoves;
	}
}


