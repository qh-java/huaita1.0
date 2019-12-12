package com.huaita.springcloudssoserver.ds.sql;

import com.huaita.springcloudssoserver.ds.util.Read;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SqlXml
{
  private NodeList nl;

  public SqlXml(String xmlName, Class<?> clazz)
  {
    try
    {
      DocumentBuilderFactory docBuilderFactory = 
        DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
      Document document = docBuilder.parse(getInputStream(
        getSQLXmlName(xmlName), clazz));
      this.nl = document.getElementsByTagName("sql");
    }
    catch (SAXException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
  }

  private String getSQLXmlName(String xmlName)
  {
    String sqlType = Read.getMsg("system.database.type");
    String suffix = ".xml";
    xmlName = xmlName.replaceAll(suffix, "_" + sqlType + suffix);
    return xmlName;
  }

  private InputStream getInputStream(String xmlName, Class<?> clazz)
    throws IOException
  {
    InputStream is = null;
    File f = new File(getPath(clazz) + xmlName);
    if (!f.exists())
    {
      is = getClass().getResourceAsStream("/conf/sql/" + xmlName);
    }
    else {
      is = new FileInputStream(f);
    }
    return is;
  }

  private String getPath(Class<?> clazz)
  {
    String path = clazz.getResource("").getPath();
    path = path.replace("%20", " ");
    path = path.substring(0, path.indexOf(clazz.getPackage().getName().replaceAll("[.]", "/"))) + 
      "sql/";
    return path;
  }

  public Map<String, String> getAllSqls()
  {
    Map result = new HashMap();
    for (int i = 0; i < this.nl.getLength(); i++)
    {
      Node node = this.nl.item(i);
      String nodeId = node.getAttributes().getNamedItem("id")
        .getNodeValue();
      result.put(nodeId, node.getTextContent().trim());
    }
    return result;
  }
}