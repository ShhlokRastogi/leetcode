class Solution {

    public int maxScore(int[] cardPoints, int k) {

        int sum = 0;
        int total_sum = 0;

        for(int i = 0; i < cardPoints.length-k; i++){
            sum += cardPoints[i];
        }

        for(int i = 0; i < cardPoints.length; i++){
            total_sum += cardPoints[i];
        }

        int minsum = Integer.MAX_VALUE;
        int left = 0;

        for(int right = cardPoints.length-k; right < cardPoints.length; right++){

            minsum = Math.min(minsum, sum);

            sum -= cardPoints[left];
            sum += cardPoints[right];
            left++;
        }

        minsum = Math.min(minsum, sum);
        return total_sum - minsum;
    }
}
