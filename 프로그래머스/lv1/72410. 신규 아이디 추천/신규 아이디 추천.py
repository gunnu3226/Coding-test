import re

def solution(new_id):
    new_id = new_id.lower()  #1단계
    
    new_id = re.sub(r"[^a-z0-9-_.]", "", new_id) #2단계
    
    new_id = re.sub(r"\.{2,}", ".", new_id) # 3단계
    
    while new_id[0] == '.' or new_id[-1] == '.':#4단계
        if len(new_id) == 1:
            new_id = ''
            break
        if new_id[0] == '.': 
            new_id = new_id[1:]
        if new_id[-1] == '.':
            new_id = new_id[:-1]
        
    
    if len(new_id) == 0: #5단계
        new_id += 'a'
    
    if len(new_id)>=16: #6단계
        new_id = new_id[:15]
        while new_id[-1] == '.':
            new_id = new_id[:-1]
            
    if len(new_id)<=2:
        while len(new_id)<3:
            new_id += new_id[-1]
    return new_id
