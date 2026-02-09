/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.univaq.swa.catalogrest.business;

/**
 *
 * @author giuse
 */
public class SectionsServiceFactory {
    
    private final static SectionsServiceImpl service = new SectionsServiceImpl();

    public static SectionsServiceImpl getSectionsService() {
        return service;
    }
}
