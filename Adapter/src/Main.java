import javax.lang.model.element.NestingKind;

public class Main {
    public static void main(String[] args){
        NewDateInterface newDateInterface = new CalendarToNewDateAdapter();
        System.out.println(newDateInterface.getDay());
        System.out.println(newDateInterface.getMonth());
        System.out.println(newDateInterface.getYear());

        newDateInterface.setDay(50);
        newDateInterface.setMonth(1);
        newDateInterface.setYear(2024);

        System.out.println(newDateInterface.getDay());
        System.out.println(newDateInterface.getMonth());
        System.out.println(newDateInterface.getYear());

        newDateInterface.advanceDays(385);
        System.out.println(newDateInterface.getDay());
        System.out.println(newDateInterface.getMonth());
        System.out.println(newDateInterface.getYear());

    }
}
