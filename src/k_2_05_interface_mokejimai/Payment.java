package k_2_05_interface_mokejimai;

public interface Payment {

//    Aprašykite interfeisą Mokėjimas (Payment) su šiais metodais:
//        banko sąskaita (bank account) -  grąžina banko sąskaitos numerį
//        sąskaitos turėtojas (account owner) - fizinio ar juridinio asmens pavadinimas
//        suma (amount) - pervedama suma

    String bankAccount();
    String accountOwner();
    Double amount();
}
