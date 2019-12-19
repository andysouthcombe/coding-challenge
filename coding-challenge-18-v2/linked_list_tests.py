import unittest
from linked_list import *


class NodeUnitTests(unittest.TestCase):
    def test_can_create_node(self):
        first_node = Node("Hello")
        self.assertEqual(first_node.item, "Hello")
        self.assertEqual(first_node.next_node, None)

    def test_can_print_one_node(self):
        first_node = Node("Hello")
        self.assertEqual(get_description(first_node), "Hello None")

    def test_can_print_two_nodes(self):
        second_node = Node("World")
        first_node = Node("Hello", second_node)
        self.assertEqual(get_description(first_node), "Hello World None")

    def test_add_node_to_two_node_list(self):
        second_node = Node("World")
        first_node = Node("Hello", second_node)
        add_to_list(first_node, "!")
        self.assertEqual(get_description(first_node), "Hello World ! None")

    def test_add_node_to_one_node_list(self):
        first_node = Node("Hello")
        add_to_list(first_node, "!")
        self.assertEqual(get_description(first_node), "Hello ! None")

    def test_convert_single_node_list_to_integer_list(self):
        first_node = Node("1")
        int_first_node = convert_string_list_to_int_list(first_node)
        self.assertEqual(int_first_node.item, int(1))

    def test_convert_single_invalid_node_to_integer_list(self):
        first_node = Node("abc")
        int_first_node = convert_string_list_to_int_list(first_node)
        self.assertEqual(int_first_node.item, int(0))

    def test_convert_string_list_to_int_list(self):
        third_node = Node("3")
        second_node = Node("abc", third_node)
        first_node = Node("27", second_node)
        int_node_list = convert_string_list_to_int_list(first_node)
        expected_int_list = Node(27, Node(0, Node(3)))
        self.assertEqual(int_node_list, expected_int_list)

    def test_reverse_two_node_list(self):
        third_node = Node("!")
        second_node = Node("World", third_node)
        expected_reversed_list = Node("!",Node("World"))
        print(get_description(reverse(second_node)))
        print(get_description(expected_reversed_list))
        self.assertEqual(expected_reversed_list, reverse(second_node))

    def test_reverse_three_node_list(self):
        third_node = Node("!")
        second_node = Node("World", third_node)
        first_node = Node("Hello", second_node)
        expected_reversed_list = Node("!", Node("World", Node("Hello")))
        print(get_description(reverse(first_node)))
        print(get_description(expected_reversed_list))
        self.assertEqual(expected_reversed_list, reverse(first_node))


