/**
 * from https://leetcode.com/problems/powx-n/
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * 
 * This solution use binany operations, for example
 * 10 in binary form is "1 0 1 0"
 * and we use "and" operator with 1 to it needs times one more time
 * and we use "shr" operator to shift right 1 bit, so "1 0 1 0" becomes "1 0 1"
 * 
 * each while loop, cumulation value, for example 4-bit cumulation for 2 is 2, 4, 16, 256
 * 
 * So for 2^10 is
 * 
 * 1   0    1   0
 * 256 16   4   2
 * --------------
 * 
 * 4 * 256 = 1024
 * 
 * So for 2^11 is
 * 
 * 1   0    1   1
 * 256 16   4   2
 * --------------
 * 
 * 2 * 4 * 256 = 2048
 * 
 **/
class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0

        var result = 1.0
        var cumulation = x

        // Kolint has Math.asb(-2147483648) = -2147483648, probably it is a bug or Integer overflow in Java
        // So change to long
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

