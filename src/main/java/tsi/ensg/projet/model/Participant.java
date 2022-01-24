package tsi.ensg.projet.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Participant")
public class Participant {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")

    @Column(name = "id")
    private long id;

    @Column
    private String prenom;

    @Column
    private String nom;

    @Column
    private String email;

    @Column
    private String date_naiss;

    @Column
    private String organisation;

    @Column
    private String observations;

    @ManyToOne
    @JoinColumn(name="participantId")
    private Evenement evenement;

    public Participant() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return id == that.id && Objects.equals(prenom, that.prenom) && Objects.equals(nom, that.nom) && Objects.equals(email, that.email) && Objects.equals(date_naiss, that.date_naiss) && Objects.equals(organisation, that.organisation) && Objects.equals(observations, that.observations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prenom, nom, email, date_naiss, organisation, observations);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", date_naiss='" + date_naiss + '\'' +
                ", organisation='" + organisation + '\'' +
                ", observations='" + observations + '\'' +
                '}';
    }

    public Participant(String prenom, String nom, String email, String  date_naiss, String organisation , String observations) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisation = organisation;
        this.observations = observations;
    }



    public long getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getObservations() {
        return observations;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }


}