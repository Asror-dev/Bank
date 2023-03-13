import java.util.Scanner;

public class Main {
    public static void main(String[] str) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("Ismingizni kiriting");
        user.userName = scanner.nextLine();

        Bank bank = new Bank();
        System.out.println("Qaysi bankdan foydalanmoqchisiz. Bank nomini kiriting!");
        bank.bankName = scanner.nextLine();
        System.out.println("Bankning budjiti");
        bank.bankMoney = scanner.nextInt();
        System.out.println("Umumiy mablag'ingiz");
        user.userMoney = scanner.nextInt();

        while (true){
            System.out.println("Bankga pul quymoqchi bo'lsangiz 1 ni bosing Agar olmoqchi bo'lsangiz 2 ni bosing!!!");

            int i = scanner.nextInt();
            if(i==1){
                user.berish = true;
            }
            if(i==2){
                user.olish = true;
            }
            if(user.berish){
                System.out.println("Qancha pul qo'ymoqchisiz");
                bank.userOlish = scanner.nextInt();
                user.berishMoney = bank.userOlish;
                if(user.userMoney>= user.berishMoney){
                    user.userMoney = user.userMoney - user.berishMoney;
                    bank.bankMoney = bank.bankMoney + bank.userOlish;
                    System.out.println("bankning budjiti " + bank.bankMoney);
                    System.out.println("sizning mablag'ingiz " + user.userMoney);

                }else{
                    System.out.println("Sizda uncha pul yuq");
                }
                user.berish = false;

            }
            if(user.olish){
                System.out.println("Qancha pul olmoqchisiz");
                user.olishMoney = scanner.nextInt();
                bank.userBerish = user.olishMoney;
                if(bank.bankMoney> bank.userBerish){
                    bank.bankMoney = bank.bankMoney- bank.userBerish;
                    user.userMoney = user.userMoney+user.olishMoney;
                    System.out.println("bankning budjiti " + bank.bankMoney);
                    System.out.println("sizning mablag'ingiz " + user.userMoney);
                }else{
                    System.out.println("bankda uncha pul yuq");
                }
                user.olish = false;



            }
        }
    }
}
