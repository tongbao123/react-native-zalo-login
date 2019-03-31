
# react-native-zalo-login
![alt text](http://giasitot.vn/wp-content/uploads/2015/09/zalo-icon.png)
## Support Method
- Zalo Login (Done)
- Zalo Logout (coming soon)
- Zalo Logout (coming soon)
- ... more

## Getting started

`$ npm install react-native-zalo-login --save`

### Mostly automatic installation

`$ react-native link react-native-zalo-login`

### Manual installation


### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-zalo-login` and add `RNZaloLogin.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNZaloLogin.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.reactlibrary.RNZaloLoginPackage;` to the imports at the top of the file
  - Add `new RNZaloLoginPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-zalo-login'
  	project(':react-native-zalo-login').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-zalo-login/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-zalo-login')
  	```
### Now Follow step manual Setup (important)
##### Android
1. Open up `android/app/build.gradle` and add bellow
    ```    
    dependencies {
        ...
        implementation "com.zing.zalo.zalosdk:core:2.4.2501"
        implementation "com.zing.zalo.zalosdk:auth:2.4.2501"
    }
    ```
2. Open up `android/app/src/main/java/[...]/MainApplication.java`
    ```
    import com.zing.zalo.zalosdk.oauth.ZaloSDKApplication;
    ...
    @Override
    public void onCreate() {
        super.onCreate();
        ...
        ZaloSDKApplication.wrap(this);
    }
    ```
3. Open up `android/app/src/main/java/[...]/MainActivity.java`
    ```
    import com.zing.zalo.zalosdk.oauth.ZaloSDK;
    ...
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ZaloSDK.Instance.onActivityResult(this, requestCode, resultCode, data);
    }
    ```
4. Open up `android/app/src/main/AndroidManifest.xml`
    ```
    <application ...>
    
    <meta-data
        android:name="com.zing.zalo.zalosdk.appID"
        android:value="@string/appID"
    />
    <activity
            android:name="com.zing.zalo.zalosdk.oauth.WebLoginActivity"
            android:theme="@style/FixThemeForLoginWebview"
            android:windowSoftInputMode="stateHidden|stateAlwaysHidden"
            android:configChanges="orientation|screenSize"
            android:screenOrientation="sensor"
            >
    </activity>
    
    <activity
        android:name=".MainActivity"
        android:label="@string/app_name"
        android:configChanges="keyboard|keyboardHidden|orientation|screenSize"
        android:windowSoftInputMode="adjustResize">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
      </activity>
      <activity android:name="com.facebook.react.devsupport.DevSettingsActivity" />
    </application>
    ```
5. Open up `strings.xml` inside res folder
    put `<string name="appID">ZaloApp ID</string>`
    Zalo App ID will be created after reg your App in this site : https://developers.zalo.me/

##### iOS
`Guide will be comming soon ...`
## Usage
```javascript
import {RNZaloLogin, RNZBridgeEmitter} from 'react-native-zalo-login';
export default class YourComponent extends Compnent{
    componentWillMount(){
        RNZBridgeEmitter.addListener("EventLoginZalo", (data) => {
            //Suck with this
            alert(JSON.stringify(data))
        })
    }
    
    LoginWithZalo = () =>{
        RNZaloLogin.AuthenZalo();
    }
    render(){
        <TouchableOpacity onPress={this.LoginWithZalo}>
            <Text>Login With Zalo</Text>
        </TouchableOpacity>
    }
}
```
