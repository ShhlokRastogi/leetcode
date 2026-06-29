class Solution {
    public int DaysCalc(int[] weights, int capacity){
        int days=1;
        int w1=weights[0];
        for(int i=1;i<weights.length;i++){
            if((w1+weights[i])>capacity){
                days++;
                w1=weights[i];
            }else{
                w1+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = weights[0];
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (weights[i] > max) {
                max = weights[i];
            }
        }
        int low=max;
        int high=sum;
        int mid=(low+high)/2;
        int daycalc;
        int ans=mid;
        while(low<=high){
            mid=(low+high)/2;
            daycalc=DaysCalc(weights,mid);
            if(daycalc>days){
                low=mid+1;
            }else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
}
