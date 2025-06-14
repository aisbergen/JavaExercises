class Solution {
    public int compress(char[] chars) {
        int k = 0;//write pointer
        int i = 0;//read
        int n=chars.length;
        if(chars.length==0 || chars==null){
            return 0;
        }
        while(i < n){
            char currentChar=chars[i];
            int count=0;
            String s;
            int j = i; // Start looking ahead from the current position
            while (j < n && chars[j] == currentChar) {
                count++; // Increment count as long as the character is the same
                j++;     // Move to the next character
            }
        

            chars[k]=currentChar;
            k++;

            if(count>1){
                String countStr = String.valueOf(count); // Convert integer count to its String representation

                for(char digitChar : countStr.toCharArray()){
                    chars[k]=digitChar;
                    k++;
                }
            }
            i=j;
        }

        return k;

    }
}