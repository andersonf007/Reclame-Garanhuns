package entidade;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Izaquias
 */
@Entity
public class ComentarioEntidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(unique = true,updatable = false)
    private long id;

    @Column(nullable = false)
    private boolean fd_publicacao;
    @Column(nullable = false)
    private String messagem;
    @Temporal(TemporalType.DATE)
    @Column
    private Date data = Date.from(Instant.now());

    
    @JoinColumn
    private UsuarioEntidade usuario;//id

    public ComentarioEntidade() {

    }

    public ComentarioEntidade(long id, boolean fd_publicacao, String messagem, Date data, UsuarioEntidade usuario) {
        this.id = id;
        this.fd_publicacao = fd_publicacao;
        this.messagem = messagem;
        this.data = data;
        this.usuario = usuario;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isFd_publicacao() {
        return fd_publicacao;
    }

    public void setFd_publicacao(boolean fd_publicacao) {
        this.fd_publicacao = fd_publicacao;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public UsuarioEntidade getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntidade usuario) {
        this.usuario = usuario;
    }
    
}
