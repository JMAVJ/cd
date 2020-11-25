function printUpTo(x) {
  if (x<0) {
    console.log('Número Negativo');
    return false;
  }
  for(let i=1; i<=x; i++){
    console.log(i);
  }
}

printUpTo(1000); // debería imprimir todos los enteros de 1 to 1000
y = printUpTo(-10); // debería imprimir false
console.log(y); // debería imprimir false