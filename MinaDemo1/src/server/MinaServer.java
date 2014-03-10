package server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {
	 
    /**
     * @param args
     */
 
    public static void main(String[] args) {
        //����һ����������server��Socket ����NIO
        SocketAcceptor acceptor = new NioSocketAcceptor();
 
        /*---------�����ַ���---------*/
//      //����һ���������ݹ�����
//      DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//      //�趨������һ����(/r/n)�Ķ�ȡ����
//      chain.addLast("mychin", new ProtocolCodecFilter(new TextLineCodecFactory()   ));
        /*---------���ն���---------*/
        //�����������ݵĹ�����
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        //�趨������������Զ���Ϊ��λ��ȡ����
        ProtocolCodecFilter filter= new ProtocolCodecFilter(new ObjectSerializationCodecFactory());
        chain.addLast("objectFilter",filter);
 
        //�趨��������Ϣ������
        acceptor.setHandler(new ServerHandler());
        //�������󶨵Ķ˿�
        int bindPort = 9988;
        //�󶨶˿ڣ�����������
        try {
            acceptor.bind(new InetSocketAddress(bindPort));
        } catch (IOException e) {
            System.out.println("Mina Server start for error!"+bindPort);
            e.printStackTrace();
        }
        System.out.println("Mina Server run done! on port:"+bindPort);
    }
}
