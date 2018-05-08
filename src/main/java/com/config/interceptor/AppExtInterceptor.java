package com.config.interceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cat.common.bean.EMsg;
import com.cat.common.bean.FMsgResponse;
import com.cat.common.bean.RConfig;
import com.cat.common.exception.RequestException;
import com.cat.common.json.RJson;
import com.cat.common.lang.RString;
import com.cat.common.listener.RSystemConfig;
import com.cat.common.safe.RAESOperator;
import com.config.aspect.LogHelper;
import com.config.aspect.ThreadLocalHelper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class AppExtInterceptor implements HandlerInterceptor {

	private Logger _logger = Logger.getLogger(this.getClass());

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("app拦截的 preHandle");
		RSystemConfig.setOrign(arg0, arg1);
	      if(!RSystemConfig.isAllowMsg(arg0, arg1)){
	         return false;
	      }
		return checkToken(arg0, arg1);
	}

	private boolean checkToken(HttpServletRequest request, HttpServletResponse response) {
		try {
			String appId = request.getHeader("appId");
			String url = request.getRequestURI();
			String ip = request.getRemoteAddr();
			
			Map<String, String> logMap = new HashMap<String, String>();
			logMap.put("appId", appId);
			logMap.put("url", url);
			logMap.put("ip", ip);
			
			// APPID 不能为空
			if (RString.isBlank(appId)) {
				LogHelper.interRequestLog(RJson.getJsonStr(logMap));
				printWriterJson(response, new FMsgResponse(EMsg.App_Id_NUll.code(), EMsg.App_Id_NUll.value()));
				return false;
			}

			/**
			 * 加密密钥
			 */
			String aecKey = RSystemConfig.getValue(appId);
			if (RString.isBlank(aecKey)) {
				LogHelper.interRequestLog(RJson.getJsonStr(logMap));
				printWriterJson(response, new FMsgResponse(EMsg.App_Id_Wrong.code(), EMsg.App_Id_Wrong.value()));
				return false;
			}

			String requestData = RString.toString(request.getParameter(RConfig.KEY_REQUEST));
			if (RString.isBlank(requestData)) {
				logMap.put("requestData", "");
				return true;
			}

			// 需要加密的密钥
			String aesOpenAppIds = RSystemConfig.getValue(RConfig.KEY_AESADDID);
			String decryptStr = "";
			if (RString.contains(aesOpenAppIds, appId)) {
				//需要解密就是解密后的字符串
				decryptStr = RAESOperator.getInstance().Decrypt(requestData, aecKey);
			}else{
				//不需要解密就是原始数据
				decryptStr = requestData;
			}
			
			if (RString.isBlank(decryptStr)) {
				// 密文不为空，解密后还是未空，
				logMap.put("requestData", requestData);
				LogHelper.interRequestLog(RJson.getJsonStr(logMap));
				printWriterJson(response, new FMsgResponse(EMsg.Aec_Wrong.code(), EMsg.Aec_Wrong.value()));
				return false;
			}
			//将解密后的请求放入线程缓存中。
			ThreadLocalHelper.setRequestStr(decryptStr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			_logger.error("checkToken", e);
		}

		return true;
	}

	public void printWriterJson(HttpServletResponse response, FMsgResponse msg) throws RequestException {
		LogHelper.interResponseLog(RJson.getJsonStr(msg));
		if (null == msg) {
			getPrintWriter(response).write("{}");
			return;
		}
		
		getPrintWriter(response).write(RJson.getJsonStr(msg).toString());
	}

	/**
	 * 写出
	 * 
	 * @param response
	 * @return
	 */
	private PrintWriter getPrintWriter(HttpServletResponse response) {
		PrintWriter out = null;
		try {
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			out = response.getWriter();
		} catch (IOException e) {
			_logger.error(e);
		}
		return out;
	}

	/**
	 * 接收发送过来的数据流
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public String getRecieveData(HttpServletRequest request) {
		String inputLine = null;
		// 接收到的数据
		StringBuffer recieveData = new StringBuffer();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			while ((inputLine = in.readLine()) != null) {
				recieveData.append(inputLine);
			}
		} catch (IOException e) {
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
			}
		}
		String requestData = recieveData.toString();
		if (RString.isBlank(requestData)) {
			return null;
		}
		return requestData;
	}


}
