/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
*/


/*brute force*/

public class Solution {
  public int strStr(String haystack, String needle) {
    int len1 = haystack.length();
    int len2 = needle.length();
    int i,j;
    if(len1<len2) return -1;
    for(i=0;i<len1-len2+1;i++){
      for(j=0;j<len2;j++)
        if(haystack.charAt(i+j)!=needle.charAt(j)) break;
      if(j==len2) return i;
    }
    return -1;
  }
}

/*用其他函式兜的暴力解*/
class Solution {
    public int strStr(String haystack, String needle) {
        // O(N)
        // "hello","ll"
        if(needle == null || needle.isEmpty()){
            return 0;
        }
        if(haystack == null || haystack.isEmpty()){
            return -1;
        }
        
        int N = needle.length(); // 2
        for(int i = 0; i <= haystack.length() - N; i++){   //i = 0   i <=3
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i,i + N).equals(needle)){
                    return i;
                }
            } 
        }
        return -1;
    }
}



/*KMP algo*/
class Solution {
public:
    vector<int> failure;
    
    void GetFailureFunction(string& needle){
        
        failure.assign(needle.size(), -1);
        
        for(int j = 1; j < needle.size(); j++){
            int i = failure[j-1];
            
            while( (needle[j] != needle[i+1]) && (i>=0) ){
                i = failure[i];
            }
            
            if(needle[j] == needle[i+1]){
                failure[j] = i+1;
            }
        }
    }

    int KMP(string& haystack, string& needle){
        int i = 0, j = 0;
        while( i<haystack.size() && j<needle.size() ){
            if( haystack[i] == needle[j] ){
                i++; j++;
            }
            else{
                if( j == 0 )
                    i++;
                else
                    j = failure[j-1] + 1;
            }
        }
        
        if(j < needle.size())
            return -1;
        else
            return i-needle.size();
    }

    int strStr(string haystack, string needle) {
        
        GetFailureFunction(needle);
        
        return KMP(haystack,needle);
    }
};