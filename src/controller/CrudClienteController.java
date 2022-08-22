package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.cliente.Cliente;
import modelo.producto.Producto;

public class CrudClienteController {
    ArrayList<Cliente> listaCliente;
    
    public CrudClienteController(){
        listaCliente= new ArrayList<>();
    }
    
    public void addCliente(String [] nuevoCliente){
        Cliente cliente = new Cliente();
        cliente.setNombres(nuevoCliente[0]);
        cliente.setApellidos(nuevoCliente[1]);
        cliente.setNumeroIdentificacion(nuevoCliente[2]);
        cliente.setDireccion((nuevoCliente[3]));
        cliente.setNumeroTelefono(nuevoCliente[4]);
        cliente.setTipoCliente(nuevoCliente[5]);
        if((nuevoCliente[5]).equals("Natural")){
                cliente.setNatural(nuevoCliente[6] , nuevoCliente[7]);
            }else{
                if((nuevoCliente[5]).equals("Juridica")){
                    cliente.setJuridica((nuevoCliente[8]), (nuevoCliente[9]));
                }
            }
        listaCliente.add(cliente);
    }

    public void deleteCliente(int fila) {
       listaCliente.remove(fila);        
    }

    public void writeListaCliente() {
       File file = new File("Clientes.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int i=0; i<listaCliente.size();i++){
                printWriter.println(listaCliente.get(i).getNombres()+","+listaCliente.get(i).getApellidos()+","+
                                    listaCliente.get(i).getNumeroIdentificacion()+","+listaCliente.get(i).getDireccion()+","+
                                    listaCliente.get(i).getNumeroTelefono()+","+listaCliente.get(i).getTipoCliente()+","+
                                    listaCliente.get(i).natural.getEmail()+","+listaCliente.get(i).natural.getFechaNacimiento()+","+
                                    listaCliente.get(i).juridica.getNit()+","+listaCliente.get(i).juridica.getNumeroIdentificacionTributaria());
            }
            printWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(CrudClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    public String[][] readListaCliente(){
        File file = new File("Clientes.txt");
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
        String[][] string1 = new String[listaCliente.size()][10];
        for(int i = 0; i < listaCliente.size(); i++){
            string1[i][0] = listaCliente.get(i).getNombres();
            string1[i][1] = listaCliente.get(i).getApellidos();
            string1[i][2] = listaCliente.get(i).getNumeroIdentificacion();
            string1[i][3] = listaCliente.get(i).getDireccion();
            string1[i][4] = listaCliente.get(i).getNumeroTelefono();
            string1[i][5] = listaCliente.get(i).getTipoCliente();
            string1[i][6] = listaCliente.get(i).natural.getEmail();
            string1[i][7] = listaCliente.get(i).natural.getFechaNacimiento();
            string1[i][8] = listaCliente.get(i).juridica.getNit();
            string1[i][9] = listaCliente.get(i).juridica.getNumeroIdentificacionTributaria();
        }
        return string1;
    }
    private void parseLine(String line){
        Cliente cliente = new Cliente();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        
        while(scanner.hasNext()){
            cliente.setNombres(scanner.next());
            cliente.setApellidos(scanner.next());
            cliente.setNumeroIdentificacion(scanner.next());
            cliente.setDireccion(scanner.next());
            cliente.setNumeroTelefono(scanner.next());
            cliente.setTipoCliente(scanner.next());
            cliente.natural.setEmail(scanner.next());
            cliente.natural.setFechaNacimiento(scanner.next());
            cliente.juridica.setNit(scanner.next());
            cliente.juridica.setNumeroIdentificacionTributaria(scanner.next());
        }
        listaCliente.add(cliente);
        scanner.close();
    }
    public void editCliente(int filaCliente, int posicion, String valor){
       Cliente cliente = listaCliente.get(filaCliente);
       switch(posicion){
           case 1:
               cliente.setNombres(valor);
               listaCliente.set(filaCliente, cliente);
           break;
           case 2:
               cliente.setApellidos(valor);
               listaCliente.set(filaCliente, cliente);
           break;
           case 3:
               cliente.setNumeroIdentificacion(valor);
               listaCliente.set(filaCliente, cliente);
           break;
           case 4:
               cliente.setDireccion(valor);
               listaCliente.set(filaCliente, cliente);
           break;
           case 5:
               cliente.setNumeroTelefono(valor);
               listaCliente.set(filaCliente, cliente);
           break;
           case 6:
               cliente.setTipoCliente(valor);
               listaCliente.set(filaCliente, cliente);
           break;
           case 7:
               cliente.natural.setEmail(valor);
               listaCliente.set(filaCliente, cliente);
           break;
           case 8:
               cliente.natural.setFechaNacimiento(valor);
               listaCliente.set(filaCliente, cliente);
           break;
           case 9:
               cliente.juridica.setNit(valor);
               listaCliente.set(filaCliente, cliente);
           break;
           case 10:
               cliente.juridica.setNumeroIdentificacionTributaria(valor);
               listaCliente.set(filaCliente, cliente);
           break;
       }
    }
}
