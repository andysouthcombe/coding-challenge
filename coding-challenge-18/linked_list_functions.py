class Node:
    def __init__(self, item, next_node):
        self.item = item
        self.next_node = next_node


def print_linked_list(first_node):
    current_node = first_node
    output_string = current_node.item

    while current_node.next_node is not None:
        current_node = current_node.next_node
        output_string += " %s" % current_node.item

    output_string += " None"
    return output_string

def append_string_to_list(first_node, text):
    current_node = first_node
    output_string = current_node.item

    while current_node.next_node is not None:
        current_node = current_node.next_node
        output_string += " %s" % current_node.item

    output_string += " %s None" % text
    return output_string