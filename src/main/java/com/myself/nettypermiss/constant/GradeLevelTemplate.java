package com.myself.nettypermiss.constant;

import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 10:16 2018\8\15 0015
 */
@Component
public class GradeLevelTemplate {

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
                return Union3(HighLevelSet,MediumLevelSet,LowLevelSet);
            //中级别
            case 2:
                return Union2(MediumLevelSet,LowLevelSet);
            //低级别
            case 3:
                return LowLevelSet;
            default:
                return null;
        }
    }

    private Set<Channel> Union3(Set<Channel> s1,Set<Channel> s2,Set<Channel> s3){
        Set<Channel> unionSet = new LinkedHashSet<>();
        for (Channel s:s1){
            unionSet.add(s);
        }
        for (Channel s:s2){
            unionSet.add(s);
        }
        for (Channel s:s3){
            unionSet.add(s);
        }
        return unionSet;
    }

    private Set<Channel> Union2(Set<Channel> s1,Set<Channel> s2){
        Set<Channel> unionSet = new LinkedHashSet<>();
        for (Channel s:s1){
            unionSet.add(s);
        }
        for (Channel s:s2){
            unionSet.add(s);
        }
        return unionSet;
    }
}
