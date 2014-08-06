package com.example.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.io.FileDao;
import com.example.prime.PrimeCounter;
import com.example.prime.PrimeCounterImpl2;

public class Main {
	
	private static final String INPUT_FILEPATH = "primenumber.txt";
	private static final String OUTPUT_FILEPATH = "output.txt";
	
	public static void main(String[] args) throws IOException {
		List<Integer> numbers = FileDao.inputAsInteger(INPUT_FILEPATH);
		PrimeCounter pc = new PrimeCounterImpl2();
		List<Integer> results = numbers.stream()
				.collect(() -> new ArrayList<>(), 
						(l, t) -> l.add(pc.countPrimeNumber(t)), 
						(l, t) -> l.addAll(t)
					);
		FileDao.output(results, OUTPUT_FILEPATH);
	}

}
