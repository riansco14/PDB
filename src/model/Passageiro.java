package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by RIAN on 10/11/2016.
 */
@Entity
@DiscriminatorValue("P")
public class Passageiro extends Pessoa {
    private Collection<Bilhete> bilhetes;

    @OneToMany
    public Collection<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void setBilhetes(Collection<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }

    private String passaporte;

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }
}
