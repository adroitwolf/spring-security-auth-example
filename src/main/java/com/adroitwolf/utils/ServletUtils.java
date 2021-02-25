package com.adroitwolf.utils;

import com.adroitwolf.domain.Dto.BaseResponse;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName ServletUtils.java
 * @Description servlet工具类
 * @createTime 2021年02月24日 11:14:00
 */
public class ServletUtils {

    public static void render(HttpServletRequest httpServletRequest, HttpServletResponse response, BaseResponse baseResponse) throws IOException {
        // 允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 允许自定义请求头token(允许head跨域)
        response.setHeader("Access-Control-Allow-Headers", "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");
        response.setHeader("Content-type", "application/json;charset=UTF-8");

        response.getWriter().print(JSONObject.toJSON(baseResponse));
    }


    public static JSONObject getRequestJsonObject(HttpServletRequest request) throws IOException {
//        if(request.getMethod().equals("GET")){ //get请求
////            System.out.println(request.getQueryString());
//            Map<String, String[]> map = request.getParameterMap();
//            return JSONObject.parseObject(request.getQueryString());
//
//        }else{ //POST方式
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String,Object> params = new HashMap<>();
            int length;
            for (Map.Entry<String,String[]> entry: parameterMap.entrySet()){
                length = entry.getValue().length;
                if(length ==1){
                    params.put(entry.getKey(), entry.getValue()[0]);
                }else if(length >1){
                    params.put(entry.getKey(),entry.getValue());
                }
            }

            System.out.println(params.toString());



//            int length = request.getContentLength();
//            if(length<0){
//                return  null;
//            }
//            byte buffer[] = new byte[length];
//            for (int i = 0; i < length;) {
//
//                int readlen = request.getInputStream().read(buffer, i,
//                        length - i);
//                if (readlen == -1) {
//                    break;
//                }
//                i += readlen;
//            }
            return new JSONObject(params);

//        }
    }
}
