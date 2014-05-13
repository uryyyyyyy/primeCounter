package com.example.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.example.io.NumberWriter;
import com.example.prime.PrimeCounter;
import com.example.prime.PrimeCounterImpl2;
import com.example.util.NumberFormatChecker;

public class Main {

	public static void main(String[] args) {
		BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				String input = stdReader.readLine();
				if(input == null || input.equals("")){
					break;// terminate application
				}
				execute(input);
			}
		} catch (Exception e) {
			System.out.println("何かエラーがおきました。ログを確認してください");
			e.printStackTrace();
		}
	}

	private static void write(int num) {
		new NumberWriter(){
			@Override
			public void write(int num) {
				System.out.println(num);
			}
		}.write(num);
	}

	private static void execute(final String input) {
		final long startTime = System.currentTimeMillis();
		try{
			//convert
			System.out.println("入力値");
			System.out.println(input);
			int num = NumberFormatChecker.toInteger(input);

			//count
			PrimeCounter primeCounter = new PrimeCounterImpl2();
			int result = primeCounter.countPrimeNumber(num);

			//output
			System.out.println("出力値");
			write(result);
		}catch(NumberFormatException e){
			//continue
			e.printStackTrace();
		}
		final long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime + "ms かかりました。");
	}

}
