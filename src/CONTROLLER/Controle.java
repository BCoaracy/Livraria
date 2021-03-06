package CONTROLLER;

import java.util.ArrayList;
import java.util.Date;

import MODEL.*;


public class Controle {
    public Controle(){
    }
    
//Controle Editora;    
    public void addEditora(EditorasBEAN editora){
        EditorasDAO.getInstance().create(editora);
    }
    
    public void updateEditoras(EditorasBEAN editora){
        EditorasDAO.getInstance().update(editora);
    }
    
    public void DeleteEditoras(EditorasBEAN editora){
        EditorasDAO.getInstance().delete(editora);
    }
    
    public EditorasBEAN findEditora(int id){
        return EditorasDAO.getInstance().findEditora(id);
    }
    
    public int findIdEditora(EditorasBEAN editora){
        return EditorasDAO.getInstance().findId(editora);
    }
    
    public Boolean ExisteEditora(int id){
        return EditorasDAO.getInstance().isExist(id);
    }
    
    public ArrayList<EditorasBEAN> listaEditoras(){
        return EditorasDAO.getInstance().findAllEditora();
    }
 
    
 //Controle Autores;
    
    public void addAutor(AutoresBEAN autor){
        AutoresDAO.getInstance().create(autor);
    }
    
    public void updateAutor(AutoresBEAN autor){
        AutoresDAO.getInstance().update(autor);
    }
    
    public void DeleteEditoras(AutoresBEAN autor){
        AutoresDAO.getInstance().delete(autor);
    }
    
    public AutoresBEAN findAutor(int id){
        return AutoresDAO.getInstance().findAutor(id);
    }
    
    public int findIdAutor(AutoresBEAN autor){
        return AutoresDAO.getInstance().findIdAutor(autor);
    }
    
    public AutoresBEAN findIdAutorNome(String nomeAutor){
        return AutoresDAO.getInstance().findIdAutorNome(nomeAutor);
    }
    
    public Boolean ExisteAutor(int id){
        return AutoresDAO.getInstance().isExist(id);
    }
    
    public ArrayList<AutoresBEAN> listaAutores(){
        return AutoresDAO.getInstance().findAllAutores();
    }

//Controle Livros;
    
    public void addLivros(LivrosBEAN livro){
        LivrosDAO.getInstance().create(livro);
        LivrosDAO.getInstance().createAuxGen(livro);
        LivrosDAO.getInstance().createAuxAutor(livro);
    }
    public void addGeneroLivro(LivrosBEAN livro){
        LivrosDAO.getInstance().createAuxGen(livro);
    }
    public void addAutorLivro(LivrosBEAN livro){
        LivrosDAO.getInstance().createAuxAutor(livro);
    }
    
    public void deleteGenLivro(LivrosBEAN livro){
        LivrosDAO.getInstance().deleteAuxGen(livro);
    }
    
    public void deleteAutorLivro(LivrosBEAN livro){
        LivrosDAO.getInstance().deleteAuxAutor(livro);
    }
    
    public void updateLivros(LivrosBEAN livro){
        LivrosDAO.getInstance().update(livro);
    }
    
    public void DeleteLivros(LivrosBEAN livro){
        LivrosDAO.getInstance().delete(livro);
    }
    
    public LivrosBEAN findLivros(int id){
        return LivrosDAO.getInstance().findLivro(id);
    }
    public LivrosBEAN findIdLivroNome(String titulo){
        return LivrosDAO.getInstance().findIdLivroNome(titulo);
    }
    
    public int findIdLivros(LivrosBEAN livro){
        return LivrosDAO.getInstance().findIdLivro(livro);
    }
    
    public Boolean ExisteLivro(int id){
        return LivrosDAO.getInstance().isExist(id);
    }
    
    public ArrayList<LivrosBEAN> listaLivros(){
        return LivrosDAO.getInstance().findAllLivros();
    }
    
//Controle Generos
    
    public void addGenero(GenerosBEAN genero){
        GenerosDAO.getInstance().create(genero);
    }
    
    public void updateGeneros(GenerosBEAN genero){
        GenerosDAO.getInstance().update(genero);
    }
    
    public ArrayList<GenerosBEAN> listaGeneros(){
        return GenerosDAO.getInstance().findAllGeneros();
    }
    
    public int findGenero(GenerosBEAN genero){
        return GenerosDAO.getInstance().findId(genero);
    }
    
//Controle Clientes

    public void addCliente(ClientesBEAN cliente){
        ClientesDAO.getInstance().create(cliente);
    }
    
    public void updateAutor(ClientesBEAN cliente){
        ClientesDAO.getInstance().update(cliente);
    }
    
    public void DeleteEditoras(ClientesBEAN cliente){
        ClientesDAO.getInstance().delete(cliente);
    }
    
    public ClientesBEAN findCliente(int id){
        return ClientesDAO.getInstance().findCliente(id);
    }
    
    public int findIdCliente(ClientesBEAN cliente){
        return ClientesDAO.getInstance().findIdCliente(cliente);
    }
    
    public ClientesBEAN findIdClienteNome(String nomeCliente){
        return ClientesDAO.getInstance().findIdClienteNome(nomeCliente);
    }
    
    public Boolean ExisteCliente(int id){
        return ClientesDAO.getInstance().isExist(id);
    }
    
    public ArrayList<ClientesBEAN> listaClientes(){
        return ClientesDAO.getInstance().findAllClientes();
    }
    
}
