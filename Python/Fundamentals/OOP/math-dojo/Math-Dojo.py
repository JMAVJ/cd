class MathDojo:
    def __init__(self):
        self.result = 0

    def add(self, *nums):
        sum = 0
        for num in nums:
            sum += num
        self.result += sum
        return self

    def subtract(self, *nums):
        sum = 0
        for num in nums:
            sum += num
        self.result -= sum
        return self

math = MathDojo()
x = math.add(2).add(2, 5, 1).subtract(3, 2).result
print(x)