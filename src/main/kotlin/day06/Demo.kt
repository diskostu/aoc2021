package day06

fun main() {
    val inputList = listOf(1, 2, 3, 4, 1, 2, 3, 1, 2)

    val variants = MutableList(9) { index ->
        inputList.count { it == index }
    }
    val variants2 = inputList
        .groupingBy { it }
        .eachCount().toMutableMap()

    println("variants = $variants")
    println("variants2 = $variants2")

}
