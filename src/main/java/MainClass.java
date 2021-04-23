import java.net.URI;
import java.net.URISyntaxException;

public class MainClass {
    public static void main(String[] args) throws URISyntaxException {

        System.out.println("启动打印站点服务");

        //读取配置文件
        //登录或注册打印站点
        //登录Socket服务器



        URI uri=new URI("ws://localhost:8080/PrintRoom/myWs");

        SocketClientDome socketClient=new SocketClientDome(uri);
        socketClient.connect();
        while (true){

        }
    }
}
