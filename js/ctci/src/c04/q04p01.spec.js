'use strict';

const expect = require('chai').expect;
const Graph = require('../utils/Graph.js');
const routeBetweenNodes = require('./q04p01.js').routeBetweenNodes;

describe('Question 4.1: Route Between Nodes', function() {
    it('finds a simple route.', function() {
        let g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        expect(routeBetweenNodes(g, 0, 2)).to.be.true;
    });

    it('finds a complex route.', function() {
        let g = new Graph(5);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        expect(routeBetweenNodes(g, 0, 2)).to.be.true;
    });

    it('finds no routes.', function() {
        let g = new Graph(5);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        expect(routeBetweenNodes(g, 0, 2)).to.be.false;
    });
});