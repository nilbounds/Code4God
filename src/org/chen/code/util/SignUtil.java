package org.chen.code.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 请求检验工具类
 * @author 中普
 * @see 1.0
 *
 */
public class SignUtil {

	private static String token = "codeforgod";
	
	/**
	 * 检查是否来自微信服务器的
	 * @param signature 微信加密签名
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @return true 当确认来自微信服务器；false其他
	 */
	public static boolean checkSignature(String signature,String timestamp,
			String nonce){
		
		// token、timestamp、nonce按字典序排序
		String[] arr = new String[]{token,timestamp,nonce};
		Arrays.sort(arr);
		
		StringBuilder content = new StringBuilder();
		for(int i = 0;i<arr.length;i++)
		{
			content.append(arr[i]);
		}
		
		MessageDigest md = null;
		String tempStr = null;
		try{
			md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(content.toString().getBytes());
			tempStr = byteToStr(digest);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		content =  null;
		return tempStr != null ? tempStr.equals(signature.toUpperCase()) : false;
		
	}
	
	
	 /** 
     * 将字节数组转换为十六进制字符串 
     *  
     * @param byteArray  字节数组
     * @return 十六进制字符串 
     */  
    private static String byteToStr(byte[] byteArray) {  
        String strDigest = "";  
        for (int i = 0; i < byteArray.length; i++) {  
            strDigest += byteToHexStr(byteArray[i]);  
        }  
        return strDigest;  
    }  
    
    
    /** 
     * 将字节转换为十六进制字符串 
     *  
     * @param mByte 字节
     * @return 十六进制字符串 
     */  
    private static String byteToHexStr(byte mByte) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
        char[] tempArr = new char[2];  
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
        tempArr[1] = Digit[mByte & 0X0F];  
  
        String s = new String(tempArr);  
        return s;  
    }  
}
