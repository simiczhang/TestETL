package simic.testetl;

import java.util.List;

public class Track {
	private Data data;
	private int legend_size;
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public int getLegend_size() {
		return legend_size;
	}
	public void setLegend_size(int legend_size) {
		this.legend_size = legend_size;
	}
}

class Data {
	private List<String> series;
	
	public Data() {
		
	}

	public List<String> getSeries() {
		return series;
	}

	public void setSeries(List<String> series) {
		this.series = series;
	}
}