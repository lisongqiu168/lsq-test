//package com.lsq.service.zk;
//
//import java.util.List;
//
//import org.I0Itec.zkclient.IZkChildListener;
//import org.I0Itec.zkclient.IZkDataListener;
//import org.I0Itec.zkclient.ZkClient;
//import org.I0Itec.zkclient.serialize.SerializableSerializer;
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.data.Stat;
//
//public class ZkService {
//
//	public static void main(String[] args) {
//		String ZKServers = "127.0.0.1:2181";
//		ZkClient zkClient = new ZkClient(ZKServers, 10000, 10000,
//				new SerializableSerializer());
//
//		//zkClient.create("/lisongqiu", "/test", CreateMode.PERSISTENT);
//		zkClient.subscribeChildChanges("/lisongqiu", new IZkChildListener() {
//			
//			@Override
//			public void handleChildChange(String parentPath, List<String> currentChilds)
//					throws Exception {
//				System.out.println("==========");
//				System.out.println(parentPath);
//			}
//		});
//		
//		zkClient.subscribeDataChanges("/lisongqiu", new IZkDataListener() {
//			
//			@Override
//			public void handleDataDeleted(String dataPath) throws Exception {
//				System.out.println("delete");
//			}
//			
//			@Override
//			public void handleDataChange(String dataPath, Object data) throws Exception {
//				System.out.println("change");
//			}
//		});
//		
//		zkClient.create("/lisongqiu", "test", CreateMode.EPHEMERAL_SEQUENTIAL);
//	}
//}
