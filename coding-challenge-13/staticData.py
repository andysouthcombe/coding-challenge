from model import ShopLocation


class ShopData:
    jl_head_office = ShopLocation("John Lewis Head Office", "SW1E 5NN", "-0.141499", "51.496466")
    peter_jones = ShopLocation("Peter Jones", "SW1W 8EL", "-0.159", "51.492246")
    abergavenny = ShopLocation("Abergavenny", "NP7 9LL", "-3.028245", "51.818294")
    brent_cross = ShopLocation("Brent Cross", "NW4 3FQ", "-0.223792", "51.576416")
    jl_exeter = ShopLocation("John Lewis Exeter", "EX4 6NN", "-3.525637", "50.726374")
    jl_aberdeen = ShopLocation("John Lewis Aberdeen", "AB25 1BW", "-2.100636", "57.150079")
    sample_input_string = "Abergavenny,NP7 9LL,-3.028245,51.818294,Abergavenny Petrol Station,NP7 9LL,-3.028245,51.818294,Abingdon,OX14 3HL,-1.279705,51.672083,Addlestone,KT15 2GL,-0.491506,51.370886"


class Parameters:
    visit_length_in_seconds = 20 * 60
    one_hour_in_seconds = 60 * 60
    speed_in_mph = 30
    max_journey_time_in_day = 10 * one_hour_in_seconds
    start_hour = 8
    head_office_to_brent_cross_travel_time = 949