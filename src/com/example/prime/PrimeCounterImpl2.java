package com.example.prime;

public class PrimeCounterImpl2 implements PrimeCounter{

	/**
	 * エラトステネスの篩を愚直に実装しました。
	 * 配列にしたのはメモリに優しいからです。
	 * 
	 * 
	 */
	@Override
	public int countPrimeNumber(int inputNum) {
		boolean[] primeList = new boolean[inputNum + 1];
		int count = 0;
		for (int i = 2; i <= inputNum; i++) {//1は素数でないので除外	
			if (primeList[i] == false) {//未チェックのものがあれば、それは素数である。
				count++;
				
				//素数の倍数は素数でないのでチェック済み
				for (int j = i; j <= inputNum; j += i) {
					primeList[j] = true;
				}
			}
		}
		return count;
	}

}
