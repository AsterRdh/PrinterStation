import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.File;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

public class SocketClientDome extends WebSocketClient {
    Configs configs;
    LinkedList<TaskBase> taskList=new LinkedList<>();
    public SocketClientDome(URI serverUri,LinkedList taskList,Configs configs) {
        super(serverUri);
        this.taskList=taskList;
        this.configs=configs;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("打开连接");
        send("login "+configs.getPrinterKey());
    }

    @Override
    public void onMessage(String s) {
        String[] comds=s.split(" ");
        switch (comds[0]){
            case "newTask":
                String fileURL=comds[1];
                int count=Integer.parseInt(comds[2]);
                File file = HttpUtil.getFile(fileURL);
                TaskBase task=new TaskBase(file,count);
                taskList.add(task);
                break;
            case "cancelTask":
                break;
            default:
                break;
        }
        System.out.println(s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("关闭连接");
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }
}
