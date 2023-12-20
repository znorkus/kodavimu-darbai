
public class Main {


//    public static void main(String[] args) {
//        // write experimental main programs here
//        PaymentTerminal unicafeExactum = new PaymentTerminal();
//
//        double change = unicafeExactum.eatAffordably(10);
//        System.out.println("remaining change " + change);
//
//        change = unicafeExactum.eatAffordably(5);
//        System.out.println("remaining change " + change);
//
//        change = unicafeExactum.eatHeartily(4.3);
//        System.out.println("remaining change " + change);
//
//        System.out.println(unicafeExactum);
//    }
//}
public static void main(String[] args) {
    PaymentTerminal unicafeExactum = new PaymentTerminal();
    System.out.println(unicafeExactum);

    PaymentCard paymentCard = new PaymentCard(2);

    System.out.println("amount of money on the card is " + paymentCard.balance() + " euros");

    boolean wasSuccessful = unicafeExactum.eatHeartily(paymentCard);
    System.out.println("there was enough money: " + wasSuccessful);

    unicafeExactum.addMoneyToCard(paymentCard, 100);

    wasSuccessful = unicafeExactum.eatHeartily(paymentCard);
    System.out.println("there was enough money: " + wasSuccessful);

    System.out.println("amount of money on the card is " + paymentCard.balance() + " euros");

    System.out.println(unicafeExactum);
}
}