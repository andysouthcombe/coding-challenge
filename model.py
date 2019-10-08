class ShopLocation:
    def __init__(self, name, postcode, longitude, latitude):
        self.name = name
        self.postcode = postcode
        self.longitude = longitude
        self.latitude = latitude

    def to_string(self):
        return "%s,%s,%s,%s" % (self.name, self.postcode, self.longitude, self.latitude)


class Journey:
    def __init__(self, day, start_location, start_time, arrival_location, arrival_time, journey_distance,formatted_start_time,formatted_arrival_time):
        self.day = day
        self.start_location = start_location
        self.start_time = start_time
        self.arrival_location = arrival_location
        self.arrival_time = arrival_time
        self.journey_distance = journey_distance
        self.formatted_arrival_time = start_time 

    def to_string(self):
        return "%s,%s,%s,%s,%s,%s" % (
            self.day, self.start_location.name, self.start_time, self.arrival_location.name,
            self.arrival_time, self.journey_distance)
