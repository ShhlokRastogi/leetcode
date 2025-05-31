class Solution(object):
    def lengthOfLongestSubstring(self, s):
        l=len(s)
        snew=""
        x=""
        for i in range(0,l):
            t=s[i]
            if t not in snew:
                snew=snew+t
            else:
                if len(x)<len(snew):
                    x=snew
                snew = snew[snew.index(t) + 1:] + t
        if len(x)<len(snew):
            x=snew
        return len(x)
        
