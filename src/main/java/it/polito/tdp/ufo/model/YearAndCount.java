package it.polito.tdp.ufo.model;

public class YearAndCount {
	private int anno;
	private int count;
	public YearAndCount(int anno, int count) {
		super();
		this.anno = anno;
		this.count = count;
	}
	public int getAnno() {
		return anno;
	}
	public int getCount() {
		return count;
	}
	@Override
	public String toString() {
		return  anno + " , " + count;
	}

}
