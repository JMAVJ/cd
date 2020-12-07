class User:
    def __init__(self, name):
        self.name = name
        self.balance = 0

    def make_withdrawal(self, amount):
        self.balance -= amount

    def deposit(self, amount):
        self.balance += amount

    def display_user_balance(self):
        return self.balance


user_1 = User('user_1')
user_2 = User('user_2')
user_3 = User('user_3')

user_1.deposit(100)
user_1.deposit(150)
user_1.deposit(200)
user_1.make_withdrawal(100)
print(user_1.display_user_balance())

user_2.deposit(100)
user_2.deposit(50)
user_2.make_withdrawal(50)
user_2.make_withdrawal(50)
print(user_2.display_user_balance())

user_3.deposit(1000)
user_3.make_withdrawal(100)
user_3.make_withdrawal(100)
user_3.make_withdrawal(100)
print(user_3.display_user_balance())