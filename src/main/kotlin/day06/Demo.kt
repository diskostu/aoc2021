package day06

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

suspend fun main() {
    lala()
}

suspend fun lala() {
    coroutineScope { // limits the scope of concurrency
        (0..10).map { // is a shorter way to write IntRange(0, 10)
            async(Dispatchers.IO) { // async means "concurrently", context goes here
                println(it)
            }
        }.awaitAll() // waits all of them
    } // if any task crashes -- this scope ends with exception
}
