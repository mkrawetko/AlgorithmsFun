'use strict';
const judgeCircle = require('../../../main/nodejs/mkrawetko/JudgeRouteCircle.js')
const chai = require('chai')
    , expect = chai.expect;

describe('#judgeCircle(moves) ', function () {

    it('should return true for input "UD"', function () {
        expect(judgeCircle("UD")).to.equal(true)
    });

    it('should return false for input LL', function () {
        expect(judgeCircle("LL")).to.equal(false)
    });

    it('should return true for input LLUUDRDR', function () {
        expect(judgeCircle("LLUUDRDR")).to.equal(true)
    });
});