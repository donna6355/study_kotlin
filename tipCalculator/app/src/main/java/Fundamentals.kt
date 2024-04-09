class Fundamentals {
}
//CANNOT REUSE
//class FillInTheBlankQuestion(
//    val questionText: String,
//    val answer: String,
//    val difficulty: String
//)
//
//class TrueOrFalseQuestion(
//    val questionText: String,
//    val answer: Boolean,
//    val difficulty: String
//)
//class NumericQuestion(
//    val questionText: String,
//    val answer: Int,
//    val difficulty: String
//)

//Reusable with generic type
//class Question<T>(
//    val questionText: String,
//    val answer: T,
//    val difficulty: String
//)

//val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
//val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
//val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")

//limit the set of value with enum
enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

//class Quiz {
//    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
//    val question3 =
//        Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
//
//    companion object Progress {
//        var total: Int = 10
//        var correct: Int = 3
//    }
//
//    fun printProgress() {
//        println("$correct of $total answered.")
//    }
//}
//val Quiz.Progress.progressText: String
//    get() = "$correct of $total answered."
//fun Quiz.Progress.progressStatusBar(){
//    repeat(Quiz.correct) { print("▓") }
//    repeat(Quiz.total - Quiz.correct) { print("▒") }
//    println()
//    println(Quiz.progressText)
//}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 =
        Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object Progress {
        var total: Int = 10
        var correct: Int = 3
    }

    override val progressText: String
        get() = TODO("$correct of $total answered.")

    override fun printProgressBar() {
        repeat(Quiz.correct) { print("▓") }
        repeat(Quiz.total - Quiz.correct) { print("▒") }
        println()
        println(progressText)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}
