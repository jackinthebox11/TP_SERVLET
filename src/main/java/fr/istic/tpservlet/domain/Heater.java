package fr.istic.tpservlet.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Heater")
public class Heater extends Device {

}
