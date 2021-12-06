package day06

data class Lanternfish(var day: Int = reproductionCycleNewBorn) {

    fun resetDays() {
        day = reproductionCycle
    }

    companion object {
        private const val reproductionCycle = 6
        private const val reproductionCycleNewBorn = 8
    }
}
