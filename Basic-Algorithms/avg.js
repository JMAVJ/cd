function avg(array) {
  let sum = 0;
  for (let i=0; i<array.length; i++) {
    sum += array[i];
  }
  return sum/array.length;
}

console.log(avg([1,3,5,7,20]));