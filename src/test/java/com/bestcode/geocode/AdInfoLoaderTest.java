package com.bestcode.geocode;

import com.bestcode.geocode.pojo.AstMeta;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class AdInfoLoaderTest {

    @Test
    public void test01() throws IOException {
        Map<Integer, AstMeta> integerAstMetaMap = AdInfoLoader.loadInfo();

        System.out.println("加载完毕");
    }
}
