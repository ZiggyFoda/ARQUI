package com.backend.backend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial {

  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "Nombre")
  private String Nombre;

  @Column(name = "Documento")
  private long Documento;

  public Tutorial() {

  }

  public Tutorial(String title, String Nombre, long Documento) {
    this.title = title;
    this.Nombre = Nombre;
    this.Documento = Documento;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getNombre() {
    return Nombre;
  }

  public void setNombre(String nombre) {
    this.Nombre = nombre;
  }

  public long getDocumento() {
    return Documento;
  }

  public void setDocumento(long Documento) {
    this.Documento = Documento;
  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + title + ", Nombre=" + Nombre + ", Documento=" + Documento + "]";
  }
}
