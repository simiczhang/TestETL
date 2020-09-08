package simic.testetl;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jeasy.batch.core.job.Job;
import org.jeasy.batch.core.job.JobBuilder;
import org.jeasy.batch.core.job.JobExecutor;
import org.jeasy.batch.core.writer.FileRecordWriter;

public class Launcher {

	public static void main(String[] args) throws IOException {
		Path outputFile = Paths.get("test.output");
		URL url = new URL("http://tracker.mocklab.io/tracks");

		try (JobExecutor jobExecutor = new JobExecutor()) {
			Job job = new JobBuilder().named("Keep Tracking")
					.reader(new TrackRecordReader(url))
					//.mapper(new JsonRecordMapper<>(Track.class))
					.processor(new TrackProcessor())
					.writer(new FileRecordWriter(outputFile)).build();
			jobExecutor.execute(job);
		}
	}
}
