function removeRange(array, from, to) {
  let newArray = [];
  for (let i=0; i<array.length; i++) {
    if (i >= from && i <= to) continue;
    newArray.push(array[i]);
  }
  return newArray;
}

console.log(removeRange([20,30,40,50,60,70],2,4));