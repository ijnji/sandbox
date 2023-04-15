'use strict';

function routeBetweenNodes(g, u, v) {
    if (u >= g.V.length || v >= g.V.length) return false;
    let que = [];
    let visited = [];
    let visiting = [];
    que.push(u);
    while (que.length > 0) {
        let curr = que.shift();
        visited[curr] = true;
        for (let i = 0; i < g.adj[curr].length; i++) {
            let a = g.adj[curr][i];
            if (a === v) return true;
            if (!visited[a] && !visiting[a]) {
                que.push(a);
                visiting[a] = true;
            }
        }
    }
    return false;
}

module.exports = {
    routeBetweenNodes: routeBetweenNodes
};