import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Introdu nr de locuri disp");
        GuestList lista=new GuestList(sc.nextInt());
        String meniu="help         - Afiseaza aceasta lista de comenzi\n" +
                "add          - Adauga o noua persoana (inscriere)\n" +
                "check        - Verifica daca o persoana este inscrisa la eveniment\n" +
                "remove       - Sterge o persoana existenta din lista\n" +
                "update       - Actualizeaza detaliile unei persoane\n" +
                "guests       - Lista de persoane care participa la eveniment\n" +
                "waitlist     - Persoanele din lista de asteptare\n" +
                "available    - Numarul de locuri libere\n" +
                "guests_no    - Numarul de persoane care participa la eveniment\n" +
                "waitlist_no  - Numarul de persoane din lista de asteptare\n" +
                "subscribe_no - Numarul total de persoane inscrise\n" +
                "search       - Cauta toti invitatii conform sirului de caractere introdus\n" +
                "quit         - Inchide aplicatia";
        System.out.println(meniu);
        Guest g=new Guest("","","","");
 String randomText="";
        String comanda="";
        while(comanda!="quit"){
            System.out.println("Introduceti o comanda");
            comanda=sc.nextLine();
            switch ((comanda)){
                case "help":
                    System.out.println(meniu);
                    break;


                case "add":
                    String nume,prenume,email,numarTelefon;
                    System.out.println("Nume: ");
                    nume=sc.nextLine();
                    System.out.println("Prenume");
                    prenume=sc.nextLine();
                    System.out.println("Email:");
                    email=sc.nextLine();
                    System.out.println("Nr telefon");
                    numarTelefon=sc.nextLine();
                    g=new Guest(nume,prenume,email,numarTelefon);
                    lista.adaugaGuest(g);
                    break;
                case "check":
                    System.out.println("Dupa ce criteriu se face cautarea?" +
                            "Variante posibile: 1.email 2.numar de telefon 3.nume 4.prenume");
                    String criteriu=sc.nextLine();
                    System.out.println("Introd sirul de caractere");
                    String x=sc.nextLine();
                    if(lista.esteInregistrat(criteriu,x))
                        System.out.println("Utilizatorul este inscris");
                    else System.out.println("Utilizatorul nu este inscris");
                    break;
                case "remove":
                    System.out.println("Introduceti criteriul dupa care sa fie sters");
                    criteriu=sc.nextLine();
                    System.out.println("Introduceti sirul de caractere");
                    randomText=sc.nextLine();
                   // System.out.println(lista.eliminaGuest(criteriu,randomText));
                    lista.eliminaGuest(criteriu,randomText);
                    break;
                case "quit":
                    System.out.println("Ai ales sa iesi din aplicatie");
                    break;
                case "search":
                    System.out.println("Introduceti subsirul cautat");
                    randomText=sc.nextLine();
                    ArrayList<String> t=new ArrayList<String>();
                    t=lista.contineSubsir(randomText);
                    for(int i=0;i<t.size();i++)
                        System.out.println(t.get(i));
                    break;
                case "available":
                    int locuriDisp=lista.getLocuriDisponibile()-lista.getListaParticipanti().size();
                    System.out.println("numarul de locuri disponibile este: "+ locuriDisp);
                    break;
                case "subscribe_no":
                    System.out.println("Numarul de pers inscrise este: " + lista.getListaParticipanti().size());
                    break;
                case "guests_no":
                    int nrParticip= lista.getListaParticipanti().size()+lista.getListaAsteptare().size();
                    System.out.println("Numarul de pers care participa la ev este: "
                    + nrParticip);
                    break;
                case "waitlist_no":
                    System.out.println("nr pers din lista asteptare este: "+lista.getListaAsteptare().size());
                    break;
                case "update":
                    System.out.println("Introduceti criteriul");
                    criteriu=sc.nextLine();
                    System.out.println("Introduceti textul");
                    randomText=sc.nextLine();
                    int pozitie=lista.cautare(lista.getListaParticipanti(),criteriu,randomText);
                    if(pozitie==-1){
                        pozitie=lista.cautare(lista.getListaAsteptare(),criteriu,randomText);
                    }
                    else {
                        System.out.println("Introduceti campul pe care doriti sa-l actualizati");
                        String camp=sc.nextLine();
                        System.out.println("Introduceti valorea campului");
                        String valCamp=sc.nextLine();
                        switch (camp) {
                            case "nume":
                                lista.getListaParticipanti().get(pozitie).setNume(valCamp);
                                break;
                            case "prenume":
                                lista.getListaParticipanti().get(pozitie).setPrenume(valCamp);
                                break;
                            case "email":
                                lista.getListaParticipanti().get(pozitie).setEmail(valCamp);
                                break;
                            case "numar de telefon":
                                lista.getListaParticipanti().get(pozitie).setNumarTelefon(valCamp);
                                break;
                            default:
                                System.out.println("Date introduse gresit");
                                break;
                        }
                        }
                    //acum pentru cand e in lista asteptare
                    System.out.println("Introduceti campul pe care doriti sa-l actualizati");
                    String camp=sc.nextLine();
                    System.out.println("Introduceti valorea campului");
                    String valCamp=sc.nextLine();
                    switch (camp) {
                        case "nume":
                            lista.getListaAsteptare().get(pozitie).setNume(valCamp);
                            break;
                        case "prenume":
                            lista.getListaAsteptare().get(pozitie).setPrenume(valCamp);
                            break;
                        case "email":
                            lista.getListaAsteptare().get(pozitie).setEmail(valCamp);
                            break;
                        case "numar de telefon":
                            lista.getListaAsteptare().get(pozitie).setNumarTelefon(valCamp);
                            break;
                        default:
                            System.out.println("Date introduse gresit");
                            break;
                    }
                    break;
                case "guests":
                    System.out.println("Lista de pers care participa la eveniment: ");
                    for(int i=0;i<lista.getListaParticipanti().size();i++)
                    {
                        System.out.println(lista.getListaParticipanti().get(i).getNume() + "  " +lista.getListaParticipanti().get(i).getPrenume() );

                    }
                    break;
                case "waitlist":
                    System.out.println("Lista de persoane din coada de asteptare");
                    for(int i=0;i<lista.getListaAsteptare().size();i++)
                    {
                        System.out.println(lista.getListaAsteptare().get(i).getNume() + "  " +lista.getListaAsteptare().get(i).getPrenume() );

                    }
                break;





            }



        }
    }
}
