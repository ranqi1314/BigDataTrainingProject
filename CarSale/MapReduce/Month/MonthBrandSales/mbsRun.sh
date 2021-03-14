HADOOP_CMD="/export/servers/hadoop/bin/hadoop"
STREAM_JAR_PATH="/export/servers/hadoop/share/hadoop/tools/lib/hadoop-streaming-2.8.5.jar"
OUTPUT_PATH="/output/mbs"
# 删除输入目录
$HADOOP_CMD fs -rm -r $OUTPUT_PATH
# 提供python作业
$HADOOP_CMD jar $STREAM_JAR_PATH \
-input "/input/CarSales.txt" \
-output $OUTPUT_PATH \
-mapper "python3 MonthBrandSales.py" \
-file "/BigDataTrainingProject/CarSale/Month/MonthBrandSales/MonthBrandSales.py"
