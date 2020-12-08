class Animal:
    def __init__(self, name, age, health=100, happiness=100, hunger=0):
        self.name = name
        self.health = health
        self.happiness = happiness
        self.hunger = hunger
        self.age = age

    def feed(self):
        self.health += 2
        self.hunger -= 2
        self.happiness += 2
        return self

    def __str__(self):
        return str(self.__dict__)


class Lion(Animal):
    def __init__(self, name, age, mane=False, health=100, happiness=100, hunger=0):
        super().__init__(name, age, health=100, happiness=100, hunger=0)
        self.mane = mane
    
    def feed(self):
        if self.hunger == 0:
            print('The Lion is not hungry')
            return self
        self.health += 1
        self.hunger -= 1
        self.happiness += 1
        return self


class Tiger(Animal):
    def __init__(self, name, age, color='orange', health=100, happiness=100, hunger=0):
        super().__init__(name, age, health=100, happiness=100, hunger=0)
        self.color = color

    def feed(self):
        if self.hunger == 0:
            print('The Tiger is not hungry')
            return self

        self.health += 4
        self.hunger -= 4
        self.happiness += 4
        
        return self
