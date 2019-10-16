/**
 * from https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * for example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

var maps = {
  "2": ["a", "b", "c"],
  "3": ["d", "e", "f"],
  "4": ["g", "h", "i"],
  "5": ["j", "k", "l"],
  "6": ["m", "n", "o"],
  "7": ["p", "q", "r", "s"],
  "8": ["t", "u", "v"],
  "9": ["w", "x", "y", "z"]
};

function letterCombinations(digits) {
  if (digits == null || digits.length == 0) return [];

  var lettersList = new Array(digits.length);

  for (let i = 0; i < digits.length; i++) {
    lettersList[i] = maps[digits[i]];
  }

  // console.log(lettersList)

  var result = lettersList[0];
  var previous = lettersList[0];

  for (let cursor = 1; cursor < lettersList.length; cursor++) {
    var current = lettersList[cursor];
    // console.log("previous", previous)
    // console.log("current", current)

    result = new Array(previous.length * current.length);
    var p = 0;
    for (let i = 0; i < previous.length; i++) {
      for (let j = 0; j < current.length; j++) {
        result[p++] = previous[i] + current[j];
      }
    }

    previous = result;
  }

  // console.log("result", result)

  return result;
}

var { expect } = require("code");

expect(letterCombinations("23")).to.only.includes([
  "ad",
  "ae",
  "af",
  "bd",
  "be",
  "bf",
  "cd",
  "ce",
  "cf"
]);
//expect(letterCombinations("233")).to.only.includes(["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"])
