from geopy import distance


def visit_all_shops(shop_string):
    journey_log = []
    print("hello")


def find_next_shop(current_shop, remaining_shops):
    current_long = current_shop.longitude
    current_lat = current_shop.latitude
    distances_from_current_shop = []

    for s in remaining_shops:
        distance_from_start = distance.geodesic((current_long, current_lat), (s.longitude, s.latitude)).miles
        distances_from_current_shop.append([s, distance_from_start])

    distances_from_current_shop.sort(key=lambda x: x[1])

    return distances_from_current_shop[0]


def load_shop_string_to_list(shop_string):

    return 1


class ShopLocation:
    def __init__(self, name, postcode, longitude, latitude):
        self.name = name
        self.postcode = postcode
        self.longitude = longitude
        self.latitude = latitude
