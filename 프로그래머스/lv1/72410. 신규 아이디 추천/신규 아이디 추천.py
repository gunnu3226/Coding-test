import re

def solution(new_id):
    new = new_id
    #1단계
    new = new.lower()
    #2단계
    new = re.sub('[^a-z0-9-_.]','',new)
    #3단계
    new = re.sub('\.+','.',new)
    #4단계
    new = re.sub('^[.]|[.]$','',new)
    #5단계,6단계
    new = 'a' if len(new)==0 else new[:15]
    new = re.sub('^[.]|[.]$','',new)
    #7단계
    while len(new) <=2:
        new += new[-1]
    return new