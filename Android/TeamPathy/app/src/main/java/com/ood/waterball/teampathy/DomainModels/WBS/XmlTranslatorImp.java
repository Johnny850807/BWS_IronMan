package com.ood.waterball.teampathy.DomainModels.WBS;

import android.content.res.AssetManager;
import android.util.Xml;

import com.ood.waterball.teampathy.Controllers.Global;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class XmlTranslatorImp extends XmlTranslator {
    private final String TASK_GROUP_NAME = "TaskGroup";
    private final String TASK_NAME = "Task";
    private final String NAME_ATT = "name";
    private final String STARTDATE_ATT = "StartDate";
    private final String DESCRIPTION_ATT = "Description";
    private final String ID_ATT = "id";
    private final String ENTDATE_ATT = "EndDate";

    private TaskItem root;

	//todo add id attributes
	public String taskToXml(TaskItem taskRoot) {
		return null;
	}

	public TaskItem xmlToTasks(String xml) throws ParserConfigurationException, IOException, SAXException {
        boolean hasRoot = false;
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
            Log(name + ":" + nodeList.getLength() );
            for ( int i = 0 ; i < nodeList.getLength() ; i ++ )
            {
                Node node = nodeList.item(i);
                if ( node.getNodeType() == Node.ELEMENT_NODE )
                {
                    Log(((Element)node).getAttribute(NAME_ATT));
                    taskItem.addTaskChild(createTaskItem((Element) node));
                }

            }
        }
        else
        {
            String description = element.getAttribute(DESCRIPTION_ATT);
            taskItem = new TodoTask(ofGroup,name,description);
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
