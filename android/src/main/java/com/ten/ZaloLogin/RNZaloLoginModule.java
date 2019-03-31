
package com.ten.ZaloLogin;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zing.zalo.zalosdk.oauth.OAuthCompleteListener;
import com.zing.zalo.zalosdk.oauth.OauthResponse;
import com.zing.zalo.zalosdk.oauth.ZaloSDK;

public class RNZaloLoginModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext mReactContext;

  public RNZaloLoginModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.mReactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNZaloLogin";
  }

  @ReactMethod
  public void AuthenZalo(){
    ZaloSDK.Instance.authenticate(mReactContext.getCurrentActivity(), listener);
  }

  OAuthCompleteListener listener = new OAuthCompleteListener(){
    @Override
    public void onAuthenError(int errorCode, String message) {
      WritableMap params = Arguments.createMap();

      params.putInt("errorCode", errorCode);
      params.putString("message", message);
      sendEvent(mReactContext, "EventLoginZalo", params);
    }

    @Override
    public void onGetOAuthComplete(long uId, String oauthCode, String channel) {
      WritableMap params = Arguments.createMap();
      params.putString("uId", "" + uId);
      params.putString("oauthCode", "" + oauthCode);
      params.putString("channel", "" + channel);

      sendEvent(mReactContext, "EventLoginZalo", params);
    }

    @Override
    public void onGetOAuthComplete(OauthResponse oauthResponse) {
      super.onGetOAuthComplete(oauthResponse);
    }

  };


  private void sendEvent(ReactContext reactContext,
                         String eventName,
                         @Nullable WritableMap params) {
    reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(eventName, params);
  }

}