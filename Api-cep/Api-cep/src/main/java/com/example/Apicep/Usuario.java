package com.example.Apicep;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "usuariosapis")
@Getter @Setter @ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cep;
    //private String logradouro;
    //private String complemento;
    //private String bairro;
    //private String localidade;
   // private String uf;




}
