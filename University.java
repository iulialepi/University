package com.company;

public class University {
    public static void main(String[] args) {
        University_Rules obj = new University_Rules(new int[]{40, 41, 39, 38, 50, 20, 99, 45, 36, 56});
        System.out.println("Die Noten die zu klein sind: ");
        for(int i = 0; i< obj.failed().length; i++){
            System.out.print(obj.failed()[i]+ " ");
        }

        System.out.println(" ");
        System.out.println("Der Durchschnittswert: ");
        System.out.println(obj.avg());

        System.out.println("Die abgerundete Noten: ");
        for(int i = 0; i< obj.round().length; i++){
            System.out.print(obj.round()[i]+ " ");
        }
        System.out.println(" ");
        System.out.println("Der Maximum der abgerundeten Noten: ");
        System.out.println(obj.max_round(obj.round()));
    }

}
class University_Rules {

    public int[] grades;

    public University_Rules(int[] gr) {
        grades = gr;
    }
    public int[] failed(){
        int[] failed_list = new int[11];
        for (int i = 0; i < 10; i++) {
            if (grades[i] < 40) {
                failed_list[i]=grades[i];
            }
        }
        return failed_list;
    }



    public double avg() {
        double sum = 0;
        for (int i = 0; i < 10; i++)
            sum = sum + grades[i];
        return sum / 10;
    }

    public int[] round() {
        int[] copy = new int[10];
        System.arraycopy(grades, 0, copy, 0, 10);
        int max=0;
        int sum;
        for (int i = 0; i < 10; i++) {
            sum = 0;
            int x = copy[i];
            while (x % 5 != 0) {
                sum++;
                x++;
            }
            x-=sum;
            if (sum < 3)
                copy[i] += sum;
            else {
                while (x % 5 != 0)
                    x--;
                copy[i] = x;
            }
        }
        return copy;

    }

    public int max_round(int[] round_numbers){
        int max_nr=0;
        for (int i = 0; i < 10; i++) {
            if(round_numbers[i]>=max_nr){
                max_nr=round_numbers[i];
            }
        }
        return max_nr;
    }
}

