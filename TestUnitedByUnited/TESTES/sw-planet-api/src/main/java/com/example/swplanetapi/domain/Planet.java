package com.example.swplanetapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "planets")
public class Planet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @Column(nullable = false, unique = true)
  private String name;

  @NotEmpty
  @Column(nullable = false)
  private String climate;

  @NotEmpty
  @Column(nullable = false)
  private String terrain;

  @NotEmpty
  @Column(nullable = false)
  private String cep;

  private String logradouro;
  private String complemento;
  private String bairro;
  private String localidade;
  private String uf;


  public Planet() {
  }

  public Planet(String climate, String terrain) {
    this.climate = climate;
    this.terrain = terrain;
  }

  public Planet(String name, String climate, String terrain) {
    this.name = name;
    this.climate = climate;
    this.terrain = terrain;
  }

  public Planet(Long id, String name, String climate, String terrain) {
    this.id = id;
    this.name = name;
    this.climate = climate;
    this.terrain = terrain;
    this.cep = cep;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(obj, this);
  }

  @Override
  public String toString() {
    return "Planet{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", climate='" + climate + '\'' +
            ", terrain='" + terrain + '\'' +
            ", cep='" + cep + '\'' +
            ", logradouro='" + logradouro + '\'' +
            ", complemento='" + complemento + '\'' +
            ", bairro='" + bairro + '\'' +
            ", localidade='" + localidade + '\'' +
            ", uf='" + uf + '\'' +
            '}';
  }
}
