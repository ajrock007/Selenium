package check;

import org.testng.annotations.Test;

public class TwoD {
	
	@Test
	public void hourglassSum()  {
		int[][] arr ={ 
			{1, 1, 1, 0, 0, 0},
			{0, 1, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0},
			{0, 9, 2, -4, -4, 0},
			{0, 0, 0, -2, 0, 0},
			{0, 0, -1, -2, -4, 0}
		};
        int[] sum = new int[16];
        int k=0;
        for(int i=0;i<=arr[0].length/2;i++){
            for(int j=0;j<=arr.length/2;j++){
                int first= arr[i][j]+arr[i][j+1]+arr[i][j+2];
                int middle=arr[i+1][j+1];
                int last=arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                sum[k]=first+middle+last;
                System.out.println(sum[k]);
                k++;
                
            }
        }
        int max = sum[0];
        for(int m=1;m<sum.length;m++){
            if(sum[m]>max){
                max=sum[m];
            }
        }
        System.out.println(max);
	}
}
