package com.example.prime;

public class PrimeCounterImpl2 implements PrimeCounter{

	/**
	 * エラトステネスの篩を愚直に実装しました。
	 * 配列にしたのはメモリに優しいからです。
	 * ただ、1*10^9くらいのinputだと大量のメモリを消費します。
	 * 
	 */
	@Override
	public int countPrimeNumber(int inputNum) {
		boolean[] primeList = new boolean[inputNum];
		int count = 0;
		double checkNumberLimit = Math.sqrt(inputNum);
		for (int num = 2; num <= inputNum-1; num++) {//1は素数でないので除外	
			if (primeList[num] == false) {//未チェックのものがあれば、それは素数である。
				count++;
				if(num <= checkNumberLimit){
					mark(inputNum-1, primeList, num);
				}
			}
		}
		return count;
	}

	private void mark(int inputNum, boolean[] primeList, int i) {
		//素数の倍数は素数でないのでチェック
		for (int j = i; j <= inputNum; j += i) {
			primeList[j] = true;
		}
	}

}
