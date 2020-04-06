import java.util.ArrayList;

public class GuestList {
    private static int locuriDisponibile;
    private ArrayList<Guest> listaParticipanti;
    private ArrayList<Guest> listaAsteptare;

    public GuestList(int locuriDisponibile){
        this.locuriDisponibile=locuriDisponibile;
        listaParticipanti=new ArrayList<Guest>(locuriDisponibile);
        listaAsteptare=new ArrayList<Guest>();
    }
    public int getLocuriDisponibile() {
        return locuriDisponibile;
    }

    public ArrayList<Guest> getListaParticipanti() {
        return listaParticipanti;
    }

    public ArrayList<Guest> getListaAsteptare() {
        return listaAsteptare;
    }
    public int cautareNume(ArrayList<Guest> a,String nume){
        for(int i=0;i<a.size();i++){
            if(a.get(i).getNume().equalsIgnoreCase(nume)) return i;
        }
        return -1;
    }
    public int cautarePrenume(ArrayList<Guest> a,String prenume){
        for(int i=0;i<a.size();i++){
            if(a.get(i).getPrenume().equalsIgnoreCase(prenume)) return i;
        }
        return -1;
    }
    public int cautareNumarTelefon(ArrayList<Guest> a,String numarTelefon){
        for(int i=0;i<a.size();i++){
            if(a.get(i).getNumarTelefon().equalsIgnoreCase(numarTelefon)) return i;
        }
        return -1;
    }
    public int cautareEmail(ArrayList<Guest> a,String email){
        for(int i=0;i<a.size();i++){
            if(a.get(i).getEmail().equalsIgnoreCase(email)) return i;
        }
        return -1;
    }



    public int cautare(ArrayList<Guest> a,String criteriu, String x){
        //returneaza pozitia
        if(criteriu.equalsIgnoreCase("nume")==false &&
              criteriu.equalsIgnoreCase("prenume")==false&&
                criteriu.equalsIgnoreCase("numar de telefon")==false &&
                criteriu.equalsIgnoreCase("email")==false)
        { System.out.println("Criteriu invalid");
        return -1;}
        if(criteriu.equalsIgnoreCase("nume"))
            return cautareNume(a,x);
        if(criteriu.equals("email"))
            return cautareEmail(a,x);
        if(criteriu.equalsIgnoreCase("prenume"))
            return cautarePrenume(a,x);
        if(criteriu.equalsIgnoreCase("numar de telefon"))
            return cautareNumarTelefon(a,x);

        return -1;
    }
    public boolean esteInregistrat(String criteriu, String x){
        if(cautare(listaParticipanti,"nume",x)!=-1)
            return true;
        if(cautare(listaParticipanti,"prenume",x)!=-1)
            return true;
        if(cautare(listaParticipanti,"numar de telefon",x)!=-1)
            return true;
        if(cautare(listaParticipanti,"email",x)!=-1)
            return true;
        //acum lista de asteptare
        if(cautare(listaAsteptare,"nume",x)!=-1)
            return true;
        if(cautare(listaAsteptare,"prenume",x)!=-1)
            return true;
        if(cautare(listaAsteptare,"numar de telefon",x)!=-1)
            return true;
        if(cautare(listaAsteptare,"email",x)!=-1)
            return true;
        return false;
    }
    public int adaugaGuest(Guest g){
        //verif daca exista pe lista particip sau pe cea de asteptare,si daca da returnam -1
        if(this.listaParticipanti.contains(g)) {
            System.out.println("Deja va aflati pe lista de participanti");
            return -1;

        }
        if(this.listaAsteptare.contains(g)){
            System.out.println("Deja va aflati pe lista de asteptare");
            return -1;}
        //verif daca mai sunt locuri
        if(listaParticipanti.size()<this.getLocuriDisponibile())
        {

            this.listaParticipanti.add(g);
            System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!.");
            return 0;

        }
        else {
            this.listaAsteptare.add(g);
            System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine"+this.listaAsteptare.size() +
                    "Te vom notifica daca un loc devine disponibil ");
            return this.listaAsteptare.size();
        }


    }

    public boolean eliminaGuest(String criteriu, String x){
        if(cautare(this.listaAsteptare,criteriu,x)==-1)
        {
            if(cautare(this.listaParticipanti,criteriu,x)==-1)
                return false;
            else {
                this.listaParticipanti.remove(cautare(this.listaParticipanti,criteriu,x));
                this.listaParticipanti.add(this.listaAsteptare.get(0));
                this.listaAsteptare.remove(0);
                return true;
            }
        }
        this.listaAsteptare.remove(cautare(this.listaAsteptare,criteriu,x));
        return true;
    }
    public  ArrayList<String> contineSubsirEmail(String x){
        ArrayList<String> rezultat=new ArrayList<String>();
        for(int i=0;i<this.listaParticipanti.size();i++)
        {
            if(this.listaParticipanti.get(i).getEmail().equalsIgnoreCase(x))
                rezultat.add(this.listaParticipanti.get(i).getEmail());
        }
        for(int i=0;i<this.listaAsteptare.size();i++)
        {
            if(this.listaAsteptare.get(i).getEmail().equalsIgnoreCase(x))
                rezultat.add(this.listaAsteptare.get(i).getEmail());
        }
        return rezultat;
    }
    public  ArrayList<String> contineSubsirNumarDeTelefon(String x){
        ArrayList<String> rezultat=new ArrayList<String>();
        for(int i=0;i<this.listaParticipanti.size();i++)
        {
            if(this.listaParticipanti.get(i).getNumarTelefon().equalsIgnoreCase(x))
                rezultat.add(this.listaParticipanti.get(i).getNumarTelefon());
        }
        for(int i=0;i<this.listaAsteptare.size();i++)
        {
            if(this.listaAsteptare.get(i).getNumarTelefon().equalsIgnoreCase(x))
                rezultat.add(this.listaAsteptare.get(i).getNumarTelefon());
        }
        return rezultat;
    }
    public  ArrayList<String> contineSubsirNume(String x){
        ArrayList<String> rezultat=new ArrayList<String>();
        for(int i=0;i<this.listaParticipanti.size();i++)
        {
            if(this.listaParticipanti.get(i).getNume().equalsIgnoreCase(x))
                rezultat.add(this.listaParticipanti.get(i).getNume());
        }
        for(int i=0;i<this.listaAsteptare.size();i++)
        {
            if(this.listaAsteptare.get(i).getNume().equalsIgnoreCase(x))
                rezultat.add(this.listaAsteptare.get(i).getNume());
        }
        return rezultat;
    }
    public  ArrayList<String> contineSubsirPrenume(String x){
        ArrayList<String> rezultat=new ArrayList<String>();
        for(int i=0;i<this.listaParticipanti.size();i++)
        {
            if(this.listaParticipanti.get(i).getPrenume().equalsIgnoreCase(x))
                rezultat.add(this.listaParticipanti.get(i).getPrenume());
        }
        for(int i=0;i<this.listaAsteptare.size();i++)
        {
            if(this.listaAsteptare.get(i).getPrenume().equalsIgnoreCase(x))
                rezultat.add(this.listaAsteptare.get(i).getPrenume());
        }
        return rezultat;
    }
    public  ArrayList<String> contineSubsir(String x){
        ArrayList<String> rezultat=new ArrayList<String>();
        rezultat.addAll(contineSubsirEmail(x));
        rezultat.addAll(contineSubsirNumarDeTelefon(x));
        rezultat.addAll(contineSubsirNume(x));
        rezultat.addAll(contineSubsirPrenume(x));
    return rezultat;


    }
}
