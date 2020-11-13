function replaceNegatives(array, string) {
  let newArray = [];
  for (let i=0; i<array.length; i++) {
    if (array[i] < 0) {
      newArray.push(string);
    } else {
      newArray.push(array[i]);
    }
  }
  return newArray;
}

console.log(replaceNegatives([1,2,-3,-5,5], 'Dojo'));