import java.util.*;

class Solution {
    public int solution(String dirs) {
        HashSet<String> visitedPaths = new HashSet<>();
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int nx = x;
            int ny = y;
            
            if (dir == 'U') ny++;
            else if (dir == 'D') ny--;
            else if (dir == 'L') nx--;
            else if(dir == 'R') nx++;
            
            if (nx < -5|| nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            
            String path1 = x + "" + y  + "" + nx + "" + ny;
            String path2 = nx + "" + ny + "" + x + "" + y;
            
            visitedPaths.add(path1);
            visitedPaths.add(path2);
            
            x = nx;
            y = ny;
        }
        
        return visitedPaths.size() / 2;
    }
}