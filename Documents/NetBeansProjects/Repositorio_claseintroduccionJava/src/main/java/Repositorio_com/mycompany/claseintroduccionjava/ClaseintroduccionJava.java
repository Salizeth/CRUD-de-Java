/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Repositorio_com.mycompany.claseintroduccionjava;

import java.util.Scanner;

/**
 *
 * @author Sandra/Sergio/Daniel
 */
public class ClaseintroduccionJava {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner Scanner = new Scanner(System.in);
        LibroCrud Libro = new LibroCrud();
                
        while (true) {
            System.out.println("Opciones: ");
            System.out.println("1. crear un libro ");
            System.out.println("2. Leer todos los libros");
            System.out.println("3. Leer libros por ID");
            System.out.println("4. Actualizar estado Libro");
            System.out.println("5. Elimininar libro");
            System.out.println("6. Salir del sistema");
            
            int opcion = Scanner.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    System.out.println("ID del libro");
                    int idLibro = Scanner.nextInt();
                    Scanner.nextLine();
                    System.out.println("Título: ");
                    String titulo = Scanner.nextLine();
                    System.out.println("Autor: ");
                    String autor = Scanner.nextLine();
                    System.out.println("Editorial: ");
                    String editorial = Scanner.nextLine();
                    System.out.println("Año Publicación: ");
                    int aniopublicacion = Scanner.nextInt();
                    Scanner.nextLine();
                    System.out.println("ISBN: ");
                    String isbn = Scanner.nextLine();
                    System.out.println("Categoría: ");
                    String categoria = Scanner.nextLine();
                    System.out.println("Estado: ");
                    String estado = Scanner.nextLine();
                    Libro.crearLibro(idLibro,titulo, autor, editorial, aniopublicacion, isbn, categoria, estado);
                }
                case 2 -> {
                    Libro.LeerLibros();
                }
                case 3 -> {
                    System.out.println("ID del libro");
                    int idLibro = Scanner.nextInt();
                    Scanner.nextLine();
                    Libro.LeerLibroPorID(idLibro);
                }
                case 4 -> {
                    System.out.println("ID del libro");
                    int idLibro = Scanner.nextInt();
                    Scanner.nextLine();
                    System.out.println("Nuevo estado");
                    String nuevoEstado = Scanner.nextLine();
                    Libro.actualizarLibro(idLibro, nuevoEstado);
                }
                case 5 -> {
                    System.out.println("ID del libro");
                    int idLibro = Scanner.nextInt();
                    Scanner.nextLine();
                    Libro.eliminarLibro(idLibro);
                }
                case 6 -> {
                    System.out.println("saliendo del sistema....");
                    Scanner.close();
                    return;
                }
                default -> 
                    System.out.println("Opcion invalida");
            }
        }
    }
}