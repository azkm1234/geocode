package com.bestcode.geocode.util;

import com.bestcode.geocode.emxx.AdEnum;

public class AdUtil {
    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
    private static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }
    public static AdEnum getAdEnum(int id) {
        if (id == 86 || id == 0) {
            return AdEnum.COUNTRY;
        }
        int size = stringSize(id);
        switch (size) {
            case 2:
                return AdEnum.PROVINCE;
            case 4:
                return AdEnum.CITY;
            case 6:
                return AdEnum.COUNTY;
                default:
                    throw new IllegalArgumentException("行政区划id错误: " + id);
        }
    }
}
