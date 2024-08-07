//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        int i=0;
        Stack<String> st=new Stack<>();
        while(i<post_exp.length()){
            char ch=post_exp.charAt(i); 
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                st.push(ch+"");
            }
            else{
                String t1=st.pop();
                String t2=st.pop();
                st.push(ch+t2+t1);
            }
            i++;
        }
        return st.peek();
    }
}
