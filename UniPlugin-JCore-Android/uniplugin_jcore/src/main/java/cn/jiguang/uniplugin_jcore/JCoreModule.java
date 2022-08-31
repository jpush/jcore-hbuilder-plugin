package cn.jiguang.uniplugin_jcore;

import android.content.Context;

import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.utils.JCollectionAuth;
import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.common.UniDestroyableModule;

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
    public void testCountryCode(String code) {
        updatePluginStatu();
        JCoreInterface.testCountryCode(code);
    }
    @Override
    public void destroy() {

    }
}
