package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.transaccion.Transaccion;

public class TransaccionVentaController {
    ArrayList<Transaccion> listaTransacciones;
    CrudProductoController crudProductoController;

    public TransaccionVentaController(){
        listaTransacciones = new ArrayList<>();
        crudProductoController = new CrudProductoController();
    }

    public void restarCantidad(String codigo, int cantidad){
        crudProductoController.restarProducto(codigo, cantidad);
        crudProductoController.writeListaProducto();
    }

    public void addTransaccion(String[] info){
        Transaccion transaccion = new Transaccion();
        transaccion.setDetalleCantidad(Short.valueOf(info[0]));
        transaccion.setCliente(info[1]);
        transaccion.setCodigo(info[2]);
        transaccion.setFecha(info[3]);
        transaccion.setIva(Float.valueOf(info[4]));
        transaccion.setDetalleProducto(info[5]);
        transaccion.setDetalleSubtotal(Integer.parseInt(info[6]));
        transaccion.setTotal(Integer.parseInt(info[7]));
        crudProductoController.restarProducto(transaccion.getDetalleCodigo(), Integer.parseInt(transaccion.getDetalleCantidad()));
        listaTransacciones.add(transaccion);
    }

    public void readlistaTransacciones(){
        File file = new File("Ventas.txt");
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
    }
    
    private void parseLine(String line){
        Transaccion transaccion = new Transaccion();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        
        while(scanner.hasNext()){
            transaccion.setDetalleCantidad(Short.valueOf(scanner.next()));
            transaccion.setCliente(scanner.next());
            transaccion.setCodigo(scanner.next());
            transaccion.setFecha(scanner.next());
            transaccion.setIva(Float.valueOf(scanner.next()));
            transaccion.setDetalleProducto(scanner.next());
            transaccion.setDetalleSubtotal(Integer.parseInt(scanner.next()));
            transaccion.setTotal(Integer.parseInt(scanner.next()));
        }
        listaTransacciones.add(transaccion);
        scanner.close();
    }

    public void writelistaTransacciones(){
        File file = new File("Ventas.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int i=0; i<listaTransacciones.size();i++){
                printWriter.println(listaTransacciones.get(i).getDetalleCantidad()+","+listaTransacciones.get(i).getCliente()+","+
                                    listaTransacciones.get(i).getCodigo()+","+listaTransacciones.get(i).getFecha()+","+
                                    listaTransacciones.get(i).getIva()+","+listaTransacciones.get(i).getDetalleCodigo()+","+
                                    listaTransacciones.get(i).getDetalleSubtotal()+","+listaTransacciones.get(i).getTotal());
            }
            printWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
