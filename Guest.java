public class Guest {
    private String nume;
    private String prenume;
    private String email;
    private String numarTelefon;

    public Guest(String nume,String prenume,String email,String numarTelefon){
        this.nume=nume;
        this.prenume=prenume;
        this.email=email;
        this.numarTelefon=numarTelefon;
    }
    public String getEmail() {
        return email;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
