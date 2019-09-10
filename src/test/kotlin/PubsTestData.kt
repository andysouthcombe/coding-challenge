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
}