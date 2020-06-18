package com.bestcode.geocode;

import java.util.Map;

public class AstSegment {
    private static final int ARRAY_LENGTH_LIMIT = 3;
    // Map存储结构
    private Map<Character, AstSegment> childrenMap;
    // 数组方式存储结构
    private AstSegment[] childrenArray;

    // 当前节点上存储的字符
    private Character nodeChar;

    // storeSize <=ARRAY_LENGTH_LIMIT ，使用数组存储， storeSize >ARRAY_LENGTH_LIMIT ,则使用Map存储
    private int storeSize = 0;
    // 当前DictSegment状态 ,默认 0 , 1表示从根节点到当前节点的路径表示一个词
    private int nodeState = 0;

    public AstSegment(Character nodeChar) {
        if (nodeChar == null) {
            throw new IllegalArgumentException("字符参数不能为空");
        }
        this.nodeChar = nodeChar;
    }
}
