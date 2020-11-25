function printSum(x) {
  var sum = 0;
  for(let i=0; i<=x; i++){
    console.log(i);
    sum += i;
    console.log(sum);
  }
  return sum
}
y = printSum(255) // debería imprimir todos los enteros de 0 a 255 y que cada entero imprima la suma parcial.
console.log(y) // // debería imprimir 32640