import unittest
from staticData import ShopData
from visitAllShops import find_next_shop


class FindNextBranchTests(unittest.TestCase):

    def test_find_next_branch_returns_next_shop_with_one_branch(self):
        self.assertEqual(find_next_shop(ShopData.jl_head_office, [ShopData.peter_jones])[0], "Peter Jones")

    def test_find_next_branch_returns_nearest_shop_with_two_branches_to_visit(self):
        two_branch_list = [ShopData.abergavenny,ShopData.brent_cross]
        self.assertEqual(find_next_shop(ShopData.jl_head_office, two_branch_list)[0], "Brent Cross")

