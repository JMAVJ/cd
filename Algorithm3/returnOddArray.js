function returnOddArray(){
   // your code here
   let oddNumbers = [];
   for(let i=1; i<=255; i++){
    if(i%2 != 0){
      oddNumbers.push(i);
    }
   }
   return oddNumbers;
}
y = returnOddArray();
console.log(y); // should log [1,3,5,...,253,255]