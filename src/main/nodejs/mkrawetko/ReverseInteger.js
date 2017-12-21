

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
var reverse = function(x) {
        let str = x.toString()
        let res = ""
        if(str[0] === '-'){
            str = str.substr(1)
            res +='-'
        }
        for(idx = str.length-1;idx>=0;idx --){
             res += str[idx];
        }
        let ret = parseInt(res)

        return ((ret | 0) !== ret)?0:ret
};

module.exports = reverse;