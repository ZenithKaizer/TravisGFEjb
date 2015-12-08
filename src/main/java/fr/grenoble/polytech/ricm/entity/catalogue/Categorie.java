package fr.grenoble.polytech.ricm.entity.catalogue;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name="CATEGORIE_TEST")
@NamedQueries( {
    @NamedQuery(name = "Categorie.findAll", query = "SELECT a FROM Categorie a" ),
    @NamedQuery(name = "Categorie.findById", query = "SELECT a FROM Categorie a WHERE a.id = :id" ),
    @NamedQuery(name = "Categorie.findByDesignation", query = "SELECT a FROM Categorie a WHERE a.designation = :designation")
})
public class Categorie implements Serializable {

    private static final long serialVersionUID = -1447051578332788777L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column
    private Long id;
    
    @Basic(optional = false)
    @Column(unique = true )
    private String designation;

    public Categorie() {
    }

    public Categorie(String designation) {
        this.designation = designation;
    }

    public Categorie( Long id, String designation ) {
        this.id = id;
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation( String designation ) {
        this.designation = designation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += ( id != null ? id.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object ) {
        if ( !( object instanceof Categorie ) ) {
            return false;
        }
        Categorie other = ( Categorie ) object;
        if ( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals( other.id ) ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categorie[ id=" + id + " ] " + designation;
    }
}
