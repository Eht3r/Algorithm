import java.util.*;

class Solution {
    class Stage {
        int number;
        double failureRate;
        
        Stage(int number, double failureRate) {
            this.number = number;
            this.failureRate = failureRate;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] count = new int[N + 2];
        
        for (int stage : stages) {
            count[stage]++;
        }
        
        List<Stage> stageList = new ArrayList<>();
        int people = stages.length;
        
        for (int i = 1; i <= N; i++) {
            double failureRate = 0;
            
            if (people != 0) {
                failureRate = (double) count[i] / people;
            }
            
            stageList.add(new Stage(i, failureRate));
            
            people -= count[i];
        }
        
        stageList.sort((a, b) -> {
            if (a.failureRate == b.failureRate) {
                return a.number - b.number;
            }
            
            return Double.compare(b.failureRate, a.failureRate);
        });
        
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).number;
        }
        
        return answer;
    }
}