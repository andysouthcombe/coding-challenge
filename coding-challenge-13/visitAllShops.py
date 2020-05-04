from geopy import distance
from staticData import Parameters
from model import ShopLocation
from model import Journey
import exceptions
from listOfBranches import ListOfBranches
from staticData import ShopData
import gmplot

def visit_all_shops(shop_string):
    list_of_shops_to_visit = load_shop_string_to_list(shop_string)
    itinerary = [
        Journey(1, list_of_shops_to_visit[0], 0, list_of_shops_to_visit[0], 0, 0)]
    latitude_list = [float(list_of_shops_to_visit[0].latitude)]
    longitude_list = [float(list_of_shops_to_visit[0].longitude)]
    list_of_shops_to_visit.pop(0)
    while len(list_of_shops_to_visit) > 0:
        (start_location, current_time, current_day) = get_current_position_and_time(itinerary)
        try:
            remaining_shops_sorted_by_distance = return_list_of_shops_sorted_by_distance(start_location,
                                                                                         list_of_shops_to_visit)
        except exceptions.NextShopTooFar:
            "Stuck at %s" % start_location.name
            break

        arrival_location = remaining_shops_sorted_by_distance[0][0]

        journey_distance = remaining_shops_sorted_by_distance[0][1]
        journey_time = remaining_shops_sorted_by_distance[0][2]
        end_of_visit_time = current_time + Parameters.visit_length_in_seconds

        (departure_time, arrival_day, arrival_time) = add_on_journey_time(end_of_visit_time, current_day, journey_time)

        itinerary.append(
            Journey(arrival_day, start_location, departure_time, arrival_location, arrival_time, journey_distance))
        latitude_list.append(float(arrival_location.latitude))
        longitude_list.append(float(arrival_location.longitude))
        remaining_shops_sorted_by_distance.pop(0)

        list_of_shops_to_visit = [s[0] for s in remaining_shops_sorted_by_distance]

    return itinerary, latitude_list, longitude_list


def return_list_of_shops_sorted_by_distance(current_shop, remaining_shops):
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

    return distances_from_current_shop


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
    total_time = start_time + journey_time
    days_to_add, new_time = divmod(total_time, Parameters.max_journey_time_in_day)

    if days_to_add > 0:
        departure_time = 0
    else:
        departure_time = start_time

    return departure_time, start_day + days_to_add, new_time


def get_current_position_and_time(itinerary):
    current_position = itinerary[-1].arrival_location
    current_time = itinerary[-1].arrival_time
    current_day = itinerary[-1].day
    return current_position, current_time, current_day


if __name__ == "__main__":
    journey_list, latitude_list, longitude_list = visit_all_shops(ListOfBranches.list_of_branches)
    #journey_list, latitude_list, longitude_list = visit_all_shops(ShopData.sample_input_string)
    print("day,start_location,start_time,arrival_location,arrival_time,journey_distance")
    for j in journey_list:
        print(j.to_string())

gmap3 = gmplot.GoogleMapPlotter(51.496466,
                                -0.141499, 13)

# scatter method of map object
# scatter points on the google map
gmap3.scatter(latitude_list, longitude_list, '# FF0000',
               size=40, marker=False)

# Plot method Draw a line in
# between given coordinates
gmap3.plot(latitude_list, longitude_list,
            'cornflowerblue', edge_width=2.5)

gmap3.apikey = ''

gmap3.draw("C:\\temp\\map13.html")
