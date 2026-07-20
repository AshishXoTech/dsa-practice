package arrays;

public class missingnumber {
    //brute force worst case only for  [1, 2, 4, 5] N=5 or [2, 3, 5, 6]
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
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5};
    }
}
