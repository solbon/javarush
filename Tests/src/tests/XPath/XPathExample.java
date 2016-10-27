package tests.XPath;

/**
 * Created by admin on 03.02.2016.
 */

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XPathExample {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException,
			IOException, XPathExpressionException {

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		Document doc = builder.parse("C:\\tmp\\books.xml");

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("@*");
		System.out.println(expr.evaluate(doc));

		// Object result = expr.evaluate(doc, XPathConstants.STRING);
		// String nodes = (String) result;
		// System.out.println(nodes);
		// for (int i = 0; i < nodes.getLength(); i++) {
		// System.out.println(nodes.item(i).getNodeValue());
		// }

	}

}