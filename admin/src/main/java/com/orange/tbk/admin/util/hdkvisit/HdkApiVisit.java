package com.orange.tbk.admin.util.hdkvisit;

import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONObject;
import com.orange.tbk.admin.util.hdkvisit.exception.ApiKeyNotNull;
import com.orange.tbk.admin.util.hdkvisit.exception.ApiNoData;
import com.orange.tbk.admin.util.hdkvisit.exception.ApiVisitFail;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 访问好单库总执行方法
 * @author Orange软件
 * @date 2019.3.1
 */
public class HdkApiVisit {

    public static String execute(Object base) throws Exception {

        Object apikey = ReflectUtil.getFieldValue(base, "apikey");
        String requestMethod = (String) ReflectUtil.invoke(base,"getRequestMethod");
        if (apikey == null || apikey.equals("")) {
            throw new ApiKeyNotNull("apikey不能为空");
        }

        //请求体拼接
        Field[] fields = ReflectUtil.getFields(base.getClass());
        Object[] fieldsValue = ReflectUtil.getFieldsValue(base);
        String requestBody = "";
        Map<String,Object> requestBodyMap = new HashMap<>();

        for (int i = 0;i < fields.length;i++) {
            Field field = fields[i];
            Object fieldValue = fieldsValue[i];
            if (fieldValue != null) {
                if (HttpRequestMethod.GET.equals(requestMethod)) {
                    requestBody+= "/"+ field.getName() + "/" + fieldValue;
                } else if (HttpRequestMethod.POST.equals(requestMethod)) {
                    requestBodyMap.put(field.getName(),fieldValue);
                }
            }
        }

        //访问地址
        String apiUrl = (String) ReflectUtil.invoke(base,"getApiUrl");
        HttpResponse execute = null;

        if (HttpRequestMethod.GET.equals(requestMethod)) {
            execute = HttpRequest.get(apiUrl + requestBody).execute();
        } else if (HttpRequestMethod.POST.equals(requestMethod)) {
            execute = HttpRequest.post(apiUrl).form(requestBodyMap).execute();
        }

        if (execute.getStatus() == HttpStatus.HTTP_OK) {

            String body = execute.body();

            JSONObject jsonObject = new JSONObject(body);
            Object code = jsonObject.get("code");
            String msg = (String) jsonObject.get("msg");

            //这样处理是，有些部分api code返回是string的
            if (code instanceof Integer) {
                int codeInt = ((Integer) code).intValue();
                if (codeInt != 1) {
                    throw new ApiNoData(msg);
                }
            } else if (code instanceof String) {
                String codeString = code.toString();
                if (!"1".equals(codeString)) {
                    throw new ApiNoData(msg);
                }
            }

            return body;
        }

        throw new ApiVisitFail("API访问失败，状态码：" + execute.getStatus());
    }



}
