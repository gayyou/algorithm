const { isUndef } = require('./Utils');
const ListNode = require('./datastruction/SingleList')

const Resolution = (node) => {
  if (isUndef(node)) {
    return ;
  }

  Resolution(node.next);
  console.log(node.val);
};

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

Resolution(node1)
