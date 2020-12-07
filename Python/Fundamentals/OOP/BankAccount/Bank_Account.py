class Bank_Account:
    def __init__(self, interest_rate, balance=0):
        self.interest_rate = interest_rate
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        self.balance -= amount
        return self

    def display_account_info(self):
        print(f'Balance: {int(self.balance)}')
        return self

    def yield_interest(self):
        self.balance = self.balance + self.balance*self.interest_rate
        return self

acc_1 = Bank_Account(0.01)
acc_2 = Bank_Account(0.012)

acc_1.deposit(100).deposit(100).deposit(100).withdraw(1).yield_interest().display_account_info()
acc_2.deposit(1000).deposit(500).withdraw(100).withdraw(100).withdraw(100).withdraw(100).yield_interest().display_account_info()