#BATCH GRADIENT DESCENT
from statistics import mean
def gradW1(x1,x2,y,w1,w2): 
    w1_new= -2*(y-(w1*x1+w2*x2))*x1 
    return w1_new
def gradW2(x1,x2,y,w1,w2): 
    w2_new= -2*(y-(w1*x1+w2*x2))*x2 
    return w2_new
 
x1=[0,2,1,-2] 
x2=[1,1,0,1] 
y=[1,9,1,7] 
w1=1 
w2=3 
mean_w1=[]#stores updated  w1 and w2 after every epoch .
mean_w2=[]

for epoch in range(25):
    arr_err1=[] #stores doe "E" by doe w1 for every data point
    arr_err2=[] #stores doe "E" by doe w2 for every data point
    print("EPOCH",epoch)
    print("W1=",w1,"\t w2=",w2)
    print()
    for a,b,c in zip(x1,x2,y): 
        arr_err1.append(gradW1(a,b,c,w1,w2))
        arr_err2.append(gradW2(a,b,c,w1,w2))
    
    w1=w1-0.01*(mean(arr_err1))
    mean_w1.append(w1)
    w2=w2-0.01*(mean(arr_err2))
    mean_w2.append(w2)
    
