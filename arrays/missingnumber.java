package arrays;
import java.util.*;

public class missingnumber {
    //brute force worst case only for  [1, 2, 4, 5] N=5 or [2, 3, 5, 6]  time complexity -> O(N*N) sc -> O(1)
    int missingNum(int arr[]) {
        for (int i = 1; i<=arr.length; i++){
            int flag = 0;
            for(int j = 0; j<arr.length-1; j++){
                if(arr[j]==i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return -1;
    }

    //better approach hashing time complexity -> O(N)+O(N) sc -> O(N)
    int missingNumhash(int arr[]){
        int n = arr.length;
        boolean[] hash = new boolean[n+1];
        for(int num : arr){
            hash[num] = true;
        }
        for(int i = 0 ; i<=n; i++){
            if(!hash[i]){
                return i;
            }
        }
        return -1;
    }


    //optimal approach this question have two optimal approach 
    //-----> SUM time complexity -> O(N) sc -> O(1)
    int missingnumsum(int arr[]){
        int n = arr.length;
        int sum = n*(n+1)/2;
        int sum2 = 0;
        for(int num : arr){
            sum2 += num;
        }
        return sum - sum2;
    }



    // -------> XOR time complexity -> O(N) sc -> O(1) its more optimal than sum
    int missingnumxor(int arr[]){
        int n = arr.length;
        int xor1= 0, xor2 = 0;
        for(int i = 0 ; i< n ; i++){
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i+1);
        }
        return xor1 ^ xor2;
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5};
    }
}
