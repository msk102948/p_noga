package com.p_noga.p_noga.common;

import java.util.UUID;

public class Util {
    /**
     * [공통함수] UUID 생성 함수
     *
     * @MethodName : makeUuid
     * @param isHyphen : 하이픈 포함 여부
     * @return String
     */
    public static String makeUuid(boolean isHyphen) {
        String result = "";

        if (isHyphen) {
            result = UUID.randomUUID().toString();
        } else {
            result = UUID.randomUUID().toString().replace("-", "");
        }

        return result;
    }
}
