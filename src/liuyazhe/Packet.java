package liuyazhe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Packet {
	// /**
	// * ����XML�ļ����ļ���ʽ
	// *
	// * @param Document
	// * @author ���ǆ�
	// */

	// public void creatXml (Document doc){
	// StringWriter writer = null;

	// try {
	// TransformerFactory tFact = TransformerFactory.newInstance();
	// Transformer trans = tFact.newTransformer();
	// trans.setOutputProperty("encoding", "gb2312");
	// writer = new StringWriter();
	// StreamResult result = new StreamResult(writer);
	// DOMSource source = new DOMSource(doc);
	// trans.transform(source, result);
	// FileOutputStream fos = new FileOutputStream(new File("d:/1.xml"));
	// Writer os = new OutputStreamWriter(fos, "gb2312");
	// os.write(writer.toString());
	// os.flush();
	// fos.close();
	// } catch (TransformerConfigurationException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (UnsupportedEncodingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (TransformerFactoryConfigurationError e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (TransformerException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
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
			// TODO
			// FileOutputStream fos = new FileOutputStream(new
			// File("d:/1.xml"));
			// fos.write(baos.toByteArray());

			// TransformerFactory tFact = TransformerFactory.newInstance();
			// Transformer trans = tFact.newTransformer();
			// trans.setOutputProperty("encoding", "gb2312");
			// trans.setOutputProperty("indent", "yes") ;
			// StreamResult result = new StreamResult(baos);
			// DOMSource source = new DOMSource(doc);
			// trans.transform(source, result);
			// baos.flush();
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

	/**
	 * ����XML��ͷ,�����������ʽ
	 * 
	 * @param xml
	 * @author ���ǆ�
	 */
	public String[] readXmlHead(byte[] bytes) {
		// ��ͷ����
		String[] st = new String[3];
		try {
			String xml = new String(bytes);
			String b = xml.substring(0, xml.lastIndexOf("\r\n"));
			InputStream is = new ByteArrayInputStream(b.getBytes());
			Document doc = parseXmlDom(is);
			// д��2.xml�ļ���,�����ã���Ҫʱɾ��
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			javax.xml.transform.Transformer transformer = TransformerFactory
					.newInstance().newTransformer();
			transformer.setOutputProperty("encoding", "gb2312");
			transformer.setOutputProperty("indent", "yes");
			StreamResult streamResult = new StreamResult(baos);
			transformer.transform(new DOMSource(doc), streamResult);
			// д����̣����ӻ�xml
			FileOutputStream fos = new FileOutputStream(new File("d:/2.xml"));
			fos.write(baos.toByteArray());
			// ɾ����ֹ��
			st[0] = doc.getElementsByTagName("packet_id").item(0)
					.getFirstChild().getNodeValue().trim().toString();
			st[1] = doc.getElementsByTagName("request_type").item(0)
					.getFirstChild().getNodeValue().trim().toString();
			st[2] = doc.getElementsByTagName("request_id").item(0)
					.getFirstChild().getNodeValue().trim().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return st;
	}

	/**
	 * ��InputStream������document
	 * 
	 * @param is
	 * @author ���ǆ�
	 */
	public static Document parseXmlDom(InputStream is) {

		org.w3c.dom.Document document = null;
		try {

			// getting the default implementation of DOM builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			dbf.setValidating(false);
			dbf.setIgnoringComments(false);
			dbf.setIgnoringElementContentWhitespace(true);
			dbf.setNamespaceAware(true);
			DocumentBuilder builder = dbf.newDocumentBuilder();
			// parsing the XML file
			document = builder.parse(is);

		} catch (Exception e) {
			// catching all exceptions
			System.out.println();
			System.out.println(e.toString());
		}
		return document;
	}

	/**
	 * ����XML��ͷ���ļ���ʽ
	 * 
	 * @param xml
	 * @author ���ǆ�
	 */
	public String[] readXmlHead(String xml) {
		String[] st = new String[10];
		Document doc = null;
		try {
			File f = new File(xml);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(f);

			st[0] = doc.getElementsByTagName("packet_id").item(0)
					.getFirstChild().getNodeValue().toString();
			st[1] = doc.getElementsByTagName("request_type").item(0)
					.getFirstChild().getNodeValue().toString();
			st[2] = doc.getElementsByTagName("request_id").item(0)
					.getFirstChild().getNodeValue().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return st;
	}

	/**
	 * ����XML����,�����������ʽ
	 * 
	 * @param xml
	 * @author ���ǆ�
	 */
	public String[] readXmlBody(byte[] bytes) {
		// ��ͷ����
		String[] st = new String[9];
		try {
			String xml = new String(bytes);
			String b = xml.substring(0, xml.lastIndexOf("\r\n"));
			InputStream is = new ByteArrayInputStream(b.getBytes());
			Document doc = parseXmlDom(is);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			javax.xml.transform.Transformer transformer = TransformerFactory
					.newInstance().newTransformer();
			transformer.setOutputProperty("encoding", "gb2312");
			transformer.setOutputProperty("indent", "yes");
			StreamResult streamResult = new StreamResult(baos);
			transformer.transform(new DOMSource(doc), streamResult);
			// д����̣����ӻ�xml
			FileOutputStream fos = new FileOutputStream(new File("d:/3.xml"));
			fos.write(baos.toByteArray());
			NodeList nl = doc.getElementsByTagName("member");
			int size = nl.getLength();
			for (int i = 0; i < size; i++) {
				st[i] = nl.item(i).getFirstChild().getNodeValue().trim()
						.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return st;
	}

	/**
	 * ����XML����,�ļ���ʽ
	 * 
	 * @param xml
	 * @author ���ǆ�
	 */
	public String[][] readXmlBody(String xml) {
		String[][] st = new String[100][100];
		Document doc = null;
		try {
			File f = new File(xml);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(f);
			NodeList nl = doc.getElementsByTagName("member");
			int size = nl.getLength();
			for (int i = 0; i < size; i++) {
				Node n = nl.item(i);
				NodeList nl2 = n.getChildNodes();
				int size2 = nl2.getLength();
				for (int j = 0; j < size2; j++) {
					st[i][j] = nl2.item(j).getFirstChild().getNodeValue()
							.toString();
				}
			}
		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		}
		return st;
	}

	/**
	 * ͨ����Ŀid�����Ŀ��Ϣ
	 * 
	 * @param Id
	 *            id
	 * @param requesttype
	 *            �����id���ͣ�301ΪӰƬid��ȡ��һӰƬ��303ΪĿ¼id��ȡ����Ŀ¼�µ�ӰƬ,100Ϊ�����û�,200Ϊ����Ŀ¼
	 * 
	 * @author ���ǆ�
	 */
	public ByteArrayOutputStream requestDetailById(int packetid,
			int requesttype, int Id) {

		Document doc = creatDoc();

		int[] line = { packetid, requesttype, Id };
		Element root = doc.createElement("head");
		doc.appendChild(root);
		// ��ͷ
		for (int i = 0; i < 1; i++) {

			Element Packetid = doc.createElement("packet_id");
			Packetid.appendChild(doc.createTextNode(String.valueOf(line[0])));
			root.appendChild(Packetid);

			Element request_type = doc.createElement("request_type");
			request_type.appendChild(doc
					.createTextNode(String.valueOf(line[1])));
			root.appendChild(request_type);

			Element request_id = doc.createElement("request_id");
			request_id.appendChild(doc.createTextNode(String.valueOf(line[2])));
			root.appendChild(request_id);
		}
		// ������ͷ
		ByteArrayOutputStream baos = creatXml(doc); // ����Xml
		return baos;
	}

	/**
	 * ���ʹ����ĵı���
	 * 
	 * @param Query
	 *            ��������
	 * @param sourceport
	 *            �˿ں�
	 * @param requesttype
	 *            ��������
	 * @author ���ǆ�
	 */
	public ByteArrayOutputStream requestDetailByQuery(String[][] query,
			int pocketid, int requesttype, int requestid) {

		Document doc = creatDoc();
		int[] line = { pocketid, requesttype, requestid };
		Element head = doc.createElement("head");
		doc.appendChild(head);
		// ��ͷ
		for (int i = 0; i < 1; i++) {

			Element packetid = doc.createElement("packet_id");
			packetid.appendChild(doc.createTextNode(String.valueOf(line[0])));
			head.appendChild(packetid);

			Element request_type = doc.createElement("request_type");
			request_type.appendChild(doc
					.createTextNode(String.valueOf(line[1])));
			head.appendChild(request_type);

			Element request_id = doc.createElement("request_id");
			request_id.appendChild(doc.createTextNode(String.valueOf(line[2])));
			head.appendChild(request_id);
			Element body = doc.createElement("body");
			head.appendChild(body);
			for (int j = 0; j < query.length; j++) {
				Element member = doc.createElement("member");
				body.appendChild(member);
				for (int k = 0; k < query[j].length; k++) {
					Element Query = doc.createElement("query");
					Query.appendChild(doc.createTextNode(query[j][k]));
					member.appendChild(Query);
				}
			}
		}
		// ������ͷ
		ByteArrayOutputStream baos = creatXml(doc); // ����Xml
		return baos;
	}

	/**
	 * ���ʹ����ĵı���
	 * 
	 * @param Query
	 *            ��������
	 * @param sourceport
	 *            �˿ں�
	 * @param requesttype
	 *            ��������
	 * @author ���ǆ�
	 */
	public ByteArrayOutputStream requestDetailByQuery(String[] query,
			int pocketid, int requesttype, int requestid) {

		Document doc = creatDoc();
		int[] line = { pocketid, requesttype, requestid };
		Element head = doc.createElement("head");
		doc.appendChild(head);
		// ��ͷ
		for (int i = 0; i < 1; i++) {

			Element packetid = doc.createElement("packet_id");
			packetid.appendChild(doc.createTextNode(String.valueOf(line[0])));
			head.appendChild(packetid);

			Element request_type = doc.createElement("request_type");
			request_type.appendChild(doc
					.createTextNode(String.valueOf(line[1])));
			head.appendChild(request_type);

			Element request_id = doc.createElement("request_id");
			request_id.appendChild(doc.createTextNode(String.valueOf(line[2])));
			head.appendChild(request_id);
			Element body = doc.createElement("body");
			head.appendChild(body);
			for (int j = 0; j < query.length; j++) {
				Element member = doc.createElement("member");
				member.appendChild(doc.createTextNode(query[j]));
				body.appendChild(member);
			}
		}
		// ������ͷ
		ByteArrayOutputStream baos = creatXml(doc); // ����Xml
		return baos;
	}

}
