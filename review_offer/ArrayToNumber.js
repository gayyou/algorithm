const Resolution = (strArr) => {
  if (strArr === null) {
    return null;
  }

  strArr.sort((str1, str2) => {
    let newStr1 = str1 + str2;
    let newStr2 = str2 + str1;

    return newStr1 === newStr2 ? 0 : newStr1 > newStr2;
  });

  let result = '';

  strArr.forEach(item => {
    result += item;
  });

  return result;
};
