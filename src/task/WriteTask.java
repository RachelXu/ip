/** ����ӿ��� **/

package task;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * д����
 * 
 * @author ֣��
 */
public class WriteTask extends Task {

	public String info() {
		return "����д��Ӧ�û�������";
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

		// ��ȡ��SelectionKey��Ӧ��Channel����Channel���п�д������
		SocketChannel sc = (SocketChannel) getKey().channel();
		try {
			sc.open();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ByteBuffer buff = ByteBuffer.allocate(getResponse().length);
		buff.clear();
		buff.put(getResponse());
		buff.flip();
		try {
			sc.write(buff);
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
			}
		}
	}

}