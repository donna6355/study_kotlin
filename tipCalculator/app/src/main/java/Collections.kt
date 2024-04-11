class Collections {
    fun arraySample() {
        val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
        val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
        val solarSystem = rockPlanets + gasPlanets
        solarSystem[3] = "Little Earth"
    }

    fun listSample() {
        val solarSys =
            listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
        for (planet in solarSys) {
            println(planet)
        }

        val solarSystem = mutableListOf(
            "Mercury",
            "Venus",
            "Earth",
            "Mars",
            "Jupiter",
            "Saturn",
            "Uranus",
            "Neptune"
        )
        solarSystem.add("Pluto")
        solarSystem.add(3, "Theia")
        solarSystem[3] = "Future Moon"
        solarSystem.removeAt(9)
        solarSystem.remove("Future Moon")
        println("Theia" in solarSystem)//false
    }

    fun setSample() {
        val solarSystem = mutableSetOf(
            "Mercury",
            "Venus",
            "Earth",
            "Mars",
            "Jupiter",
            "Saturn",
            "Uranus",
            "Neptune"
        )
        println(solarSystem.size)
        solarSystem.add("Pluto")
        println(solarSystem.size)
        println(solarSystem.contains("Pluto"))
        println(solarSystem.size)
        solarSystem.add("Pluto")
        println(solarSystem.size)
        solarSystem.remove("Pluto")
        println(solarSystem.size)
    }

    fun mapSample() {
        val solarSystem = mutableMapOf<String, Int>(
            "Mercury" to 0,
            "Venus" to 0,
            "Earth" to 1,
            "Mars" to 2,
            "Jupiter" to 79,
            "Saturn" to 82,
            "Uranus" to 27,
            "Neptune" to 14
        )
        solarSystem["Pluto"] = 5
        println(solarSystem["Pluto"])
        println(solarSystem.get("Theia")) // null
        solarSystem["Jupiter"] = 78
        println(solarSystem["Jupiter"])
    }
}
