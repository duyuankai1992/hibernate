�ӳټ���

Session��load()������֧���ӳټ���

<class>Ԫ����
lazy:true/false

<set>
lazy:true/false/extra
ֵextra��hibernate�����ܵķ�����ѯ�������϶����SQL	��䣬
���ֻ��ȡ�����е�size(),�ᷢ��ʹ��count������SQL���

<many-to-one>
<one-to-one>
lazy:false/proxy/no-proxy
no-proxy:�ֽ�����ǿ����֧�ֹ����������Ե��ӳټ��أ�ֻ�з������е����ԣ��ŷ���SQL��䣩


Hibernate���洦��
һ�����棺Session����Ļ��棬���ݱ�ͬһ��session������
* sessionĬ�ϻὫ�������󻺴�(query�ӿ���list()��������֧�ֻ�ȡ��������)

�������棺SessionFactory����Ļ���
������ö������棺
* hibernate�����ļ���
  �򿪶������濪��
  <property name="cache.use_second_level_cache">true</property>
  ָ��ʹ�õĶ������湩Ӧ�� 
 <property name="hibernate.cache.region.factory_class">
 	org.hibernate.cache.ehcache.EhCacheRegionFactory
 </property>
 ����EhCache jar��������EhCache�����ļ�	
  
* ָ����Щ���󱻴洢�ڶ���������
<class>Ԫ���������Ԫ��
<cache usage="read-only"/>








