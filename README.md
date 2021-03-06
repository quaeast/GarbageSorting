# 北京垃圾分类专家系统 BJFU_AI_实验2

## 项目

### 依赖

[alibaba FastJson](https://www.runoob.com/w3cnote/fastjson-intro.html)

[Lombok](https://projectlombok.org/features/all)

### 运行

```shell script
# test
mvn test

# run
mvn package
java -jar target/GarbageSorting*jar
```

## 北京分类标准

### 垃圾种类

* 厨余垃圾
* 有害垃圾
* 可回收垃圾
* 其他垃圾
### 厨余垃圾（湿垃圾）

#### 特点

* 可以在短时间内自然降解

#### 举例

* 剩饭剩菜
* 果皮树叶
* 骨头菜叶

### 有害垃圾

#### 特点

* 重金属
* 有毒物质
* 危害环境

#### 举例

* 水银温度计
* 过期药品
* 含有有毒有害物质的家电
* 电池
* 荧光灯管
* 灯泡
* 油漆桶
* 过期化妆品
* 汽车

### 可回收垃圾

#### 特点

* 废纸
* 塑料
* 玻璃
* 金属
* 布料

#### 举例

* 报纸、期刊、图书、包装纸（不包括厕纸）
* 塑料袋、塑料泡沫、塑料包装、一次性塑料餐盒餐具、硬塑料、塑料牙刷、塑料杯子、矿泉水瓶（不包括快递包装）
* 玻璃瓶、碎玻璃片、暖瓶（不包括镜子）
* 易拉罐、罐头盒
* 废弃衣服、桌布、洗脸巾、书包、鞋

### 其他垃圾（干垃圾）

#### 特点

* 其他三种垃圾种类之外
* 难以回收

#### 举例

* 卫生纸
* 烟盒
* 快递包装袋
* 镜子
* 尘土
* 大棒骨
