package com.makingdevs;

public class StringCalculator {

  public int add(String numbers){
    if(areNotValidNumbers(numbers)) return 0;
    numbers = replaceBreakLinesForCommasFor(numbers);
    return theSumOf(numbers);
  }

  private boolean areNotValidNumbers(String numbers){
    if(!(numbers == null
          || numbers.startsWith(",")
          || numbers.endsWith(",")
          || numbers.contains(",,")
          || numbers.isEmpty())){
      return false;
          }
    return true;
  }

  private String replaceBreakLinesForCommasFor(String numbers){
    return numbers.replaceAll("\n",",");
  }

  private int theSumOf(String numbers){
    int sum = 0;
    String[] arrayOfNumbers = numbers.split(",");
    for(String number : arrayOfNumbers){
      sum += Integer.parseInt(number);
    }
    return sum;
  }
}
