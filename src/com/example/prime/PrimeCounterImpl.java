package com.example.prime;


public class PrimeCounterImpl implements PrimeCounter{

	/** 
	 * http://qiita.com/Liberty/items/9514f3c29f2ffb5019d5
	 * のアルゴリズムを流用しました。
	 */
	@Override
	public int countPrimeNumber(int inputNum) {
		if(inputNum < 2){
			return 0;
		}

		int count = 1; // 2は予めカウント
		// 2以外の偶数は素数でないので無視
		for (int i = 3; i <= inputNum; i += 2) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	private boolean isPrime(int input){
		for (int i = 2; i * i <= input; i++){
			if(input % i == 0){
				return false;
			}
		}
		return true;
	}
}
