package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
public class Bilhete {

    private int id;

    @GeneratedValue
    @Id
    public int getId() {
        return id;
    }

    public void setId(int idBilhete) {
        this.id = idBilhete;
    }

    private int valorTotal;

    @Basic
    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    private Produto_Voo produto;

    @OneToOne(optional = false)
    public Produto_Voo getProduto() {
        return produto;
    }

    public void setProduto(Produto_Voo produto) {
        this.produto = produto;
    }

    private int numAssento;

    @Basic
    public int getNumAssento() {
        return numAssento;
    }

    public void setNumAssento(int numAssento) {
        this.numAssento = numAssento;
    }

    private Date validade;

    @Basic
    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    private Assento assento;

    @OneToOne(optional = false)
    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }
}
