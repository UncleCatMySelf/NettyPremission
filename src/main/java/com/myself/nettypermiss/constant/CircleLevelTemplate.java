package com.myself.nettypermiss.constant;

import com.myself.nettypermiss.enums.LevelStatusEnum;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 10:16 2018\8\15 0015
 */
@Component
public class CircleLevelTemplate {

    private static Set<Channel> HighLevelSet = new LinkedHashSet<>();

    private static Set<Channel> MediumLevelSet = new LinkedHashSet<>();

    private static Set<Channel> LowLevelSet = new LinkedHashSet<>();

    public synchronized void save(Integer code,Channel channel){
        switch (code){
            //高级别
            case 1:
                HighLevelSet.add(channel);
                break;
            //中级别
            case 2:
                MediumLevelSet.add(channel);
                break;
            //低级别
            case 3:
                LowLevelSet.add(channel);
                break;
            default:
                break;
        }
    }

    public synchronized void remove(Channel channel){
        HighLevelSet.remove(channel);
        MediumLevelSet.remove(channel);
        LowLevelSet.remove(channel);
    }

    public synchronized Set<Channel> get(Integer code){
        switch (code){
            //高级别
            case 1:
                return HighLevelSet;
            //中级别
            case 2:
                return MediumLevelSet;
            //低级别
            case 3:
                return LowLevelSet;
            default:
                return null;
        }
    }
}
