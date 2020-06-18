package com.bestcode.geocode;

import com.bestcode.geocode.pojo.AstMeta;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdInfoLoader {
    private static final String url = "https://apis.map.qq.com/ws/district/v1/list?key=ZFWBZ-PS7EW-N6TRW-OP6EP-7TSBZ-DYFIS";

    public static Map<Integer, AstMeta> loadInfo() throws IOException {
        Map<Integer, AstMeta> map = new HashMap<>();
        URL url = new URL(AdInfoLoader.url);
        InputStream inputStream = url.openConnection().getInputStream();
        ObjectMapper objectMapper = JacksonUtil.getObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(inputStream);
        JsonNode status = jsonNode.path("status");
        if (status.isMissingNode() || status.asInt() != 0) {
            throw new IOException("url 读取数据失败");
        }
        JsonNode result = jsonNode.path("result");
        if (result.isMissingNode() || !result.isArray()) {
            throw new IllegalStateException("json解析错误");
        }
        parseDataToMap(map, result);
        return map;
    }

    private static void parseDataToMap(Map<Integer, AstMeta> map, JsonNode result) {
        for (JsonNode ad : result) {
            if (ad.isArray()) {
                parseDataToMap(map, ad);
            } else {
                AstMeta astMeta = new AstMeta();
                astMeta.setAdcode(ad.get("id").asInt());
                List<String> list = new ArrayList<>();
                list.add(ad.path("name").asText());
                list.add(ad.path("fullname").asText());
                astMeta.setNameZh(list);
                if (map.containsKey(astMeta.getAdcode())) {
                    AstMeta merge = merge(astMeta, map.get(astMeta.getAdcode()));
                    map.put(merge.getAdcode(), merge);
                } else {
                    map.put(astMeta.getAdcode(), astMeta);
                }
            }
        }
    }

    private static AstMeta merge(AstMeta astMeta, AstMeta other) {
        astMeta.getNameZh().addAll(other.getNameZh());
        return astMeta;
    }


}
