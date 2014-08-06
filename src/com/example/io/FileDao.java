package com.example.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileDao{

	public static List<Integer> inputAsInteger(String fileName) throws IOException {
		return Files.lines(new File(fileName).toPath(), Charset.forName("UTF-8"))
					.filter(s -> !Objects.equals(s, ""))
					.map(s -> Integer.valueOf(s))
					.collect(Collectors.toList());
	}

	public static void output(List<Integer> results, String fileName) throws IOException {
		List<String> xs = results.stream().map(i -> i.toString()).collect(Collectors.toList());
		Files.write(new File(fileName).toPath(), xs, Charset.forName("UTF-8"));
	}
}
