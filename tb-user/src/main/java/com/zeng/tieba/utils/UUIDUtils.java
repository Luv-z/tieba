package com.zeng.tieba.utils;

import java.util.UUID;

public class UUIDUtils {

    //创建32位UUID
    public static String createUUID(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
