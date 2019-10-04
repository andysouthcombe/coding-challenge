from geopy import distance


def visit_all_shops(shop_list):
    print("hello")


def find_next_shop(current_shop, remaining_shops):
    current_long = current_shop[2]
    current_lat = current_shop[3]
    distances_from_current_shop = []

    for s in remaining_shops:
        shop_long = s[2]
        shop_lat = s[3]
        distance_from_start = distance.geodesic((current_long, current_lat), (shop_long, shop_lat)).miles
        distances_from_current_shop.append([s[0], s[1], s[2], s[3], distance_from_start])

    distances_from_current_shop.sort(key=lambda x: x[4])

    return distances_from_current_shop[0]
