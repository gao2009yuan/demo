package client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import server.MessageObj;

public class ClientHandler  extends IoHandlerAdapter {
    // ��һ���Ͷ˶����ᵽ��������
    @Override
    public void sessionOpened(IoSession session) throws Exception {
//      session.write("������........");
        MessageObj ho = new MessageObj(1,"Himi");
        session.write(ho);
    }
 
    // ��һ���ͻ��˹ر�ʱ
    @Override
    public void sessionClosed(IoSession session) {
        System.out.println("I'm Client &&  I closed!");
    }
 
    // ���������˷��͵���Ϣ����ʱ:
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
//      // ���Ǽ��趨�˷�����������Ϣ�Ĺ�����һ��һ�ж�ȡ,����Ϳ�תΪ String:
//      String s = (String) message;
//      // Write the received data back to remote peer
//      System.out.println("�������������յ���Ϣ: " + s);
//      // ���Խ���Ϣ���͸��ͻ��� session.write(s);
 
    	MessageObj ho = (MessageObj) message;
        System.out.println(ho.getName());
 
    }
}