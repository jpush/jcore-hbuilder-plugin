package cn.jiguang.uniplugin_jcore;

import android.content.Context;

import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.utils.JCollectionAuth;
import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.common.UniDestroyableModule;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.JSCallback;

public class JCoreModule extends UniDestroyableModule{
    public static Context uniContext = null;
    public void updatePluginStatu() {
        uniContext = mWXSDKInstance.getContext();
    }
    @UniJSMethod(uiThread = true)
    public void setAuth(boolean enable) {
        updatePluginStatu();
        JCollectionAuth.setAuth(uniContext,enable);
    }
    @UniJSMethod(uiThread = true)
    public void enableAutoWakeup(boolean enable) {
        updatePluginStatu();
        JCollectionAuth.enableAutoWakeup(uniContext,enable);
    }
    @UniJSMethod(uiThread = true)
    public void testCountryCode(String code) {
        updatePluginStatu();
        JCoreInterface.testCountryCode(uniContext,code);
    }

    @UniJSMethod(uiThread = true)
    public void enableSDKLocalLog(JSONObject readableMap) {
        updatePluginStatu();
        if (readableMap == null) {
            return;
        }
        boolean enable = readableMap.getBoolean("enable");
        boolean uploadJgToServer = readableMap.getBoolean("uploadJgToServer");
        JCoreInterface.enableSDKLocalLog(mWXSDKInstance.getContext(), enable, uploadJgToServer);
    }

    @UniJSMethod(uiThread = true)
    public void readNewLogs(JSCallback callback) {
        updatePluginStatu();
        if (callback == null) {
            return;
        }
        String logs = JCoreInterface.readNewLogs(mWXSDKInstance.getContext());
        callback.invoke(logs);
    }

    @Override
    public void destroy() {

    }
}
