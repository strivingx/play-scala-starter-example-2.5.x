package test.zookeeper

import org.apache.zookeeper.client.ZKClientConfig

/*
 ubuntu配置https://blog.csdn.net/Yan_Chou/article/details/53322429
 http://coolxing.iteye.com/blog/1871009
 编码https://www.cnblogs.com/ggjucheng/p/3370359.html
*/
object ZkUtil extends App {
    val zkClient = new ZKClientConfig("127.0.0.1:2181")
    System.out.println("ZooKeeper session established.")
}
