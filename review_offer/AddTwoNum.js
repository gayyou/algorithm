const Resolution = (n1, n2) => {
  let add, carry;
  do {
    // 首先将不能进位的操作记起来
    add = n1 ^ n2;
    carry = (n1 & n2) << 1;
    n1 = add;
    n2 = carry;
  } while (n2 !== 0);

  return n1;
};
