import com.beust.klaxon.FieldRenamer
import com.beust.klaxon.Klaxon
import java.lang.Exception

fun getPubsInArea(inputJson: String): List<Pub> {
    val renamer = object: FieldRenamer {
        override fun toJson(fieldName: String) = fieldName.capitalize()
        override fun fromJson(fieldName: String) = fieldName.toLowerCase()
    }
    val klaxon = Klaxon().fieldRenamer(renamer)
    return try {
    val pubsInArea = klaxon.parse<PubsInArea>(inputJson)
        pubsInArea?.pubs ?: listOf()
    } catch (e: Exception) {
        println(e)
        listOf()
    }

}