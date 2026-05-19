import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        Arrays.fill(students, 1);
        
        for (int num : lost) {
            students[num - 1]--;
        }
        
        for(int num : reserve) {
            students[num - 1]++;
        }
        
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                if (i != 0 && students[i - 1] == 2) {
                    students[i - 1]--;
                    students[i]++;
                } else if (i != students.length -1 && students[i + 1] == 2) {
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }
        
        return (int) Arrays.stream(students)
            .filter(a -> a > 0)
            .count();
    }
}