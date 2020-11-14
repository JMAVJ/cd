function resetNegatives(array) {
  let newArr = [];
  for (let i=0; i<array.length; i++) {
    if (array[i] < 0) {
      newArr.push(0);
    } else {
      newArr.push(array[i]);
    }
  }
  return newArr;
}

console.log(resetNegatives([1,5,10,-2]));