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
