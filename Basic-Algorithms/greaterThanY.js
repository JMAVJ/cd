function greaterThan(value, array) {
  let count = 0;
  for (let i=0; i<array.length; i++) {
    if (array[i] > value) count++;
  }
  return count;
}

console.log(greaterThan(3, [1,3,5,7]));