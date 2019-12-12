class Node:
    def __init__(self, item, next_node):
        self.item = item
        self.next_node = next_node


def iterate_through_list(first_node, reverse=False):
    current_node = first_node
    output_string = current_node.item
    while current_node.next_node is not None:
        current_node = current_node.next_node
        if reverse:
            output_string = current_node.item + " " + output_string
        else:
            output_string += " %s" % current_node.item
    return output_string


def print_linked_list(first_node):
    return iterate_through_list(first_node) + " None"


def append_string_to_list(first_node, text):
    return iterate_through_list(first_node) + " %s None" % text


def print_linked_list_reverse(first_node):
    return iterate_through_list(first_node, True) + " None"
