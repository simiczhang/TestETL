package simic.testetl;

import org.jeasy.batch.core.processor.RecordProcessor;
import org.jeasy.batch.core.record.Record;
import org.jeasy.batch.core.record.StringRecord;

public class TrackProcessor implements RecordProcessor<StringRecord, StringRecord> {

    @Override
    public StringRecord processRecord(StringRecord record) {
       return record;
    }
}