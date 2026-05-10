package prog2.model;

import java.io.Serializable;

public class Exemplar implements InExemplar, Serializable {

    /**
     * Atributs privats d'Exemplar
     */

    private String id, titol, autor;
    private boolean admetPrestecLlarg, disponible;

    /**
     * Constructor d'Exemplar
     */
    public Exemplar(String id,String titol, String autor, boolean admetPrestecLlarg){
        this.id = id;
        this.titol = titol;
        this.autor = autor;
        this.admetPrestecLlarg = admetPrestecLlarg;
        this.disponible = true;
    }

    /**
     * Setters i getters
     */
    @Override
    public void setId(String id) {this.id = id;}
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setTitol(String titol) {this.titol = titol;}
    @Override
    public String getTitol() {
        return titol;
    }

    @Override
    public void setAutor(String autor) {this.autor = autor;}
    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) {this.admetPrestecLlarg = admetPrestecLlarg;}
    @Override
    public boolean getAdmetPrestecLlarg() {
        return admetPrestecLlarg;
    }

    public void setDisponible(boolean disponible) {this.disponible = disponible;}
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @return un string amb l'informacio de l'Exemplar
     */
    @Override
    public String toString() {
        return "Id=" + id +", Titol=" + titol +", Autor=" + autor +", Admet Prestec Llarg=" + admetPrestecLlarg +", Disponible=" + disponible;
    }


}
