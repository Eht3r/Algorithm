def solution(a, b):
    low = min(a, b)
    high = max(a, b)
    
    return (low + high) * (high - low + 1) // 2