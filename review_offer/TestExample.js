const BinaryNode = require('./datastruction/BinaryNode');
const ListNode = require('./datastruction/SingleList');

let node1 = new ListNode(1);
let node2 = new ListNode(2);
let node3 = new ListNode(3);
let node4 = new ListNode(4);
let node5 = new ListNode(5);
let node6 = new ListNode(6);
let node7 = new ListNode(7);

node1.next = node2;
node2.next = node3;
node3.next = node4;
node4.next = node5;
node5.next = node6;
node6.next = node7;

let BN1 = new BinaryNode(6);
let BN2 = new BinaryNode(1);
let BN3 = new BinaryNode(12);
let BN4 = new BinaryNode(0);
let BN5 = new BinaryNode(3);
let BN6 = new BinaryNode(10);
let BN7 = new BinaryNode(13);
let BN8 = new BinaryNode(4);
let BN9 = new BinaryNode(14);
let BN10 = new BinaryNode(20);
let BN11 = new BinaryNode(16);
let BN12 = new BinaryNode(2);
let BN13 = new BinaryNode(5);
let BN14 = new BinaryNode(11);
let BN15 = new BinaryNode(15);

BN1.left = BN2;
BN1.right = BN3;
BN2.left = BN4;
BN2.right = BN5;
BN3.left = BN6;
BN3.right = BN7;
BN6.left = BN8;
BN6.right = BN9;
BN7.left = BN10;
BN7.right = BN11;
BN8.left = BN12;
BN8.right = BN13;
BN9.left = BN14;
BN9.right = BN15;

module.exports = {
  SN1: node1,
  BN1
};
