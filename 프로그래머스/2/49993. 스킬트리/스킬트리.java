class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            String result = tree.replaceAll("[^" + skill + "]", "");
            
            if (skill.indexOf(result) == 0) {
                answer++;
            }
            
        }
        
        return answer;
    }
}