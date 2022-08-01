//Bola8

//Declarando valores de las respuestas
const val AFFIRMATIVE_ANSWER = "✅"
const val NEGATIVE_ANSWER = "❌"
const val DOUBTFUL_ANSWER = "?"

//uniendo las respuestas con sus valores
val answers = mapOf(
    "Yes" to AFFIRMATIVE_ANSWER,
    "It's true" to AFFIRMATIVE_ANSWER,
    "Totally" to AFFIRMATIVE_ANSWER,
    "Undoubtedly" to AFFIRMATIVE_ANSWER,
    "Ask in an other moment" to DOUBTFUL_ANSWER,
    "I can't say you in this moment" to DOUBTFUL_ANSWER,
    "Maybe yes, or maybe not" to DOUBTFUL_ANSWER,
    "It's not going to happen" to NEGATIVE_ANSWER,
    "Do not count on it" to NEGATIVE_ANSWER,
    "Definitely not" to NEGATIVE_ANSWER,
    "I don't believe it" to NEGATIVE_ANSWER
)


fun main(args: Array<String>) {
    //Declarando el menu principal
    println(
        "Hello, I'm the Kotlin 8 Ball. What do you want to do?\n" +
                "1. Ask a question\n" +
                "2. Check all answers\n" +
                "3. Exit"
    )
    //leyendo la respuesta del usuario
    val inputValue = readLine()

    //funciones a executar segun la respuesta del usuario
    when (inputValue) {
        "1" -> askQuestion()
        "2" -> checkAnswer()
        "3" -> exit()
        else -> showError()
    }

}

fun showError() {
    println("Not available option")
}

fun exit() {
    println("Goodbye!")
}

fun checkAnswer() {
    println("Select an option")
    println("1. Check all answers")
    println("2. Check only affirmative answers")
    println("3. Check only doubtfully answers")
    println("4. Check only negative answers")

    val inputOption = readLine()
    when (inputOption) {
        "1" -> showAnswersByType()
        "2" -> showAnswersByType(answerType = AFFIRMATIVE_ANSWER)
        "3" -> showAnswersByType(answerType = DOUBTFUL_ANSWER)
        "4" -> showAnswersByType(answerType = NEGATIVE_ANSWER)
        else -> println("Not available answer. Goodbye")
    }
}

fun showAnswersByType(answerType : String = "ALL") {
    when (answerType) {
        "ALL" -> answers.keys.forEach { answers -> (answers) }

        AFFIRMATIVE_ANSWER -> answers.filterValues { values -> values == AFFIRMATIVE_ANSWER }
            .also { positiveAnswers -> println(positiveAnswers.keys) }

        NEGATIVE_ANSWER -> answers.filterValues { values -> values == NEGATIVE_ANSWER }
            .also { negativeAnswers -> println(negativeAnswers.keys) }

        DOUBTFUL_ANSWER -> answers.filterValues { values -> values == DOUBTFUL_ANSWER }
            .also { doubtfulAnswers -> println(doubtfulAnswers.keys) }
    }
}

fun askQuestion() {
    println("What question want to do?")
    readLine()
    println("So this is your question.. The answer is:")
    val generatedAnswer = answers.keys.random()
    println(generatedAnswer)
}

