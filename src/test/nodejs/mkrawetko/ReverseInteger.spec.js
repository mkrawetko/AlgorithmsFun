'use strict';
const reverse = require('../../../main/nodejs/mkrawetko/ReverseInteger.js')
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

});