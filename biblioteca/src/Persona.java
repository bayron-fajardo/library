import java.time.LocalDate;
public class Persona {
    
    private String name;
    private int phone;
    private String email;
    private boolean activeLoan;
    private LocalDate loanDate;

    public Persona(String name, int phone, String email) {
        
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.activeLoan = false;
        
    }

    @Override
    public String toString(){
        return "Nombre: " + getName() + ", Telefono: " + getPhone() + ", Email: " + getEmail() + ", Prestamo Activo: " + isActiveLoan()+ ", Fecha prestamos: " + getLoanDate() ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActiveLoan() {
        return activeLoan;
    }

    public void setActiveLoan(boolean activeLoan) {
        this.activeLoan = activeLoan;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }




}
