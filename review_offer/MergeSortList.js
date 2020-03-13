const Resolution = (list1, list2) => {
  if (list1 === null) {
    return list2;
  }

  if (list2 === null) {
    return list1;
  }

  let pre1, pre2, post1, post2, head;

  if (list1.val <= list2.val) {
    pre1 = list1;
    pre2 = list2;
  } else {
    pre1 = list2;
    pre2 = list1;
  }

  head = pre1;

  post1 = pre1;
  post2 = pre2;

  while (post1 !== null && post2 !== null) {
    while (post1 !== null && post1.val <= pre2.val) {
      pre1 = post1;
      post1 = post1.next;
    }

    pre1.next = pre2;

    if (post1 === null) {
      break;
    }

    while (post2 !== null && post2.val <= post1.val) {
      pre2 = post2;
      post2 = post2.next;
    }

    pre2.next = post1;
  }

  return head;
};

// 递归处理
const Resolution2 = (list1, list2) => {
  if (list1 === null) {
    return list2;
  }

  if (list2 === null) {
    return list1;
  }

  if (list1.val <= list2.val) {
    list1.next = Resolution2(list1.next, list2);
    return list1;
  }

  list2.next = Resolution2(list2.next, list1);
  return list2;
}
