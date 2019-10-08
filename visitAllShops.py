from geopy import distance
from staticData import Parameters
from model import ShopLocation
from model import Journey
import exceptions


def visit_all_shops(shop_string):
    list_of_shops_to_visit = load_shop_string_to_list(shop_string)
    itinerary = []
    itinerary.append(
        Journey(1, list_of_shops_to_visit[0], 0, list_of_shops_to_visit[0], Parameters.visit_length_in_seconds, 0))
    return itinerary


def find_next_shop(current_shop, remaining_shops):
    current_long = current_shop.longitude
    current_lat = current_shop.latitude
    distances_from_current_shop = []

    for s in remaining_shops:
        distance_from_start = distance.geodesic((current_long, current_lat), (s.longitude, s.latitude)).miles
        distances_from_current_shop.append(
            [s, distance_from_start, calculate_journey_time_in_seconds(distance_from_start)])

    distances_from_current_shop.sort(key=lambda x: x[1])
    if distances_from_current_shop[0][2] > Parameters.max_journey_time_in_day:
        raise exceptions.NextShopTooFar

    return distances_from_current_shop[0]


def load_shop_string_to_list(shop_string):
    raw_list = shop_string.split(",")
    num_shops = int(len(raw_list) / 4)
    list_of_shops_to_visit = []

    for s in range(1, num_shops + 1):
        shop_name = raw_list[0 + (s - 1) * 4]
        shop_postcode = raw_list[1 + (s - 1) * 4]
        shop_longitude = raw_list[2 + (s - 1) * 4]
        shop_latitude = raw_list[3 + (s - 1) * 4]
        list_of_shops_to_visit.append(ShopLocation(shop_name, shop_postcode, shop_longitude, shop_latitude))
    return list_of_shops_to_visit


def calculate_journey_time_in_seconds(distance_in_miles):
    return int((distance_in_miles / Parameters.speed_in_mph) * Parameters.one_hour_in_seconds)


def add_on_journey_time(start_time, start_day, journey_time):
    final_day = start_day + int((start_time + journey_time) / Parameters.max_journey_time_in_day)
    if final_day > start_day:
        finish_time = journey_time
    else:
        finish_time = start_time + journey_time

    return final_day, finish_time
