inline fun <reified E> List<E>.contentEquals(target: List<E>): Boolean {
    return this.toTypedArray().contentEquals(target.toTypedArray())
}

inline fun <reified E> List<List<E>>.deepContentEquals(target: List<List<E>>): Boolean {
    if (this.size != target.size) return false

    val a = this.toMutableList()
    val b = target.toMutableList()

    for (a1 in a.toList()) {
        for (b1 in b.toList()) {
            if (a1.contentEquals(b1)) {
                a.remove(a1)
                b.remove(b1)
                break
            }
        }
    }

    return a.isEmpty() && b.isEmpty()
}

fun Double.round(decimals: Int): Double {
    val multiplier = Math.pow(10.0, decimals.toDouble())
    return Math.round(this * multiplier) / multiplier
}