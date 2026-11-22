import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        
        for (String record : records) {
            String[] parts = record.split(" ");
            
             String[] timeArr = parts[0].split(":");
             int time = Integer.parseInt(timeArr[0]) * 60
                      + Integer.parseInt(timeArr[1]);
            
            String carNumber = parts[1];
            String type = parts[2];
            
            if (type.equals("IN")) {
                inTime.put(carNumber, time);
            } else {
                int start = inTime.get(carNumber);
                int parkingTime = time - start;
                
                totalTime.put(
                    carNumber, 
                    totalTime.getOrDefault(carNumber, 0) + parkingTime
                );
                inTime.remove(carNumber);
            }
        }
        
        int endTime = 23 * 60 + 59;
        
        for (String carNumber : inTime.keySet()) {
            int start = inTime.get(carNumber);
            int parkingTime = endTime - start;
            
            totalTime.put(
                carNumber, 
                totalTime.getOrDefault(carNumber, 0) + parkingTime
            );
        }
        
        List<String> carNumbers = new ArrayList<>(totalTime.keySet());
        Collections.sort(carNumbers);

        int[] answer = new int[carNumbers.size()];

        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            answer[i] = calculateFee(fees, totalTime.get(carNumber));
        }

        return answer;
    }
    
    private int calculateFee(int[] fees, int totalTime) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if (totalTime <= baseTime) {
            return baseFee;
        }

        int extraTime = totalTime - baseTime;
        int extraUnit = (int) Math.ceil((double) extraTime / unitTime);
        
        return baseFee + extraUnit * unitFee;
    }
}