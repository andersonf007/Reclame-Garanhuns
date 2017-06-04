
package entidade;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Izaquias
 */
@Entity
public class PublicacaoEntidade implements Serializable{

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(unique = true,updatable = false)
    private long id;
    @Column(length = 50, nullable = false)
    private String categoria;
    @Column(length = 50, nullable = false)
    private String localidade;
    @Temporal(TemporalType.DATE)
    @Column
    private Date data = Date.from(Instant.now());;
    @Column(length = 100, nullable = false)
    private String mensagem;
    @Column(length = 10, nullable = false )
    private String status;
    //id do usuario na relação!
    @OneToMany
    private Collection<UsuarioEntidade> usuarios = new ArrayList<>();;//Fazer o devido relacionamento ORM!
    @OneToMany
    private Collection<ComentarioEntidade> comentarios = new ArrayList<>();
    
    public PublicacaoEntidade() {
    }

    public PublicacaoEntidade(String categoria, String localidade,Date data, String descricao,
            Collection<UsuarioEntidade> usuarios, String status, Collection<ComentarioEntidade> comentarios) {
        
        this.categoria = categoria;
        this.localidade = localidade;
        this.mensagem = descricao;
        this.usuarios = usuarios;//Ver se não dará complicações futuras! 
        this.data = data;
        this.status = status;
        this.comentarios = comentarios;
    }

    public long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Collection<UsuarioEntidade> getUsuario() {
        return usuarios;
    }

    public void setUsuario(Collection<UsuarioEntidade> usuarios) {
        this.usuarios = usuarios;
    }

    public Collection<ComentarioEntidade> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Collection<ComentarioEntidade> comentarios) {
        this.comentarios = comentarios;
    }
    
}
