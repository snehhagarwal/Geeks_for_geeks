//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        int i=0;
        String ans="";
        Stack<Character> st=new Stack<>();
        while(i<s.length()){
            if((s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                ans=ans+s.charAt(i);
            }
            else if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans=ans+st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && prec(s.charAt(i))<=prec(st.peek())){
                    ans=ans+st.pop();
                }
                st.push(s.charAt(i));
            }
            i++;
        }
        while(!st.isEmpty()){
            ans=ans+st.pop();
        }
        return ans;
    }
    
    public static int prec(char ch){
        switch(ch){
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
        
    }
}