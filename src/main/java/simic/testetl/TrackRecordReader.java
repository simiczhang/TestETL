package simic.testetl;

import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.jeasy.batch.core.reader.RecordReader;
import org.jeasy.batch.core.record.Record;
import org.jeasy.batch.core.record.StringRecord;
import org.json.JSONObject;

public class TrackRecordReader implements RecordReader{
	private JSONObject onlineStatus;
	private URL endpoint;
	private Iterator<String> currentKey;
	
	public TrackRecordReader(URL endpoint) {
		this.endpoint = endpoint;
	}
	
	@Override
	public void open() throws Exception {
		try (InputStream inputStream = endpoint.openStream();) {
			JSONObject payload = new JSONObject(IOUtils.toString(inputStream, "utf-8"));
		    onlineStatus = payload.getJSONObject("data").getJSONObject("values").getJSONObject("Online Status");
		    currentKey = onlineStatus.keys();
		}
	}

	@Override
	public Record readRecord() throws Exception {
		if (!currentKey.hasNext()) {
			return null;
		}
		String key = currentKey.next();
		return new StringRecord(null, key + " " + onlineStatus.getInt(key));
	}

	@Override
	public void close() throws Exception {
	}

}
