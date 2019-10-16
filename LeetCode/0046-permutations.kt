/**
 * https://leetcode.com/problems/permutations/
 * Given a collection of distinct integers, return all possible permutations.
 **/
class Solution046 {
    lateinit var result: MutableList<List<Int>>
    fun permute(nums: IntArray): List<List<Int>> {
        result = mutableListOf()

        if (nums.isNotEmpty()) {
            build(mutableListOf(), nums.toMutableList())
        }

        return result
    }

    /**
     * @param nums is the current numbers
     * @param remNums is the remainder numbers to pick up
     */
    fun build(nums: MutableList<Int>, remNums: MutableList<Int>) {
        if (remNums.isEmpty()) {
            // if there is no number left, add to result
            result.add(nums)
            return
        }

        // pick up 1 remainder number for each
        for (i in remNums.indices) {
            val nr = remNums.toMutableList() // clone
            val nn = nums.toMutableList() // clone
            nn.add(nr.removeAt(i)) // pick up one number by index

            build(nn, nr)
        }
    }
}

// testing
fun test(input: IntArray, expect: List<List<Int>>) {
    val start = System.currentTimeMillis()
    val actual = Solution046().permute(input)

    val spend = System.currentTimeMillis() - start

    println("spend: $spend ms, result:${actual.deepContentEquals(expect)}, actual: $actual, expect: $expect")
}

fun main() {
    test(
        intArrayOf(1, 2, 3),
        listOf(
            listOf(1, 2, 3), listOf(1, 3, 2), listOf(2, 1, 3), listOf(2, 3, 1), listOf(3, 1, 2), listOf(3, 2, 1)
        )
    )

    test(
        intArrayOf(1, 2, 3, 4),
        listOf(
            listOf(1, 2, 3, 4),
            listOf(1, 2, 4, 3),
            listOf(1, 3, 2, 4),
            listOf(1, 3, 4, 2),
            listOf(1, 4, 2, 3),
            listOf(1, 4, 3, 2),
            listOf(2, 1, 3, 4),
            listOf(2, 1, 4, 3),
            listOf(2, 3, 1, 4),
            listOf(2, 3, 4, 1),
            listOf(2, 4, 1, 3),
            listOf(2, 4, 3, 1),
            listOf(3, 1, 2, 4),
            listOf(3, 1, 4, 2),
            listOf(3, 2, 1, 4),
            listOf(3, 2, 4, 1),
            listOf(3, 4, 1, 2),
            listOf(3, 4, 2, 1),
            listOf(4, 1, 2, 3),
            listOf(4, 1, 3, 2),
            listOf(4, 2, 1, 3),
            listOf(4, 2, 3, 1),
            listOf(4, 3, 1, 2),
            listOf(4, 3, 2, 1)
        )
    )
}

