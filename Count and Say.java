class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i=1;i < n ;i++){
            result = count(result);
        }
		return result;
    }
	
	public String count(String str){
		StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = str.charAt(0);
        //j is pointer of same number
        //ch is current number count
		for (int j=1; j<str.length(); j++){
            if(str.charAt(j) == ch){
                count++;
            }else{
                sb.append(count);
                sb.append(ch);
                ch = str.charAt(j);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(ch);
	    return sb.toString();
	}
}