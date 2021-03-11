class Node():
    def __init__(self, value):
        self.value = value
        self.next = None


class Singly_Linked_List:
    def __init__(self):
        self.head = None

    def add_first(self, value):
        new_node = Node(value)
        current_head = self.head
        new_node.next = current_head
        self.head = new_node
        return self

    def push(self, value):
        new_node = Node(value)
        iterator = self.head
        while iterator.next != None:
            iterator = iterator.next
        iterator.next = new_node
        return self

    def remove_front(self):
        self.head = self.head.next
        return self

    def remove_back(self):
        pass

    def print_values(self):
        iterator = self.head
        while iterator != None:
            print(iterator.value)
            iterator = iterator.next
        return self


sl_list = Singly_Linked_List()
sl_list.add_first(1).push(2).push(
    3).print_values().remove_front().print_values()

print('')
print('Head:')
print(sl_list.head.value)
