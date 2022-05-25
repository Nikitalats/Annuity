import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void Annuity(double sum,double percent, int month) {

        double interest_rate = percent / 100 / 12;
        double monthly_pay = sum * ((interest_rate * Math.pow((1 + interest_rate), month)) / (Math.pow((1 + interest_rate), month) - 1));
        monthly_pay = new BigDecimal(monthly_pay).setScale(2, RoundingMode.UP).doubleValue();
        double ostatok=sum;
        int i=0;
        System.out.println("Месяц |"+" Ежемесячный платеж |"  + " Основной долг |"+" Долг по процентам |"+" Остаток основного долга " );
        while (ostatok>0){
            i++;
            double interest_debt=sum*interest_rate;
            double principal_debt = monthly_pay -interest_debt;
            ostatok=sum-principal_debt;
            sum-=principal_debt;
            if (ostatok<0)
                ostatok=0;
            interest_debt = new BigDecimal(interest_debt).setScale(2, RoundingMode.UP).doubleValue();
            principal_debt = new BigDecimal(principal_debt).setScale(2, RoundingMode.UP).doubleValue();
            ostatok = new BigDecimal(ostatok).setScale(2, RoundingMode.UP).doubleValue();
            System.out.println(i+" | " + monthly_pay+" | "+ principal_debt +" |  " + interest_debt+" | " + ostatok);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Сумма:");
        double sum= sc.nextDouble();
        System.out.print("Ставка:");
        double percent= sc.nextDouble();
        System.out.print("Срок:");
        int month= sc.nextInt();
        Annuity(sum,percent, month);
    }
}

