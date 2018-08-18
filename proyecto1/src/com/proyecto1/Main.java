package com.proyecto1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.proyecto1.*;

public class Main {


    public static void main(String[] args) {
        String filePath = "datos.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Actividad");
            NodeList nodeList2 = doc.getElementsByTagName("Relacion");
            //now XML is loaded as Document in memory, lets convert it to Object List
            List<Actividad> actList = new ArrayList<Actividad>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                actList.add(getActividad(nodeList.item(i)));
            }
            List<Relacion> relList = new ArrayList<Relacion>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                relList.add(getRelacion(nodeList2.item(i)));
            }
           
            //lets print Employee list information
            for (Actividad act : actList) {
                System.out.println(act.toString());
            }
            
            for (Relacion rel : relList) {
                System.out.println(rel.toString());
            }
            
            setRelacion(relList, actList);
            for (Actividad act : actList) {
                System.out.println(act.toString());
            }
            
            
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
    	
    	//System.out.println("Hola");

    }


    private static Actividad getActividad(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Actividad act = new Actividad();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            act.setId((getTagValue("id", element)));
            act.setDuracion((Integer.parseInt(getTagValue("duracion", element))));
            act.setX((Integer.parseInt(getTagValue("x", element))));
            act.setY((Integer.parseInt(getTagValue("y", element))));
        }

        return act;
    }

    
    private static Relacion getRelacion(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Relacion rel = new Relacion();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            rel.setActividad((getTagValue("actividad", element)));
            rel.setSucesor((getTagValue("sucesor", element)));
        }

        return rel;
    }

    private static String getTagValue(String tag, Element element) {
        String node = element.getAttribute(tag);
        return node;
    }
    
    private static void setRelacion(List<Relacion> relList, List<Actividad> actList) {
    	for (Actividad actividad : actList) {
	    	for (Relacion relacion : relList) {
				if(relacion.getActividad().equals(actividad.getId())) {
					actividad.setSucesor(relacion.getSucesor());
				}
			}
    	
    	}
    }

}
