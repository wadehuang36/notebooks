/**
 * from https://leetcode.com/problems/4sum/description/
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 */
function fourSum(nums, target) {
  if (nums.length < 4) return [];

  var results = [];
  var size0 = nums.length - 3;
  var size1 = nums.length - 2;
  var v0, v1, v2, v3;

  nums = nums.sort((a, b) => (a < b ? -1 : 1));

  // first two numbers use for loop, last two use binary search
  for (var i0 = 0; i0 < size0; i0++) {
    v0 = nums[i0];
    if (i0 != 0 && v0 == nums[i0 - 1]) continue; // avoid duplicate

    for (var i1 = i0 + 1; i1 < size1; i1++) {
      v1 = nums[i1];
      if (i1 != i0 + 1 && v1 == nums[i1 - 1]) continue; // avoid duplicate

      var l = i1 + 1,
        r = nums.length - 1;
      var t = target - (v0 + v1);

      if (t < nums[l] * 2 || t > nums[r] * 2) {
        continue; // early termination
      }

      while (l < r) {
        (v2 = nums[l]), (v3 = nums[r]);
        var s = v2 + v3;

        if (s == t) {
          results.push([v0, v1, v2, v3]);

          do {
            l++;
          } while (l < r && nums[l] == nums[l - 1]);
        } else if (s < t) {
          l++;
        } else {
          r--;
        }
      }
    }
  }

  return results;
}

// testing
var { expect } = require("code");

test(fourSum([1, 0, -1, 0, -2, 2], 0), [
  [-1, 0, 0, 1],
  [-2, -1, 1, 2],
  [-2, 0, 0, 2]
]);

test(fourSum([-3, -2, -1, 0, 0, 1, 2, 3], 0), [
  [-3, -2, 2, 3],
  [-3, -1, 1, 3],
  [-3, 0, 0, 3],
  [-3, 0, 1, 2],
  [-2, -1, 0, 3],
  [-2, -1, 1, 2],
  [-2, 0, 0, 2],
  [-1, 0, 0, 1]
]);

function test(e, t) {
  expect(e.length).to.equal(t.length);
  expect(e).to.only.includes(t);
}
