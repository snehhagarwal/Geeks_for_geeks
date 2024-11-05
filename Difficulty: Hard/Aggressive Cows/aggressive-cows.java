//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggresiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggresiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int low=0;
        int ans=0;
        int high=stalls[stalls.length-1]-stalls[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(stalls,mid,k)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static boolean possible(int[] stalls,int dist,int cows){
        int count=1;
        int last_cow=stalls[0];
        for(int i=1;i<stalls.length;i++) {
            if (stalls[i] - last_cow >= dist) {
                count++;
                last_cow = stalls[i];
            }
            if (count >= cows) {
                return true;
            }
        }
        return false;
    }
}