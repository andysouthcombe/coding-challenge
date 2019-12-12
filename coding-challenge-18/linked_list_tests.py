import unittest
from linked_list_functions import *


class PrintLinkedListTests(unittest.TestCase):
    def test_print_text_of_single_node_list(self):
        node = Node("hello", None)
        self.assertEqual(print_linked_list(node), "hello None")

    def test_print_text_of_two_node_list(self):
        secondNode = Node("world", None)
        node = Node("hello", secondNode)
        self.assertEqual(print_linked_list(node), "hello world None")

    def test_print_text_of_three_node_list(self):
        third_node = Node("three", None)
        secondNode = Node("two", third_node)
        node = Node("one", secondNode)
        self.assertEqual(print_linked_list(node), "one two three None")

    def test_appending_text_to_list(self):
        third_node = Node("three", None)
        secondNode = Node("two", third_node)
        node = Node("one", secondNode)
        self.assertEqual(append_string_to_list(node, "!"), "one two three ! None")

    def test_reverse_list_of_strings(self):
        third_node = Node("three", None)
        secondNode = Node("two", third_node)
        node = Node("one", secondNode)
        self.assertEqual(print_linked_list_reverse(node), "three two one None")

    def test_cast_string_list_to_integer(self):
        third_node = Node("3", None)
        secondNode = Node("z", third_node)
        node = Node("17", secondNode)
        self.assertEqual(cast_string_list_to_integer(node), "17 0 3")

    def test_safe_cast_to_int(self):
        self.assertEqual(safe_cast_to_int("1"), 1)
        self.assertEqual(safe_cast_to_int("abc"), 0)
