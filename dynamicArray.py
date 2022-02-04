import ctypes

class DynamicArray():

    def __init__(self):
        self.n = 0
        self.capacity = 1
        self.A = self.make_Array(self.capacity)

    def make_Array(self, new_capacity):
        return (new_capacity * ctypes.py_object)

    def __append__(self, element):
        if self.n == self.capacity:
            self.__resize(2 * self.capacity)
        self.A[self.n] = element
        self.n += 1

    def __resize(self, new_capacity):
        B = self.make_Array(new_capacity)
        for k in range(self.n):
            B[k] = self.A[k]
        self.A = B
        self.capacity = new_capacity

    def __len__(self):
        return self.n

    def __getitem__(self, item):
        if not 0 <= item < self.n:
            return IndexError('item is out of bound')
        return self.A[item]