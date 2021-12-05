package day04

data class BingoNumber(val number: Int, var marked: Boolean = false) {
    override fun toString(): String {
        var string = "$number"
        string += if (marked) "[x]" else "[ ]"
        return string
    }
}
