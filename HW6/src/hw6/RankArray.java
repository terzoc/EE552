package hw6;

import java.util.Arrays;

public class RankArray {
	
	static public int[] arrayRankTransform(int[] arr) {
		int[] sortedArr = arr.clone();
		Arrays.sort(sortedArr);
		
		int[] ranks = new int[arr.length]; 
		Arrays.fill(ranks, -1);
		
		int rank = 1;
		for(int i =0; i < sortedArr.length; i++) {
			if(i==0 || sortedArr[i] != sortedArr[i-1]) {
				for(int j = 0; j < arr.length; j++) {
					if(arr[j] == sortedArr[i] && ranks[j] == -1) {
						ranks[j] = rank;
					}
				}
				rank++;
			}
		}
		return ranks;
	}

	public static void main(String[] args) {
		int[] arr =  {40,10,20,30};
		int[] arr2 =  {100,100,100};
		int[] arr3 =  {37,12,28,9,100,56,80,5,12};
		int[] rank1 = arrayRankTransform(arr);
		int[] rank2 = arrayRankTransform(arr2);
		int[] rank3 = arrayRankTransform(arr3);
		
		System.out.println("Original: " + Arrays.toString(arr) + " Ranked: " + Arrays.toString(rank1));
		System.out.println();
		System.out.println("Original: " + Arrays.toString(arr2) + " Ranked: " + Arrays.toString(rank2));
		System.out.println();
		System.out.println("Original: " + Arrays.toString(arr3) + " Ranked: " + Arrays.toString(rank3));
	}

}
