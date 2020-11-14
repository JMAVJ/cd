function oddSum() {
  let sum = 0;
  for (let i=1; i<=5000; i++) {
    if (i % 2 == 0) { continue };
    sum += i; 
  }
  return sum;
}

console.log(oddSum());