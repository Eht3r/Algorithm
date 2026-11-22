import java.util.*;

class Solution {
    class Stage {
        final int number;
        final double failureRate;
        
        Stage(int number, double failureRate) {
            this.number = number;
            this.failureRate = failureRate;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] stageCounts = countStages(N, stages);
        List<Stage> stageList = createStageList(N, stages.length, stageCounts);
        
        stageList.sort(
            Comparator
                .comparingDouble((Stage stage) -> stage.failureRate)
                .reversed()
                .thenComparingInt(stage -> stage.number)
        );
        
        return stageList.stream()
            .mapToInt(stage -> stage.number)
            .toArray();
    }
    
    private int[] countStages(int N, int[] stages) {
        int[] counts = new int[N + 2];
        
        for (int stage : stages) {
            counts[stage]++;
        }
        
        return counts;
    }
    
    private List<Stage> createStageList(int N, int totalPeople, int[] stageCounts) {
        List<Stage> stageList = new ArrayList<>();
        int reachedPeople = totalPeople;
        
        for (int stageNumber = 1; stageNumber <= N; stageNumber++) {
            double failureRate = calculateFailureRate(stageCounts[stageNumber], reachedPeople);
            
            stageList.add(new Stage(stageNumber, failureRate));
    
            reachedPeople -= stageCounts[stageNumber];
        }
        
        return stageList;
    }
    
    private double calculateFailureRate(int failedPeople, int reachedPeople) {
        if (reachedPeople == 0) {
            return 0;
        }
        
        return (double) failedPeople / reachedPeople;
    }
}