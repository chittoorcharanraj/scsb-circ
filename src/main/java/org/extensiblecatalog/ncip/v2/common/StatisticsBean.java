package org.extensiblecatalog.ncip.v2.common;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatisticsBean implements ToolkitComponent {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsBean.class);
    public static final String COMPONENT_NAME = StatisticsBean.class.getSimpleName();
    public static final String[] RESPONDER_UNMARSHAL_MESSAGE_LABELS = new String[]{"1", "Unmarshal Message"};
    public static final String[] RESPONDER_CREATE_DATA_LABELS = new String[]{"2", "Create Data From Message"};
    public static final String[] RESPONDER_PERFORM_SERVICE_LABELS = new String[]{"3", "Perform Service"};
    public static final String[] RESPONDER_CREATE_MESSAGE_LABELS = new String[]{"4", "Create Message From Data"};
    public static final String[] RESPONDER_MARSHAL_MESSAGE_LABELS = new String[]{"5", "Marshal Message"};
    public static final String[] RESPONDER_TOTAL_LABELS = new String[]{"6", "Total"};
    public static final String[] INITIATOR_CREATE_MESSAGE_LABELS = new String[]{"1", "Create Message From Data"};
    public static final String[] INITIATOR_MARSHAL_MESSAGE_LABELS = new String[]{"2", "Marshal Message"};
    public static final String[] INITIATOR_SEND_MESSAGE_LABELS = new String[]{"3", "Send Message"};
    public static final String[] INITIATOR_UNMARSHAL_MESSAGE_LABELS = new String[]{"4", "Unmarshal Message"};
    public static final String[] INITIATOR_CREATE_DATA_LABELS = new String[]{"5", "Create Data From Message"};
    public static final String[] INITIATOR_TOTAL_LABELS = new String[]{"6", "Total"};
    protected int maxLabels = 0;
    private static Map<String, StatisticsBean.StatsRecord> statisticsMap = new TreeMap();
    private static final String separator = " ";

    public StatisticsBean() {
    }

    public StatisticsBean(Properties properties) {
    }

    public StatisticsBean(StatisticsBeanConfiguration config) {
    }

    public synchronized void record(long startTime, long endTime, Object... labels) {
        String key = createKey(labels);
        logger.debug(key + ": " + (endTime - startTime) + " milliseconds.");
        this.maxLabels = Math.max(this.maxLabels, this.countLabels(labels));
        StatisticsBean.StatsRecord statsRecord = (StatisticsBean.StatsRecord)statisticsMap.get(key);
        if (statsRecord != null) {
            statsRecord.add(startTime, endTime);
        } else {
            statisticsMap.put(key, new StatisticsBean.StatsRecord(labels, startTime, endTime));
        }

    }

    public int countLabels(Object[] labelArray) {
        int count = 0;
        Object[] var3 = labelArray;
        int var4 = labelArray.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Object obj = var3[var5];
            if (obj != null && obj.getClass().isArray()) {
                Object[] objArray = (Object[])((Object[])obj);
                count += this.countLabels(objArray);
            } else {
                ++count;
            }
        }

        return count;
    }

    public static String createKey(Object[] labels) {
        String key;
        if (labels != null && labels.length != 0) {
            if (labels.length == 1) {
                if (labels[0] != null && labels[0].getClass().isArray()) {
                    key = createKey((Object[])((Object[])labels[0]));
                } else {
                    key = labels[0].toString();
                }
            } else {
                StringBuffer sb = new StringBuffer();
                int stopIndex = labels.length - 1;

                for(int i = 0; i < stopIndex; ++i) {
                    Object label = labels[i];
                    if (label != null && label.getClass().isArray()) {
                        sb.append(createKey((Object[])((Object[])label))).append(" ");
                    } else {
                        sb.append(label).append(" ");
                    }
                }

                sb.append(labels[stopIndex]);
                key = sb.toString();
            }
        } else {
            key = "";
        }

        return key;
    }

    public synchronized long getMaxLabels() {
        return (long)this.maxLabels;
    }

    public synchronized Map<String, StatisticsBean.StatsRecord> getStatsRecords() {
        return new TreeMap(statisticsMap);
    }

    public synchronized void clear() {
        statisticsMap.clear();
        this.maxLabels = 0;
    }

    public String createCSVReport() {
        DecimalFormat formatter = new DecimalFormat("0.00");
        StringBuilder statsReport = new StringBuilder();

        for(long i = 0L; i < this.getMaxLabels(); ++i) {
            statsReport.append("Type").append(",");
        }

        statsReport.append("Count, Total ms.,Average ms.").append(System.getProperty("line.separator"));
        Iterator var8 = this.getStatsRecords().entrySet().iterator();

        while(var8.hasNext()) {
            Entry<String, StatisticsBean.StatsRecord> statRecord = (Entry)var8.next();
            this.buildKeyCSV(statsReport, ((StatisticsBean.StatsRecord)statRecord.getValue()).getLabels());
            if (((StatisticsBean.StatsRecord)statRecord.getValue()).getLabelCount() < this.getMaxLabels()) {
                for(long i = ((StatisticsBean.StatsRecord)statRecord.getValue()).getLabelCount(); i <= this.getMaxLabels(); ++i) {
                    statsReport.append(",");
                }
            }

            float floatAvg = (float)((StatisticsBean.StatsRecord)statRecord.getValue()).getTotalIntervals() / (float)((StatisticsBean.StatsRecord)statRecord.getValue()).getCount();
            statsReport.append(((StatisticsBean.StatsRecord)statRecord.getValue()).getCount()).append(",").append(((StatisticsBean.StatsRecord)statRecord.getValue()).getTotalIntervals()).append(",").append(formatter.format((double)floatAvg)).append(System.getProperty("line.separator"));
        }

        return statsReport.toString();
    }

    private void buildKeyCSV(StringBuilder responseMsg, Object keyPart) {
        if (keyPart != null && keyPart.getClass().isArray()) {
            Object[] keyPartArray = (Object[])((Object[])keyPart);
            Object[] var4 = keyPartArray;
            int var5 = keyPartArray.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Object obj = var4[var6];
                this.buildKeyCSV(responseMsg, obj);
            }
        } else {
            responseMsg.append(keyPart).append(",");
        }

    }

    public class StatsRecord {
        protected Object[] labels;
        protected long count;
        protected long totalIntervals;

        public StatsRecord(Object[] labels, long startTime, long endTime) {
            this.labels = new Object[labels.length];
            System.arraycopy(labels, 0, this.labels, 0, labels.length);
            this.add(startTime, endTime);
        }

        public Object[] getLabels() {
            return this.labels;
        }

        public long getLabelCount() {
            return (long)StatisticsBean.this.countLabels(this.labels);
        }

        public long getCount() {
            return this.count;
        }

        public long getTotalIntervals() {
            return this.totalIntervals;
        }

        public final void add(long startTime, long endTime) {
            ++this.count;
            this.totalIntervals += Math.max(endTime - startTime, 0L);
        }
    }
}
