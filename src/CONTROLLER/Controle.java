package CONTROLLER;

import java.util.ArrayList;
import java.util.Date;

import MODEL.EditorasBEAN;
import MODEL.EditorasDAO;
import MODEL.AutoresBEAN;
import MODEL.AutoresDAO;
import MODEL.LivrosBEAN;
import MODEL.LivrosDAO;

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
    
    public Boolean ExisteAutor(int id){
        return AutoresDAO.getInstance().isExist(id);
    }
    
    public ArrayList<AutoresBEAN> listaAutores(){
        return AutoresDAO.getInstance().findAllAutores();
    }

//Controle Livros;
    
    public void addLivro(LivrosBEAN livro){
        LivrosDAO.getInstance().create(livro);
    }
    
    public void updateAutor(LivrosBEAN livro){
        LivrosDAO.getInstance().update(livro);
    }
    
    public void DeleteEditoras(LivrosBEAN livro){
        LivrosDAO.getInstance().delete(livro);
    }
    
    public LivrosBEAN findLivro(int id){
        return LivrosDAO.getInstance().findLivro(id);
    }
    
    public int findIdLivro(LivrosBEAN livro){
        return LivrosDAO.getInstance().findIdLivro(livro);
    }
    
    public Boolean ExisteLivro(int id){
        return LivrosDAO.getInstance().isExist(id);
    }
    
    public ArrayList<LivrosBEAN> listaLivros(){
        return LivrosDAO.getInstance().findAllLivros();
    }
    
}
