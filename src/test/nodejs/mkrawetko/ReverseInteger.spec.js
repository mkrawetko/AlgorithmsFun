'use strict';
const reverse = require('../../../main/nodejs/mkrawetko/ReverseInteger.js');
const chai = require('chai')
    , expect = chai.expect;


describe('#reverseInteger(x,y) ', function () {

    it('on input 123 should return 321', function () {
        expect(reverse(123)).to.equal(321)
    });
    it('on input -123 should return -321', function () {
        expect(reverse(-123)).to.equal(-321)
    });
    it('on input 120 should return 21', function () {
        expect(reverse(120)).to.equal(21)
    });
    it('on input 0 should return 0', function () {
        expect(reverse(0)).to.equal(0)
    });
    it('on input 901000 should return 109', function () {
        expect(reverse(901000)).to.equal(109)
    });
    it('on input 1534236469 should return 0 overflows', function () {
        expect(reverse(1534236469)).to.equal(0)
    });

});