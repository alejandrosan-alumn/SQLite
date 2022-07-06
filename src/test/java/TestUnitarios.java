/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ModeloDatos.Empresa;
import Vista.Ventana;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alexP
 */
public class TestUnitarios {

    public TestUnitarios() {
    }

    @Test
    public void TestAñadirEmpresaYEscribirlaEnElFichero(){

        Ventana ventanaTest = new Ventana();
        Empresa empresaTest = new Empresa("Test", "Test", "Test", "Test", ventanaTest.getListaEmpresas().size());
        int tamañoLibreDelFicheroPreEscritura = ventanaTest.getCrearFichero().DimensionTablaEmpresa();

        ventanaTest.getListaEmpresas().add(empresaTest);
        ventanaTest.getCrearFichero().EscribirFicheroEmpresas(ventanaTest.getListaEmpresas());
        assertNotEquals(tamañoLibreDelFicheroPreEscritura, ventanaTest.getCrearFichero().DimensionTablaEmpresa());
        ventanaTest.getListaEmpresas().remove(ventanaTest.getListaEmpresas().size()-1);
        ventanaTest.getCrearFichero().EscribirFicheroEmpresas(ventanaTest.getListaEmpresas());
    }
    @Test
    public void TestLeerArchivoYLeerLaEmpresaTestIntroducida(){
        
        Ventana ventanaTest = new Ventana();
        Empresa empresaTestAniadir = new Empresa("Test", "Test", "Test", "Test", ventanaTest.getListaEmpresas().size());
        ventanaTest.getListaEmpresas().add(empresaTestAniadir);
        ventanaTest.getCrearFichero().EscribirFicheroEmpresas(ventanaTest.getListaEmpresas());
        
        Empresa empresaTest = new Empresa("Test", "Test", "Test", "Test", ventanaTest.getListaEmpresas().size()-1);
        ventanaTest.CargarArraysDeDatos();
        assertEquals(empresaTest.getNombre(), ventanaTest.getListaEmpresas().get(ventanaTest.getListaEmpresas().size()-1).getNombre());
        
        ventanaTest.getListaEmpresas().remove(ventanaTest.getListaEmpresas().size()-1);
        ventanaTest.getCrearFichero().EscribirFicheroEmpresas(ventanaTest.getListaEmpresas());
    }
    @Test
    public void TestModificarUnaEmpresaYQueSeModifiqueEnElFichero(){
        
        Ventana ventanaTest = new Ventana();
        Empresa empresaTestAniadir = new Empresa("Test", "Test", "Test", "Test", ventanaTest.getListaEmpresas().size());
        ventanaTest.getListaEmpresas().add(empresaTestAniadir);
        ventanaTest.getCrearFichero().EscribirFicheroEmpresas(ventanaTest.getListaEmpresas());
        ventanaTest.CargarArraysDeDatos();
        
        ventanaTest.ModificarSeleccionadoDelArray("TestMod", "TestMod", "TestMod", "TestMod", ventanaTest.getListaEmpresas().size()-1);
        ventanaTest.getCrearFichero().EscribirFicheroEmpresas(ventanaTest.getListaEmpresas());
        ventanaTest.CargarArraysDeDatos();
        assertEquals("TestMod", ventanaTest.getListaEmpresas().get(ventanaTest.getListaEmpresas().size()-1).getNombre());
        
        ventanaTest.getListaEmpresas().remove(ventanaTest.getListaEmpresas().size()-1);
        ventanaTest.getCrearFichero().EscribirFicheroEmpresas(ventanaTest.getListaEmpresas());
    }
    @Test
    public void TestEliminarEmpresaTestPorCompleto(){
        Ventana ventanaTest = new Ventana();
        int posicionBorrado = 0;
        Empresa empresaTest = new Empresa("Test", "Test", "Test", "Test", ventanaTest.getListaEmpresas().size());
        ventanaTest.getListaEmpresas().add(empresaTest);
        ventanaTest.getCrearFichero().EscribirFicheroEmpresas(ventanaTest.getListaEmpresas());
        ventanaTest.CargarArraysDeDatos();
        
        if(ventanaTest.getListaEmpresas().size() > 0){
            posicionBorrado = ventanaTest.getListaEmpresas().size()-1;
        }

        ventanaTest.getListaEmpresas().remove(posicionBorrado);
        ventanaTest.getCrearFichero().EscribirFicheroEmpresas(ventanaTest.getListaEmpresas());
        ventanaTest.CargarArraysDeDatos();
        assertEquals(posicionBorrado, ventanaTest.getListaEmpresas().size());
    }
}