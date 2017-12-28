package com.example.demo.netty.nio.multi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
  private static final Logger LOGGER = LoggerFactory.getLogger(NIOServer.class);
  public static void main(String[] args) throws IOException {
    Selector selector = Selector.open();
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.configureBlocking(false);
    serverSocketChannel.bind(new InetSocketAddress(1234));
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    while (true) {
      if(selector.selectNow() < 0) {
        continue;
      }
      Set<SelectionKey> keys = selector.selectedKeys();
      Iterator<SelectionKey> iterator = keys.iterator();
      while(iterator.hasNext()) {
        SelectionKey key = iterator.next();
        iterator.remove();
        if (key.isAcceptable()) {
          ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) key.channel();
          SocketChannel socketChannel = acceptServerSocketChannel.accept();
          socketChannel.configureBlocking(false);
          LOGGER.info("Accept request from {}", socketChannel.getRemoteAddress());
          SelectionKey readKey = socketChannel.register(selector, SelectionKey.OP_READ);
          readKey.attach(new Processor());
        } else if (key.isReadable()) {
          Processor processor = (Processor) key.attachment();
          processor.process(key);
        }
      }
    }
  }
}