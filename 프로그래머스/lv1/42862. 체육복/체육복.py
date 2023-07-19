def solution(n, lost, reserve):
    set_reserve = set(reserve)-set(lost)
    set_lost = set(lost)-set(reserve)
    
    for kind in set_reserve:
        if kind-1 in set_lost:
            set_lost.remove(kind-1)
        elif kind+1 in set_lost:
            set_lost.remove(kind+1)
            
    return n-len(set_lost)
        
            