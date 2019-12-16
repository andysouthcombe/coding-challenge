class Node:
    def __init__(self, item, next_node=None):
        self.item = item
        self.next_node = next_node

    def __eq__(self, other):
        if not isinstance(other, Node):
            return NotImplemented

        return self.item == other.item and self.next_node == other.next_node

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


def add_to_list(first_node, item_to_add):
    last_node = first_node
    while last_node.next_node is not None:
        last_node = last_node.next_node

    new_node = Node(item_to_add, None)
    last_node.next_node = new_node


def convert_string_list_to_int_list(input_node):
    if input_node.next_node is not None:
        return Node(safe_cast_str_to_int(input_node.item), convert_string_list_to_int_list(input_node.next_node))
    else:
        return Node(safe_cast_str_to_int(input_node.item))


def safe_cast_str_to_int(value):
    try:
        return int(value)
    except:
        return int(0)
