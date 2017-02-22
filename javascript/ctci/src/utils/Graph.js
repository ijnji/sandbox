'use strict';

function Graph(verts) {
    this.V = [];
    this.E = 0;
    this.adj = [];
    for (let i = 0; i < verts; i++) {
        this.V[i] = 0;
        this.adj[i] = [];
    }
}

Graph.prototype.addEdge = function(u, v) {
    if (u >= this.V.length || v >= this.V.length) return;
    if (this.adj[u].indexOf(v) >= 0) return;
    this.adj[u].push(v);
    this.E++;
}

module.exports = Graph;