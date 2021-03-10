# coding:utf-8
from abc import ABC
from mrjob.job import MRJob
import time
import pymysql


class YearBrandSales(MRJob, ABC):
    def mapper(self, key, value):
        # 业务：基于汽车销售数据统计以年度为统计频度，按汽车品牌统计汇总和汽车类型统计汇总，展示每年品牌销量、每年汽车类型销量前10车型。
        # 数据源：玲丽	510101198208184590	四川省成都市市辖区	17384315802	欧洲	大众	桑塔纳	MNC375D2MN6400602    8.69-11.59万 10.34	[4S]四川精典申众汽车销售服务有限公司	2020/12/30
        # 将数据按空格分割为数组
        salesData = str(value).split("\t")
        # 将年月日时间转换为年月
        ymd = time.strptime(salesData[11], "%Y/%m/%d")
        # 年时间
        y = str(ymd.tm_year)
        # 品牌
        brand = salesData[5]
        key = y + "\t" + brand
        # 以月时间和车辆类型分组，统计销量
        yield key, 1

    container = []

    def reducer(self, key, values):
        keyData = str(key).split("\t")
        self.container.append((keyData[0], keyData[1], sum(values)))
        # 统计同一个月同一个品牌的销售量
        yield key, sum(values)

    # 将数据插入到MySQL数据库中
    def toMySQL(self):
        # 获取对数据库操作权限
        db = pymysql.connect(host="192.168.153.1", port=3306, user="root", passwd="123456", db="xuedao", charset="utf8")
        # 获取对表的操作权限
        cursor = db.cursor()
        sql = "insert into year_brand_sales values(%s, %s, %s)"
        # 解析SQL语句
        cursor.executemany(sql, self.container)
        db.commit()
        db.close()


if __name__ == '__main__':
    mbs = YearBrandSales()
    # 调用MR
    mbs.run()
    # 调用操作数据库方法
    mbs.toMySQL()
