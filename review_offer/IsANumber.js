const Resolution = (str) => {
  if (str === null || str.length === 0) {
    return false;
  }

  let eIdx = str.indexOf('e') === -1 ? str.indexOf('E') : str.indexOf('e');

  if (eIdx !== -1) {
    if (eIdx === 0 || eIdx === str.length - 1 || !isNumber(str[eIdx - 1]) || !isNumber(str[eIdx + 1])) {
      return false;
    }
  }
};

function isNumber(char) {
  return char >= '0' && char <= '9';
}
