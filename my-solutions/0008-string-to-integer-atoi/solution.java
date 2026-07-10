class Solution {
    public int myAtoi(String s) {
        int MAX_VALUE = 2147483647;
        int MIN_VALUE = -2147483648;
        int len = s.length();
        int number = 0;
        int sign = 1;
        boolean flag=false;
        boolean signflag=false;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                flag=true;
                int digit = ch - '0';
                if (number > MAX_VALUE / 10 || (number == MAX_VALUE / 10 && digit > 7)) {
                    if (sign == 1)
                    return MAX_VALUE;
                    else
                    return MIN_VALUE;
                }else{
                    number = number * 10 + digit;
                }
            } else if (ch == ' ') {
                if(flag==true) break;
                if(signflag==true) break;
                continue;
            } else if (ch == '-') {
                if(flag==true) break;
                if(signflag==true) break;
                sign = -1;
                signflag=true;
            }else if(ch=='+'){
                if(flag==true) break;
                if(signflag==true) break;
                sign = 1;
                signflag=true;
            }else {
                return number*sign;
            }
        }

        return number * sign;
    }
}
