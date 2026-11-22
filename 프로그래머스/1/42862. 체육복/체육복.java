import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] uniforms = new int[n];
        Arrays.fill(uniforms, 1);
        
        for (int student : lost) {
            uniforms[student - 1]--;
        }
        
        for(int student : reserve) {
            uniforms[student - 1]++;
        }
        
        for (int i = 0; i < n; i++) {
           if (uniforms[i] != 0) {
               continue;
           }
            
            if (canBorrowFromLeft(uniforms, i)) {
                uniforms[i - 1]--;
                uniforms[i]++;
            } else if (canBorrowFromRight(uniforms, i)) {
                uniforms[i + 1]--;
                uniforms[i]++;
            }
        }
        
        return countAttendableStudents(uniforms);
    }
    
    private boolean canBorrowFromLeft(int[] uniforms, int index) {
        return index > 0 && uniforms[index - 1] == 2;
    }
    
    private boolean canBorrowFromRight(int[] uniforms, int index) {
        return index < uniforms.length - 1 && uniforms[index + 1] == 2;
    }
    
    private int countAttendableStudents(int[] uniforms) {
        return (int) Arrays.stream(uniforms)
            .filter(uniform -> uniform > 0)
            .count();
    }
}