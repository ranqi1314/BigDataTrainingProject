# coding:utf-8
from abc import ABC
from mrjob.job import MRJob
import time
import pymysql


class MonthBrandSales(MRJob, ABC):
    def mapper(self, key, value):
        # 业务：基于汽车销售数据统计以月度为统计频度，按月和汽车品牌统计汇总，展示每个月品牌销量前10的汽车品牌销量数据，并提供钻取指定品牌当月的其它车型销售数据。 数据源：玲丽	510101198208184590
        # 四川省成都市市辖区	17384315802	欧洲	大众	桑塔纳	MNC375D2MN6400602	8.69-11.59万 10.34	[4S]四川精典申众汽车销售服务有限公司
        # 2020/12/30 将数据按空格分割为数组
        salesData = str(value).split("\t")
        # 将年月日时间转换为年月
        ymd = time.strptime(salesData[11], "%Y/%m/%d")
        ym = str(ymd.tm_year) + "-" + str(ymd.tm_mon)
        brand = salesData[5]
        key = brand + "\t" + ym
        # 以月时间、品牌分组，统计销量
        yield key, 1

    container = []

    def reducer(self, key, values):
        keyData = str(key).split("\t")
        self.container.append((keyData[1], keyData[0], sum(values)))
        # 统计同一个月，同一个品牌的销售量
        yield key, sum(values)

    # 将数据插入到MySQL数据库中
    def toMySQL(self):
        # 获取对数据库操作权限
        db = pymysql.connect(host="192.168.153.1", port=3306, user="root", passwd="123456", db="xuedao", charset="utf8")
        # 获取对表的操作权限
        cursor = db.cursor()
        sql = "insert into month_brand_sales values(%s, %s, %s)"
        # 解析SQL语句
        cursor.executemany(sql, self.container)
        db.commit()
        db.close()


if __name__ == '__main__':
    mbs = MonthBrandSales()
    # 调用MR
    mbs.run()
    # 调用操作数据库方法
    mbs.toMySQL()
