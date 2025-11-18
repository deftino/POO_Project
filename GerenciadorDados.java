package login.pk;

import java.io.*;
import java.util.HashMap;
import mgmt.pk.ListaProd;
import mgmt.pk.Produto;

public class GerenciadorDados {
    private static final String USUARIOS_FILE = "usuarios.dat";
    private static final String INVENTARIOS_FILE = "inventarios.dat";
    

    public static void salvarUsuarios(HashMap<String, String> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USUARIOS_FILE))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuarios: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, String> carregarUsuarios() {
        File file = new File(USUARIOS_FILE);
        if (!file.exists()) {
            HashMap<String, String> usuarios = new HashMap<>();
            usuarios.put("admin", "admin1234");
            return usuarios;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USUARIOS_FILE))) {
            return (HashMap<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar usuarios: " + e.getMessage());
            HashMap<String, String> usuarios = new HashMap<>();
            usuarios.put("admin", "admin1234");
            return usuarios;
        }
    }
    
    public static void salvarInventario(String usuario, ListaProd lista) {
        HashMap<String, ListaProd> todosInventarios = carregarTodosInventarios();
        todosInventarios.put(usuario, lista);
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INVENTARIOS_FILE))) {
            oos.writeObject(todosInventarios);
        } catch (IOException e) {
            System.err.println("Erro ao salvar inventario: " + e.getMessage());
        }
    }
    

    public static ListaProd carregarInventario(String usuario) {
        HashMap<String, ListaProd> todosInventarios = carregarTodosInventarios();
        ListaProd lista = todosInventarios.get(usuario);
        return (lista != null) ? lista : new ListaProd();
    }
    

    @SuppressWarnings("unchecked")
    private static HashMap<String, ListaProd> carregarTodosInventarios() {
        File file = new File(INVENTARIOS_FILE);
        if (!file.exists()) {
            return new HashMap<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INVENTARIOS_FILE))) {
            return (HashMap<String, ListaProd>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar inventarios: " + e.getMessage());
            return new HashMap<>();
        }
    }
}
