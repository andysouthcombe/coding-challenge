import unittest
from staticData import ShopData
from visitAllShops import find_next_shop


class VisitAllShopsTests(unittest.TestCase):

    def test_find_next_branch_returns_next_shop_with_one_branch(self):
        self.assertEqual(find_next_shop(ShopData.jl_head_office, [ShopData.peter_jones]), ShopData.peter_jones)
