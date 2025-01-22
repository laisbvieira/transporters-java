package logistics.demo.model;

import java.time.LocalDateTime;

//classes de especificação do JPA
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//define a classe como uma entidade JPA => permite que seja mapeada para uma tabela no banco de dados
@Entity
public class Transporter {
    
    //primary key
    @Id
    //autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String razaoSocial;
    private String responsavel;
    
    private String ie;
    private String celular;
    private String telefoneComercial;

    //customiza o nome da coluna
    @Column(name = "data_criacao") 
    private LocalDateTime dataCriacao;

    //customiza o nome da coluna
    @Column(name = "data_alteracao") 
    private LocalDateTime dataAlteracao;

    private String situacao;

    //necessário para o JPA criar instâncias da classe
    public Transporter() {}

    //parametrizado => facilita a criação das instâncias fornecendo valores iniciais
    public Transporter(String nome, String cnpj, String razaoSocial, String responsavel, String ie, String celular, String telefoneComercial, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String situacao) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.responsavel = responsavel;
        this.ie = ie;
        this.celular = celular;
        this.telefoneComercial = telefoneComercial;
        this.dataCriacao = dataCriacao;
        this.dataAlteracao = dataAlteracao;
        this.situacao = situacao;
    }

    //getters e setters
    //métodos para acessar e modificar o valor dos atributos
    public Long getId() {
        return id;
    }  
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
}
