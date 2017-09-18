/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import models.ConnexionMySql;
import java.sql.Connection;
import java.util.List;
import java.util.Observable;

/**
 * Interface de défition des propriétés de la DAO L'ensemble des éléments de la
 * Javadoc sont définis si besoin est dans les éléments héritant de cette
 * interface.
 *
 * @author Kévin Mèche, Yoanns Charpentier, Jimmy Rossignol
 * @param <T> un type de données abstrait
 */
public abstract class DAO<T> extends Observable {

    /**
     * Javadoc non nécessaire
     */
    protected Connection connexion;

    /**
     * Javadoc non nécessaire
     */
    public DAO() {
        this.connexion = ConnexionMySql.getInstance();
    }

    /**
     * Javadoc plus détaillée dans les éléments enfants.
     *
     * @param id int
     * @return T type indéfini
     */
    public abstract T find(int id);

    /**
     * Javadoc plus détaillée dans les éléments enfants.
     *
     * @return T type indéfini
     */
    public abstract List<T> findAll();

    /**
     * Javadoc plus détaillée dans les éléments enfants.
     *
     * @param o de type T non défini
     * @return T de type non défini
     */
    public abstract T create(T o);

    /**
     * Javadoc plus détaillée dans les éléments enfants.
     *
     * @param o de type T non défini
     * @return T type non défini
     */
    public abstract T update(T o);

    /**
     * Javadoc plus détaillée dans les éléments enfants.
     *
     * @param o de type T non défini
     */
    public abstract void delete(T o);

}
