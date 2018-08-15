package com.myself.nettypermiss.utils;

import com.myself.nettypermiss.enums.LevelStatusEnum;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:21 2018\8\15 0015
 */
public class CheckLevelUtils {

    public static String getLevelName(Integer code){

            switch (code){
                //高级别
                case 1:
                    return LevelStatusEnum.HIGH_LEVEL.getMsg();
                //中级别
                case 2:
                    return LevelStatusEnum.MEDIUM_LEVEL.getMsg();
                //低级别
                case 3:
                    return LevelStatusEnum.LOW_LEVEL.getMsg();
                default:
                    return null;
            }

    }

}
