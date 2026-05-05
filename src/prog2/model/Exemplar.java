package prog2.model;

public class Exemplar implements InExemplar{

    /**
     * Atributs privats d'Exemplar
     */

    private String Id, Titol, Autor;
    private boolean AdmetPrestecLlarg, Disponible;

    /**
     * Constructor d'Exemplar
     */
    public Exemplar(String Id,String Titol, String Autor, boolean AdmetPrestecLlarg){
        this.Id = Id;
        this.Titol = Titol;
        this.Autor = Autor;
        this.AdmetPrestecLlarg = AdmetPrestecLlarg;
        this.Disponible = true;
    }

    /**
     * Setters i getters
     */
    @Override
    public void setId(String id) {this.Id = id;}
    @Override
    public String getId() {
        return Id;
    }

    @Override
    public void setTitol(String titol) {this.Titol = titol;}
    @Override
    public String getTitol() {
        return Titol;
    }

    @Override
    public void setAutor(String autor) {this.Autor = autor;}
    @Override
    public String getAutor() {
        return Autor;
    }

    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) {this.AdmetPrestecLlarg = admetPrestecLlarg;}
    @Override
    public boolean getAdmetPrestecLlarg() {
        return AdmetPrestecLlarg;
    }

    public void setDisponible(boolean disponible) {this.Disponible = disponible;}
    public boolean isDisponible() {
        return Disponible;
    }

    /**
     * @return un strign amb l'informacio de l'Exemplar
     */
    @Override
    public String toString() {
        return "Id=" + Id +", Titol=" + Titol+", Autor=" + Autor +", Admet Prestec Llarg=" + AdmetPrestecLlarg +", Disponible=" + Disponible;
    }


}
