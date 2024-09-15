/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio_com.mycompany.claseintroduccionjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sandra/Sergio/Daniel
 */
public class LibroCrud {
 
    int ID_Libro;
    String titulo;
    String autor;
    String editorial;
    int anioPublicacion;
    String ISBN;
    String categoria;
    String estado;
    
    
    public void crearLibro(int ID_Libro,String titulo,String autor,String editorial,int anioPublicacion,String ISBN,String categoria, String estado) {
        String query = "INSERT INTO Libro(ID_Libro,Titulo, Autor, Editorial, Año_Publicacion, ISBN, Categoría, Estado)VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
             pstmt.setInt(1, ID_Libro);
             pstmt.setString(2, titulo);
             pstmt.setString(3,autor);
             pstmt.setString(4,editorial);
             pstmt.setInt(5, anioPublicacion);
             pstmt.setString(6,ISBN);
             pstmt.setString(7,categoria);
             pstmt.setString(8,estado);
             pstmt.executeUpdate();
             System.out.println("Libro Creado exitosamente;");
        } catch (Exception e) {
            System.out.println(e.getMessage());              
        } finally {
            System.out.println("Excepcion finalizada.");  
        }
    }
    
    
    public void LeerLibros (){
        String query = "SELECT * FROM Libro";
        try (Connection conn = ConexionBD.getConnection(); Statement stmt = conn.createStatement();ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()) {
                System.out.println(rs.getInt("ID_Libro") + "\t"
                                 + rs.getString("Título")+ "\t"
                                 + rs.getString("Autor")+ "\t"
                                 + rs.getString("Editorial")+ "\t"
                                 + rs.getInt("Año Publicación")+ "\t"
                                 + rs.getString("ISBN")+ "\t"
                                 + rs.getString("Categoría")+ "\t" 
                                 + rs.getString("Estado") 
                );
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());              
        } finally {
            System.out.println("Excepcion finalizada.");  
        }
    }
    
    public void LeerLibroPorID (int ID_Libro){
        String query = "SELECT * FROM Libro WHERE ID_Libro = ?";
        
        try (Connection conn = ConexionBD.getConnection(); Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()) {
                System.out.println(rs.getInt("ID_Libro") + "\t"
                                 + rs.getString("Título")+ "\t"
                                 + rs.getString("Autor")+ "\t"
                                 + rs.getString("Editorial")+ "\t"
                                 + rs.getInt("Año Publicación")+ "\t"
                                 + rs.getString("ISBN")+ "\t"
                                 + rs.getString("Categoría")+ "\t" 
                                 + rs.getString("Estado") 
                );
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());              
        } finally {
            System.out.println("Excepcion finalizada."); 
        }
    }
    
    public void actualizarLibro (int ID_Libro, String nuevoEstado) {
        String query = "UPDATE Libro SET Estado = ? WHERE ID_Libro = ?";
       
         try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
             pstmt.setString(1, nuevoEstado);
             pstmt.setInt(2, ID_Libro);
             pstmt.executeUpdate();
             System.out.print("Estado del libro actualizado con exito¡");
         } catch(Exception e){
            System.out.println(e.getMessage());
         }
    }
    
    public void eliminarLibro(int ID_Libro) {
        String query = "DELETE FROM Libro WHERE ID_Libro = ?";
       
         try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
             pstmt.setInt(1, ID_Libro);
             pstmt.executeUpdate();
             System.out.print("Libro eliminado con exito¡");
         } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}

