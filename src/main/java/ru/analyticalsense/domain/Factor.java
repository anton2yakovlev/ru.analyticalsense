package ru.analyticalsense.domain;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
public class Factor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "user_creator_id")
    //private User userCreator;

    private String factorName;
    private String factorQuery;

    public Factor(String factorName, String factorQuery) {
        setFactorName(factorName);
        setFactorQuery(factorQuery);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /*public User getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(User userCreator) {
        this.userCreator = userCreator;
    }*/

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    public String getFactorQuery() {
        return factorQuery;
    }

    public void setFactorQuery(String factorQuery) {
        this.factorQuery = factorQuery;
    }
}
