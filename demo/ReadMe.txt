A.��װopencv
1.����/usr/local/share/opencv������ѹ������opencv-3.2.0.tar.gz���Ž�ȥ����ѹ
2.�ڽ�ѹ��Ŀ¼���½�buildĿ¼
3.����buildĿ¼��ִ�С�cmake ..��
4.��δ��װcmake����yum��װcmake����
5.��δ��װgcc-c++����yum��װgcc-c++����
6.�ٴ�ִ�С�cmake ..��
7.������ippicv�������ز��ɹ������ֶ����ء�ippicv_linux_20151201.tgz��
  ɾ��������δ������ȫ��ѹ����������֮�ϴ���/usr/local/share/opencv/opencv-3.2.0/3rdparty/ippicv/downloads/linux-808b791a6eac9ed78d32a7666804320e
8.�ٴ�ִ�С�cmake ..��
9.��buildĿ¼��ִ�С�make -j2��
10.��buildĿ¼��ִ�С�make install��
11.��ӿ�·����ϵͳ�����У���/bin/bash -c 'echo "/usr/local/share/opencv/opencv-3.2.0/build/lib" > /etc/ld.so.conf.d/opencv.conf'��
12.���»�����������ldconfig��
------------------------------------------------------------------------------------------------------------------------------------
B.Ӧ�ò���
1.��Filter.jar�ϴ���ϵͳ��
2.������nohup java -jar Filter.jar &
3.����Ĭ�϶˿�9091
4.����url��http://192.168.88.129:9091/color/colorMapping
  �������ͣ�POST
  ���������originImagePath=/root/zqc.png
			colorMapCode=11
  ����ֵ��{'status': 'ok', 'imgPath': '/home/youn/zqc_11.png'}