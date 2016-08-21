package listener;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

import dispatch.Dispatcher;

/**
 * ����ϵͳ��������
 * 
 * @author ֣��
 */
public class IoChangeListener extends Thread {

	/** ���ڼ������Channel״̬��Selector */
	private Selector ioChangeSelector = null;

	/**
	 * ���췽��
	 * 
	 * @throws IOException
	 */
	public IoChangeListener(Selector ioChangeSelector) throws IOException {

		// ����һ��Selector
		this.ioChangeSelector = ioChangeSelector;

	}

	/**
	 * ������
	 */
	public void run() {
		int keyCount = 0;
		try {
			while (this.ioChangeSelector.isOpen()) {
				keyCount = this.ioChangeSelector.selectNow();
				if (keyCount > 0) {

					Iterator<SelectionKey> iterator = ioChangeSelector
							.selectedKeys().iterator();
					// ���δ���selector�ϵ�ÿ����ѡ���SelectionKey
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						// ��selector�ϵ���ѡ��Key����ɾ�����ڴ����SelectionKey
						iterator.remove();
						if (key.isReadable()) {
							// ���key��Ӧ��ͨ����������Ҫ��ȡ
							// �ַ������������
							// System.out.println(Thread.currentThread().getName()
							// + "���ڼ���IO״̬�ı�");
							key.cancel();
							Dispatcher.notifyRead(key);
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
