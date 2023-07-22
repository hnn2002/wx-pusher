package com.asleepyfish.strategy.template;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.asleepyfish.common.WxConstants;
import com.asleepyfish.common.WxTemplateConstants;
import com.asleepyfish.dto.IdentityInfo;
import com.asleepyfish.strategy.WxTemplateStrategy;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: asleepyfish
 * @Date: 2022-09-26 23:21
 * @Description: 特殊下午模板
 */
@Service(WxTemplateConstants.SPECIAL_AFTERNOON)
public class SpecialAfternoonStrategy implements WxTemplateStrategy {
    @Override
    public void execute(WxMpTemplateMessage wxMpTemplateMessage, IdentityInfo identityInfo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        String poemUrl = "https://apis.tianapi.com/everyday/index?key=" + WxConstants.TX_AK;
        String poemStr = HttpUtil.get(poemUrl);
        String poemList = JSONObject.parseObject(poemStr).get("result").toString();
        //String poem = JSONArray.parseArray(poemList).getJSONObject(0).get("content").toString();
        String poem = JSONObject.parseObject(poemList).get("content").toString();
        //String title = JSONArray.parseArray(poemList).getJSONObject(0).get("source").toString();
        String title = JSONObject.parseObject(poemList).get("source").toString();
        wxMpTemplateMessage.addData(new WxMpTemplateData("location", identityInfo.getAddress(), "#9370DB"));
        wxMpTemplateMessage.addData(new WxMpTemplateData("time", time, "#7CFC00"));
        wxMpTemplateMessage.addData(new WxMpTemplateData("poem", poem, "#FFA500"));
        if(title.equals("")){
            title = "不知道谁说的";
        }
        wxMpTemplateMessage.addData(new WxMpTemplateData("title", "《" + title + "》", "#FF6347"));
    }
}
