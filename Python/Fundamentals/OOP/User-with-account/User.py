class Bank_Account:
    def __init__(self, interest_rate=0.01, balance=0):
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


class User:
    def __init__(self, name):
        self.name = name
        self.account = Bank_Account()

    def make_deposit(self, amount):
        self.account.deposit(amount)
        return self

    def make_withdrawal(self, amount):
        self.account.withdraw(amount)
        return self

    def display_user_balance(self):
        self.account.display_account_info()
        return self

user_1 = User('user1')
user_1.display_user_balance()