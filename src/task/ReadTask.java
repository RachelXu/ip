/** ����ӿ��� **/

package task;

import java.io.IOException;
import java.nio.channels.SocketChannel;

import buffer.Buffer;
import dispatch.Dispatcher;

/**
 * ������
 * 
 * @author ֣��
 */
public class ReadTask extends Task {

	public String info() {
		return "���ж�ȡ�û����������";
	}

	protected boolean needExecuteImmediate() {
		return true;
	}

	protected boolean useDb() {
		return false;
	}

	/**
	 * ����ִ�����
	 */
	public void execute() {

		// ��ȡ��SelectionKey��Ӧ��Channel����Channel���пɶ�������
		SocketChannel sc = (SocketChannel) getKey().channel();

		// ����׼��ִ�ж�ȡ���ݵ�ByteBuffer
		// ByteBuffer buff = ByteBuffer.allocate(10);
		// buff.clear();
		Buffer buff = new Buffer();
		buff.allocate();

		// ��ʼ��ȡ����
		int i = 0;
		try {
			i = sc.read(buff.buff());
			if (!buff.hasRemaining()) {
				buff.expand();
				sc.read(buff.buff());
			}
		} catch (IOException e) {
			e.printStackTrace();
			getKey().cancel();
			if (sc != null) {
				try {
					sc.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				sc = null;
				return;
			}
		}
		if (i == -1) {
			getKey().cancel();
			if (sc != null) {
				try {
					sc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				sc = null;
			}
			return;
		}
		buff.flip();
		// ����ҵ�������
		Dispatcher.notifyLogic(getKey(), buff.array());
	}

}