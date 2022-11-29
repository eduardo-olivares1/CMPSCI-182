import java.util.*;
import java.io.*;

public class WordLadder {
	private static LinkedList<String> dict;
	private static LinkedList<String> visited;
	private static String start, end;

	public static void main(String[] args) throws IOException {
		File dictfile = new File("dictionary.txt");
		File infile = new File("infile.txt");
		dict = new LinkedList<>();
		// load the dictionary
		try (
				Scanner in = new Scanner(dictfile);) {
			while (in.hasNext()) {
				dict.add(in.next());
			}
		}
		try (Scanner in = new Scanner(infile);) {
			while (in.hasNext()) {

				start = in.next();

				end = in.next();

				if (start.length() != end.length() || !dict.contains(start) || !dict.contains(end)) {
					System.out.println("There is no word ladder between " + start + " and " +
							end);
					continue;
				}

				findLadder(start, end);

			}
		}

	}

	public static void findLadder(String start, String end) {
		Queue<Stack<String>> queue = new LinkedList<>();
		visited = new LinkedList<>();
		Stack<String> copiedStack = new Stack<>();

		// Create base stack in queue
		for (int i = 0; i < dict.size(); i++) {
			String currentWord = dict.get(i);
			if (isAnEdge(start, currentWord) && !visited.contains(currentWord)) {
				Stack<String> stack = new Stack<>();
				stack.add(start);
				stack.add(currentWord);
				// Add stacks to smaller queue
				queue.add((Stack<String>) stack.clone());
				visited.add(start);
				visited.add(currentWord);
			}
		}

		while (!queue.isEmpty()) {
			// Remove stack item from queue and use for next word stack
			copiedStack = (Stack<String>) queue.remove().clone();
			String nextWord = copiedStack.peek();

			if (nextWord.equals(end)) {
				System.out.println("Shortest word ladder: " + copiedStack);
				return;
			}

			for (int i = 0; i < dict.size(); i++) {
				String currentWord = dict.get(i);
				// If the current dictionary word is one letter different and hasnt been
				// visited, add to stack
				if (isAnEdge(nextWord, currentWord) && !visited.contains(currentWord)) {
					copiedStack.add(currentWord);
					// Add stacks to smaller queue
					queue.add((Stack<String>) copiedStack.clone());
					visited.add(nextWord);
					visited.add(currentWord);
				}
			}

		}

		System.out.println("There is no word ladder between " + start + " and " + end);

	}

	public static boolean isAnEdge(String w1, String w2) {
		int diffCount = 0;
		for (int i = 0; i < w1.length(); i++) {
			if (w1.charAt(i) != w2.charAt(i)) {
				diffCount += 1;
			}
		}

		if (diffCount == 1) {
			return true;
		} else {
			return false;
		}
	}

}
