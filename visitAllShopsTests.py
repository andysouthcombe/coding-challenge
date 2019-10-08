import unittest
from staticData import ShopData
from visitAllShops import find_next_shop
from visitAllShops import load_shop_string_to_list
from visitAllShops import visit_all_shops
from staticData import Parameters
from visitAllShops import calculate_journey_time_in_seconds
import exceptions
from visitAllShops import add_on_journey_time


class FindNextBranchTests(unittest.TestCase):

    def test_find_next_branch_returns_next_shop_with_one_branch(self):
        self.assertEqual(find_next_shop(ShopData.jl_head_office, [ShopData.peter_jones])[0].name, "Peter Jones")

    def test_find_next_branch_returns_nearest_shop_with_two_branches_to_visit(self):
        two_branch_list = [ShopData.abergavenny, ShopData.brent_cross]
        self.assertEqual(find_next_shop(ShopData.jl_head_office, two_branch_list)[0].name, "Brent Cross")

    def test_throws_exception_if_next_shop_unreachable(self):
        with self.assertRaises(exceptions.NextShopTooFar):
            find_next_shop(ShopData.jl_exeter, [ShopData.jl_aberdeen])


class LoadShopStringToListTests(unittest.TestCase):
    def test_load_shop_data(self):
        list_of_shops = load_shop_string_to_list(ShopData.sample_input_string)
        self.assertEqual(list_of_shops[0].name, "Abergavenny")
        self.assertEqual(list_of_shops[1].postcode, "NP7 9LL")
        self.assertEqual(list_of_shops[2].longitude, "-1.279705")
        self.assertEqual(list_of_shops[3].latitude, "51.370886")


class VisitAllShopsTest(unittest.TestCase):
    def test_records_starting_journey(self):
        returned_list = visit_all_shops(ShopData.jl_head_office.to_string())
        self.assertEqual(returned_list[0].start_location.name, ShopData.jl_head_office.name)
        self.assertEqual(returned_list[0].start_time, 0)
        self.assertEqual(returned_list[0].arrival_location.name, ShopData.jl_head_office.name)
        self.assertEqual(returned_list[0].arrival_time, Parameters.visit_length_in_seconds)
        self.assertEqual(returned_list[0].journey_distance, 0)


class CalculateJourneyTimeTests(unittest.TestCase):
    def test_calculate_journey_times(self):
        self.assertEqual(calculate_journey_time_in_seconds(30), Parameters.one_hour_in_seconds)
        self.assertEqual(calculate_journey_time_in_seconds(29.4), 3528)


class AddOnJourneyTimeTests(unittest.TestCase):
    def test_adds_journey_time_for_same_day_journey(self):
        start_location = ShopData.jl_head_office
        end_location = ShopData.brent_cross
        next_trip = find_next_shop(start_location, [end_location])
        start_time = 0
        self.assertEqual(add_on_journey_time(start_time, next_trip[2]), 949)
