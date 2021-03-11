HADOOP_CMD="/root/software/hadoop-2.6.5/bin/hadoop"
STREAM_JAR_PATH="/root/software/hadoop-2.6.5/share/hadoop/tools/lib/hadoop-streaming-2.6.5.jar"
OUTPUT_PATH="/output/mbs"
# 删除输入目录
$HADOOP_CMD fs -rm -r $OUTPUT_PATH
# 提供python作业
$HADOOP_CMD jar $STREAM_JAR_PATH \
-input "/input/CarSales.txt" \
-output $OUTPUT_PATH \
-mapper "/usr/bin/python3 MonthTypeVolume.py" \
-file "/root/MonthTypeVolume.py"
