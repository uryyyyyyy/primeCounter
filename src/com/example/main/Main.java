package com.example.main;

import java.util.ArrayList;
import java.util.List;

import com.example.io.NumberWriter;
import com.example.prime.PrimeCounter;
import com.example.prime.PrimeCounterImpl;
import com.example.util.NumberFormatChecker;

public class Main {

	public static void main(String[] args) {
		try{
			final long startTime = System.currentTimeMillis();
			List<Integer> inputs = load(args);
			List<Integer> outputs = execute(inputs);
			write(outputs);

			final long endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime + "ms かかりました。");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("エラーです。ログを確認してください。");
		}
	}

	private static void write(List<Integer> intList) {
		System.out.println("出力値");
		NumberWriter output = new NumberWriter(){

			@Override
			public void writeAll(List<Integer> list) {
				for (Integer i : list) {
					System.out.println(i);
				}
			}
		};
		output.writeAll(intList);
	}

	private static List<Integer> execute(final List<Integer> inputs) {
		final List<Integer> resultList = new ArrayList<Integer>(inputs.size());
		for (Integer num : inputs) {
			PrimeCounter logic = new PrimeCounterImpl();
			int result = logic.countPrimeNumber(num);
			resultList.add(result);
		}
		return resultList;
	}

	private static List<Integer> load(final String[] args) {
		System.out.println("入力値");
		List<Integer> list = new ArrayList<Integer>(args.length);
		for(String arg: args){
			System.out.println(arg);
			list.add(NumberFormatChecker.toInteger(arg));
		}
		return list;
	}

}
