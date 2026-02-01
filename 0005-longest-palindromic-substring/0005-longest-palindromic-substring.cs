public class Solution {
    public string LongestPalindrome(string s) {
        string result = "";
        for (int i=0; i<s.Length; i++){
            string odd  = Expand(s, i - 1, i + 1);  
            string even = Expand(s, i, i + 1);   
            if(odd.Length > result.Length){
                result = odd;
            }
            if(even.Length > result.Length){
                result = even;
            } 
        }
        return result;
    }
    public string Expand(string s, int l, int r){
            //returns palindrome string
            while(l >=0 && r<s.Length && s[l] == s[r]){
                l--;
                r++;
            }
            return s.Substring(l+1, r-l-1);
        }
        
}
