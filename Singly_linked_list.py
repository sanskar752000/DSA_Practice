class node :
    def __init__(self, data=None):
        self.data = data
        self.next = None

class Linked_list:

    def __init__(self):
        self.head = node()

    # insertion at the end
    def ins_at_end(self, data):
        new_node = node(data)
        cur = self.head
        while cur.next!=None:
            cur = cur.next
        cur.next = new_node

    # insertion at the beginning
    def ins_at_begin(self, new_node):
        new_node.next = self.head
        self.head = new_node

    # insertion at given position
    def ins_at_pos(self, pos, newnode):
        cur_node = self.head
        cur_pos = 0
        while True:
            if cur_pos == pos:
                prev_node.next = newnode
                newnode.next = cur_node
                break
            prev_node = cur_node
            cur_node = cur_node.next
            cur_pos += 1

    # deletion from the beginning
    def del_beg(self):
        curr_node = self.head
        self.head = curr_node.next

    # deletion from the end
    def del_end(self):
        curr_node = self.head
        while(curr_node.next).next!=None:
            curr_node = curr_node.next

        temp = curr_node.next
        backup = temp
        curr_node.next = None

    # deletion from the given index
    def delete(self, index):
        if index>=self.length():
            print("Error")
            return
        cur_index = 0
        cur_node = self.head
        while True:
            last_node = cur_node
            cur_node = cur_node.next
            if cur_index == index:
                last_node.next = cur_node.next
                return
            cur_index += 1

    # getting the length of the linked list
    def length(self):
        cur = self.head
        total = 0
        while cur.next!=None:
            total+=1
            cur = cur.next
        return total

    # to get any element from the linked list
    def get(self, index):
        if index>=self.length():
            print("error")
            return None
        cur_index = 0
        cur_node = self.head
        while True:
            cur_node = cur_node.next
            if cur_index == index:
                return cur_node.data
            cur_index += 1

    # to display the linked list
    def display(self):
        elems = []
        cur_node = self.head
        while cur_node.next!=None:
            cur_node = cur_node.next
            elems.append(cur_node.data)
        print(elems)

my_list = Linked_list()
my_list.ins_at_end(1)
my_list.ins_at_end(2)
my_list.ins_at_end(3)
my_list.ins_at_end(4)
my_list.ins_at_end(5)
my_list.ins_at_end(7)

my_list.display()

print("element at 3rd index: %d" % my_list.get(3))

my_list.delete(3)
my_list.display()

print("element at 3rd index: %d" % my_list.get(3))


temp = node(6)
my_list.ins_at_pos(5, temp)
my_list.display()


my_list.del_beg()
my_list.display()


my_list.del_end()
my_list.display()

temp = node(50)
my_list.ins_at_begin(temp)
my_list.display()
