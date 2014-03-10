package server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ServerHandler extends IoHandlerAdapter {
	private int count = 0;
	 
    // ��һ���¿ͻ������Ӻ󴥷��˷���.
    public void sessionCreated(IoSession session) {
        System.out.println("�¿ͻ�������");
    }
 
    // ��һ���Ͷ˶��������ʱ @Override
    public void sessionOpened(IoSession session) throws Exception {
        count++;
        System.out.println("�� " + count + " �� client ��½��address�� : "
                + session.getRemoteAddress());
 
    }
 
    // ���ͻ��˷��͵���Ϣ����ʱ:
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        // // ���Ǽ��趨�˷�����������Ϣ�Ĺ�����һ��һ�ж�ȡ,����Ϳ�תΪString:
        // String s = (String) message;
        // // Write the received data back to remote peer
        // System.out.println("�յ��ͻ�����������Ϣ: " + s);
        // // ���Խ���Ϣ���͸��ͻ��� session.write(s+count); count++;
 
        MessageObj ho = (MessageObj) message;
        System.out.println(ho.getName());
 
        ho.setName("serverHimi");
        session.write(ho);
 
    }
 
    // ����Ϣ�Ѿ����͸��ͻ��˺󴥷��˷���.
    @Override
    public void messageSent(IoSession session, Object message) {
        System.out.println("��Ϣ�Ѿ����͸��ͻ���");
 
    }
 
    // ��һ���ͻ��˹ر�ʱ
    @Override
    public void sessionClosed(IoSession session) {
        System.out.println("one Clinet Disconnect !");
    }
 
    // �����ӿ���ʱ�����˷���.
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) {
        System.out.println("���ӿ���");
    }
 
    // ���ӿ������������׳��쳣δ������ʱ�����˷���
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        System.out.println("���������׳��쳣");
    }
 
}
