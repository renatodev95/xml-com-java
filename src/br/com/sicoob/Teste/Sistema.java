package br.com.sicoob.Teste;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.sicoob.Model.Produto;

public class Sistema {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document document = builder.parse("src/vendas.xml");

		NodeList produtos = document.getElementsByTagName("produto");
		for (int i = 0; i < produtos.getLength(); i++) {
			Element produto = (Element) produtos.item(i);
		    String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
		    double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
		    Produto prod = new Produto(nome, preco);

		    System.out.println(prod);
		}
	}
}
