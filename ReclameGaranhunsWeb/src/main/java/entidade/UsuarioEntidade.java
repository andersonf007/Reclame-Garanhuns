
package entidade;

//import excecoes.UsuarioMenorDeIdadeException;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Izaquias
 */
@Entity
public class UsuarioEntidade implements Serializable{

    /**
     * @param id the id to set
     */
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//add 50+
    @Column(unique = true)
    private long id;
    @Column(length = 50, nullable = false, unique = true)
    private String nome;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 50, nullable = false)
    private String senha;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private String tipo;//pode ser uma flague, analizar!
    
    public UsuarioEntidade() {
        
    }

    
    public UsuarioEntidade( String nome, String email, String senha, String categoria,String tipo) {
       
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.categoria = categoria;
        
    }

    public long getId() {
        return id;
    }
 public void setId(long id) {
        this.id = id;
    }
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

}
