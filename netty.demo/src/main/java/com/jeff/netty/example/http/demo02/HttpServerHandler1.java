/*
 * Copyright 2013-2018 Lilinfeng.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jeff.netty.example.http.demo02;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * 
 * @author 58
 * 处理数据
 */
public class HttpServerHandler1 extends SimpleChannelInboundHandler<FullHttpRequest> {
	private final String url;

	public HttpServerHandler1(String url) {
		this.url = url;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
		messageReceived(ctx, msg);
	}

	/**
	 * 处理数据
	 * @param ctx
	 * @param request
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public void messageReceived(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
		
		String uri = request.getUri();
		String version = request.getProtocolVersion().toString();
		String method = request.getMethod().toString();
		
		System.out.println("uri="+uri+",version="+version+",method="+method);
		if(!request.getDecoderResult().isSuccess()) {
			ctx.writeAndFlush("请求解码失败");
		}
		ByteBuf buf = request.content();
		
//		buf.getByte
		System.out.println(buf);
	}
}
