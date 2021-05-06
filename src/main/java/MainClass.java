import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws URISyntaxException, IOException {
        LinkedList<TaskBase> taskList=new LinkedList<>();
        System.out.println("启动打印站点服务");
        //读取配置文件
        Configs configs=new Configs();
        System.out.println(configs.toString());
        //登录或注册打印站点

        //启动打印线程


        //登录Socket服务器
        URI uri=new URI("ws://localhost:8080/PrintRoom/myWs");
        SocketClientDome socketClient=new SocketClientDome(uri,taskList,configs);
        socketClient.connect();

        //
        while (true){

            if(!taskList.isEmpty()){
                TaskBase pop = taskList.pop();
                try {
                    printUtil.doPrinter("",pop.getFile(),pop.getCount());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }
}
