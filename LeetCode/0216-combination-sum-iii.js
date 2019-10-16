/**
 * form: https://leetcode.com/problems/combination-sum-iii/
 * 
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
var combinationSum3 = function(k, n) {
  var results = [];

  search(results, [], 1, k, n);

  return results;
};

function search(results, set, start, layer, left) {
  if (layer == 0 && left == 0) {
    results.push(set);
    return;
  }

  // console.log(set, start, layer, left);

  layer--;

  for (var i = start; i <= 9; i++) {
    var l = left - i;

    if (layer >= 0 && l >= 0) {
      search(results, [...set, i], i + 1, layer, l);
    }
  }
}

function test(input) {
  var start = Date.now();
  var result = combinationSum3.apply(null, input);
  console.log(
    `Spent: ${Date.now() - start}, ${JSON.stringify(result)}`
  );
}

// test([3, 7], [[1, 2, 3]]);
// test([3, 9], [[1, 2, 3]]);
test([1, 9], [[1, 2, 3]]);
// test([2, 18], []);
// test([8, 36], []);
