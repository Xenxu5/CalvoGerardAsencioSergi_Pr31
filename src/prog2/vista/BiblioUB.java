/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.util.List;
import java.util.Scanner;
import prog2.adaptador.Adaptador;

/**
 *
 * @author dortiz
 */
public class BiblioUB {
    
    // Declarem les constants del menu principal
    static private enum OpcionsMenuPrincipal {
        MENU_PRINCIPAL_EXEMPLARS,
        MENU_PRINCIPAL_USUARIS,
        MENU_PRINCIPAL_PRESTECS,
        MENU_PRINCIPAL_SAVE,
        MENU_PRINCIPAL_LOAD,
        MENU_PRINCIPAL_EXIT};
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuPrincipal={"Gestió Exemplars",
                                               "Gestió Usuaris",
                                               "Gestió Prestecs",
                                               "Guardar Dades",
                                               "Recuperar Dades",
                                               "Sortir"};

    static private enum OpcionsMenuGestioExemplars {
        MENU_GESTIO_EXEMPLARS_ADD,
        MENU_GESTIO_EXEMPLARS_VIEW,
        MENU_GESTIO_EXEMPLARS_EXIT
    };
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuGestioExemplars ={"Afegir Exemplar",
                                                      "Visualitzar Exemplars",
                                                      "Sortir"};

    static private enum OpcionsMenuGestioClients {
        MENU_GESTIO_USUARIS_ADD,
        MENU_GESTIO_USUARIS_VIEW,
        MENU_GESTIO_USUARIS_EXIT
    };
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuGestioUsuaris ={"Afegir Usuari",
                                                    "Visualitzar Usuaris",
                                                    "Sortir"};

    static private enum OpcionsMenuGestioPrestecs {
        MENU_GESTIO_PRESTECS_ADD,
        MENU_GESTIO_PRESTECS_REMOVE,
        MENU_GESTIO_PRESTECS_VIEW,
        MENU_GESTIO_PRESTECS_VIEW_URG,
        MENU_GESTIO_PRESTECS_EXIT
    };
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuGestioPrestecs ={"Afegir Prestec",
                                                     "Retornar Prestec",
                                                     "Visualitzar Prestecs",
                                                     "Visualitzar Prestecs no Retornats",
                                                     "Sortir"};

    
    /** Adaptador de l'aplicació */
    private Adaptador adaptador;
    
    /* Constructor*/
    public BiblioUB() {
        adaptador = new Adaptador();
    }

    /**
     * Mètode pùblic que gestiona el menu principal
     */
    public void gestioBiblioUB() {
        // Creem un objecte per llegir des del teclat
        Scanner sc = new Scanner(System.in);
        
        // Creem l'objecte per al menú. Li passem com a primer paràmetre el nom del menú
        Menu<OpcionsMenuPrincipal> menu = new Menu<>("Menu principal", OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);
        
        OpcionsMenuPrincipal opcio;
        do {
            // Mostrem les opcions del menú i demanem una opció
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            // Fem les accions necessàries per a la opció triada
            switch(opcio) {
                case MENU_PRINCIPAL_EXEMPLARS:
                    // Mostra el menú per a la gestió d'exemplars
                    menuGestioExemplars(sc);
                    break;

                case MENU_PRINCIPAL_USUARIS:
                    // Mostra el menú per a la gestió d'usuaris
                    menuGestioUsuaris(sc);
                    break;

                case MENU_PRINCIPAL_PRESTECS:
                    // Mostra el menú per a la gestió de prestecs
                    menuGestioPrestecs(sc);
                    break;

                case MENU_PRINCIPAL_SAVE:
                    // Guardar dades
                    String dstFile = getFilePath(sc,false); // Obtenir el fitxer de sortida
                    if(dstFile != null) {
                        // Guardar les dades al fitxer triat
                        try {
                             this.adaptador.guardaDades(dstFile);
                             System.err.println("Dades guardades");
                        } catch (BiblioException ex) {
                            System.out.println("Error guardant les dades: " + ex.getMessage());
                        }
                    }                   
                    break;
                case MENU_PRINCIPAL_LOAD:
                    // Carregar dades                   
                    String srcFile = getFilePath(sc,false); // Obtenir el fitxer d'entrada
                    if(srcFile != null) {
                        // Carregar les dades del fitxer triat
                        try {
                             this.adaptador.carregaDades(srcFile);
                             System.err.println("Dades carregades");
                        } catch(BiblioException ex) {
                            System.out.println("Error carregant les dades." + ex.getMessage());
                        }
                    }     
                    break;
                case MENU_PRINCIPAL_EXIT:
                    // Sortir      1
                    System.out.println("Sortint de l'aplicació...");
                    break;
            }
        } while(opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_EXIT);
    }

    /**
     * Mètode que gestiona el submenu de la primera opció
     * @param sc
     */
    private void menuGestioExemplars(Scanner sc) {
        Menu<OpcionsMenuGestioExemplars> menu = new Menu<>("Gestió d'Exemplars", OpcionsMenuGestioExemplars.values());
        menu.setDescripcions(descMenuGestioExemplars);
        OpcionsMenuGestioExemplars opcio;

        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            switch(opcio) {
                case MENU_GESTIO_EXEMPLARS_ADD:
                    afegirExemplar(sc);
                    break;
                case MENU_GESTIO_EXEMPLARS_VIEW:
                    // Cridem al showList passant el títol i la llista de strings que ens dona l'adaptador
                    showList("Llista d'Exemplars", adaptador.recuperaExemplars());
                    break;
                case MENU_GESTIO_EXEMPLARS_EXIT:
                    break;
            }
        } while(opcio != OpcionsMenuGestioExemplars.MENU_GESTIO_EXEMPLARS_EXIT);
    }

    /**
     * Afegir un nou exemplar
     * @param sc
     */
    private void afegirExemplar(Scanner sc){
        try {
            System.out.print("Introdueix el codi (ID) de l'exemplar: ");
            String id = sc.nextLine();
            System.out.print("Introdueix el títol: ");
            String titol = sc.nextLine();
            System.out.print("Introdueix l'autor: ");
            String autor = sc.nextLine();
            System.out.print("Admet préstec llarg? (true/false): ");
            boolean admetLlarg = sc.nextBoolean();
            sc.nextLine(); // Netejar el buffer del teclat

            // Passem les dades al pont
            adaptador.afegirExemplar(id, titol, autor, admetLlarg);
            System.out.println("Exemplar afegit correctament.");

        } catch (BiblioException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR en les dades introduïdes.");
            sc.nextLine(); // Netejar buffer per si ha posat lletres en lloc de true/false
        }
    }

    /**
     * Mètode que gestiona el submenu de la segona opció
     * @param sc
     */
    private void menuGestioUsuaris(Scanner sc) {
        Menu<OpcionsMenuGestioClients> menu = new Menu<>("Gestió d'Usuaris", OpcionsMenuGestioClients.values());
        menu.setDescripcions(descMenuGestioUsuaris);
        OpcionsMenuGestioClients opcio;

        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            switch(opcio) {
                case MENU_GESTIO_USUARIS_ADD:
                    afegirUsuari(sc);
                    break;
                case MENU_GESTIO_USUARIS_VIEW:
                    showList("Llista d'Usuaris", adaptador.recuperaUsuaris());
                    break;
                case MENU_GESTIO_USUARIS_EXIT:
                    break;
            }
        } while(opcio != OpcionsMenuGestioClients.MENU_GESTIO_USUARIS_EXIT);
    }

    /**
     * Afegir un nou usuari
     * @param sc
     */
    private void afegirUsuari(Scanner sc){
        try {
            System.out.print("Introdueix l'email: ");
            String email = sc.nextLine();
            System.out.print("Introdueix el nom: ");
            String nom = sc.nextLine();
            System.out.print("Introdueix l'adreça: ");
            String adreca = sc.nextLine();
            System.out.print("És estudiant? (true/false): ");
            boolean esEstudiant = sc.nextBoolean();
            sc.nextLine(); // Netejar el buffer del teclat

            adaptador.afegirUsuari(email, nom, adreca, esEstudiant);
            System.out.println("Usuari afegit correctament.");

        } catch (BiblioException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR en les dades introduïdes.");
            sc.nextLine();
        }
    }

    /**
     * Mètode que gestiona el submenu de la tercera opció
     * @param sc
     */
    private void menuGestioPrestecs(Scanner sc) {
        Menu<OpcionsMenuGestioPrestecs> menu = new Menu<>("Gestió de Préstecs", OpcionsMenuGestioPrestecs.values());
        menu.setDescripcions(descMenuGestioPrestecs);
        OpcionsMenuGestioPrestecs opcio;

        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            switch(opcio) {
                case MENU_GESTIO_PRESTECS_ADD:
                    afegirPrestec(sc);
                    break;
                case MENU_GESTIO_PRESTECS_REMOVE:
                    cancelarPrestec(sc); // Aquest és el de retornar
                    break;
                case MENU_GESTIO_PRESTECS_VIEW:
                    showList("Llista de tots els Préstecs", adaptador.recuperaPrestecs());
                    break;
                case MENU_GESTIO_PRESTECS_VIEW_URG:
                    showList("Llista de Préstecs no Retornats", adaptador.recuperaPrestecsNoRetornats());
                    break;
                case MENU_GESTIO_PRESTECS_EXIT:
                    break;
            }
        } while(opcio != OpcionsMenuGestioPrestecs.MENU_GESTIO_PRESTECS_EXIT);
    }

    /**
     * Afegir un nou prestec
     * @param sc
     */
    private void afegirPrestec(Scanner sc){
        try {
            // Primer mostrem els exemplars i usuaris perquè sàpiga quina posició triar
            showList("Exemplars Disponibles", adaptador.recuperaExemplars());
            System.out.print("Introdueix la posició de l'exemplar a la llista: ");
            int posExemplar = sc.nextInt();

            showList("Usuaris Registrats", adaptador.recuperaUsuaris());
            System.out.print("Introdueix la posició de l'usuari a la llista: ");
            int posUsuari = sc.nextInt();

            System.out.print("És un préstec llarg? (true/false): ");
            boolean esLlarg = sc.nextBoolean();
            sc.nextLine(); // Netejar buffer

            adaptador.afegirPrestec(posExemplar, posUsuari, esLlarg);
            System.out.println("Préstec realitzat correctament.");

        } catch (BiblioException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: Dades introduïdes incorrectes.");
            sc.nextLine();
        }
    }

    /**
     * Mètode que anul·la un préstec
     * @param sc
     */
    private void cancelarPrestec(Scanner sc){
        try {
            // Mostrem els actuals
            showList("Préstecs Actuals", adaptador.recuperaPrestecs());
            System.out.print("Introdueix la posició del préstec que vols retornar: ");
            int posPrestec = sc.nextInt();
            sc.nextLine(); // Netejar buffer

            adaptador.retornarPrestec(posPrestec);
            System.out.println("Préstec retornat correctament.");

        } catch (BiblioException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: Posició no vàlida.");
            sc.nextLine();
        }
    }

    /**
     * Mostra una llista d'objectes
     * @param title Títol a posar com a capçalera
     * @param lines Llista d'objectes per mostrar
     */
    private void showList(String title, List<String> lines) {
        System.out.println("============================================");
        System.out.println(title);
        System.out.println("============================================");
        int i = 0;
        for(String l : lines) {
            System.out.println("\t[" + (i++) + "] " + l);
        }
        System.out.println("============================================");
    }


    /**
     * Demana el camí d'un fitxer
     * @param sc Objecte per a la lectura de dades de teclat
     * @param mustExist Exigeix que el fitxer existeixi (True) o no (False)
     * @return Ruta al fitxer entrada per l'usuari o null si s'ha cancelat
     */
    private String getFilePath(Scanner sc, boolean mustExist) {
        String filePath = null;

        // Mostrar el missatge demanant la entrada
        System.out.println("Entra ruta completa fitxer (o ENTER per ometre):");

            // Llegim la ruta del fitxer
            filePath = sc.nextLine();

            // Si la ruta està buida retornem un null
            if(filePath.isEmpty()) {
                return null;
            }

        return filePath;
    }

}
