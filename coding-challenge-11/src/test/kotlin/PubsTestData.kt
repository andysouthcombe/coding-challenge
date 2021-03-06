class PubsTestData {
    val pubWithNoBeer = """{
            "Pubs":[
                {"Name":"Phoenix",
                "PubService":"https://pubcrawlapi.appspot.com/pub/?v=1&id=16185&branch=WLD&uId=mike&pubs=no&realAle=yes&memberDiscount=no&town=London", 
                "Id":"16185", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-16 19:31:20"}
                ]
                }"""

    val pubWithOneRegularBeer = """{
            "Pubs":[
                {"Name":"Phoenix",
                "RegularBeers":
                    ["Young#039;s Bitter"],
                "PubService":"https://pubcrawlapi.appspot.com/pub/?v=1&id=16185&branch=WLD&uId=mike&pubs=no&realAle=yes&memberDiscount=no&town=London", 
                "Id":"16185", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-16 19:31:20"}
                ]
                }"""
    val pubWithTwoRegularAndThreeGuestBeers = """{
            "Pubs":[
                {"Name":"Phoenix",
                "RegularBeers":
                    ["Doom Bar",
                    "Otter Ale"]
                "GuestBeers":
                    ["Westerham Viceroy",
                    "Westerham Summer Perle",
                    "Oxted Crystal"]    
                "PubService":"https://pubcrawlapi.appspot.com/pub/?v=1&id=16185&branch=WLD&uId=mike&pubs=no&realAle=yes&memberDiscount=no&town=London", 
                "Id":"16185", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-16 19:31:20"}
                ]
                }"""
    val threePubsWithVariousBeers = """{
            "Pubs":[
                {"Name":"Phoenix",
                "RegularBeers":
                    ["Doom Bar",
                    "Otter Ale"]
                "GuestBeers":
                    ["Westerham Viceroy",
                    "Westerham Summer Perle",
                    "Oxted Crystal"]    
                "PubService":"service one", 
                "Id":"16185", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-16 19:31:20"},
                {"Name":"Windsor Castle",
                "RegularBeers":
                    ["Sam Smiths Bitter",
                    "Sam Smiths lager"]
                "GuestBeers":
                    ["Westerham Viceroy"]
                "PubService":"service two", 
                "Id":"16186", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-17 19:31:20"},
                {"Name":"Brass Monkey",
                "RegularBeers":
                    ["Tribute",
                    "Meantime Pale Ale"]
                "PubService":"service three", 
                "Id":"16187", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-18 19:31:20"}
                ]
                }"""
    val pubWithOneRegularBeerAndOneGuestBeer = """{
            "Pubs":[
                {"Name":"Phoenix",
                "RegularBeers":
                    ["Young#039;s Bitter"],
                "GuestBeers":
                    ["Doom Bar"],
                "PubService":"https://pubcrawlapi.appspot.com/pub/?v=1&id=16185&branch=WLD&uId=mike&pubs=no&realAle=yes&memberDiscount=no&town=London", 
                "Id":"16185", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-16 19:31:20"}
                ]
                }"""
    val twoPubsWithVariousBeers = """{
            "Pubs":[
                {"Name":"Pub1",
                "RegularBeers":
                    ["Beer1",
                    "Beer2"]
                "GuestBeers":
                    ["Beer3"] 
                "PubService":"service one", 
                "Id":"16185", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-16 19:31:20"},
                {"Name":"Pub2",
                "RegularBeers":
                    ["Beer1",
                    "Beer4"]
                "PubService":"service two", 
                "Id":"16186", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-17 19:31:20"}
                ]
                }"""
    val duplicatePubs = """{
            "Pubs":[
                {"Name":"Pub1",
                "RegularBeers":
                    ["Beer1",
                    "Beer2"]
                "GuestBeers":
                    ["Beer3"] 
                "PubService":"service one", 
                "Id":"16185", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-16 19:31:20"},
                {"Name":"Pub1",
                "RegularBeers":
                    ["Beer1",
                    "Beer4"]
                "GuestBeers":
                    ["Beer5"] 
                "PubService":"service one", 
                "Id":"16185", 
                "Branch":"WLD", 
                "CreateTS":"2019-05-17 19:31:20"}
                ]
                }"""
}