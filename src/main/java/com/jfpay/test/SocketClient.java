package com.jfpay.test;


import com.jfpay.core.domain.to.ReceiveDataTO;
import com.jfpay.core.util.JsonUtil;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SocketClient {
	private static Logger logger = LoggerFactory.getLogger(SocketClient.class);

	public static void main(String args[]) {
		ThreadTest t = new ThreadTest();
		//这里是以秒为单位的时间,表示循环测试的时间
		t.m();

//		Date start = new Date();
//		ReceiveDataTO r=new ReceiveDataTO();
//		Map<String,Object> map=new HashMap<>();
//		map.put("abc","123");
//		map.put("sss","sdfsadjfksdalkfjkasdljfklsdjfhsdjafklsdfjksdlafkjasdklfjlksdjflkasdjklfjsadkjfklsadjfkljasdlkjfklsdajflkjasdklfjklasdjf" +
//				"jfklsdjfklsdjfkljsdklfjskldjfjksdahgklasdjflkdsklfjksdljflasdjlfkjsdaljfsdlkfjlksdhgklsdajfasdf" +
//				"dlfkjsdklhfgklsdhgkljsadklfjsdlkjhflksadjflksadghjklsdaghklasdjfjkhasdjfkgashfksdajflkasdjlghasdhghjas" +
//				"fsdjlkfhsdhjgjksdhalkfjdsjkghfasdlkjfdasihgkjasdjfjkdshfsdjkfsdhglkasdg" +
//				"sldkfhksdjhglsdjkfujeiojfklasjxnvildkvhklsjdfgnsagbsdkljhgklegujgndklvjsdiogjeklghsdalkjfasd" +
//				"gjhkdlshgbsdkghfjeiojgkldjklvhdjkvbkldsjl;asdklfjpioewujklwafndskjavkljsdjhklgjsdakljgfklsdjfopewjfklwjflkasdf" +
//				"jsdlkvgbhdsfbnvjkfdhieosfujioewjfklasdjfkldsanvjkdsjvlkdasjflkdsjaklfvndklsfjsdalkjfopeijfkasdjf" +
//				"asdfgnkdlsjgkldsnvjfkdbvnjfkvjkfdnvuidfjklsdajfklejoifwnklenfsedjfklsdajl;ahsdgvkldnvdskjjacioef" +
//				"afjkldsgjklsdjgkldsjfiohdskjlgfksdlfjdskvckfdnvjflkjflkasdjfoiwqajq;fkl;sajdfioenlkahfjdsnmvkjhdklsjfioaejnl;afjsdpofwajeklfjasoijfeaw" +
//				"dsjklghdasjknfgsdjkldsajfkldsnklvgjsdlakfjasdljfiopwejlfkajsdklfjioejlak;jsdiofdjslkjflkasjdfoiweajlk;fjals;d" +
//				"fsdjflsadjgoiasdjfeaoifaljjdlifjeaklsjfoidsjaklf;asdjklfjasdl;ujfgseaklghsdklanfasdjflkasdjfoiawe" +
//				"dsalkjfgdlskaghdksjanfkjdsfklsdjafioaejlkfjdskljfkleasjfioaesjklsdjfklasdhnfkldsjakfljdsaklfnlejafklsjdfkl;asd" +
//				"jklsdajgdsiafujklejfaiosdjklfjsdklajfailsdjfeionaklndjkvcxhjvbnmcxvbmcxzbvnmzklfjsdajfiowqeklqjflkqjwekfjdasiofjweklfa" +
//				"sdfjklsdgjiodsafjkleajflkasdjfnsdavdfsjkjkdfjownfdsjkvnisdjfoidsuifowejfndsjkfbdnmsfbewkjaksjfhklejasbnfdsjkbfejklafjioejklsnfjkdajfkldsjfenaljkfdsa" +
//				"jskdlgjasdklfnekjlhfakljdskfndsjkvbdfsjklsdjfienflkasjdvndiosvjeklrfasnkejnfdsasdafkdasfljasd" +
//				"gjkadsjflkasdjfiopejaklfndsjkvhkldsjfvasdofjvklsdajvas" +
//				"fvjklasdjvkldasjvklsdajvklasdjviosdavjklasdjhvioasdjvkldasuvioadsjvklbhdjkzxcbvjhruisyvherwkljhvklsajvlasdkjfgas" +
//				"vdjiocvdsaklvjdklsajvdfkasdjfkljdsaklgjiodfsgvm,nfdjbvklcxjkbvjlkxcj" +
//				"asgfjikosdgubfsdkljgkldasjfioasdjfklwejkfbasdkjgklsdfjbviofudvbkljsdfaas" +
//				"fweklgfkasebgfbasdmnfhbhjkweahfasebfnmbasdm,fbmwehfklajseguidojvklcxjvioxzcuvlkjzxciovuxciolzjvlzxcv" +
//				"ewjfklwesfbjksdbfgjdbgjmdns,mfndask,jfnkl;dasjviosdfjvlkxdjcvilkujcxiovjkledrhvgbjkerbjkhfgdaslkjfasd" +
//				"gvjiodsfuvgcxkljviopcxuvklzxcjiovjcxkl;zujvio;lzxcujviopzcxujvkl;zxcuviojerlkhfgkasdjjflk;asdjiolvucx" +
//				"sdjklgufvidovjilc;xuvlxckjvioprejvkldsfajviopasdujflksduaiojsdvkljxcioxcjviopzxcuvolcxzjvlk;jxczv");
//		r.setHead("testMethodrhdf");
//		r.setHead("getRejectinfoListByObj");
//		r.setParams(map);
//		String s= JsonUtil.toJson(r);
//		logger.info(s);
//		SocketClient.sendSocketMsg("127.0.0.1", 8000,s.getBytes());
//		Date end = new Date();
//		int seconds = SocketClient.getSeconds(start, end);
//		logger.info("-------耗时{}s",seconds);

//		String path = "/imp/imp-audit.TCP";
//		ZkClient zkClient = new ZkClient("192.168.1.74:2181,192.168.1.75:2181", 60000, 1000);
//		List<String> childs = zkClient.getChildren(path);
//		for(String p : childs) {
//			logger.info(p);
//			logger.info((String)zkClient.readData(path + "/" + p));
//		}
//		//订阅节点变化事件
//
//		zkClient.subscribeChildChanges(path, new IZkChildListener() {
//			@Override
//			public void handleChildChange(String s, List list) throws Exception {
//
//				logger.info("zk子节点变化:path={},currtentChilds={}",s,list);
//			}
//		});
//
//		zkClient.subscribeChildChanges("/imp/imp-audit.THRIFT", new IZkChildListener() {
//			@Override
//			public void handleChildChange(String s, List list) throws Exception {
//
//				logger.info("zk子节点变化:path={},currtentChilds={}",s,list);
//			}
//		});
//		Scanner reader=new Scanner(System.in);
//		if(reader.hasNext()){
//			System.exit(0);
//		}

	}


	public static int getSeconds(Date startdate, Date enddate) {
		long time = enddate.getTime() - startdate.getTime();
		int totalS = new Long(time / 1000).intValue();
		return totalS;
	}



	public static String sendSocketMsg(String ip, int port, String msg) {

		// 1.建立客户端socket连接，指定服务器位置及端口
		Socket socket = null;
		// 2.得到socket读写流
		OutputStream os = null;
		PrintWriter pw = null;
		// 输入流
		InputStream is = null;
		BufferedReader br = null;
		try {
			msg = URLEncoder.encode(msg, "UTF-8") + "\r\n";
			socket = new Socket(ip, port);
			socket.setSoTimeout(30000);
			os = socket.getOutputStream();
			is = socket.getInputStream();
			ByteBuffer header = ByteBuffer.allocate(4);
			header.putInt(msg.getBytes().length);
			os.write(header.array());
			os.write(msg.getBytes());
//			pw = new PrintWriter(os);
			br = new BufferedReader(new InputStreamReader(is));
			// 3.利用流按照一定的操作，对socket进行读写操作
//			String info = msg;
//			pw.write(URLEncoder.encode(info, "UTF-8") + "\r\n");
			os.flush();
			socket.shutdownOutput();
			// 接收服务器的相应
			String reply = null;
			StringBuffer infoS = new StringBuffer("");
			while (!((reply = br.readLine()) == null)) {
				// System.out.println("接收服务器的信息："+reply);
				// System.out.println("----------------------------"+reply);
				infoS.append(reply + "\n");
				if (reply.indexOf("^JFPAL***END^") > -1) {
					System.out.println("跳出");
					break;
				}
			}
//			String returnInfo = infoS.substring(0,
//					infoS.indexOf("^JFPAL***END^"));
//			if (returnInfo == null || "".equals(returnInfo)) {
//				logger.error("socket返回空:【" + msg + "】");
//				return "";
//			}
			return infoS.toString();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("socket通讯异常:【" + msg + "】" + e.toString());
			return "";
		} finally {
			try {
				br.close();
				is.close();
				pw.close();
				os.close();
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				logger.error("socket关闭异常:【" + msg + "】" + e2.toString());
			}
		}
	}

	public static void sendSocketMsg(String ip, int port, byte[] msg) {
		try {
			BufferedReader br = null;
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(ip, port));
			socket.setKeepAlive(true);
			OutputStream out = socket.getOutputStream();
			ByteBuffer header = ByteBuffer.allocate(4);
			header.putInt(msg.length);
			out.write(header.array());
			out.write(msg);
			out.flush();
			InputStream in = socket.getInputStream();
//			byte[] buff = new byte[4096*1024];
//			int readed = in.read(buff);
//			if (readed > 0) {
//				String str = new String(buff, 4, readed);
//				logger.info("client received msg from server:" + str);
//			}
			br = new BufferedReader(new InputStreamReader(in));
			// 3.利用流按照一定的操作，对socket进行读写操作
//			String info = msg;
//			pw.write(URLEncoder.encode(info, "UTF-8") + "\r\n");
			socket.shutdownOutput();
			// 接收服务器的相应
			String reply = null;
			StringBuffer infoS = new StringBuffer("");
			while (!((reply = br.readLine()) == null)) {
				// System.out.println("接收服务器的信息："+reply);
				// System.out.println("----------------------------"+reply);
				infoS.append(reply + "\n");
//				if (reply.indexOf("^JFPAL***END^") > -1) {
//					System.out.println("跳出");
//					break;
//				}
			}
			logger.info(infoS.toString().substring(4));
			out.close();
			br.close();
			in.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}