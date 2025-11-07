class Solution {
    public int romanToInt(String s) {
        int[] num=new int [s.length()];
        for(int i=0;i<=s.length()-1;i++){
                   char x=s.charAt(i);
                   if(x=='I'){
                    num[i]=1;
                   }
                   else if(x=='V'){
                    num[i]=5;
                   }
                    else if(x=='X'){
                    num[i]=10;
                   }
                   else if(x=='L'){
                    num[i]=50;
                   }
                   else if(x=='C'){
                    num[i]=100;
                   }
                 else if(x=='D'){
                    num[i]=500;
                   }
                else{
                    num[i]=1000;
                }
        }
        int sum=0;
        boolean flag=false;
        for(int i=s.length()-1;i>0;){
           if(num[i-1]<num[i]){
                sum+=num[i]-num[i-1];
                if((i-1)==0)flag=true;
                i-=2;
            }
            else{
            sum+=num[i];
            i--;
            }
        }
        if (flag==false){
            sum+=num[0];
        }
        return sum;
    }
}
