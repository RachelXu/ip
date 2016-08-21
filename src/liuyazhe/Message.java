package liuyazhe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Message {
	CreateXML createxml = new CreateXML();

	/**
	 * 将InputStream解析成document
	 * 
	 * @param is
	 * @author 刘亚喆
	 */
	public Document parseXmlDom(InputStream is) {

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
			String b = xml.substring(0, xml.lastIndexOf("\n"));
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

	public List<String[]> readXmlBody(byte[] bytes) {
		List<String[]> list = new ArrayList();

		try {
			String xml = new String(bytes);
			String b = xml.substring(0, xml.lastIndexOf("\n"));
			InputStream is = new ByteArrayInputStream(b.getBytes());
			Document doc = parseXmlDom(is);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			javax.xml.transform.Transformer transformer = TransformerFactory
					.newInstance().newTransformer();
			transformer.setOutputProperty("encoding", "gb2312");
			transformer.setOutputProperty("indent", "yes");
			StreamResult streamResult = new StreamResult(baos);
			transformer.transform(new DOMSource(doc), streamResult);
			NodeList nl = doc.getElementsByTagName("member");
			int size = nl.getLength();
			for (int i = 0; i < size; i++) {
				Node n = nl.item(i);
				NodeList nl2 = n.getChildNodes();
				int size2 = nl2.getLength();
				int m = 0;
				String[] st = new String[11];
				// List<String> s = new ArrayList();
				for (int j = 0; j < size2; j++) {

					if (nl2.item(j).getNodeType() == Node.ELEMENT_NODE) {
						if (nl2.item(j).getFirstChild().getNodeValue().trim()
								.toString() != null) {
							st[m] = nl2.item(j).getFirstChild().getNodeValue()
									.trim().toString();
							m++;
						}
					}
				}
				List<String> tmp = new ArrayList<String>();
				for (String str : st) {
					if (str != null && str.length() != 0) {
						tmp.add(str);
					}
				}
				st = tmp.toArray(new String[0]);
				list.add(st);

			}
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 创建报头
	 * 
	 * @param Id
	 *            id
	 * @param requesttype
	 *            请求的id类型
	 * 
	 * @author 刘亚喆
	 */
	public ByteArrayOutputStream createXMLhead(int packetid, int requesttype,
			int Id) {
		Document doc = createxml.creatDoc();
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
		ByteArrayOutputStream baos = createxml.creatXml(doc); // 创建Xml
		return baos;
	}

	public ByteArrayOutputStream createXMLbody(List<String[]> query) {

		Document doc = createxml.creatDoc();
		Element head = doc.createElement("head");
		doc.appendChild(head);
		// 报头
		for (int i = 0; i < 1; i++) {
			Element body = doc.createElement("body");
			head.appendChild(body);
			for (int j = 0; j < query.size(); j++) {
				Element member = doc.createElement("member");
				body.appendChild(member);
				for (int k = 0; k < query.get(j).length; k++) {
					Element Query = doc.createElement("query");
					Query.appendChild(doc.createTextNode(query.get(j)[k]));
					member.appendChild(Query);
				}
			}
		}
		ByteArrayOutputStream baos = createxml.creatXml(doc); // 创建Xml
		return baos;
	}
}
