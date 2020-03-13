const Resolution = (list) => {
  if (list == null || list.next === null) {
    return null;
  }

  let temp1 = list.next, temp2 = list.next.next;

  while (temp2 !== temp1) {
    temp1 = temp1.next;
    temp2 = temp2.next;

    if (temp2 === null) {
      return null;
    }

    temp2 = temp2.next;
  }

  temp1 = list;

  while (temp1 !== temp2) {
    temp1 = temp1.next;
    temp2 = temp2.next;
  }

  return temp1;
};
