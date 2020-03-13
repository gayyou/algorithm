const Resolution = (list) => {
  if (list == null) {
    return null;
  }

  let pre, cur, next;

  pre = null;
  cur = list;

  while (cur !== null) {
    next= cur.next;
    cur.next = pre;
    [pre, cur] = [cur, pre];
  }

  return pre;
};
