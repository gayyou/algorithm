const Resolution = (priceArray) => {
  if (priceArray === null || priceArray.length === 0) {
    return 0;
  }

  let maxProfit = 0, minPrice = Infinity;

  for (let i = 0; i < priceArray.length; i++) {
    minPrice = Math.min(minPrice, priceArray[i]);

    maxProfit = Math.max(maxProfit, priceArray[i] - minPrice);
  }

  return maxProfit;
};
