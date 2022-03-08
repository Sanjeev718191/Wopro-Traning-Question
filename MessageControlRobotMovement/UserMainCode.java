import java.util.Scanner;

public class UserMainCode{
    public String moveRobot(int input1, int input2, String input3, String input4){
        char arr[] = {'N','E','S','W'};
        String str = input3;
        int x = Integer.parseInt(str.split("-")[0]);
        int y = Integer.parseInt(str.split("-")[1]);
        int p =0;
        for(int i =0;i<4;i++){
            if(input3.charAt(4) == arr[i]){
                p = i;
            }
        }
        String res = input1+"-"+input2+"-"+input3.charAt(4);
        for (int i = 0; i < input4.length(); i++) {
            if(input4.charAt(i) == 'L' && p != 0){
                p--;
                res = x+"-"+y+"-"+arr[p];
            }
            else if(input4.charAt(i) == 'L' && p == 0){
                p=3;
                res = x+"-"+y+"-"+arr[p];
            }
            else if(input4.charAt(i) == 'R' && p != 3){
                p++;
                res = x+"-"+y+"-"+arr[p];
            }
            else if(input4.charAt(i) == 'R' && p == 3){
                p = 0;
                res = x+"-"+y+"-"+arr[p];
            }
            else if(input4.charAt(i) == 'M' && res.charAt(4)=='N'){
                if(y+1 > input2){
                    res = x+"-"+y+"-"+arr[p]+"-ER";
                    return res;
                }
                y++;
                res = x+"-"+y+"-"+arr[p];
            }
            else if(input4.charAt(i) == 'M' && res.charAt(4)=='E'){
                if(x+1 > input1){
                    res = x+"-"+y+"-"+arr[p]+"-ER";
                    return res;
                }
                x++;
                res = x+"-"+y+"-"+arr[p];
            }
            else if(input4.charAt(i) == 'M' && res.charAt(4)=='W'){
                if(x-1 < 0){
                    res = x+"-"+y+"-"+arr[p]+"-ER";
                    return res;
                }
                x--;
                res = x+"-"+y+"-"+arr[p];
            }
            else if(input4.charAt(i) == 'M' && res.charAt(4)=='S'){
                if(y-1 < 0){
                    res = x+"-"+y+"-"+arr[p]+"-ER";
                    return res;
                }
                y--;
                res = x+"-"+y+"-"+arr[p];
            }
        }
        return res;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        String input3 = sc.next();
        String input4 = sc.nextLine();
        UserMainCode u = new UserMainCode();
        System.out.println(u.moveRobot(input1,input2,input3,input4));

    }
}
