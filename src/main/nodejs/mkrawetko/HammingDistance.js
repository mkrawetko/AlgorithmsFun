'use strict';
//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//
//Given two integers x and y, calculate the Hamming distance.
//
//Note:
//0 ≤ x, y < 231.
//
//Example:
//
//Input: x = 1, y = 4
//
//Output: 2
//
//Explanation:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//The above arrows point to positions where the corresponding bits are different.

/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
    let c = 0;
    if(x%2 != y%2){
        c++;
    }
//    console.log("starting x"+x + "; y"+y +" c"+c);
    while(x!=0 || y!=0){
        x>>=1;
        y>>=1;
//        console.log("x"+x + "; y"+y +" c"+c);
        if(x%2 != y%2){
            c++;
        }
    }
//    console.log("before return x"+x + "; y"+y +" c"+c);
    return c;
};

module.exports = hammingDistance;