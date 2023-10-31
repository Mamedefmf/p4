package br.com.fiap.p4.p4.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.Date;


//Entidade Pesquisa de Preço Padrão - PPP
@Entity
@Table(name = "tb_PPP")
public class PPP {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;//Atributo de chave ID automático
    private String descricao;//Atributo descrição da PPP
    private String responsavel;//Atributo nome do responsável da PPP
    private Date dataCriacao; //Atributo para colocar data automatica

    ///Construtor feito pela IDE
    public PPP(UUID id, String descricao, String responsavel, Date date, List<ItemPesquisa> itemPesquisas) {
    }

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = new Date();
    }
    @ElementCollection //Atributo para receber os itens
    private List<ItemPesquisa> itensPesquisa = new ArrayList<>();

    //Getters, Setters, Construtores
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getResponsavel() {
        return responsavel;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    public List<ItemPesquisa> getItensPesquisa() {
        return itensPesquisa;
    }
    public void setItensPesquisa(List<ItemPesquisa> itensPesquisa) {
        this.itensPesquisa = itensPesquisa;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
        result = prime * result + ((itensPesquisa == null) ? 0 : itensPesquisa.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PPP other = (PPP) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (responsavel == null) {
            if (other.responsavel != null)
                return false;
        } else if (!responsavel.equals(other.responsavel))
            return false;
        if (itensPesquisa == null) {
            if (other.itensPesquisa != null)
                return false;
        } else if (!itensPesquisa.equals(other.itensPesquisa))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "PPP [id=" + id + ", descricao=" + descricao + ", responsavel=" + responsavel + ", itensPesquisa="
                + itensPesquisa + "]";
    }
}
