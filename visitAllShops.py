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
    raw_list = shop_string.split(",")
    num_shops = int(len(raw_list) / 4)
    list_of_shops_to_visit = []

    for s in range(1, num_shops+1):
        shop_name = raw_list[0 + (s - 1) * 4]
        shop_postcode = raw_list[1 + (s - 1) * 4]
        shop_longitude = raw_list[2 + (s - 1) * 4]
        shop_latitude = raw_list[3 + (s - 1) * 4]
        list_of_shops_to_visit.append(ShopLocation(shop_name,shop_postcode,shop_longitude,shop_latitude))
    return list_of_shops_to_visit


class ShopLocation:
    def __init__(self, name, postcode, longitude, latitude):
        self.name = name
        self.postcode = postcode
        self.longitude = longitude
        self.latitude = latitude
