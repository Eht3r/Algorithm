class Solution {
    public String solution(String s) {      
        s = s.toLowerCase();
        
        char[] arr = s.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] ==  ' ' && Character.isLetter(arr[i])) {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }
        
        return new String(arr);
    }
}