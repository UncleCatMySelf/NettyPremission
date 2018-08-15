package com.myself.nettypermiss.config;

import com.myself.nettypermiss.constant.CircleLevelTemplate;
import com.myself.nettypermiss.constant.GradeLevelTemplate;
import com.myself.nettypermiss.utils.CheckLevelUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;


/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:01 2018\8\14 0014
 */
@Component
@Qualifier("textWebSocketFrameHandler")
@ChannelHandler.Sharable
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    //圈子模式
    @Autowired
    private CircleLevelTemplate levelTemplate;
//    级别模式
//    @Autowired
//    private GradeLevelTemplate levelTemplate;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                TextWebSocketFrame msg) throws Exception {
        Channel incoming = ctx.channel();
        int inlevel =  Integer.parseInt(msg.text().substring(0,1));
        String realMsg =  msg.text().substring(1,msg.text().length());
        //异步处理 级别归类存储 待定，异步存在数据慢消费（不做异步处理）
        levelTemplate.save(inlevel,incoming);
        Set<Channel> levelSet = levelTemplate.get(inlevel);
        Iterator<Channel> iter = levelSet.iterator();
        //向所有连接推送消息
        while (iter.hasNext()){
            Channel channel = iter.next();
            channel.writeAndFlush(new TextWebSocketFrame(CheckLevelUtils.getLevelName(inlevel)+realMsg));
        }
        channels.add(incoming);
    }

    /**
     * 连接加入，不区分权限高中低
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        levelTemplate.remove(ctx.channel());
        channels.remove(ctx.channel());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("用户:在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("用户:掉线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println("用户:异常");
        cause.printStackTrace();
        ctx.close();
    }
}
