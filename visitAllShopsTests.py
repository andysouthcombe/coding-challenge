import unittest
from staticData import *
from visitAllShops import *
import exceptions
from formatSecondsAsTime import format_seconds_to_time


class FindNextBranchTests(unittest.TestCase):

    def test_find_next_branch_returns_next_shop_with_one_branch(self):
        self.assertEqual(
            return_list_of_shops_sorted_by_distance(ShopData.jl_head_office, [ShopData.peter_jones])[0][0].name,
            "Peter Jones")

    def test_find_next_branch_returns_nearest_shop_with_two_branches_to_visit(self):
        two_branch_list = [ShopData.abergavenny, ShopData.brent_cross]
        self.assertEqual(return_list_of_shops_sorted_by_distance(ShopData.jl_head_office, two_branch_list)[0][0].name,
                         "Brent Cross")

    def test_throws_exception_if_next_shop_unreachable(self):
        with self.assertRaises(exceptions.NextShopTooFar):
            return_list_of_shops_sorted_by_distance(ShopData.jl_exeter, [ShopData.jl_aberdeen])


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
        self.assertEqual(returned_list[0].day, 1)
        self.assertEqual(returned_list[0].start_location.name, ShopData.jl_head_office.name)
        self.assertEqual(returned_list[0].start_time, 0)
        self.assertEqual(returned_list[0].arrival_location.name, ShopData.jl_head_office.name)
        self.assertEqual(returned_list[0].arrival_time, 0)
        self.assertEqual(returned_list[0].journey_distance, 0)

    def test_records_one_shop_to_visit(self):
        input_string = ",".join([ShopData.jl_head_office.to_string(), ShopData.brent_cross.to_string()])
        returned_list = visit_all_shops(input_string)
        self.assertEqual(returned_list[0].start_location.name, ShopData.jl_head_office.name)
        self.assertEqual(returned_list[1].arrival_location.name, ShopData.brent_cross.name)
        self.assertEqual(returned_list[1].arrival_time,
                         Parameters.visit_length_in_seconds + Parameters.head_office_to_brent_cross_travel_time)
        self.assertEqual(returned_list[1].day, 1)


class CalculateJourneyTimeTests(unittest.TestCase):
    def test_calculate_journey_times(self):
        self.assertEqual(calculate_journey_time_in_seconds(30), Parameters.one_hour_in_seconds)
        self.assertEqual(calculate_journey_time_in_seconds(29.4), 3528)


class AddOnJourneyTimeTests(unittest.TestCase):
    def test_adds_journey_time_for_same_day_journey(self):
        start_location = ShopData.jl_head_office
        end_location = ShopData.brent_cross
        next_trip = return_list_of_shops_sorted_by_distance(start_location, [end_location])[0]
        start_time = 0
        self.assertEqual(add_on_journey_time(start_time, 1, next_trip[2]),
                         (start_time,1, Parameters.head_office_to_brent_cross_travel_time))

    def test_if_journey_finishes_after_8pm_starts_next_day(self):
        start_location = ShopData.jl_head_office
        end_location = ShopData.brent_cross
        next_trip = return_list_of_shops_sorted_by_distance(start_location, [end_location])[0]
        start_time = Parameters.max_journey_time_in_day - 700
        self.assertEqual(add_on_journey_time(start_time, 3, next_trip[2]),
                         (0,4, Parameters.head_office_to_brent_cross_travel_time-700))


class GetCurrentPositionAndTimeTests(unittest.TestCase):
    def test_gets_latest_position_time_and_day(self):
        itinerary = [Journey(1, ShopData.jl_head_office, 0, ShopData.jl_aberdeen, 10, 100)]
        itinerary.append(Journey(2, ShopData.jl_aberdeen, 0, ShopData.jl_exeter, 300, 400))
        self.assertEqual(get_current_position_and_time(itinerary), (ShopData.jl_exeter, 300, 2))


class FormatSecondsAsTimeTests(unittest.TestCase):
    def test_formats_seconds_to_seconds(self):
        self.assertEqual(format_seconds_to_time(53), "08:00:53")

    def test_formats_seconds_to_minutes_and_seconds(self):
        self.assertEqual(format_seconds_to_time(62), "08:01:02")

    def test_formats_seconds_to_hours_minutes_and_seconds(self):
        self.assertEqual(format_seconds_to_time(Parameters.one_hour_in_seconds * 2 + Parameters.visit_length_in_seconds + 12), "10:20:12")
        self.assertEqual(format_seconds_to_time(Parameters.one_hour_in_seconds * 6 + 43), "14:00:43")
