class Node:
    def __init__(self, item, next_node=None):
        self.item = item
        self.next_node = next_node

    def print_label(self):
        if self.next_node is not None:
            return self.item + " "
        else:
            return self.item + " None"


def get_description(first_node):
    current_node = first_node
    output_string = ""
    while current_node is not None:
        output_string += current_node.print_label()
        current_node = current_node.next_node
    return output_string


def add_to_list(first_node,item_to_add):
    last_node = first_node
    while last_node.next_node is not None:
        last_node = last_node.next_node

    new_node = Node(item_to_add,None)
    last_node.next_node = new_node

