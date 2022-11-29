public class Word implements Comparable<Word> {
	private String word;
	private int count;

	public Word() {
	}

	public Word(String w, int cnt) {
		// "Implementation left as an exercise";
		this.word = w;
		this.count = cnt;
	}

	public void setWord(String w) {
		// "Implementation left as an exercise";
		this.word = w;
	}

	public String getWord() {
		// "Implementation left as an exercise";
		return this.word;
	}

	public void setCount(int c) {
		// "Implementation left as an exercise";
		this.count = c;
	}

	public int getCount() {
		// "Implementation left as an exercise";
		return this.count;
	}

	@Override /** Override equals defined in Object */
	public boolean equals(Object o) {
		// "Implementation left as an exercise";
		return this.word.equals(o);
	}

	public int compareTo(Word w) {
		// "Implementation left as an exercise";
		return this.word.compareTo(w.getWord());
	}

	public String toString() {
		return word + ":" + count;
	}

}
