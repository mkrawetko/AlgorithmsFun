

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
        if(x === 0 ){
            return 0
        }
       let str = x.toString()
       let res = ""
       let idx = 0;
       let addSign = false;
       while(idx<str.length){
           let c = str[idx]
           if(c==='-'){
               addSign = true
           }else if(c!=='0' || parseInt(str.substr(idx)) !== 0){
               res = c+res;
           }
           idx++
       }

        if(addSign){
            res = '-'+res;
        }
       let ret = parseInt(res)
       if(addSign && ret > 0){
            return 0;
       }else if(!addSign && ret<0){
            return 0
       }
       return ret;
};

module.exports = reverse;