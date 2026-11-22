import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> list1 = createList(str1);
        List<String> list2 = createList(str2);
        
        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }
        
        int interSectionSize = 0;
        int totalSize = list1.size() + list2.size();
        
        for (String s : list1) {
            if (list2.remove(s)) {
                interSectionSize++;
            }
        }
        
        int unionSize = totalSize - interSectionSize;
        
        double jaccard = (double) interSectionSize / unionSize;
        return (int) (jaccard * 65536);
    }
    
    public List<String> createList(String str) {
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            
            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                list.add(str.substring(i, i+2));
            }
        }
        
        return list;
    }
}