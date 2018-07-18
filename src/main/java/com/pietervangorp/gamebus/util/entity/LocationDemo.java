/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pietervangorp.gamebus.util.entity;

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
import lombok.Data;

/**
 *
 * @author praghletoos
 */
@Entity
@Data
@Table(name = "Location_Demo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocationDemo.findAll", query = "SELECT l FROM LocationDemo l")
    , @NamedQuery(name = "LocationDemo.findById", query = "SELECT l FROM LocationDemo l WHERE l.id = :id")
    , @NamedQuery(name = "LocationDemo.findByAccount", query = "SELECT l FROM LocationDemo l WHERE l.account = :account")
    , @NamedQuery(name = "LocationDemo.findByLocation", query = "SELECT l FROM LocationDemo l WHERE l.location = :location")
    , @NamedQuery(name = "LocationDemo.findByCity", query = "SELECT l FROM LocationDemo l WHERE l.city = :city")
    , @NamedQuery(name = "LocationDemo.findByCountry", query = "SELECT l FROM LocationDemo l WHERE l.country = :country")})
public class LocationDemo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "account")
    private Integer account;
    @Column(name = "location")
    private String location;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country; 
    
}
