class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int largestPile = -1;

        for(int i = 0; i < piles.length; i++){
            if (largestPile == -1 || piles[i] > piles[largestPile]) largestPile = i;
        }

        int smallestK = piles[largestPile];
        int left = 1;
        int right = piles[largestPile];
        while(left <= right){
            int middle = (left + right) / 2;

            double sum = 0;
            for(int i = 0; i < piles.length; i++){
                sum += Math.ceil((double) piles[i] / middle);
            }

            if(sum <= h){
                smallestK = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return smallestK;
    }
}
