//Given a 32-bit signed integer, reverse digits of an integer.
//
//Example 1:
//
//Input: 123
//Output:  321
//Example 2:
//
//Input: -123
//Output: -321
//Example 3:
//
//Input: 120
//Output: 21
//Note:
//Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
//For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
    let absX = Math.abs(x);
    let res = 0;
    while (absX > 0) {
        res = res * 10 + absX % 10;
        absX = Math.floor(absX / 10)
    }
    if (x < 0) {
        res = -res;
    }
    return ((res | 0) !== res) ? 0 : res;
};

module.exports = reverse;