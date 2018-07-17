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
@Table(name = "Account_Demo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountDemo.findAll", query = "SELECT a FROM AccountDemo a")
    , @NamedQuery(name = "AccountDemo.findById", query = "SELECT a FROM AccountDemo a WHERE a.id = :id")
    , @NamedQuery(name = "AccountDemo.findByFirstName", query = "SELECT a FROM AccountDemo a WHERE a.firstName = :firstName")
    , @NamedQuery(name = "AccountDemo.findByLastName", query = "SELECT a FROM AccountDemo a WHERE a.lastName = :lastName")
    , @NamedQuery(name = "AccountDemo.findByEmail", query = "SELECT a FROM AccountDemo a WHERE a.email = :email")
    , @NamedQuery(name = "AccountDemo.findByGender", query = "SELECT a FROM AccountDemo a WHERE a.gender = :gender")
    , @NamedQuery(name = "AccountDemo.findByIpAddress", query = "SELECT a FROM AccountDemo a WHERE a.ipAddress = :ipAddress")})
public class AccountDemo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "ip_address")
    private String ipAddress;

}
