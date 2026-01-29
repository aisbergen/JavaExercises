public class Solution {
    public char FindTheDifference(string s, string t) {
        var count = new Dictionary<char, int>();
        foreach(char b in s){
           if (count.ContainsKey(b)){
            count[b]++;
           }else{
            count[b]=1;
           }
        }
        foreach(char b in t ){
            if(!count.ContainsKey(b) || count[b] == 0){
                return b;

            }count[b]--;
        }
        return ' ';
    }
}