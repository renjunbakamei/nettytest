package com.jfpay.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpURLRequestUtil {
	private final static Logger log = LoggerFactory
			.getLogger(HttpURLRequestUtil.class);

	// HTTP GET request
	/**
	 * 
	 * @param url
	 * @param reqKey
	 * @param reqVal
	 * @return
	 * @throws Exception
	 */
	public static String sendGet(String url, String reqKey, String reqVal)
			throws Exception {
		String req = url + "?" + reqKey + "=" + reqVal;
		URL obj = new URL(req);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//		con.setConnectTimeout(30000);
//		con.setReadTimeout(30000);
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept-Charset", "UTF-8");
		con.setRequestProperty("contentType", "UTF-8");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

	/**
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public static String sendGet(String url, Map<String, String> params)
			throws IOException {

		String req = url + "?";
		String urlParameters = "";

		for (Map.Entry<String, String> param : params.entrySet()) {
			System.out.println("Key = " + param.getKey() + ", Value = "
					+ param.getValue());
			String tmpParam = param.getKey() + "="
					+ URLEncoder.encode(param.getValue(), "UTF-8") + "&";
			urlParameters += tmpParam;
		}
		urlParameters = urlParameters
				.substring(0, (urlParameters.length() - 1));

		URL obj = new URL(req + urlParameters);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept-Charset", "UTF-8");
		con.setRequestProperty("contentType", "UTF-8");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

	// HTTP POST request
	/**
	 * 
	 * @param url
	 * @param reqKey
	 * @param reqVal
	 * @return
	 * @throws IOException
	 */
	public static String sendPost(String url, String reqKey, String reqVal)
			throws IOException {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		// con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Charset", "UTF-8");
		con.setRequestProperty("contentType", "UTF-8");

		String urlParameters = reqKey + "=" + reqVal;
		System.out.println("request=============:" + urlParameters);
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

	// HTTP POST request

	/**
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public static String sendPost(String url, Map<String, Object> params)
			throws IOException {
	    HttpURLConnection con =null;
	    try {
	        URL obj = new URL(url);
	        con =(HttpURLConnection) obj.openConnection();
	        con.setRequestMethod("POST");
	        con.setRequestProperty("Accept-Charset", "UTF-8");
	        con.setRequestProperty("contentType", "UTF-8");
	        String urlParameters = "";
	        for (Map.Entry<String, Object> param : params.entrySet()) {
	            System.out.println("Key = " + param.getKey() + ", Value = "
	                    + param.getValue());
	            String tmpParam = param.getKey() + "="
	                    + URLEncoder.encode((String)param.getValue(), "UTF-8") + "&";
	            urlParameters += tmpParam;
	        }
	        urlParameters = urlParameters
	                .substring(0, (urlParameters.length() - 1));
	        con.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	        wr.writeBytes(urlParameters);
	        wr.flush();
	        wr.close();
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                con.getInputStream(), "UTF-8"));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();
	        return response.toString();
        } catch (Exception e) {
            e.getStackTrace();
            log.error("HTTP error",e);
        }finally{
            if(con !=null){
                con.disconnect();
            }
        }
        return null;
	}
	
//	/**
//	 * 请求POST
//	 * @param url
//	 * @param requestParams
//	 * @return
//	 */
//	public static String sendHttpPostXml(String url,Object requestParams) {
//		// post请求返回结果
//		String respResult = null;
//		DefaultHttpClient httpClient = new DefaultHttpClient();
//		log.info("发送的请求地址=="+url);
//		log.info("发送的请求参数=="+requestParams);
//		try {
//			HttpPost method = new HttpPost(url);
//			if (null != requestParams) {
//				// 解决中文乱码问题
//				StringEntity entity = new StringEntity(requestParams.toString(),"utf-8");
//				entity.setContentEncoding("UTF-8");
//				entity.setContentType("application/xml");
//				method.setEntity(entity);
//			}
//			httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 50000);
//			httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 50000);
//			HttpResponse result = httpClient.execute(method);
//			url = URLDecoder.decode(url, "UTF-8");
//			/** 请求发送成功，并得到响应 **/
//			if (result.getStatusLine().getStatusCode() == 200) {
//				try {
//					/** 读取服务器返回字符串数据 **/
//					respResult = EntityUtils.toString(result.getEntity());
//				} catch (Exception e) {
//					log.error("post请求提交失败:" + url, e);
//				}
//			}
//		} catch (IOException e) {
//			log.error("post请求提交失败:" + url, e);
//		} catch (Exception e) {
//			log.error("post请求提交失败:" + url, e);
//		}
//		return respResult;
//	}

	/**
	 * 请求发送
	 * 
	 * @author herion 2014-12-29下午5:05:10
	 * @param callURL
	 * @param postData
	 * @return
	 */
	public static String send(String callURL, String postData) {
		log.info("call url is:" + callURL);
		HttpURLConnection connection = null;
		try {
			URL url = new URL(callURL);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type",
					"application/json;charset=UTF-8");
			connection.connect();
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.write(postData.getBytes("UTF-8"));
			out.flush();
			out.close();
			int rc = connection.getResponseCode();
			// 响应成功
			if (rc == 200) {
				String temp;
				InputStream in = null;
				in = connection.getInputStream();
				BufferedReader data = new BufferedReader(new InputStreamReader(
						in, "utf-8"));
				StringBuffer result = new StringBuffer();
				while ((temp = data.readLine()) != null) {
					result.append(temp);
					temp = null;
				}
				log.info("send message end,and the result is :"
						+ result.toString());
				data.close();
				in.close();
				return result.toString();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null){
				connection.disconnect();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public static String sendPostMap(String url, Map<String, Object> params)
			throws IOException {

		HttpURLConnection con =null;
		try {
			URL obj = new URL(url);
			con =(HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Charset", "UTF-8");
			con.setRequestProperty("contentType", "UTF-8");
			String urlParameters = "";
			for (Map.Entry<String, Object> param : params.entrySet()) {
				System.out.println("Key = " + param.getKey() + ", Value = "
						+ param.getValue());
				String tmpParam = param.getKey() + "="
						+ URLEncoder.encode((String)param.getValue(), "UTF-8") + "&";
				urlParameters += tmpParam;
			}
			urlParameters = urlParameters
					.substring(0, (urlParameters.length() - 1));
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		} catch (Exception e) {
			e.getStackTrace();
			log.error("HTTP error",e);
		}finally{
			if(con !=null){
				con.disconnect();
			}
		}
		return null;
	}

    public static String sendPostGBK(String url, String reqKey, String reqVal)  throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Charset", "GBK");
        con.setRequestProperty("contentType", "GBK");
        String urlParameters = reqKey + "=" + reqVal;
        System.out.println("request=============:" + urlParameters);
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(), "GBK"));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

	public static String reqPost(Map<String,Object> params, String ip) throws
			IOException {
		HttpURLConnection urlCon = null;
		BufferedReader in = null;
		StringBuilder builder = new StringBuilder();
		String paras="";
		for (Map.Entry<String, Object> param : params.entrySet()) {
			System.out.println("Key = " + param.getKey() + ", Value = "
					+ param.getValue());
			String tmpParam = param.getKey() + "="
					+ (String)param.getValue()+ "&";
			paras += tmpParam;
		}
		paras = paras
				.substring(0, (paras.length() - 1));
		System.out.println(paras);
		urlCon = (HttpURLConnection) (new URL(ip)).openConnection();
		urlCon.setDoInput(true);
		urlCon.setDoOutput(true);
		urlCon.setRequestMethod("POST");
		urlCon.setRequestProperty("Content-Length", String.valueOf(paras.getBytes().length));
		urlCon.setUseCaches(false);
		// 设置为gbk可以解决服务器接收时读取的数据中文乱码问题
		urlCon.getOutputStream().write(paras.getBytes("UTF-8"));
		urlCon.getOutputStream().flush();
		urlCon.getOutputStream().close();
		in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

		String line;
		while ((line = in.readLine()) != null) {
			builder.append(line);
		}

		return builder.toString();

	}

	/**
	 * 请求发送
	 *
	 * @author herion 2014-12-29下午5:05:10
	 * @param callURL
	 * @param postData
	 * @return
	 */
	public static String sendNotJson(String callURL, String postData) {
		log.info("call url is:" + callURL);
		HttpURLConnection connection = null;
		try {
			URL url = new URL(callURL);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			connection.connect();
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.write(postData.getBytes("UTF-8"));
			out.flush();
			out.close();
			int rc = connection.getResponseCode();
			// 响应成功
			if (rc == 200) {
				String temp;
				InputStream in = null;
				in = connection.getInputStream();
				BufferedReader data = new BufferedReader(new InputStreamReader(
						in, "utf-8"));
				StringBuffer result = new StringBuffer();
				while ((temp = data.readLine()) != null) {
					result.append(temp);
					temp = null;
				}
				log.info("send message end,and the result is :"
						+ result.toString());
				System.out.println("send message end,and the result is :"
						+ result.toString());
				data.close();
				in.close();
				return result.toString();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null){
				connection.disconnect();
			}
		}
		return null;
	}

	public static String sendMeCard(String callURL,String postData) throws Exception {

		log.info("call url is:" + callURL);
		int dataLen=0;
		if(postData!=null){
			dataLen=postData.length();
		}
		if(dataLen>30*1024){
			log.info("call postData is:" + postData.substring(0,300)+"......");
		}else{
			log.info("call postData is:" + postData);
		}
		DataOutputStream out =null;
		InputStream in = null;
		BufferedReader data =null;
		try {
			URL url = new URL(callURL);
			HttpURLConnection connection = null;
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.connect();
			out = new DataOutputStream(connection
					.getOutputStream());

			out.write(postData.getBytes("UTF-8"));
			out.flush();
			int rc = connection.getResponseCode();
			log.info("connect result is:" + rc);
			// 响应成功
			if (rc == 200) {
				String temp;
				in = connection.getInputStream();
				data = new BufferedReader(new InputStreamReader(
						in, "utf-8"));
				StringBuffer result = new StringBuffer();
				while ((temp = data.readLine()) != null) {
					result.append(temp);
					temp = null;
				}
				log.info("returnData is:" + result.toString());
				return result.toString();
			}
		} catch (IOException io) {
			log.info(io.toString());
			throw io;
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}finally{
			try {
				if(out!=null){
					out.close();
				}
				if(data!=null){
					data.close();
				}
				if(in!=null){
					in.close();
				}
			} catch (IOException e2) {
			}
		}
		return null;
	}


}
