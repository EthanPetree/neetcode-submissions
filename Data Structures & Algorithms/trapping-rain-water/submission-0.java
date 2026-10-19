class Solution {
    public int trap(int[] height) {
        int[] prefixMax = new int[height.length];
        int maxLeft = 0;
        prefixMax[0] = maxLeft;
        for(int i = 1; i < height.length; i++){
            if (height[i - 1] > maxLeft) maxLeft = height[i - 1];
            prefixMax[i] = maxLeft;
        }

        int[] suffixMax = new int[height.length];
        int maxRight = 0;
        suffixMax[height.length - 1] = maxRight;
        for(int i = height.length - 2; i >= 0; i--){
            if(height[i + 1] > maxRight) maxRight = height[i + 1];
            suffixMax[i] = maxRight;
        }

        int totalWater = 0;

        for(int i = 0; i < height.length; i++){
            int water = Math.min(prefixMax[i], suffixMax[i]) - height[i];
            if(water > 0) totalWater += water;
        }

        return totalWater;
    }
}
