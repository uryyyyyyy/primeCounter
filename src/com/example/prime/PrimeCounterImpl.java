package com.example.prime;

import java.util.stream.Stream;


public class PrimeCounterImpl implements PrimeCounter{

	@Override
	public int countPrimeNumber(int inputNum) {	
		 return (int)Stream.iterate(1, i -> i+1)
			.limit(inputNum-1)
			.filter(i -> isPrime(i))
			.count();
	}

	private boolean isPrime(int n){
		if(n < 2){
			return false;
		}
		for (int i = 2; i * i <= n; i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
}
