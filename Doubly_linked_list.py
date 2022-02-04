class node():

    def __init__(self, data = None, next=None, previous=None):
        self.data = data
        self.next = next
        self.previous = previous

class Doubly_linked_list():

    def __init__(self):
        self.head = node()

    def insert_at_end(self, data):
        newnode = node(data)
        curr_node = self.head
        while curr_node.next != None:
            curr_node = curr_node.next
        curr_node.next = newnode
        newnode.previous = curr_node

    def insert_at_beg(self, data):
        curr_node = self.head
        newnode = node(data)
        newnode.next = curr_node
        curr_node.previous = newnode
        newnode.previous = None
        self.head = newnode

    def display(self):
        ele = []
        curr_node = self.head
        while curr_node is not None:
             ele.append(curr_node.data)
             curr_node = curr_node.next
        print(ele)

    def length(self):
        curr_node = self.head
        total = 0
        while curr_node.next != None:
            total += 1
            curr_node = curr_node.next
        return total

    def __getitem__(self, index):
        if index >= self.length():
            IndexError("Index is out of range")
        curr_index = 0
        curr_node = self.head
        while True:
            curr_node = curr_node.next
            if curr_index == index:
                print(curr_node.data)
                break
            curr_index += 1



my_list = Doubly_linked_list()
my_list.insert_at_end(10)
my_list.insert_at_end(20)
my_list.insert_at_end(30)
my_list.insert_at_end(40)
my_list.insert_at_end(50)

my_list.display()

my_list.__getitem__(2)

# my_list.insert_at_beg(500)
# my_list.display()

my_list.__getitem__(0)

my_list.insert_at_beg(1)
my_list.display()

my_list.__getitem__(0)

