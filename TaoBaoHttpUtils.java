package com.ash.message.common.base.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;


import java.io.IOException;
import java.util.Objects;

public class TaoBaoHttpUtils {
    public String getGoodsDetailJson(String goodsItemId) {
        String url="https://detailskip.taobao.com/service/getData/1/p1/item/detail/sib.htm?itemId="+goodsItemId+"&sellerId=166797920&modules=dynStock,qrcode,viewer,price,duty,xmpPromotion,delivery,activity,fqg,zjys,couponActivity,soldQuantity,page,originalPrice,tradeContract&callback=onSibRequestSuccess";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder request = new Request.Builder().url(url);
        request.get();
        request.addHeader ("accept","*/*");
        request.addHeader("accept-language","zh-CN,zh;q=0.9");
        request.addHeader("referer","https://item.taobao.com/item.htm?id=628436159033&price=2122-2952&original_price=2199-2999&sourceType=item&sourceType=item&suid=b3ce741c-55a4-4130-9f78-0b5f1c47ac30&shareUniqueId=5080246433&ut_sk=1.XtSN0T7VpQ8DAIB7ZAvAl9JS_21646297_1604674447715.Copy.1&un=ad9452ea320bf487b2a02c4eb1ea31ed&share_crt_v=1&spm=a2159r.13376460.0.0&sp_tk=SmdUUmM5ejRPd1c=&bxsign=tcdiGnvNjOsQ0TCrESSNKnWGYArdKC-ELkHQi8gG7g0cZsMTuo7TBocVNDtda8zB1fsWL1DbjRLek-k_VI_ILAxhMpB8wx13dbfijiVZ9M0pWI&price=2122-2952&original_price=2199-2999&sourceType=item&sourceType=item&suid=b3ce741c-55a4-4130-9f78-0b5f1c47ac30&shareUniqueId=5080246433&ut_sk=1.XtSN0T7VpQ8DAIB7ZAvAl9JS_21646297_1604674447715.Copy.1&un=ad9452ea320bf487b2a02c4eb1ea31ed&share_crt_v=1&spm=a2159r.13376460.0.0&sp_tk=SmdUUmM5ejRPd1c=&bxsign=tcdiGnvNjOsQ0TCrESSNKnWGYArdKC-ELkHQi8gG7g0cZsMTuo7TBocVNDtda8zB1fsWL1DbjRLek-k_VI_ILAxhMpB8wx13dbfijiVZ9M0pWI");
        request.addHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36");
        request.addHeader("Cookie","cna=O/sGGNexMxgCAdygMYE1mBbS; lgc=%5Cu738B%5Cu601D%5Cu6052i; tracknick=%5Cu738B%5Cu601D%5Cu6052i; enc=43qfIeSEhZMUBJHFnHKWhr13%2BMmuVMGRh2VPc0TvAMxq4iiIycsSyTICYU18JB1rBLQSAGyW7MD2YmeVI3KiSA%3D%3D; sgcookie=E100Rr%2FpkOgO3R8iTmHwT4HAehFpEeaNoyKq%2FSZw1lrpuJyPttps9zuPocVp3vYCPw0z9KAPuEgCXdg%2FGUcR%2Fk440w%3D%3D; uc3=vt3=F8dCufOHxxPMliZ4J84%3D&nk2=rpBgDJZYcg%3D%3D&lg2=VFC%2FuZ9ayeYq2g%3D%3D&id2=UUwZ%2BvIPs1V4PA%3D%3D; uc4=nk4=0%40rMpYFzYlA8Mg5HJGXdhQ0ePt&id4=0%40U27Gi9Qg5dDiknwPGzVtAYBYaBxO; _cc_=W5iHLLyFfA%3D%3D; _m_h5_tk=cf0e0c8b4d25c2a1224a7eba62b40fb7_1605505598900; _m_h5_tk_enc=95e81e76e3eaef9efa1292f8030f8317; xlly_s=1; mt=ci=-1_0; thw=cn; hng=CN%7Czh-CN%7CCNY%7C156; cookie2=1a22346a234306cda41591edb6433946; t=05327517085d107db68d1aa0538cf98f; _tb_token_=f75e10700e5eb; v=0; uc1=cookie14=Uoe0aDgwPE9OAw%3D%3D; isg=BOfnx_v6dE_-d_DU8b9ckW3ldhuxbLtOgl_EoblVU3adqAJqwTh-n9vpyqg2QJPG; l=eBawWr7IO6Ga1LkpBO5wlurza77OzIOfCsPzaNbMiInca6s1MFZdNNQVl55wydtjgtfvtetybUMLyRFwPAUU-AkDBeYIOC0eQDp9-; tfstk=cRFhBRTe2JkCvfDgh6GQkC1P8R4haOdrm7P__5JxL2j4SpNZ8scwQKSOwNm3x7p5.");

        Call call = okHttpClient.newCall(request.build());
        Response response = null;
        try {
            response = call.execute();

        } catch (IOException e) {
            System.out.println("HttpUtils异常");
        }
        try {
            assert response != null;
            String res = Objects.requireNonNull(response.body()).string();
            if (response.code() != 200) {
                res = "{\"code\":" + response.code() + "} ";
            }
            String s = StringUtils.substringBetween(res + "@#!$%^&#$#^#!123", "onSibRequestSuccess(", ");@#!$%^&#$#^#!123");
            return s;
        } catch (IOException e) {
            System.out.println("HttpUtil异常");
        }
        return "-1";
    }

    public String analyzeTaoBaoGoodsJsonOriginalPrice(String goodsDetailJson){
        JSONObject jsonObject = JSONObject.parseObject(goodsDetailJson);
        String price= jsonObject.getJSONObject("data").getString("price");
        return price;
    }
    public String analyzeTaoBaoGoodsJsonPrice(String goodsDetailJson){
        JSONObject jsonObject = JSONObject.parseObject(goodsDetailJson);
        try {
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONObject("promotion").getJSONObject("promoData").getJSONArray("def");
            for (Object obj : jsonArray) {
                JSONObject jsonObject1 = JSONObject.parseObject(obj.toString());
                String price = jsonObject1.getString("price");
                return price;
            }
        }catch (NullPointerException e){

        }
        return null;
    }

    /**
     *如果没有优惠价格那么返回的是页面上显示的价格
     * 有可能是originalPrice
     */

    public String getGoodsPrice(String goodsItemId){
        String goodsDetailJson = getGoodsDetailJson(goodsItemId);
        String originalPrice= analyzeTaoBaoGoodsJsonOriginalPrice(goodsDetailJson);
        String price = analyzeTaoBaoGoodsJsonPrice(goodsDetailJson);
        if (price==null){
            return originalPrice;
        }
        return price;
    }


}
