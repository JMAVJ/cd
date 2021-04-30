package me.cd.models;

import java.text.SimpleDateFormat;

public class Time implements java.io.Serializable {
	private long start;
	private long stop;
	private float total;
	
	private static final long serialVersionUID = 1L;

	public Time() {
		// TODO Auto-generated constructor stub
		this.start = System.currentTimeMillis();
	}
	
	public float getTotal() {
		if (this.stop == 0L) {
			this.stop = System.currentTimeMillis();
			this.total = (int) (this.stop - this.start)/1000;
		}
		return this.total;
	}
	
	public String getStart() {
		SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss");
		return dt.format(this.start);
	}
	
	public String getStop() {
		SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss");
		return dt.format(this.stop);
	}
	
	public void stop() {
		if (this.stop != 0L) {
			return;
		}
		this.stop = System.currentTimeMillis();
		this.total = (float) (this.stop - this.start)/1000;
	}

}
