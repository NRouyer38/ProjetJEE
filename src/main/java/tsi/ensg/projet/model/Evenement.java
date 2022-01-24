package tsi.ensg.projet.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Evenement")
public class Evenement {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")

    @Column(name = "id")
    private long id;

    @Column
    private String intitule;

    @Column
    private String theme;

    @Column
    private String date_debut;

    @Column
    private String duree;

    @Column
    private int nb_part_max;

    @Column
    private String description;

    @Column
    private String organisateur;

    @Column
    private String type_even;

    @OneToMany(targetEntity=Participant.class, mappedBy="evenement", fetch=FetchType.EAGER)
    private List<Participant> participantList;

    public Evenement() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evenement evenement = (Evenement) o;
        return id == evenement.id && nb_part_max == evenement.nb_part_max && Objects.equals(intitule, evenement.intitule) && Objects.equals(theme, evenement.theme) && Objects.equals(date_debut, evenement.date_debut) && Objects.equals(duree, evenement.duree) && Objects.equals(description, evenement.description) && Objects.equals(organisateur, evenement.organisateur) && Objects.equals(type_even, evenement.type_even);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, intitule, theme, date_debut, duree, nb_part_max, description, organisateur, type_even);
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                ", theme='" + theme + '\'' +
                ", date_debut='" + date_debut + '\'' +
                ", duree='" + duree + '\'' +
                ", nb_part_max=" + nb_part_max +
                ", description='" + description + '\'' +
                ", organisateur='" + organisateur + '\'' +
                ", type_even='" + type_even + '\'' +
                '}';
    }

    public Evenement(String intitule, String theme, String date_debut,
                     String duree, int nb_part_max , String description,
                     String organisateur, String type_even) {
        this.intitule = intitule;
        this.theme = theme;
        this.date_debut = date_debut;
        this.duree = duree;
        this.nb_part_max = nb_part_max;
        this.description = description;
        this.organisateur = organisateur;
        this.type_even = type_even;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getNb_part_max() {
        return nb_part_max;
    }

    public void setNb_part_max(int nb_part_max) {
        this.nb_part_max = nb_part_max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public String getType_even() {
        return type_even;
    }

    public void setType_even(String type_even) {
        this.type_even = type_even;
    }

}