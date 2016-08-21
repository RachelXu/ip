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
	// * 创建XML文件，文件方式
	// *
	// * @param Document
	// * @author 刘亚喆
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
	 * 创建XML文件，输入输出流方式
	 * 
	 * @param Document
	 * @author 刘亚喆
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

			// 写入磁盘，可视化xml
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
	 * 创建DOC文件
	 * 
	 * @author 刘亚喆
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
	 * 解析XML报头,输入输出流方式
	 * 
	 * @param xml
	 * @author 刘亚喆
	 */
	public String[] readXmlHead(byte[] bytes) {
		// 报头长度
		String[] st = new String[3];
		try {
			String xml = new String(bytes);
			String b = xml.substring(0, xml.lastIndexOf("\r\n"));
			InputStream is = new ByteArrayInputStream(b.getBytes());
			Document doc = parseXmlDom(is);
			// 写入2.xml文件中,测试用，需要时删除
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			javax.xml.transform.Transformer transformer = TransformerFactory
					.newInstance().newTransformer();
			transformer.setOutputProperty("encoding", "gb2312");
			transformer.setOutputProperty("indent", "yes");
			StreamResult streamResult = new StreamResult(baos);
			transformer.transform(new DOMSource(doc), streamResult);
			// 写入磁盘，可视化xml
			FileOutputStream fos = new FileOutputStream(new File("d:/2.xml"));
			fos.write(baos.toByteArray());
			// 删除截止符
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
	 * 将InputStream解析成document
	 * 
	 * @param is
	 * @author 刘亚喆
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
	 * 解析XML报头，文件方式
	 * 
	 * @param xml
	 * @author 刘亚喆
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
	 * 解析XML正文,输入输出流方式
	 * 
	 * @param xml
	 * @author 刘亚喆
	 */
	public String[] readXmlBody(byte[] bytes) {
		// 报头长度
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
			// 写入磁盘，可视化xml
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
	 * 解析XML正文,文件方式
	 * 
	 * @param xml
	 * @author 刘亚喆
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
	 * 通过节目id请求节目信息
	 * 
	 * @param Id
	 *            id
	 * @param requesttype
	 *            请求的id类型，301为影片id获取单一影片，303为目录id获取整个目录下的影片,100为请求用户,200为请求目录
	 * 
	 * @author 刘亚喆
	 */
	public ByteArrayOutputStream requestDetailById(int packetid,
			int requesttype, int Id) {

		Document doc = creatDoc();

		int[] line = { packetid, requesttype, Id };
		Element root = doc.createElement("head");
		doc.appendChild(root);
		// 报头
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
		// 结束报头
		ByteArrayOutputStream baos = creatXml(doc); // 创建Xml
		return baos;
	}

	/**
	 * 发送带正文的报文
	 * 
	 * @param Query
	 *            报文内容
	 * @param sourceport
	 *            端口号
	 * @param requesttype
	 *            请求类型
	 * @author 刘亚喆
	 */
	public ByteArrayOutputStream requestDetailByQuery(String[][] query,
			int pocketid, int requesttype, int requestid) {

		Document doc = creatDoc();
		int[] line = { pocketid, requesttype, requestid };
		Element head = doc.createElement("head");
		doc.appendChild(head);
		// 报头
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
		// 结束报头
		ByteArrayOutputStream baos = creatXml(doc); // 创建Xml
		return baos;
	}

	/**
	 * 发送带正文的报文
	 * 
	 * @param Query
	 *            报文内容
	 * @param sourceport
	 *            端口号
	 * @param requesttype
	 *            请求类型
	 * @author 刘亚喆
	 */
	public ByteArrayOutputStream requestDetailByQuery(String[] query,
			int pocketid, int requesttype, int requestid) {

		Document doc = creatDoc();
		int[] line = { pocketid, requesttype, requestid };
		Element head = doc.createElement("head");
		doc.appendChild(head);
		// 报头
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
		// 结束报头
		ByteArrayOutputStream baos = creatXml(doc); // 创建Xml
		return baos;
	}

}
