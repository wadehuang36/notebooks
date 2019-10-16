/**
 * from https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 **/
function removeNthFromEnd(head, n) {
  var list = [];
  var node = head;
  while (node != null) {
    list.push(node);
    node = node.next;
  }

  var i = list.length - n;

  if (i == 0) {
    head = list[i].next;
  } else {
    list[i - 1].next = list[i].next;
  }

  return head;
}

// testing
var { expect } = require("code");

function test(input, n, should) {
  var result = removeNthFromEnd(generate(input), n);

  expect(flat(result)).to.equal(should.toString());
}

function generate(input) {
  var head;
  var parent;

  for (const i of input) {
    var node = {
      val: i
    };

    if (parent == null) {
      head = node;
    } else {
      parent.next = node;
    }

    parent = node;
  }

  return head;
}

function flat(head) {
  var arr = [];
  var node = head;
  while (node != null) {
    arr.push(node.val);
    node = node.next;
  }

  return arr.toString();
}

test([1], 1, []);

test([1, 2, 3, 4, 5], 2, [1, 2, 3, 5]);

test([1, 2], 2, [2]);

test([1, 2], 1, [1]);
