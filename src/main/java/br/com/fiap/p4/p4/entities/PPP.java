package br.com.fiap.p4.p4.entities;

import java.util.*;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


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

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = new Date();
    }
    @ElementCollection //Atributo para receber os itens
    private List<ItemPesquisa> itensPesquisa = new ArrayList<>();

    //Getters, Setters, Construtores

    public PPP() { }

    public PPP(UUID id, String descricao, String responsavel, Date dataCriacao, List<ItemPesquisa> itensPesquisa) {
        this.id = id;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.dataCriacao = dataCriacao;
        this.itensPesquisa = itensPesquisa;
    }

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

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<ItemPesquisa> getItensPesquisa() {
        return itensPesquisa;
    }

    public void setItensPesquisa(List<ItemPesquisa> itensPesquisa) {
        this.itensPesquisa = itensPesquisa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PPP ppp = (PPP) o;
        return Objects.equals(id, ppp.id) && Objects.equals(descricao, ppp.descricao) && Objects.equals(responsavel, ppp.responsavel) && Objects.equals(dataCriacao, ppp.dataCriacao) && Objects.equals(itensPesquisa, ppp.itensPesquisa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, responsavel, dataCriacao, itensPesquisa);
    }

    @Override
    public String toString() {
        return "PPP{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", itensPesquisa=" + itensPesquisa +
                '}';
    }

}
