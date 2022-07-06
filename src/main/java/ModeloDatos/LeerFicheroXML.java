/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDatos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author alexP
 */
public class LeerFicheroXML {

    DocumentBuilderFactory factory;
    Document documento;
    DocumentBuilder build;
    
    public LeerFicheroXML() {
    
        factory = null;
        documento = null;
        build = null;
    }
    
    public void LeerFicheroEmpresa(ArrayList<Empresa>listaEmpresa){
        
        factory = DocumentBuilderFactory.newInstance();
        try {
            build = this.factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        }
        try {
            documento = build.parse("empresas.xml");
        } catch (SAXException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        }
        
        if(documento != null){
            String nombreEmpresa = null, paisSede = null, fechaFundacion = null, ceo = null;
            int idEmpresa = -1;
            NodeList empresas = this.documento.getElementsByTagName("Empresa");
            for(int i = 0; i < empresas.getLength(); i++){
                Node empresa = empresas.item(i);
                Element elemento = (Element) empresa;
                idEmpresa = Integer.parseInt(elemento.getElementsByTagName("idEmpresa").item(0).getChildNodes().item(0).getNodeValue());
                nombreEmpresa = elemento.getElementsByTagName("Nombre").item(0).getChildNodes().item(0).getNodeValue();
                paisSede = elemento.getElementsByTagName("PaisSede").item(0).getChildNodes().item(0).getNodeValue();
                fechaFundacion = elemento.getElementsByTagName("FechaFundacion").item(0).getChildNodes().item(0).getNodeValue();
                ceo = elemento.getElementsByTagName("ceo").item(0).getChildNodes().item(0).getNodeValue();
                listaEmpresa.add(new Empresa(nombreEmpresa, paisSede, fechaFundacion, ceo, idEmpresa));
            }
        }
    }
    
    public void LeerFicheroSaga(ArrayList<Saga>lista){
        
        factory = DocumentBuilderFactory.newInstance();
        try {
            build = this.factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        }
        try {
            documento = build.parse("sagas.xml");
        } catch (SAXException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        }
        
        if(documento != null){
            String nombre = null, Desarrolladora = null, genero = null;
            int idSaga = -1, idEmpresaSaga = -1, aniCreacion = 0;
            NodeList empresas = this.documento.getElementsByTagName("Saga");
            for(int i = 0; i < empresas.getLength(); i++){
                Node empresa = empresas.item(i);
                Element elemento = (Element) empresa;
                idSaga = Integer.parseInt(elemento.getElementsByTagName("idSaga").item(0).getChildNodes().item(0).getNodeValue());
                nombre = elemento.getElementsByTagName("NombreSaga").item(0).getChildNodes().item(0).getNodeValue();
                Desarrolladora = elemento.getElementsByTagName("Desarrolladora").item(0).getChildNodes().item(0).getNodeValue();
                aniCreacion = Integer.parseInt(elemento.getElementsByTagName("AnioCreacion").item(0).getChildNodes().item(0).getNodeValue());
                genero = elemento.getElementsByTagName("genero").item(0).getChildNodes().item(0).getNodeValue();
                idEmpresaSaga = Integer.parseInt(elemento.getElementsByTagName("idEmpresaSaga").item(0).getChildNodes().item(0).getNodeValue());
                lista.add(new Saga(nombre, Desarrolladora, genero, aniCreacion, idSaga, idEmpresaSaga));
            }
        }
    }
    
    public void LeerFicheroVideojuego(ArrayList<Videojuego>lista){
        
        factory = DocumentBuilderFactory.newInstance();
        try {
            build = this.factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        }
        try {
            documento = build.parse("videojuegos.xml");
        } catch (SAXException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        }
        
        if(documento != null){
            String nombre = null, motor = null, fechaLanzamiento = null;
            int idVideojuego = -1, idSagaVideojuego = -1, pegi = 0;
            NodeList nodoLista = this.documento.getElementsByTagName("Videojuego");
            for(int i = 0; i < nodoLista.getLength(); i++){
                Node nodo = nodoLista.item(i);
                Element elemento = (Element) nodo;
                idVideojuego = Integer.parseInt(elemento.getElementsByTagName("idVideojuego").item(0).getChildNodes().item(0).getNodeValue());
                nombre = elemento.getElementsByTagName("NombreVideojuego").item(0).getChildNodes().item(0).getNodeValue();
                motor = elemento.getElementsByTagName("MotorVideojuego").item(0).getChildNodes().item(0).getNodeValue();
                fechaLanzamiento = elemento.getElementsByTagName("FechaLanzamiento").item(0).getChildNodes().item(0).getNodeValue();
                pegi = Integer.parseInt(elemento.getElementsByTagName("pegi").item(0).getChildNodes().item(0).getNodeValue());
                idSagaVideojuego = Integer.parseInt(elemento.getElementsByTagName("idSagaVideojuego").item(0).getChildNodes().item(0).getNodeValue());
                lista.add(new Videojuego(nombre, motor, fechaLanzamiento, pegi, idVideojuego, idSagaVideojuego));
            }
        }
    }
    
    public void LeerFicheroPersonaje(ArrayList<Personaje>lista){
        
        factory = DocumentBuilderFactory.newInstance();
        try {
            build = this.factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        }
        try {
            documento = build.parse("personajes.xml");
        } catch (SAXException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error ocurrido, código del error: " + ex);
        }
        
        if(documento != null){
            String nombre = null, interpreteModelo = null, interpreteVoz = null;
            int idPersonaje = -1, idVideojuegoPersonaje = -1, anioAparicion = 0;
            NodeList nodoLista = this.documento.getElementsByTagName("Personaje");
            for(int i = 0; i < nodoLista.getLength(); i++){
                Node nodo = nodoLista.item(i);
                Element elemento = (Element) nodo;
                idPersonaje = Integer.parseInt(elemento.getElementsByTagName("idPersonaje").item(0).getChildNodes().item(0).getNodeValue());
                nombre = elemento.getElementsByTagName("NombrePersonaje").item(0).getChildNodes().item(0).getNodeValue();
                interpreteModelo = elemento.getElementsByTagName("InterpreteModelo").item(0).getChildNodes().item(0).getNodeValue();
                interpreteVoz = elemento.getElementsByTagName("InterpreteVoz").item(0).getChildNodes().item(0).getNodeValue();
                anioAparicion = Integer.parseInt(elemento.getElementsByTagName("AnioAparicion").item(0).getChildNodes().item(0).getNodeValue());
                idVideojuegoPersonaje = Integer.parseInt(elemento.getElementsByTagName("idVideojuegoPersonaje").item(0).getChildNodes().item(0).getNodeValue());
                lista.add(new Personaje(nombre, interpreteModelo, interpreteVoz, anioAparicion, idPersonaje, idVideojuegoPersonaje));
            }
        }
    }
}