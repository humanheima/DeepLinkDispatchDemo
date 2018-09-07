# DeepLinkDemo

am start -W -a android.intent.action.VIEW -d "hm://hm.com/deepLink/123"

```java
 @DeepLink("hm://methodDeepLink/{param1}")
    public static Intent intentForDeepLinkMethod(Context context) {
        return new Intent(context, MainActivity.class).setAction(ACTION_DEEP_LINK_METHOD);
    }
```
通过方法启动Activity
```java
am start -W -a android.intent.action.VIEW -d "hm://methodDeepLink/123"

```

```java
@DeepLink("hm://methodDeepLink/extras")
    public static Intent intentForDeepLinkMethod(Context context, Bundle extras) {
        return new Intent(context, MainActivity.class).setAction(ACTION_DEEP_LINK_METHOD);
    }
```
通过方法启动携带参数

```java
am start -W -a android.intent.action.VIEW -d "hm://methodDeepLink/extras?qp=456"

```