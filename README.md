# 一、简介
此JAVA-CTPAPI是用swig方法在官方C++ API上编译得到，完全开源，有兴趣可以参考笔者文章[《CTP JAVA API(JCTP)编译（利用Swig封装C++动态库）windows版》](https://blog.csdn.net/pjjing/article/details/77338423)或文章[《CTP JAVA API(JCTP) 64位 2in1及CTP JAVA订阅全市场行情DEMO》](https://blog.csdn.net/pjjing/article/details/85063988)自行编译实现。此方法编译得到的API在数据结构，参数名，函数名及用法上与C++版API完全一致，可以参考官方开发文档，十分容易上手。
**编译维护不易，欢迎大家star, fork鼓励。**

# 二、文件清单
- 6.3.13_20181119  
穿透式评测版，用于正式生产接入前期货公司评测，和官方C++ API一一对应。穿透式流程详见文章[《什么是穿透式监管，需要投资者做什么？》](https://blog.csdn.net/pjjing/article/details/90141906)
- 6.3.13_20181119_2_in_1  
官方C++ API分为行情API和交易API两个，有一些共同的头文件，单独封装后java文件有不少重复。这个版本将两个API封装到一个jar包中，去除了重复文件。  
如果需要单独使用交易或者行情API，可以用上个文件夹中的单独版本。如果交易行情都需要用，可以考虑使用这个版本。
- 6.3.15_20190220 及 6.3.15_20190220_2_in_1  
文件夹的区分同上面6.3.13版本。这个版本是最新的穿透式生产版本，正式接入交易使用。**对接simnow也使用此版本**。
- demo  
使用6.3.15_20190220版本，是windows下eclipse工程。  
mdapi中提供了链接，登录，订阅1个合约，收取行情功能。  
tradeapi中提供了链接，认证（即穿透式监管），登录，查询结算单功能。
- 2in1demo  
使用6.3.15_20190220_2_in_1版本，是windows下eclipse工程。  
demo提供了交易api认证登录，查询全部合约，行情api订阅全部合约行情，收取行情的功能。  
注意：demo使用时需要正确替换demo中userid，password等信息。


# 三、常见问题
## 1. "java.lang.UnsatisfiedLinkError: no thostmduserapi in java.library.path"
将动态库拷贝到你电脑环境变量path路径底下，如果自己不清楚，可以在Java中用如下代码获得
```
System.out.println(System.getProperty("java.library.path"));
```

## 2. "UnsatisfiedLinkError: ...thostmduserapi_wrap.dll: Can't find dependent libraries"
windows下wrap.dll本身依赖vs再编译时的一些dll，可以使用dll依赖工具看下依赖下载，一般是缺msvcr120.dll。或者直接百度搜索"微软常用运行库合集64位"安装。

## 3."UnsatisfiedLinkError: ... .thosttradeapiJNI.swig_module_init()V"
swig命令生成时指定的jar包路径要与实际使用中，java工程中jar包import路径一致。

## 4.订阅成功但是没收到行情
参见[《CTP程序化交易入门系列之四：行情订阅常见问题解答》](https://blog.csdn.net/pjjing/article/details/100532276)。

# 四、欢迎交流
欢迎扫二维码关注或者搜索程序化交易入门(QuantRoad2019)，一起学习程序化交易！
![image](https://img-blog.csdnimg.cn/20190520205748924.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lpc2h1aWhhbjEyMTI=,size_16,color_FFFFFF,t_70)

QQ交流群（767101469），一起讨论程序化交易！  
![image](https://img-blog.csdnimg.cn/20191005173130764.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lpc2h1aWhhbjEyMTI=,size_16,color_FFFFFF,t_70)

