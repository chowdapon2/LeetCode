/*
Write a function to find the longest common prefix string amongst an array of strings.
*/


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0)   return "";            
        StringBuilder lcp=new StringBuilder(strs[0]);
		//用第一個字串當標地, LCP再長也不會比第一個長
        for(int i =1; i<strs.length;i++){
            while(!strs[i].startsWith(lcp.toString())){
			  //比較每個字串, 如果沒有startWith 就將LCP少一個字元, 直到有相同, for迴圈才會繼續
              lcp.deleteCharAt(lcp.length()-1);  
            } 
            
        }
        return lcp.toString();
    }
}


//-----------------------------------------------------------------------------------
// 9mm的答案
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String pre = strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0, pre.length()-1);
            }
        }
        
        return pre;
    }
}