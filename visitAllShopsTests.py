import unittest
from staticData import ShopData
from visitAllShops import find_next_shop
from visitAllShops import load_shop_string_to_list


class FindNextBranchTests(unittest.TestCase):

    def test_find_next_branch_returns_next_shop_with_one_branch(self):
        self.assertEqual(find_next_shop(ShopData.jl_head_office, [ShopData.peter_jones])[0].name, "Peter Jones")

    def test_find_next_branch_returns_nearest_shop_with_two_branches_to_visit(self):
        two_branch_list = [ShopData.abergavenny, ShopData.brent_cross]
        self.assertEqual(find_next_shop(ShopData.jl_head_office, two_branch_list)[0].name, "Brent Cross")

class LoadShopStringToListTests(unittest.TestCase):
    def test_(self):
        list_of_shops = load_shop_string_to_list(ShopData.sample_input_string)
        self.assertEqual(list_of_shops[0].name, "Abergavenny")
        self.assertEqual(list_of_shops[1].postcode, "NP7 9LL")
        self.assertEqual(list_of_shops[2].longitude, "-1.279705")
        self.assertEqual(list_of_shops[3].latitude, "51.370886")
