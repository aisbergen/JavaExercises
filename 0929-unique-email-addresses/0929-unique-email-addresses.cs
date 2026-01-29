public class Solution {
    public int NumUniqueEmails(string[] emails) {
        var unordered = new HashSet<string>();
        int count=emails.Length;
        foreach(string email in emails){
            string local= "";
            string domain = "";

            bool in_local = true;
            bool before_plus = true;

            foreach(char c in email){
                if(c=='@'){
                    in_local = false;
                    continue;
                }

                if(in_local){
                    if(c=='+'){
                        before_plus = false;
                    }
                    
                    if(c !='.'){
                        if(before_plus){
                            local+=c;
                        }
                    }
                }else{
                    domain+=c; 
                }
            }
            
            string final_email = local + '@' + domain;
            unordered.Add(final_email);         
        }
        return unordered.Count();
    }
}