/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.producto.Producto;

/**
 *
 * @author Esteban
 */
public class CrudProductoController {
    ArrayList<Producto> listaProducto;
    
    public CrudProductoController(){
        listaProducto = new ArrayList<>();
    }
    
    public void addProducto(String[] nuevoProducto){
        Producto producto = new Producto();
        producto.setCodigo(nuevoProducto[0]);
        producto.setNombre(nuevoProducto[1]);
        producto.setDescripcion(nuevoProducto[2]);
        producto.setValorUnitario(Integer.parseInt(nuevoProducto[3]));
        producto.setCantidadExistencia(Integer.parseInt(nuevoProducto[4]));
        producto.setTipoProducto(nuevoProducto[5]);
        if(nuevoProducto[5] == "Perecederos"){
                producto.setPerecederos(nuevoProducto[6]);
            }else{
                if(nuevoProducto[5] == "Refrigerados"){
                    producto.setRefrigerados(nuevoProducto[7], Float.valueOf(nuevoProducto[8]));
                }else{
                    if(nuevoProducto[5] == "Envasados"){
                        producto.setEnvasado(nuevoProducto[9], Float.valueOf(nuevoProducto[10]), nuevoProducto[11]);
                    }
                }
            }
        listaProducto.add(producto);
    }
    
    public void deleteProducto(int index){
        listaProducto.remove(index);
    }
    
    public void writeListaProducto(){
        File file = new File("Productos.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int i=0; i<listaProducto.size();i++){
                printWriter.println(listaProducto.get(i).getCodigo()+","+listaProducto.get(i).getNombre()+","+
                                    listaProducto.get(i).getDescripcion()+","+listaProducto.get(i).getValorUnitario()+","+
                                    listaProducto.get(i).getCantidadExistencia()+","+listaProducto.get(i).getTipoProducto()+","+
                                    listaProducto.get(i).getPerecederos()+","+listaProducto.get(i).getRefrigeradosCodigo()+","+
                                    listaProducto.get(i).getRefrigeradosTemperatura()+","+listaProducto.get(i).getEnvasadoFecha()+","+
                                    listaProducto.get(i).getEnvasadoPeso()+","+listaProducto.get(i).getEnvasadoPais());
            }
            printWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(CrudProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void restarProducto(String codigo, int cantidad){
        readListaProducto();
        for(int i = 0; i<listaProducto.size(); i++){
            if(listaProducto.get(i).getCodigo().equals(codigo) && listaProducto.get(i).getCantidadExistencia() - cantidad >= 0){
                listaProducto.get(i).setCantidadExistencia(listaProducto.get(i).getCantidadExistencia() - cantidad);
            }
        }
        writeListaProducto();
    }
    
    public String[][] readListaProducto(){
        File file = new File("Productos.txt");
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
             String string = scanner.nextLine();
             parseLine(string);
            }
        }catch(IOException exp){
            exp.printStackTrace();
        }
        scanner.close();
        String[][] string1 = new String[listaProducto.size()][12];
        for(int i = 0; i < listaProducto.size(); i++){
            string1[i][0] = listaProducto.get(i).getCodigo();
            string1[i][1] = listaProducto.get(i).getNombre();
            string1[i][2] = listaProducto.get(i).getDescripcion();
            string1[i][3] = String.valueOf(listaProducto.get(i).getValorUnitario());
            string1[i][4] = String.valueOf(listaProducto.get(i).getCantidadExistencia());
            string1[i][5] = listaProducto.get(i).getTipoProducto();
            string1[i][6] = listaProducto.get(i).getPerecederos();
            string1[i][7] = listaProducto.get(i).getRefrigeradosCodigo();
            string1[i][8] = listaProducto.get(i).getRefrigeradosTemperatura();
            string1[i][9] = listaProducto.get(i).getEnvasadoFecha();
            string1[i][10] = listaProducto.get(i).getEnvasadoPeso();
            string1[i][11] = listaProducto.get(i).getEnvasadoPais();
        }
        return string1;
    }
    
    private void parseLine(String line){
        Producto producto = new Producto();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        
        while(scanner.hasNext()){
            producto.setCodigo(scanner.next());
            producto.setNombre(scanner.next());
            producto.setDescripcion(scanner.next());
            producto.setValorUnitario(Integer.parseInt(scanner.next()));
            producto.setCantidadExistencia(Integer.parseInt(scanner.next()));
            producto.setTipoProducto(scanner.next());
            producto.setPerecederos(scanner.next());
            producto.setRefrigeradosCodigo(scanner.next());
            producto.setRefrigeradosTemperatura(Float.valueOf(scanner.next()));
            producto.setEnvasadoFecha(scanner.next());
            producto.setEnvasadoPeso(Float.valueOf(scanner.next()));
            producto.setEnvasadoPais(scanner.next());
        }
        listaProducto.add(producto);
        scanner.close();
    }
  
    public void editProducto(int indexProducto, int campo, String valor){
       Producto producto = listaProducto.get(indexProducto);
       switch(campo){
           case 1:
               producto.setCodigo(valor);
               listaProducto.set(indexProducto, producto);
           break;
           case 2:
               producto.setNombre(valor);
               listaProducto.set(indexProducto, producto);
           break;
           case 3:
               producto.setDescripcion(valor);
               listaProducto.set(indexProducto, producto);
           break;
           case 4:
               producto.setValorUnitario(Integer.parseInt(valor));
               listaProducto.set(indexProducto, producto);
           break;
           case 5:
               producto.setCantidadExistencia(Integer.parseInt(valor));
               listaProducto.set(indexProducto, producto);
           break;
           case 6:
               producto.setTipoProducto(valor);
               listaProducto.set(indexProducto, producto);
           break;
           case 7:
               producto.setPerecederos(valor);
               listaProducto.set(indexProducto, producto);
           break;
           case 8:
               producto.setRefrigeradosCodigo(valor);
               listaProducto.set(indexProducto, producto);
           break;
           case 9:
               producto.setRefrigeradosTemperatura(Float.valueOf(valor));
               listaProducto.set(indexProducto, producto);
           break;
           case 10:
               producto.setEnvasadoFecha(valor);
               listaProducto.set(indexProducto, producto);
           break;
           case 11:
               producto.setEnvasadoPeso(Float.valueOf(valor));
               listaProducto.set(indexProducto, producto);
           break;
           case 12:
               producto.setEnvasadoPais(valor);
               listaProducto.set(indexProducto, producto);
           break;
       }
    }
}
