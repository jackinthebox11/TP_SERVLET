package fr.istic.tpservlet.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Electronic")
public class ElectronicDevice extends Device {

}
