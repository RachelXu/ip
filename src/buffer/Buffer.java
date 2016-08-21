package buffer;

import java.nio.ByteBuffer;

import util.Contents;

public class Buffer {
	private ByteBuffer byteBuffer;

	public void allocate() {
		this.byteBuffer = ByteBuffer.allocate(Contents.BUFFER_SIZE);
	}

	public void expand() {

		int newCapacity;
		if (Contents.AUTO_EXPAND) {
			newCapacity = Contents.BUFFER_SIZE + Contents.EXPAND_SIZE;
		} else {
			newCapacity = Contents.BUFFER_SIZE;
		}
		ByteBuffer newByteBuffer = ByteBuffer.allocate(newCapacity);
		newByteBuffer.put(buff().array());
		buff(newByteBuffer);
	}

	public boolean hasRemaining() {
		return buff().hasRemaining();
	}

	public byte[] array() {
		return buff().array();
	}

	public void clear() {
		buff().clear();
	}

	public void flip() {
		buff().flip();
	}

	public ByteBuffer buff() {
		return this.byteBuffer;
	}

	private void buff(ByteBuffer newByteBuffer) {
		this.byteBuffer = newByteBuffer;
	}
}
