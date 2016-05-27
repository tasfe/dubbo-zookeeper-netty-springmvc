package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.socket.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyServer {

    private final int port;

    public MyServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        ServerBootstrap server = new ServerBootstrap();
        try {
            server.group(new NioEventLoopGroup(), new NioEventLoopGroup())
                    .channel(NioServerSocketChannel.class).localAddress(port)
                    .childHandler(new DispatcherServletChannelInitializer());

            server.bind().sync().channel().closeFuture().sync();
        } finally {
            server.shutdown();
        }
    }

    public static void main(String[] args) throws Exception {
        final int port = 8080;
        new Thread(new Runnable() {
            public void run() {
                try {
                    new MyServer(port).run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
