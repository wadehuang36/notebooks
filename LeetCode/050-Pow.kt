/**
 * from https://leetcode.com/problems/powx-n/
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 **/
class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0

        var result = 1.0
        var cumulation = x
        var t = Math.abs(n.toLong())

        while (t > 0) {
            if (t and 1L == 1L) {
                result = result * cumulation
            }

            cumulation = cumulation * cumulation

            t = t shr 1
        }

        if (n < 0) {
            return 1 / result
        } else {
            return result
        }
    }
}

// testing
fun test(x: Double, n: Int, t: Double) {
    var actual = Solution().myPow(x, n)
    println("x: $x, n: $n, actual: $actual, except:$t")
}

fun main(args: Array<String>) {
    test(2.0, 10, 1024.0)
    test(2.10000, 3, 9.26100)
    test(2.00000, -2, 0.25000)
    test(2.00000, -2147483648, 0.0)
}

