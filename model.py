class ShopLocation:
    def __init__(self, name, postcode, longitude, latitude):
        self.name = name
        self.postcode = postcode
        self.longitude = longitude
        self.latitude = latitude

    def to_string(self):
        return "%s,%s,%d,%d" % (self.name, self.postcode, self.longitude, self.latitude)


class Journey:
    def __init__(self, start_location, start_time, arrival_location, arrival_time , journey_distance):
        self.start_location = start_location
        self.start_time = start_time
        self.arrival_location = arrival_location
        self.arrival_time = arrival_time
        self.journey_distance = journey_distance
