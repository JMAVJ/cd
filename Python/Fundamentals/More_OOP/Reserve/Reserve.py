from animals import Lion, Tiger

class Reserve:
    def __init__(self, name):
        self.name = name
        self.animals = {}

    def add_lion(self, name, age, mane=False):
        lion = Lion(name, age, mane)
        self.animals[lion.name] = lion
        return self

    def add_tiger(self, name, age, color='orange'):
        tiger = Tiger(name, age, color)
        self.animals[tiger.name] = tiger
        return self

    def get_animals(self):
        print(self.animals)
        return self