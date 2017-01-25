function Vertex(id) {
    this.id = id;
    this.vis = false;
    this.adj = [];
}

Vertex.prototype.addEdge = function(v) {
    if (!(v instanceof Vertex)) return;
    this.adj.push(v);
};

const compList = function(g) {
    let lis = [];
    g.forEach((u) => {
        if (u.vis) return;
        let queue = [];
        let sublis = [];
        queue.push(u);
        while (queue.length > 0) {
            let a = queue.shift();
            sublis.push(a.id);
            a.vis = true;
            a.adj.forEach((b) => { if (!b.vis) queue.push(b) });
        }
        lis.push(sublis);
    });
    return lis;
};

const strList = function(g) {
    return g.map((u) => {
        return u.id + ': ' + u.adj.map((a) => { return a.id }).join(' ');
    });
};

// Test: [0..4], [5..9], [10..14], [15..19] are connected.
(function() {
    const randInt = function(min, max) {
        min = Math.ceil(min);
        max = Math.floor(max);
        return Math.floor(Math.random() * (max - min + 1)) + min;
    };
    const N = 20;
    const g = Array.apply(null, Array(N)).map((u, i) => { return new Vertex(i) });
    g.forEach((u, i) => {
        if (i % 5 > 0) {
            let v = g[randInt(i - (i % 5), i - 1)];
            u.addEdge(v);
            v.addEdge(u);
        }
    });
    console.log(strList(g));
    console.log(compList(g));
})();