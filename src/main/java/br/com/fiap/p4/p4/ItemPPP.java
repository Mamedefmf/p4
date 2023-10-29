package br.com.fiap.p4.p4;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_ppp")
public class ItemPPP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    private String nomeProduto;
    private double precoEmpresa1;
    private double precoEmpresa2;
    private double precoEmpresa3;
    private String urlEmpresa1;
    private String urlEmpresa2;
    private String urlEmpresa3;
    
    @ManyToOne
    @JoinColumn(name = "ppp_id")
    private PPP ppp;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoEmpresa1() {
        return precoEmpresa1;
    }

    public void setPrecoEmpresa1(double precoEmpresa1) {
        this.precoEmpresa1 = precoEmpresa1;
    }

    public double getPrecoEmpresa2() {
        return precoEmpresa2;
    }

    public void setPrecoEmpresa2(double precoEmpresa2) {
        this.precoEmpresa2 = precoEmpresa2;
    }

    public double getPrecoEmpresa3() {
        return precoEmpresa3;
    }

    public void setPrecoEmpresa3(double precoEmpresa3) {
        this.precoEmpresa3 = precoEmpresa3;
    }

    public String getUrlEmpresa1() {
        return urlEmpresa1;
    }

    public void setUrlEmpresa1(String urlEmpresa1) {
        this.urlEmpresa1 = urlEmpresa1;
    }

    public String getUrlEmpresa2() {
        return urlEmpresa2;
    }

    public void setUrlEmpresa2(String urlEmpresa2) {
        this.urlEmpresa2 = urlEmpresa2;
    }

    public String getUrlEmpresa3() {
        return urlEmpresa3;
    }

    public void setUrlEmpresa3(String urlEmpresa3) {
        this.urlEmpresa3 = urlEmpresa3;
    }

    public PPP getPpp() {
        return ppp;
    }

    public void setPpp(PPP ppp) {
        this.ppp = ppp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precoEmpresa1);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(precoEmpresa2);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(precoEmpresa3);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((urlEmpresa1 == null) ? 0 : urlEmpresa1.hashCode());
        result = prime * result + ((urlEmpresa2 == null) ? 0 : urlEmpresa2.hashCode());
        result = prime * result + ((urlEmpresa3 == null) ? 0 : urlEmpresa3.hashCode());
        result = prime * result + ((ppp == null) ? 0 : ppp.hashCode());
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
        ItemPPP other = (ItemPPP) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nomeProduto == null) {
            if (other.nomeProduto != null)
                return false;
        } else if (!nomeProduto.equals(other.nomeProduto))
            return false;
        if (Double.doubleToLongBits(precoEmpresa1) != Double.doubleToLongBits(other.precoEmpresa1))
            return false;
        if (Double.doubleToLongBits(precoEmpresa2) != Double.doubleToLongBits(other.precoEmpresa2))
            return false;
        if (Double.doubleToLongBits(precoEmpresa3) != Double.doubleToLongBits(other.precoEmpresa3))
            return false;
        if (urlEmpresa1 == null) {
            if (other.urlEmpresa1 != null)
                return false;
        } else if (!urlEmpresa1.equals(other.urlEmpresa1))
            return false;
        if (urlEmpresa2 == null) {
            if (other.urlEmpresa2 != null)
                return false;
        } else if (!urlEmpresa2.equals(other.urlEmpresa2))
            return false;
        if (urlEmpresa3 == null) {
            if (other.urlEmpresa3 != null)
                return false;
        } else if (!urlEmpresa3.equals(other.urlEmpresa3))
            return false;
        if (ppp == null) {
            if (other.ppp != null)
                return false;
        } else if (!ppp.equals(other.ppp))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ItemPPP [id=" + id + ", nomeProduto=" + nomeProduto + ", precoEmpresa1=" + precoEmpresa1
                + ", precoEmpresa2=" + precoEmpresa2 + ", precoEmpresa3=" + precoEmpresa3 + ", urlEmpresa1="
                + urlEmpresa1 + ", urlEmpresa2=" + urlEmpresa2 + ", urlEmpresa3=" + urlEmpresa3 + ", ppp=" + ppp + "]";
    }
}

