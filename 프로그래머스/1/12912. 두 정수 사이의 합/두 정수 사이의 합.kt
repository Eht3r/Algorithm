class Solution {
    fun solution(a: Int, b: Int): Long {
        val min = minOf(a, b).toLong()
        val max = maxOf(a, b).toLong()
        
        return (max + min) * (max - min + 1) / 2
    }
}