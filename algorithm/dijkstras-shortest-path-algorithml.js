function shortestPath(input, start, end) {
  var nodes = new Array(input.length);

  for (var i = 0; i < nodes.length; i++) {
    var arr = input[i];
    var n = {
      name: i,
      previous: null,
      distance: Number.MAX_VALUE,
      check: false,
      neighbors: {}
    };

    for (var j = 0; j < arr.length; j++) {
      if (arr[j] != 0) {
        n.neighbors[j] = arr[j];
      }
    }

    nodes[i] = n;
  }

  var startNode = nodes[start];
  startNode.distance = 0;
  startNode.check = true;

  var target;
  var queue = [startNode];
  while (queue.length > 0) {
    var n = queue.splice(0, 1)[0];

    for (var i in n.neighbors) {
      var nei = nodes[i];

      var newDistance = n.distance + n.neighbors[i];
      if (newDistance < nei.distance) {
        nei.previous = n;
        nei.distance = newDistance;
      }

      if (nei.name == end) {
        target = nei;
      }

      if (!nei.check) {
        nei.check = true;
        queue.push(nei);
      }
    }
  }

  if (target) {
    var path = [];
    var n = target;
    while (n != null) {
      path.push(`(${n.name},${n.distance})`);
      n = n.previous;
    }
    return path.reverse();
  } else {
    return "no";
  }
}

var INPUT = [
  [0, 4, 0, 0, 0, 0, 0, 8, 0],
  [4, 0, 8, 0, 0, 0, 0, 11, 0],
  [0, 8, 0, 7, 0, 4, 0, 0, 2],
  [0, 0, 7, 0, 9, 14, 0, 0, 0],
  [0, 0, 0, 9, 0, 10, 0, 0, 0],
  [0, 0, 4, 14, 10, 0, 2, 0, 0],
  [0, 0, 0, 0, 0, 2, 0, 1, 6],
  [8, 11, 0, 0, 0, 0, 1, 0, 7],
  [0, 0, 2, 0, 0, 0, 6, 7, 0]
];

console.log(`the shortest path from 0 to 8 is : ${shortestPath(INPUT, 0, 8)}`);
console.log(`the shortest path from 1 to 5 is : ${shortestPath(INPUT, 1, 5)}`);
console.log(`the shortest path from 1 to 5 is : ${shortestPath(INPUT, 0, 4)}`);
