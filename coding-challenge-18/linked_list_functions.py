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


def cast_string_list_to_integer(first_node):
    current_node = first_node
    output_string = str(safe_cast_to_int(current_node.item))
    while current_node.next_node is not None:
        current_node = current_node.next_node
        output_string += " %s" % str(safe_cast_to_int(current_node.item))
    return output_string


def safe_cast_to_int(input_string):
    try:
        return int(input_string)
    except:
        return 0
