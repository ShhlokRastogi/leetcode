class Solution {
    double pow(double x,int n){
        if (n == 0) {
            return 1;
        }
        else if(n==1){
            return x;
        }
        else if(n%2==0){
            return pow(x*x,n/2);
        }else{
            return x* pow(x*x,n/2);
        }
    }
    public double myPow(double x, int n) {
        if(n<0){
            x=(1/x);
        }
        return pow(x,n);
    }
}
