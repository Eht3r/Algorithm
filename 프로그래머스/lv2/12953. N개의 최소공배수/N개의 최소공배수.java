class Solution {
    public int solution(int[] arr) {
        if (arr.length == 1) return arr[0];
        
        int answer = (arr[0] * arr[1]) / gcd(arr[0], arr[1]);
        
        if(arr.length > 2) {
            for (int i = 2; i < arr.length; i++) {
                answer = (answer * arr[i]) / gcd(answer, arr[i]);
            }
        }
        
        return answer;
    }
    
    private static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) return b;
       else return gcd(b, r);
    }
}