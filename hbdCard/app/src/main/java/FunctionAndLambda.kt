fun main() {
    val trickFunction = ::trick
    val treatFunction = treat

    val coins: (Int) -> String = { qty -> "$qty cents" }

    val boolTreatFunction = trickOrTreat(false)
    val boolTrickFunction = trickOrTreat(true)
    val extraTreatFunction = extraTrickOrTreat(false, coins)
    val extraTrickFunction = extraTrickOrTreat(true, null)

    //Pass a lambda expression directly into a function
    val extraTreatFnShort = extraTrickOrTreat(false, {"$it won"})
    //Use trailing lambda syntax
    val extraTreatFnShortHand = extraTrickOrTreat(false){"$it donuts"}
    boolTreatFunction()
    boolTrickFunction()
    extraTreatFunction()
    extraTreatFnShort()

    repeat(3){
        extraTreatFnShortHand()
    }
}

fun trickOrTreat(forTrick: Boolean): () -> Unit {
    if (forTrick) return ::trick
    else return treat

}

fun extraTrickOrTreat(forTrick: Boolean, extra: ((Int) -> String)?): () -> Unit {
    if (forTrick) return ::trick
    else {
        if (extra != null) {
            println(extra(5))
        }
        return treat
    }

}

fun trick() {
    println("No treats!")
}

val treat: () -> Unit = {
    println("TREATS!!")
}