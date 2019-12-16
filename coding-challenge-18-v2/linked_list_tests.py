import unittest
from linked_list import *


class NodeUnitTests(unittest.TestCase):
    def test_can_create_node(self):
        first_node = Node("Hello")
        self.assertEqual(first_node.item, "Hello")
        self.assertEqual(first_node.next_node, None)
