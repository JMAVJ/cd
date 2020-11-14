  
function min(array) {
  let min = array[0];
  for(let i=1; i<array.length; i++) {
    if (array[i] < min) min = array[i];
  }
  return min;
}

function max(array) {
  let max = array[0];
  for (let i=1; i<array.length; i++) {
    if (array[i] > max) max = array[i];
  }
  return max;
}

function avg(array) {
  let sum = 0;
  for (let i=0; i<array.length; i++) {
    sum += array[i];
  }
  return sum/array.length;
}

function maxMinAvg (arr) {
  return [max(arr), min(arr), avg(arr)];
}

console.log(maxMinAvg([1,5,10,-2]));