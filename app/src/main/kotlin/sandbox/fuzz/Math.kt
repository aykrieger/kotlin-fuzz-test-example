package sandbox.fuzz

fun addOne(input: Int): Int = if (input % 2 == 0) input + 1 else throw IllegalArgumentException()
fun subtractOne(input: Int): Int = input - 1
