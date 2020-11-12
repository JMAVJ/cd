function largestElement(array){
  let largest = array[0];
  for(let i=1; i<array.length; i++){
    if(array[i] > largest) largest = array[i];
  }
  return largest;
}

console.log(largestElement([1,30,5,7]));