'use strict';

const expect = require('chai').expect;
const isUnique = require('./q01p01.js').isUnique;

describe('Question 1.1: Is Unique', function() {
    it('passes a unique string.', function() {
        let str = 'abcde';
        expect(isUnique(str)).to.be.true;
    });

    it('fails a non-unique string.', function() {
        let str = 'zzzzz';
        expect(isUnique(str)).to.be.false;
    });
});