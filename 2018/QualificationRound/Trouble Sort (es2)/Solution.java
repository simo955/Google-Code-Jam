import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numTest = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= numTest; i++) {
			int size = in.nextInt();
			int[] list = new int[size];
			for (int y = 0; y < size; y++) {
				list[y] = in.nextInt();
			}
			list = sorting(list);
			int check = checkList(list);
			if (check == -1 ) {
				System.out.println("Case #" + i + ": OK");
			}
			else {
				System.out.println("Case #" + i + ": " + check);
			}
		}
	}

	private static int[] sorting(int[] list) {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int y = 0; y < list.length-2; y++) {
				if (list[y] > list[y+2]) {
					list = swap(list, y);
					flag = true;
				}
			}
		}
		return list;
	}

	private static int[] swap(int[] list, int y) {
		int aux = list[y];
		list[y] = list[y+2];
		list[y+2] = aux;
		return list;
	}

	private static int checkList(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i+1]) return i;
		}
		return -1;
	}
}
