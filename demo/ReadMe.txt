A.安装opencv
1.创建/usr/local/share/opencv，并将压缩包【opencv-3.2.0.tar.gz】放进去，解压
2.在解压的目录中新建build目录
3.进入build目录，执行【cmake ..】
4.若未安装cmake，用yum安装cmake工具
5.若未安装gcc-c++，用yum安装gcc-c++工具
6.再次执行【cmake ..】
7.若遇到ippicv在线下载不成功，需手动下载【ippicv_linux_20151201.tgz】
  删除先在线未下载完全的压缩包，并将之上传到/usr/local/share/opencv/opencv-3.2.0/3rdparty/ippicv/downloads/linux-808b791a6eac9ed78d32a7666804320e
8.再次执行【cmake ..】
9.在build目录中执行【make -j2】
10.在build目录中执行【make install】
11.添加库路径到系统环境中：【/bin/bash -c 'echo "/usr/local/share/opencv/opencv-3.2.0/build/lib" > /etc/ld.so.conf.d/opencv.conf'】
12.更新环境变量：【ldconfig】
------------------------------------------------------------------------------------------------------------------------------------
B.应用部署
1.将Filter.jar上传至系统。
2.启动：nohup java -jar Filter.jar &
3.服务默认端口9091
4.调用url：http://192.168.88.129:9091/color/colorMapping
  请求类型：POST
  请求参数：originImagePath=/root/zqc.png
			colorMapCode=11
  返回值：{'status': 'ok', 'imgPath': '/home/youn/zqc_11.png'}