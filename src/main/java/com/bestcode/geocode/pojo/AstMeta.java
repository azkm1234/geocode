package com.bestcode.geocode.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;
/**
 * administrative metadata
 */
@Data
public class AstMeta {
    /**
     * admin code
     */
    private int adcode;

    /**
     * 行政区划的中文名
     */
    private List<String> nameZh;

    /**
     * 子行政区
     */
    private Map<Integer, AstMeta> childAd;

}
