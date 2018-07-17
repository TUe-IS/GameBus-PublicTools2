/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pietervangorp.gamebus.util.webentity;

import lombok.Data;

/**
 *
 * @author praghletoos
 */
@Data
public class Employee {
    public int id;
    public String name;
    public String branch;
    public float salary;
    public String country; 
    public String birth; 
    public String email; 
}
