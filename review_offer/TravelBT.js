const { isUndef, isDef } = require('./Utils');

const example = require('./TestExample');

let BN1 = example.BN1;

console.log(BN1.preOrder(BN1));
console.log(BN1.midOrder(BN1));
console.log(BN1.postOrder(BN1));

