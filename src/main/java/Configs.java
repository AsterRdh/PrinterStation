import java.io.*;

public class Configs {
    private String printerKey;
    private String printerName;
    private String printerAddrx;
    private String printerAddry;
    private String printerInfo;
    private String serviceURL;
    private String tempPath;

    public Configs() throws IOException {
        FileInputStream inputStream = new FileInputStream("src\\main\\resources\\conf");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
            String[] s = str.split(" ");
            switch (s[0]){
                case "printer_key":
                    this.printerKey=s[1];
                    break;
                case "printer_name":
                    this.printerName=s[1];
                    break;
                case "printer_addrx":
                    this.printerAddrx=s[1];
                    break;
                case "printer_addry":
                    this.printerAddry=s[1];
                    break;
                case "printer_info":
                    this.printerInfo=s[1];
                    break;
                case "service_url":
                    this.serviceURL=s[1];
                    break;
                case "temp_path":
                    this.tempPath=s[1];
                    break;
            }

            System.out.println(str);
        }
        inputStream.close();
        bufferedReader.close();
    }

    public String getPrinterKey() {
        return printerKey;
    }

    public String getPrinterName() {
        return printerName;
    }

    public String getPrinterAddrx() {
        return printerAddrx;
    }

    public String getPrinterAddry() {
        return printerAddry;
    }

    public String getPrinterInfo() {
        return printerInfo;
    }

    public String getServiceURL() {
        return serviceURL;
    }

    public String getTempPath() {
        return tempPath;
    }

    @Override
    public String toString() {
        return "Configs{" +
                "printerKey='" + printerKey + '\'' +
                ", printerName='" + printerName + '\'' +
                ", printerAddrx='" + printerAddrx + '\'' +
                ", printerAddry='" + printerAddry + '\'' +
                ", printerInfo='" + printerInfo + '\'' +
                ", serviceURL='" + serviceURL + '\'' +
                ", tempPath='" + tempPath + '\'' +
                '}';
    }
}
