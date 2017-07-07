package com.ood.waterball.teampathy.DomainModels.WBS;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class XmlTranslatorImp extends XmlTranslator {
    public static final String TASK_GROUP_NAME = "TaskGroup";
    public static final String TASK_NAME = "Task";
    public static final String NAME_ATT = "name";
    public static final String STARTDATE_ATT = "StartDate";
    public static final String DESCRIPTION_ATT = "Description";
    public static final String ID_ATT = "id";
    public static final String ENTDATE_ATT = "EndDate";
    public static final String CONTRIBUTION_ATT = "Contribution";

    //todo add id attributes
	public String taskToXml(TaskItem taskRoot) throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();
        document.appendChild(taskRoot.toXmlNode(document));

        StringWriter stringWriter = new StringWriter();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
        Log(stringWriter.toString());
		return stringWriter.toString();
	}

	public TaskItem xmlToTasks(String xml) throws ParserConfigurationException, IOException, SAXException {
        Document document = parseRootElement(xml);
        Element rootElement = document.getDocumentElement();
        TaskItem taskRoot = new TaskRoot(rootElement.getAttribute(NAME_ATT));
		NodeList nodeList = rootElement.getChildNodes();
        for ( int i = 0 ; i < nodeList.getLength() ; i ++ )
        {
            Node node = nodeList.item(i);
            if ( node.getNodeType() == Node.ELEMENT_NODE )
                taskRoot.addTaskChild(createTaskItem((Element) node));
        }
        return taskRoot;
	}

	private TaskItem createTaskItem(Element element){
        TaskItem taskItem;
        String name = element.getAttribute(NAME_ATT);
        String ofGroup = ((Element)element.getParentNode()).getAttribute(NAME_ATT);
        if (element.getTagName().equals(TASK_GROUP_NAME))
        {
            taskItem = new TaskGroup(ofGroup,name);
            NodeList nodeList = element.getChildNodes();
            for ( int i = 0 ; i < nodeList.getLength() ; i ++ )
            {
                Node node = nodeList.item(i);
                if ( node.getNodeType() == Node.ELEMENT_NODE )
                    taskItem.addTaskChild(createTaskItem((Element) node));
            }
        }
        else
        {
            String description = element.getAttribute(DESCRIPTION_ATT);
            int contribution = Integer.parseInt(element.getAttribute(CONTRIBUTION_ATT));
            taskItem = new TodoTask(ofGroup,name,description,contribution);
        }

        return taskItem;
    }

	private Document parseRootElement(String xml) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        is.setEncoding("UTF-8");
        return builder.parse(is);
    }
}
