package liuyazhe;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;

public class CreateXML {
	/**
	 * ����XML�ļ��������������ʽ
	 * 
	 * @param Document
	 * @author ���ǆ�
	 */

	public ByteArrayOutputStream creatXml(Document doc) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			javax.xml.transform.Transformer transformer = TransformerFactory
					.newInstance().newTransformer();
			transformer.setOutputProperty("encoding", "gb2312");
			transformer.setOutputProperty("indent", "yes");
			StreamResult streamResult = new StreamResult(baos);
			transformer.transform(new DOMSource(doc), streamResult);
			// д����̣����ӻ�xml
			FileOutputStream fos = new FileOutputStream(new File("d:/1.xml"));
			fos.write(baos.toByteArray());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baos;
	}

	/**
	 * ����DOC�ļ�
	 * 
	 * @author ���ǆ�
	 */
	public Document creatDoc() {

		Document doc = null;
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			doc = build.newDocument();
			doc.setXmlStandalone(true);
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
}
