'use strict';
const hammingDistance = require('../../../main/nodejs/mkrawetko/HammingDistance.js')
const chai = require('chai')
    , expect = chai.expect;

describe('#hammingDistance(x,y) ', function () {

    it('should return 2 for input (1,4)', function () {
        expect(hammingDistance(1,4)).to.equal(2)
    });

    it('should return 2 for input (5,9)', function () {
        expect(hammingDistance(5,9)).to.equal(2)
    });
});