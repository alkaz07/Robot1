import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //String prg = inputProg();
        //String prg = "LSSSRSRSSSSLSLLLL";

        runProg2("LSSSS");
    }

    public static void runProg2(String prog) {
        int maxCountS = 10;
        int[][] matrix = new int[2*maxCountS+1][2*maxCountS+1];

        int directionGrad = 0;
        int x =maxCountS;
        int y =maxCountS;
        int countS=0;
        boolean flag=false;

        matrix[x][y] = 1;       //оставить след на карте
        printMatr(matrix);
        for (char symbol : prog.toCharArray()) {
            if (symbol == 'R') {//одинарные кавычки задают значение типа char - один символ
                System.out.println("робот поворачивает направо");
                directionGrad -=90;
                if(directionGrad == -90)
                    directionGrad= 270;
                System.out.println("направление в градусах = "+directionGrad);

            }
            if (symbol == 'L') {//одинарные кавычки задают значение типа char - один символ
                System.out.println("робот поворачивает налево");
                directionGrad +=90;
                if(directionGrad == 360)
                    directionGrad= 0;
                System.out.println("направление в градусах = "+directionGrad);
            }
            if (symbol == 'S') {//одинарные кавычки задают значение типа char - один символ
                System.out.println("робот идет вперед");
                if(directionGrad==0){
                    x++;
                }
                if(directionGrad==90){
                    y++;
                }
                if(directionGrad==180){
                    x--;
                }
                if(directionGrad==270){
                    y--;
                }
                countS++;
                matrix[x][y] ++;   //оставить след
                if(matrix[x][y]>1) {
                    System.out.println("робот уже был здесь! Пройдено " + countS + " шагов");
                    flag=true;
                    break;
                }
                System.out.println("x = "+x+" y = "+y);
            }
        }
        printMatr(matrix);

        if(flag)
            System.out.println("Ответ "+countS);
        else
            System.out.println("Ответ -1");
    }

    public static void runProg1(String prog) {
        int direction = 0; //всего будет 4 направления: 0, 1, 2, 3
        int directionGrad = 0;
        int x =0;
        int y =0;

        for (char symbol : prog.toCharArray()) {
            if (symbol == 'R') {//одинарные кавычки задают значение типа char - один символ
                System.out.println("робот поворачивает направо");
                direction -= 1;
                if(direction == -1)
                    direction = 3;
                System.out.println("направление = "+direction);
                directionGrad -=90;
                if(directionGrad == -90)
                    directionGrad= 270;
                System.out.println("направление в градусах = "+directionGrad);

            }
            if (symbol == 'L') {//одинарные кавычки задают значение типа char - один символ
                System.out.println("робот поворачивает налево");
                direction +=1;
                if(direction == 4)
                    direction = 0;
                System.out.println("направление = "+direction);

                directionGrad +=90;
                if(directionGrad == 360)
                    directionGrad= 0;
                System.out.println("направление в градусах = "+directionGrad);
            }
            if (symbol == 'S') {//одинарные кавычки задают значение типа char - один символ
                System.out.println("робот идет вперед");
                if(direction==0){
                    x++;
                }
                if(direction==1){
                    y++;
                }
                if(direction==2){
                    x--;
                }
                if(direction==3){
                    y--;
                }
                System.out.println("x = "+x+" y = "+y);
            }
        }
    }

    public static void runProg0(String prog) {
        // for (int i = 0; i < prog.length(); i++) {
        //     System.out.println("очередная команда "+ prog.charAt(i));
        // }
        for (char symbol : prog.toCharArray()) {
            System.out.println("очередная команда " + symbol);
        }
    }

    public static String inputProg() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввведите программу робота");
        String s = scanner.next();
        return s;
    }

    public static void printMatr(int[][] matr){
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j <  matr[i].length; j++) {
                System.out.printf("%2d", matr[i][j]);   //форматируем для красивых ровных столбцов
            }
            System.out.println();
        }
    }
}