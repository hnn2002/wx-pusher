package com.asleepyfish.common;

/**
 * @Author: asleepyfish
 * @Date: 2022/8/23 18:46
 * @Description: 常量类
 */
public final class WxConstants {
    private WxConstants() {
    }

    /**
     * appId
     */
    public static final String APP_ID = "wxa71d09ded2916d20";

    /**
     * appSecret
     */
    public static final String APP_SECRET = "8fed9ea6bca928a090f38efe784c12e3";

    /**
     * 公众号
     */
    public static final String PUBLIC_ID = "gh_1471ac4902e9";

    /**
     * token
     */
    public static final String TOKEN = "asleepyfish";

    /**
     * 请求api需要的token，开启定时任务，每一个小时获取一次
     */
    public static String accessToken = "";

    /**
     * 请求百度地图相关服务的AK
     */
    public static final String BAI_DU_AK = "kBvScD29cG1pSs0XOtW2lPTO88Q0eBMt";

    /**
     * 天行API AK
     */
    public static final String TX_AK = "3409f0eee0ee08c17451b8c0d1dc8eaa";

    /**
     * 相识日期
     */
    public static final String MEET_DATE = "2022-06-27";

    /**
     * 客服
     */
    public static String CUSTOMER_SERVICE = "ChatGPT@ChatGPT";
}
