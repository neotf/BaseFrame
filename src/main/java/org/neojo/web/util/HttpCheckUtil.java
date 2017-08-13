package org.neojo.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class HttpCheckUtil {
	private static Logger logger = Logger.getLogger(HttpCheckUtil.class);
	
	/**
	 * 获取远程服务器ATN结果
	 * 
	 * @param urlvalue
	 *            指定URL路径地址
	 * @return 服务器ATN结果
	 * @throws IOException 
	 */
	public static String GetUrl(String urlvalue){
		String inputLine = "";
		try {
		URL url = new URL(urlvalue);
		URLConnection urlConnection = url.openConnection();
		urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		inputLine = in.readLine().toString();
		}catch (Exception e) {  
			e.printStackTrace();
		}  
		return inputLine;
	}
	
	
	public static InputStream GetIS(String urlvalue) throws IOException{
		InputStream is = null;
		try {
		URL url = new URL(urlvalue);
		URLConnection urlConnection = url.openConnection();
		urlConnection.getInputStream();
		}catch (Exception e) {  
			e.printStackTrace();
		} finally {
			if(is!=null)
				is.close();
		}
		return is;
	}
	
	public static int checkUrl(String urlvalue){
		HttpURLConnection conn;
		int code = 0;
		try {
			conn = (HttpURLConnection) new URL(urlvalue).openConnection();
			conn.setRequestMethod("HEAD");
			code = conn.getResponseCode();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return checkUrl(urlvalue);
		} 
		return code;
	}
	
	public static int download(String urlvalue,String path,String filename) throws IOException{
		File file = new File(path, filename);
		file.createNewFile();
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(urlvalue).openConnection();
			is = conn.getInputStream();
			fos = new FileOutputStream(file);
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			fos.flush();
		} catch (MalformedURLException e) {
			logger.error(e.getStackTrace(), e);
			return -2;
		} catch (IOException e) {
			logger.error(e.getStackTrace(), e);
			return -1;
		} finally {
			if (is != null) {
				is.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
		return 1;
	}
	
	public static String sendPost(String url, String param,String bytes) {  
		String inputLine = "";
		PrintWriter out = null;
		BufferedReader in = null; 
        try {  
        	HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection(); 
    		urlConnection.setDoOutput(true);  
    		urlConnection.setDoInput(true);   
    		out = new PrintWriter(urlConnection.getOutputStream());  
//            out.print(param);  
            out.write(bytes);
            out.flush();  
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            inputLine = in.readLine().toString();
    		return inputLine;
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return null;  
    }  
}
