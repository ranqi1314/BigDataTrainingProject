# 数据库设计：

## E-R图：

##### <img src="D:\Users\Ranqi\Desktop\1.png" alt="1" style="zoom:70%;" />

## 各个业务模型表结构如下所示：

#### 1、月品牌销量（柱状图）

create table xuedao.month_brand_sales(

  month varchar(20),     #月时间

  brand varchar(20),     #品牌

  sales_data int       #销量数量，前10

);

 

#### 2、月类型销量详细（饼图）

create table xuedao.month_sales_details(

  month varchar(20),     #月时间

  brand varchar(20),     #品牌

  car_type varchar(20),   #车辆类型

  sales_data int       #销量数量，前10

);

 

#### 3、月类型销量（柱状图）

create table xuedao.month_type_volume(

  month varchar(20),     #月时间

  car_type varchar(20),   #车辆类型

  sales_data int       #销量数量，前10

);

 

#### 4、年品牌销量（柱状图）

create table xuedao.year_brand_sales(

  year varchar(20),     #年时间

  brand varchar(20),     #品牌

  sales_data int       #销量数量，前10

);

 

#### 5、年类型销量（柱状图）

create table xuedao.year_type_volume(

  Year varchar(20),     #年时间

  car_type varchar(20),   #车辆类型

  sales_data int       #销量数量，前10

);

 

#### 6、国籍占比（饼图）

create table xuedao.nationality_ratio(

  month varchar(20),     #月时间

  nationality varchar(20),  #车辆国籍

  proportion double      #占比

);