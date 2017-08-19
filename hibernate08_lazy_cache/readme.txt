延迟加载

Session的load()方法，支持延迟加载

<class>元素中
lazy:true/false

<set>
lazy:true/false/extra
值extra，hibernate会智能的发出查询关联集合对象的SQL	语句，
如果只获取集合中的size(),会发送使用count函数的SQL语句

<many-to-one>
<one-to-one>
lazy:false/proxy/no-proxy
no-proxy:字节码增强处理，支持关联对象属性的延迟加载（只有访问类中的属性，才发送SQL语句）


Hibernate缓存处理：
一级缓存：Session级别的缓存，数据被同一个session对象共享
* session默认会将关联对象缓存(query接口中list()方法，不支持获取缓存数据)

二级缓存：SessionFactory级别的缓存
如何配置二级缓存：
* hibernate配置文件，
  打开二级缓存开关
  <property name="cache.use_second_level_cache">true</property>
  指定使用的二级缓存供应商 
 <property name="hibernate.cache.region.factory_class">
 	org.hibernate.cache.ehcache.EhCacheRegionFactory
 </property>
 导入EhCache jar包，创建EhCache配置文件	
  
* 指定哪些对象被存储在二级缓存中
<class>元素中添加子元素
<cache usage="read-only"/>








