##sample comment added

##sample comment added

class point:
    def __init__(self,x=0,y=0):
        self.x = x
        self.y = y
    def print(self):
        print(self.x,self.y)
    def __str__(self):
        return(str(self.x)+" "+str(self.y))