class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
         int answer = -1;
            int minimumDistance = Integer.MAX_VALUE;
            for (int i = 0; i < drones.length; i++) {
                int distance = Math.abs( drones[i][0] - target[0])
                              + Math.abs( drones[i][1] - target[1]);  
                if (distance <= drones[i][2] && distance < minimumDistance) {
                    minimumDistance = distance;
                    answer = i;
                }
            }
            return answer;
    }
}