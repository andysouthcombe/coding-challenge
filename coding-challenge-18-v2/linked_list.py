class Node:
    def __init__(self, item, next_node=None):
        self.item = item
        self.next_node = next_node


def print_linked_list(first_node):
    return first_node.item + " " + str(first_node.next_node)
